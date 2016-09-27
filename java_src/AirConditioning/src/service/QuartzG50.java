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
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.base.util.MyProperties;
import com.base.util.Tools;

import org.springframework.beans.factory.access.BeanFactoryLocator;
import org.springframework.beans.factory.access.BeanFactoryReference;
import org.springframework.beans.factory.access.SingletonBeanFactoryLocator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;




import service.G50_Server.G50StatusXML;
import service.PowerServer.RealPower;
import tncc.power.service.PowerManager;
import tncc.power.value.*;
import tncc.reserve.service.ReserveManager;
import tncc.wpc.service.wpcManager;

import com.common.value.*;
import com.common.web.action.CommonActionSupport;


public class QuartzG50  extends HttpServlet {  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		try {   
        	//System.out.println("**** QuartzG50 setSchedule()  ****"+Tools.getCurrentTimestamp());
        	ServletContext servletContext=getServletContext(); 
    	    ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
    	    ReserveManager reserveManager=(ReserveManager) ctx.getBean("reserveManager");
    	    PowerController ps=reserveManager.getPowerControllerById(1L);
    	    System.out.println(ps.getName()+"--"+Tools.getCurrentTimestamp());
        	//ServletContextHolder.getCurrentServletContext();
       	    
        }catch(Exception e){
			System.out.println("QuartzG50 doGet error 2 ="+e.toString());
		}
	    
	}
	
	public  void setSchedule() {   
        try {   
        	//System.out.println("**** QuartzG50 setSchedule()  ****"+Tools.getCurrentTimestamp());
        	//ServletContext servletContext=getServletContext(); 
    	    //ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
    	    //ReserveManager reserveManager=(ReserveManager) ctx.getBean("reserveManager");
    	    //PowerController ps=reserveManager.getPowerControllerById(1L);
    	    //System.out.println(ps.getName()+"--"+Tools.getCurrentTimestamp());
        	//ServletContextHolder.getCurrentServletContext();
        	
        	BeanFactoryLocator bfl = SingletonBeanFactoryLocator.getInstance();
        	BeanFactoryReference bf = bfl.useBeanFactory("mainContext");
        	ReserveManager reserveManager = (ReserveManager) bf.getFactory().getBean("reserveManager");
        	PowerController ps=reserveManager.getPowerControllerById(1L);
        	System.out.println(ps.getName()+"--"+Tools.getCurrentTimestamp());
        	
        }catch(Exception e){
			System.out.println("QuartzG50 setSchedule error 2 ="+e.toString());
		}
	}
	
	
}
