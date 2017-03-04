package service;
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

import MITSUBISHI_G50.*;

import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.context.ApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;
import tncc.wpc.service.wpcManager;
import tncc.power.service.*;
import tncc.power.value.*;
import tncc.power.value.Reader;
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




public class G50_Server extends HttpServlet {
	com.opensymphony.xwork.ActionSupport ww= new com.opensymphony.xwork.ActionSupport();
    public void init() throws ServletException {
		try{			
		  System.out.println("**** G50_Server init()  ****");
		  Thread thread = new Thread(new G50StatusXML());
		  thread.start();		  
		  Thread thread1 = new Thread(new G50Timing());
		  thread1.start();
		}catch (Exception ex) {		
			System.out.println(ex.toString());
	    }
	}
    
    class G50Timing extends Thread {	
    	com.opensymphony.xwork.ActionSupport ww= new com.opensymphony.xwork.ActionSupport();
		ServletContext servletContext=getServletContext(); 
        ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        PowerManager powerManager=(PowerManager) ctx.getBean("powerManager");       
    	
       public void run() {			
		while(true) {
		 try {
			System.out.println("G50Timing="+Tools.getCurrentTimestamp());	
			List<PowerController> ls=powerManager.getPowerControllerList();
			BasicInfo basicInfo=powerManager.getBasicInfo();
			for(int i=0;i<ls.size();i++){
				PowerController pc=ls.get(i);
				DeviceConnection c=new DeviceConnection(pc.getIp());
				if(pc.getDeviceTypeId()==45L)
				{				
				  String cmd=c.getTiming();
				  c.sendCommand(cmd);				
				  
				  //寫Log
		          tncc.power.value.Log g=new tncc.power.value.Log();
		          g.setType(powerManager.getAppPropertyById(84L)); //校時
		          g.setCreatedDate(Tools.getCurrentTimestamp());	
		          g.setCreatedUser(powerManager.getSystemUser());		       
		          String msg=pc.getName()+"[控制器]已執行校時";
		          g.setMsg(msg);
		          powerManager.saveLog(g);  
				}				
			}
			int times=basicInfo.getTimingEveryMins()*60*1000;
			sleep(times); 			
		 }catch (Exception ex) {
			 System.out.println("G50Timing() error..");
			 System.out.println(ex.toString());
		 }
	   }
	  }
    }
	
	class G50StatusXML extends Thread {		
		int i=0;		
		com.opensymphony.xwork.ActionSupport ww= new com.opensymphony.xwork.ActionSupport();
		ServletContext servletContext=getServletContext(); 
                ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
                PowerManager powerManager=(PowerManager) ctx.getBean("powerManager");
                MyProperties myProperties = (MyProperties)ctx.getBean("myProperties");        
		public void run() {
			try {
				while(true) {	 
				    try {					    	
				    	Timestamp start=Tools.getCurrentTimestamp();	
				    	System.out.println("G50_Server start==="+start);				    
				    	Element powerstatus = new Element("powerstatus");
			    		Document doc = new Document(powerstatus);
			    		doc.setRootElement(powerstatus);			    		
			    		int k=1,count=1;
			    		String statusmsg="";
			    		AppProperty deviceType=powerManager.getAppPropertyById(45L);
				    	List<PowerController> pc=powerManager.getPowerControllerListByDeviceType(deviceType);
				      	for(int j=0;j<pc.size();j++){
				      	    PowerController p=pc.get(j);	
				      	    DeviceConnection c=new DeviceConnection(p.getIp());
				            List<Device> al=c.getDeviceStatus();				            				         
				            //System.out.println(p.getName()+"--"+p.getIp()+"--"+p.getPort()+"--devices="+al.size());	
				            
				            for(int i=0;i<al.size();i++){
				            	Device d=al.get(i);
				            	//System.out.println(p.getName()+"--"+i+"--Group="+d.getGroup()+"--Drive="+d.getDrive()+"--SetTemp="+d.getSetTemp()+"--InletTemp="+d.getInletTemp());
				            	try{ 
				            	PowerControllerReader cc=powerManager.getReaderByControllerDeviceNo(p,Integer.parseInt(d.getGroup()));
				            	 if(cc!=null){
				            	    //System.out.println(cc.getReader().getName());				            		
				            	                Reader reader=cc.getReader(); 
				            	                Element door = new Element("door");
					        		door.setAttribute(new Attribute("id", String.valueOf(cc.getReader().getId()) ));    	
					        		doc.getRootElement().addContent(door);
					        		
					        		//寫面版開啟/關閉LOG
					        		String powerlog,msg;
					        		Long logId;					        		
					        		if(reader.getPowerstatus()==true){
					        			powerlog="ON";					        			
					        		}else{
					        			powerlog="OFF";
					        		}		
					        		
					        		if(!powerlog.equals(d.getDrive())){
					        			
					        			if(d.getDrive().equals("ON")){
					        				logId=86L;
						        			msg="面版"+reader.getName()+"已被開啟!";
					        			}else{
					        				logId=87L;
						        			msg="面版"+reader.getName()+"已被關閉!";						        		
					        			}		
					        			Log log=new Log();
					        			log.setReader(reader);
					        			log.setCreatedDate(Tools.getCurrentTimestamp());
					        			log.setType(powerManager.getAppPropertyById(logId));
					        			log.setMsg(msg);
					        			powerManager.saveLog(log);
					        		}
					        		
					        		
					        		//儲存目前電源使用狀態	
					        		if(d.getDrive().equals("ON")){
					        			reader.setPowerstatus(true);
					        		 }else{
					        			 reader.setPowerstatus(false); 
					        		 }
					        		 
					        		//ClassroomGroup
					        		Element classroomGroup = new Element("classroomGroup");
					        		classroomGroup.setText(cc.getClassRoom().getClassroomGroup());
					        		door.addContent(classroomGroup);
					        		
					        		//教室					        		
					        		Element classroom = new Element("classroom");
					        		ClassRoom cr=cc.getClassRoom();
					        		if(cr!=null){
					        			classroom.setText(cc.getClassRoom().getId());
					        		}else{
					        			classroom.setText("0");
					        		}		
					        		door.addContent(classroom);	
					        		
					        		//狀態
					        		Element status = new Element("status");
					        		status.setText(d.getDrive());
					        		door.addContent(status);	
					        		
					        		//設定溫度
					        		Element settemp = new Element("settemp");
					        		settemp.setText(String.valueOf(reader.getTemp()));
					        		door.addContent(settemp);
					        		
					        		//室內溫度
					        		Element inlettemp = new Element("inlettemp");
					        		inlettemp.setText(d.getInletTemp());
					        		door.addContent(inlettemp);
					        		
					        		//目前時間
					        		Element time = new Element("time");
					        		time.setText(Tools.formatSimpleDate2(Tools.getCurrentTimestamp()));
					        		door.addContent(time);
					        		
					        		//Mode
					        		Element setting_mode = new Element("setting_mode");
					        		setting_mode.setText(URLEncoder.encode(reader.getMode().getValueTw(),"utf8"));
					        		door.addContent(setting_mode);
					        		
					        		//DriveItem
					        		Element setting_driveItem = new Element("setting_driveItem");
					        		setting_driveItem.setText(URLEncoder.encode(reader.getDriveItem().getValueTw(),"utf8")); 
					        		door.addContent(setting_driveItem);
					        		
					        		//ModeItem
					        		Element setting_modeItem = new Element("setting_modeItem");
					        		setting_modeItem.setText(URLEncoder.encode(reader.getModeItem().getValueTw(),"utf8"));
					        		door.addContent(setting_modeItem);
					        		
					        		//TempItem
					        		Element setting_tempItem = new Element("setting_tempItem");
					        		setting_tempItem.setText(URLEncoder.encode(reader.getTempItem().getValueTw(),"utf8"));
					        		door.addContent(setting_tempItem);
					        		
					        		//FilterItem
					        		Element setting_filterItem = new Element("setting_filterItem");
					        		setting_filterItem.setText(URLEncoder.encode(reader.getFilterItem().getValueTw(),"utf8"));
					        		door.addContent(setting_filterItem);
					        		
					        		//節電讀卡機台號
					        		Element readerId = new Element("readerId");
					        		readerId.setText(String.valueOf(reader.getReaderId()));
					        		door.addContent(readerId);
					        		
					        		//節電G50名稱
					        		Element powercontroller = new Element("powercontroller");
					        		powercontroller.setText(URLEncoder.encode(cc.getPowerController().getName(),"utf8"));
					        		door.addContent(powercontroller);
					        		
					        		//節電G50IP
					        		Element powercontrollerIP = new Element("powercontrollerIP");
					        		powercontrollerIP.setText(cc.getPowerController().getIp());
					        		door.addContent(powercontrollerIP);
					        		
					        		//active
					        		Element active = new Element("active");
					        		try{
					        			if (reader.getActive()==true && reader.getActive()!=null)
						        		{
						        			active.setText("1");
						        		}else{
						        			active.setText("0");
						        		}						        			
					        		}catch(Exception e){
					        			active.setText("0");					        			
					        		}				        		
					        		door.addContent(active);
					        		
					        		//狀態模式					        		
					        		Element state = new Element("state");
					        		state.setText(reader.getState().getValueUs());
					        		door.addContent(state);						        		
					        		
					        		//狀態模式					        		
					        		Element stateId = new Element("stateId");
					        		stateId.setText(String.valueOf(reader.getState().getId()));
					        		door.addContent(stateId);	
					        		
					        		//information
					        		Element information = new Element("information");					        		
					        		information.setText(URLEncoder.encode(reader.getInformation(),"utf8"));
					        		door.addContent(information);	
					        		
					        		//lastModifiedDate
					        		reader.setLastModifiedDate(Tools.getCurrentTimestamp());
					        		
					        		powerManager.saveReader(reader);	
					        		
					        		//statusmsg
					        		statusmsg+="["+count+"] "+reader.getName()+"/"+reader.getState().getValueTw()+"/"+powerlog+"/"+reader.getInformation()+"<hr>";
					        		count++;  
					        		 
				            	 }				            	 
                                 
				                }catch(Exception e){
				                	System.out.println("G50_Server error="+e.toString());
				                }				                
				            }	
				            sleep(300000);
				      	}				      	                     
				      	XMLOutputter xmlOutput = new XMLOutputter();
				      	Format format = Format.getPrettyFormat();
				        format.setEncoding("UTF-8");
			    		xmlOutput.setFormat(format.getPrettyFormat());  			    		
			    		xmlOutput.output(doc, new FileWriter(myProperties.getG50filePath()+"status.xml"));
			      
			    		//寫LOG
		        		Log log=new Log();
		        		log.setType(powerManager.getAppPropertyById(88L));
		        		log.setCreatedDate(Tools.getCurrentTimestamp());
		        		log.setCreatedUser(powerManager.getSystemUser());		        	
		        		log.setMsg(statusmsg);
		        		powerManager.saveLog(log);
		        		
		        		System.out.println("G50_Server....end="+Tools.getCurrentTimestamp());
		            	   
				    
				    } catch (Exception e) {
				    	System.out.println("G50_Server error="+e.toString());
				      } 
					sleep(120000);
					i++;
				}
			}
			catch (Exception ex) {
				System.out.println("DeviceStatusXML() error..");
				System.out.println(ex.toString());
			}
		}
	}
	
}
