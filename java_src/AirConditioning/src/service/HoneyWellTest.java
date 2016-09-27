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


public class HoneyWellTest  extends HttpServlet {  
	
	public interface CMobus extends Library{
		CMobus instance = (CMobus)Native.loadLibrary("modbusfunc", CMobus.class);
		public int dt200_register_get(String host,int port,int type, int uid, int sid, int addr);
		public int dt200_register_set(String host,int port,int type, int uid, int sid, int addr, int value);
		public int dt200_drive_lock(String host,int port,int type, int uid, int sid);
		public int dt200_drive_unlock(String host,int port,int type, int uid, int sid);
		public int dt200_global_status_get(String host,int port,int type, int uid,int[] ret);
		
	}
	
	public void init() throws ServletException {
		try{			
		 System.out.println("JNATest test.."+Tools.getAppProperties().getProperty("dll_parh"));
		 System.setProperty("jna.library.path", Tools.getAppProperties().getProperty("dll_parh"));
		 
		 
		 String host = "140.118.18.229";
			int port = 4660;
			int type = 1;
			int uid = 30;
			int sid = 1;

			int DT200_SENSOR_TEMP  = 0x01;  // ·P´ú¾¹·Å«×
			

			int sensor_temp = CMobus.instance.dt200_register_get(host, port, type, uid, sid, DT200_SENSOR_TEMP);
			
			System.out.println("SENSOR_TEMP = " + sensor_temp);
			
			
		}catch (Exception ex) {		
			System.out.println("JNATest error.."+ex.toString());
	    }
	}	
}
