package service;
import java.io.*;
import java.util.*;
import java.util.Date;

import javax.servlet.*;
import javax.servlet.http.*;

import MITSUBISHI_G50.*;

import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.context.ApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;
import tncc.wpc.service.wpcManager;
import tncc.power.service.*;
import tncc.power.value.*;
import tncc.power.value.Reader;
import tncc.reserve.service.ReserveManager;
import tncc.reserve.value.*;
import tncc.wpc.value.*;
import com.base.util.*;

import org.springframework.web.context.support.*;

import com.base.util.MyProperties;
import com.base.util.Tools;
import com.base.value.*;
import com.opensymphony.xwork.ActionContext;
import java.sql.*;
import java.io.*;
//載入JDOM類別
import org.jdom.*;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import com.common.util.XMLHelper;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.io.BufferedOutputStream;




public class G50_Server_Weekly extends HttpServlet {
	
	public void init() throws ServletException {
		try{			
		  System.out.println("**** G50_Server_Weekly init()  ****");				  
		  Thread thread = new Thread(new G50_Server_WeeklyXML());
		  thread.start();		 
		}catch (Exception ex) {		
			System.out.println(ex.toString());
	    }
		
	}	

	class G50_Server_WeeklyXML extends Thread {		
		com.opensymphony.xwork.ActionSupport ww= new com.opensymphony.xwork.ActionSupport();
		ServletContext servletContext=getServletContext(); 
	    ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
	    ReserveManager reserveManager=(ReserveManager) ctx.getBean("reserveManager");
	 	public void run() {     	
     		try {
     			while(true) {
     			 System.out.println("G50_Server_Weekly="+Tools.getCurrentTimestamp());
     			 BasicInfo basicInfo=reserveManager.getBasicInfo();     			 
				 try {			
					    List<ClassRoom> ls=reserveManager.getAllClassRooms();
				        for(int i=0;i<ls.size();i++){	        	
				        	ClassRoom classroom=ls.get(i);
				        	//System.out.println(classroom.getId());
				        	
				        	Set readers=classroom.getReaders();
				        	if(readers!=null){
				        	
			       		    Iterator k = readers.iterator(); 
			  	    		 while (k.hasNext()) {
			  	    		  Reader r= (Reader) k.next();
			  	    		  PowerController pc=reserveManager.getPowerControllerByReader(r);
			  	    		  
			 	    		  Element packet = new Element("Packet");
			 	    		  Document doc = new Document(packet);
			 	    		  doc.setRootElement(packet);
			 	    		  
			 	    		  String desc=classroom.getId()+"--"+r.getId();
			 	    		  Element memo = new Element("memo"); 
			 	    		  memo.setAttribute(new Attribute("desc", String.valueOf(desc)));
			 	    		  //doc.getRootElement().addContent(memo);
				    		  
			 	    		
			 	    		  Element command = new Element("Command");
			 	    		  command.setText("setRequest");
			 	    		  doc.getRootElement().addContent(command);
			 	    		
			 	    		  Element databaseManager = new Element("DatabaseManager");
			 	    		  Element scheduleControl = new Element("ScheduleControl");
				        	
				        	   for(int w=1;w<=7;w++){	        		
				        		 Element wpatternList = new Element("WPatternList");
				        		 wpatternList.setAttribute(new Attribute("Pattern", String.valueOf(w)));
				        		 wpatternList.setAttribute(new Attribute("Group", String.valueOf(r.getReaderId())));
				        		 scheduleControl.addContent(wpatternList);
				        		 
				        		 List<CourseOpen> ls1=reserveManager.getCourseOpenListByWeek(classroom,w); 
				        		  int count=1; 
				        		  for(int y=0;y<ls1.size();y++){
				        			 CourseOpen c=ls1.get(y);
				  	        		 String startHour=c.getReservation().substring(0,2);
				  	        		 String startMinute=c.getReservation().substring(2,4);
				  	        		 String endHour=c.getReservation().substring(0,2);
				  	        		 String endMinute=c.getReservation().substring(2,4); 	  	        
				  	        		 String active=c.getActive();
				  	        		 
				  	        		 
				  	        		Element wpatternRecord = new Element("WPatternRecord"); 
				  	        		   
				  	        		 if(active.equals("on")){
				  	        			 wpatternRecord.setAttribute(new Attribute("testid", String.valueOf(c.getId())));
				  	        		     wpatternRecord.setAttribute(new Attribute("Index", String.valueOf(count)));
						        	     wpatternRecord.setAttribute(new Attribute("Hour", startHour));
					  	        	     wpatternRecord.setAttribute(new Attribute("Minute", startMinute));	  	        		 
					  	        	     wpatternRecord.setAttribute(new Attribute("Drive", ""));    
					  	        	     wpatternRecord.setAttribute(new Attribute("DriveItem", r.getDriveItem().getValueUs()));
				  	        		 }
				  	        		 if(active.equals("off")){
				  	        			 wpatternRecord.setAttribute(new Attribute("testid", String.valueOf(c.getId())));
				  	        			 wpatternRecord.setAttribute(new Attribute("Index", String.valueOf(count)));
						        		 wpatternRecord.setAttribute(new Attribute("Hour", endHour));
					  	        		 wpatternRecord.setAttribute(new Attribute("Minute", endMinute));	  	        		 
					  	        		 wpatternRecord.setAttribute(new Attribute("Drive", "OFF")); 
					  	        		 wpatternRecord.setAttribute(new Attribute("DriveItem", "CHK_ON"));
					  	        	 }
				  	        		 wpatternRecord.setAttribute(new Attribute("Mode", "COOL"));
				  	        		 wpatternRecord.setAttribute(new Attribute("SetTemp",String.valueOf(r.getTemp())));
				  	        		 wpatternRecord.setAttribute(new Attribute("SetBack", ""));
				  	        		 //wpatternRecord.setAttribute(new Attribute("DriveItem", r.getDriveItem().getValueUs()));
				  	        		 wpatternRecord.setAttribute(new Attribute("ModeItem", r.getModeItem().getValueUs()));
				  	        		 wpatternRecord.setAttribute(new Attribute("SetTempItem", r.getTempItem().getValueUs()));
				  	        		 wpatternList.addContent(wpatternRecord);	 
				  	        		 count++;
				        		   }
				        	  }
				        	  
				        	  databaseManager.addContent(scheduleControl);
				        	  doc.getRootElement().addContent(databaseManager);
				        	  //System.out.println("------------------------------------");
				 			  XMLOutputter xmlOutput = new XMLOutputter();
				 			  xmlOutput.setFormat(Format.getPrettyFormat());
				 			  //xmlOutput.output(doc, new FileWriter("d:\\tmp\\w.xml"));
				 			  String cmd=xmlOutput.outputString(doc);
				 			  //System.out.println(cmd);
				 			  //傳送G50
				 			  if(r.getActive()==true){
				 			   DeviceConnection dc=new DeviceConnection(pc.getIp(),r.getReaderId());
				 			   dc.sendCommand(cmd);	
				 			   
				 			    //寫log
				 			    tncc.power.value.Log g=new tncc.power.value.Log();
				 	            g.setType(reserveManager.getAppPropertyById(70L)); //課表排程
				 	            g.setCreatedDate(Tools.getCurrentTimestamp());	
				 	            g.setCreatedUser(reserveManager.getSystemUser());
				 	            g.setReader(r);
				 	            String msg=classroom.getName()+"/"+r.getName()+"已同步課表排程";
				 	            g.setMsg(msg);
				 	            reserveManager.saveLog(g); 
				 	            
				 			  }
				          } 			  	    		 
				      }
				    }    	
				  }catch(Exception e){
		     		  System.out.println("error="+e.toString());	
		     	  }     
				 
				 int times=basicInfo.getTimingEveryMins()*60*1000;
				 sleep(times); 
     			 sleep(1000); 
     			 
     		   }
     		}catch(Exception e){
     		  System.out.println("G50_Server_WeeklyXML errot="+e.toString());	
     		}
		}     	
	} 	
 
	

	
}
