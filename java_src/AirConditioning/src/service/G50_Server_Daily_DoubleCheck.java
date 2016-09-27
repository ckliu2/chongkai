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
import org.dom4j.XPath;
import org.jdom.*;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import com.common.util.XMLHelper;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.io.BufferedOutputStream;




public class G50_Server_Daily_DoubleCheck extends HttpServlet {
	public void init() throws ServletException {
		try{			
		  System.out.println("**** G50_Server_Daily_DoubleCheck init()  ****");				  
		  Thread thread = new Thread(new G50_Server_Daily_DoubleCheckXML());
		  thread.start();		 
		}catch (Exception ex) {		
			System.out.println(ex.toString());
	    }
	}	
	
	class G50_Server_Daily_DoubleCheckXML extends Thread {		
		com.opensymphony.xwork.ActionSupport ww= new com.opensymphony.xwork.ActionSupport();
		ServletContext servletContext=getServletContext(); 
	        ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
	        PowerManager powerManager=(PowerManager) ctx.getBean("powerManager");	    
	 	public void run() {     
     		try {
     			while(true) {     			
				 try {	
				         System.out.println("DoubleCheck Start");
					 Date date =new Date();				
					 List<Reader> al=powerManager.findAllReaderByG50();					 
					 for(int i=0;i<al.size();i++){					     
					 sleep(10000);					     
					 Reader reader=al.get(i);
				    	 if(reader.getActive()==true)
				    	 {
				    	          System.out.println("DoubleCheck Reader "+reader.getName()+"---"+Tools.getCurrentTimestamp()); 
				                  PowerControllerReader pc=powerManager.getReaderByControllerDeviceNo(reader);
				    		  DeviceConnection cn=new DeviceConnection(pc.getPowerController().getIp(), Integer.parseInt( String.valueOf(reader.getReaderId()) ) );
				    		  //取得DB排程
				    		  List<ScheduleReaderDaily> ls=powerManager.getScheduleListByDate(date,reader);
				    		  String cmd=command(reader,ls); 
				    		
				    	   	  SAXBuilder builder = new SAXBuilder(); 	
				    	          XMLOutputter xmlOutput = new XMLOutputter();				    	    
				    	          xmlOutput.setFormat(Format.getPrettyFormat());
				    		  Document doc = builder.build(new StringReader(cmd));
				    		  Element docElement = doc.getRootElement();
				    		  docElement.removeChild("Command");
				    		
				    		  DeviceConnection dc=new DeviceConnection(pc.getPowerController().getIp(),reader.getReaderId());
				    		  String todaycmd=dc.getTodayList(dc.deviceNo);				  
				    		  String response=dc.sendCommand(todaycmd);	
				    		
				    		  SAXBuilder builder1 = new SAXBuilder(); 						
				    		  Document doc1 = builder1.build(new StringReader(response));
				    		  Element doc1Element = doc1.getRootElement();
				    		  doc1Element.removeChild("Command");
				    		
				    		  String cmd_xml=Tools.md5(xmlOutput.outputString(doc));
				    		  String response_xml=Tools.md5(xmlOutput.outputString(doc1));
				    		  
				    		  //xmlOutput.output(doc, new FileWriter("d:\\tmp\\cmd_103.xml"));
				    		  //xmlOutput.output(doc1, new FileWriter("d:\\tmp\\response_103.xml"));
				    		
				    		  //System.out.println(reader.getName()+" cmd_xml ="+cmd_xml);
				    		  //System.out.println(reader.getName()+ " response_xml ="+response_xml);
				    		  //狀態不一致 重新
				    		  if(!cmd_xml.equals(response_xml)){
				    		          //修改active=0 
				    			  powerManager.scheduleReaderDailyResetByReader(date,reader);				    			  
				    			  //如果沒有任何排程 下空排程
				    			  if(ls.size()==0){
				    			    ArrayList<ScheduleReaderDaily> empty=new ArrayList<ScheduleReaderDaily>();
				    			    String emptyCmd= command(reader,empty);
				    			    cn.sendCommand(emptyCmd);
				    			  }
				    			  
				    			  //寫LOG
							  Log log=new Log();
					        	  log.setType(powerManager.getAppPropertyById(93L));
					        	  log.setCreatedDate(Tools.getCurrentTimestamp());
					        	  log.setCreatedUser(powerManager.getSystemUser());
					        	  log.setReader(reader);
					        	  String msg=reader.getName()+" 已重新下放排程";
					        	  log.setMsg(msg);
					        	  powerManager.saveLog(log);	
				    		  }	
				    	   }
				        }
					 
				        //寫LOG
					Log log=new Log();
		        	        log.setType(powerManager.getAppPropertyById(92L));
		        	        log.setCreatedDate(Tools.getCurrentTimestamp());
		        	        log.setCreatedUser(powerManager.getSystemUser());
		        	        powerManager.saveLog(log);			 
				   	 
				  }catch(Exception e){					  
		     		  System.out.println("error="+e.toString());	
		     	       } 
			       System.out.println("DoubleCheck End");
			       sleep(5000);
     			}
     		}catch(Exception e){
     		  System.out.println("G50_Server_Daily_DoubleCheckXML errot="+e.toString());	
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
			  Element todayRecord = new Element("TodayRecord");			
			  todayRecord.setAttribute(new Attribute("Index", String.valueOf(i+1) ));
			  todayRecord.setAttribute(new Attribute("Hour", String.valueOf( s.getScheduledDate().getHours() )));
			  todayRecord.setAttribute(new Attribute("Minute", String.valueOf( s.getScheduledDate().getMinutes() ) ));
			  todayRecord.setAttribute(new Attribute("Drive", s.getScheduleDaily().getDrive().getValueUs()));
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
			cmd=xmlOutput.outputString(doc);
			return cmd;
			}catch(Exception e){
				System.out.println(e.toString());
			}			
			return cmd;
 	  }
	
}
