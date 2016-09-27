package com.city.web.action;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.*;
import javax.servlet.http.*;

import java.sql.*;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTMLDocument.Iterator;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.base.util.MyProperties;
import com.base.util.Tools;
import com.base.value.UploadedFile;
import com.city.service.*;
import com.city.value.Course;
import com.oreilly.servlet.multipart.MultipartParser;
import com.oreilly.servlet.multipart.Part;
import com.oreilly.servlet.multipart.FilePart;

public class UploadServlet extends HttpServlet {

	public void init() {
		System.out.println("UploadServlet init....");
	}
	
	/*
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
		System.out.println("UploadServlet doGet....");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
		System.out.println("UploadServlet doPost....");
	}
	*/
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {

		List<FileItem> items;
		HttpSession session = request.getSession(true);
		try {
			String courseId = request.getParameter("courseId");
			System.out.println("UploadServlet courseId="+courseId);
			if (courseId != null) {
				System.out.println("UploadServlet doGet courseId=" + courseId);
				ServletContext servletContext = getServletContext();
				ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
				MyProperties myProperties = (MyProperties) ctx.getBean("myProperties");
				CityManager cityManager = (CityManager) ctx.getBean("cityManager");
				String filePath = myProperties.getCoursefilePath();

				Course course = cityManager.getCourseById(Long.parseLong(courseId));
				System.out.println("photo course.id=" + course.getId());
				DiskFileItemFactory f = new DiskFileItemFactory();
				items = new ServletFileUpload(f).parseRequest(request);
				for (FileItem item : items) {
					try {
						File ff = new File(filePath + course.getId());
						if (ff.exists() == false) {
							ff.mkdirs();
						}
						String filename = FilenameUtils.getName(item.getName());
						System.out.println("filename=" + filename);
						File uploadedFile = new File(filePath + course.getId() + "\\" + filename);
						item.write(uploadedFile);

						UploadedFile val = new UploadedFile();
						val.setFileName(filename);
						val.setLastModifiedDate(Tools.getCurrentTimestamp());
						cityManager.saveUploadedFile(val);

						Set photos = course.getPhotos();
						photos.add(val);
						cityManager.saveCourse(course);

					} catch (Exception e) {
						System.out.println(e.toString());
					}
				}

			}

		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}
	
	

}
