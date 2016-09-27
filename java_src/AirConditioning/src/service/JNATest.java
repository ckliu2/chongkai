package service;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.*;
import java.net.*;
import java.sql.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.base.util.MyProperties;
import com.base.util.Tools;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;






import service.G50_Server.G50StatusXML;
import service.PowerServer.RealPower;
import tncc.power.service.PowerManager;
import tncc.power.value.*;
import tncc.wpc.service.wpcManager;

import com.common.value.*;
import com.common.web.action.CommonActionSupport;
import com.sun.jna.Library;
import com.sun.jna.Native;


public class JNATest  extends HttpServlet {  
	
	public interface CHelloWorld extends Library{
		CHelloWorld instance = (CHelloWorld)Native.loadLibrary("Project1", CHelloWorld.class);
		public int add(int a,int b);
		public int multiplication(int a,int b);
		public int substruction(int a,int b);
		public int square(int a,int b);		
	}
	
	public void init() throws ServletException {
		try{			
		 System.out.println("JNATest test.."+Tools.getAppProperties().getProperty("dll_parh"));
		 System.setProperty("jna.library.path", Tools.getAppProperties().getProperty("dll_parh"));
		 int s=CHelloWorld.instance.add(5,3);
			int s1=CHelloWorld.instance.multiplication(5,3);
			int s2=CHelloWorld.instance.substruction(5,3);
			int s3=CHelloWorld.instance.square(5,3);
			System.out.println(s+"--"+s1+"--"+s2+"--"+s3);
			
		}catch (Exception ex) {		
			System.out.println("JNATest error.."+ex.toString());
	    }
	}	
}
