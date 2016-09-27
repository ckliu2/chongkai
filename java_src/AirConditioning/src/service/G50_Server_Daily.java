package service;
import java.io.*;
import java.util.*;
import java.util.Date;

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




public class G50_Server_Daily extends HttpServlet {
	public void init() throws ServletException {
		try{			
		  System.out.println("**** G50_Server_Daily init()  ****");				  
		  Thread thread = new Thread(new G50_Server_DailyXML());
		  thread.start();		 
		}catch (Exception ex) {		
			System.out.println(ex.toString());
	    }
	}	
	
	class G50_Server_DailyXML extends Thread {		
	    com.opensymphony.xwork.ActionSupport ww= new com.opensymphony.xwork.ActionSupport();
	    ServletContext servletContext=getServletContext(); 
	    ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
	    PowerManager powerManager=(PowerManager) ctx.getBean("powerManager");
	 	public void run() {     	
     		try {
     			while(true) {     			
				 try {		
					 System.out.println("G50_Server_DailyXML start="+Tools.getCurrentTimestamp());
					 Date date =new Date();						 
					 List<Reader> al=powerManager.getScheduleListByReader(date,false);					
					 String scheduledId="";
					 for(int i=0;i<al.size();i++){					        
				    		Reader reader=al.get(i);
				    		PowerControllerReader pc=powerManager.getReaderByControllerDeviceNo(reader);				    		
				    		if(pc.getPowerController().getDeviceType().getValueTw().equals("MITSUBISHI G50"))
				    		{				    		    
				    		sleep(5000);				    		
				    		DeviceConnection cn=new DeviceConnection(pc.getPowerController().getIp(), Integer.parseInt( String.valueOf(reader.getReaderId()) ) );
				    		//取得排程
				    		List<ScheduleReaderDaily> ls=powerManager.getScheduleListByDate(date,reader);
				    		String cmd=command(reader,ls); 	
				    		String response=cn.sendCommand(cmd);	
				    		System.out.println("response="+response);
				    		if(!response.equals("error")){
				    			for(int j=0;j<ls.size();j++){
				    				ScheduleDaily s=ls.get(j).getScheduleDaily();
				    				s.setActive(true);
				    				//s.setIp("127.0.0.1");				    				
				    				powerManager.saveScheduleDaily(s); //注記已下放過的排程
				    				scheduledId+=s.getId()+"<hr>"+"<br>"+reader.getName()+"已成功下放";
				    				System.out.println("s.id="+s.getId()+"--"+reader.getName()+"已成功下放");
				    			}
				    		 }				    		
				    		 //寫Log
				    		 try{
						   Log log=new Log();
			        	           log.setType(powerManager.getAppPropertyById(91L));
			        	           log.setCreatedDate(Tools.getCurrentTimestamp());
			        	           log.setCreatedUser(powerManager.getSystemUser());		        	
			        	           String statusmsg="下放排程編號:<hr>"+scheduledId;
			        	            if(scheduledId.equals("")){
			        		     statusmsg="無排程下放";
			        	            }
			        	           log.setMsg(statusmsg);
			        	           powerManager.saveLog(log);
				    		 }catch(Exception e){
				    		     System.out.println("save log error="+e.toString());
				    		 }
				    		 
			        	         System.out.println(i+"--reader.name="+reader.getName()+"--排程數="+ls.size()+"---"+Tools.getCurrentTimestamp());
				    		 
				    	       }
					 }	
					 System.out.println("G50_Server_Daily end="+Tools.getCurrentTimestamp());					 
				  }catch(Exception e){					  
		     		  System.out.println("error="+e.toString());	
		     	  }     			 
     			  sleep(5000);
     			}
     		}catch(Exception e){
     		  System.out.println("G50_Server_DailyXML errot="+e.toString());	
     		}
		}     	
	}
	

	
 	public String command(Reader reader,List<ScheduleReaderDaily> ls){
 		com.opensymphony.xwork.ActionSupport ww= new com.opensymphony.xwork.ActionSupport();
		ServletContext servletContext=getServletContext(); 
	        ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
	        PowerManager powerManager=(PowerManager) ctx.getBean("powerManager");
	 
	    String cmd="";
 		try{
			Element packet = new Element("Packet");
			Document doc = new Document(packet);
			doc.setRootElement(packet);			
			Element command = new Element("Command");
			command.setText("setRequest");
			doc.getRootElement().addContent(command);			
			Element databaseManager = new Element("DatabaseManager");			
			Element scheduleControl = new Element("ScheduleControl");			
			Element todayList = new Element("TodayList");    			
			scheduleControl.addContent(todayList);    			
			databaseManager.addContent(scheduleControl);   
			
			todayList.setAttribute("Group", String.valueOf(reader.getReaderId()) );
			
			for(int i=0;i<ls.size();i++){
			  ScheduleReaderDaily s=ls.get(i);
			  
			  //寫入Log檔			  
			  //boolean status=powerManager.haveLog(s.getScheduleDaily(),s.getReader());
			  //if(status==false){
			     Log log=new Log();
			     AppProperty type;
			     String msg="";			    
			     switch(Integer.parseInt(String.valueOf(s.getType().getId())))
			     {
			     
			       //課表排程
			       case 81:
				    type=powerManager.getAppPropertyById(70L);
				    msg=s.getReader().getName()+"已同步課表排程";  
				   break;
				   
				   //手動排程
			       case 82:
					type=powerManager.getAppPropertyById(69L);
					msg=s.getReader().getName()+"已同步手動排程";   
				   break;
			     
				   //每日強制關閉時段
			       case 89:
			    	type=powerManager.getAppPropertyById(89L);
				    msg=s.getReader().getName()+"已執行每日強制關閉時段";   
			       break;	
			       
			       //每日強制初始化時段
			       default:
				    type=powerManager.getAppPropertyById(90L);
					msg=s.getReader().getName()+"已執行每日強制初始化時段";   
				   break;
			     }
			     
			     try{
			       log.setType(type);			    
			       log.setReader(s.getReader());
			       log.setScheduleDaily(s.getScheduleDaily());
			       log.setCreatedDate(Tools.getCurrentTimestamp());
			       log.setCreatedUser(powerManager.getSystemUser());			     
			       log.setMsg(msg);
			       powerManager.saveLog(log);			     
			     }catch(Exception e){
				 System.out.println("save log error="+e.toString());
			     }
			  //寫入Log檔
			
			  Element todayRecord = new Element("TodayRecord");			
			  todayRecord.setAttribute(new Attribute("Index", String.valueOf(i+1) ));
			  todayRecord.setAttribute(new Attribute("Hour", String.valueOf( s.getScheduledDate().getHours() )));
			  todayRecord.setAttribute(new Attribute("Minute", String.valueOf( s.getScheduledDate().getMinutes() ) ));
			  
			  if(s.getScheduleDaily().getDrive().getValueUs().equals("NOSETTING")){
			      todayRecord.setAttribute(new Attribute("Drive", ""));
			  }else{
			      todayRecord.setAttribute(new Attribute("Drive", s.getScheduleDaily().getDrive().getValueUs()));
			  }
			  
			  todayRecord.setAttribute(new Attribute("Mode", s.getScheduleDaily().getMode().getValueUs() ));
			  todayRecord.setAttribute(new Attribute("SetTemp", String.valueOf(s.getScheduleDaily().getTemp()) ));	
			  todayRecord.setAttribute(new Attribute("SetBack", ""));
			  todayRecord.setAttribute(new Attribute("DriveItem", s.getScheduleDaily().getDriveItem().getValueUs() ));
			  todayRecord.setAttribute(new Attribute("ModeItem", s.getScheduleDaily().getModeItem().getValueUs() ));
			  todayRecord.setAttribute(new Attribute("SetTempItem", s.getScheduleDaily().getTempItem().getValueUs() ));    		
			  todayList.addContent(todayRecord);	
			}
			
			doc.getRootElement().addContent(databaseManager);	
			XMLOutputter xmlOutput = new XMLOutputter();
	      	        Format format = Format.getPrettyFormat();
	                format.setEncoding("UTF-8");
			xmlOutput.setFormat(format.getPrettyFormat()); 
			
			//xmlOutput.output(doc, new FileWriter("d:\\tmp\\"+reader.getName()+".xml"));    
			
			cmd=xmlOutput.outputString(doc);
			return cmd;
			}catch(Exception e){
				System.out.println(e.toString());
			}
			
			return cmd;
 	  }
	
}
