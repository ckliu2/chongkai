package service;

import java.io.FileWriter;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import DEM510C.Device;

import com.base.util.MyProperties;
import com.base.util.Tools;
import com.base.value.AppProperty;

import service.HoneyWell_Server.HoneyWell_ServerStatusXML;
import tncc.power.service.PowerManager;
import tncc.power.value.Log;
import tncc.power.value.PowerController;
import tncc.power.value.PowerControllerReader;
import tncc.power.value.Reader;
import tncc.reserve.value.ClassRoom;

public class Meter_Server  extends HttpServlet{

    Device device=new Device();
    
    public void init() throws ServletException {
   	try {
   	    System.out.println("**** Meter_Server init()  ****");
   	    Thread thread = new Thread(new MeterStatusXML());
   	    thread.start();
   	} catch (Exception ex) {
   	    System.out.println(ex.toString());
   	}
       }
    
    class MeterStatusXML extends Thread {
	int i = 0;
	
	com.opensymphony.xwork.ActionSupport ww = new com.opensymphony.xwork.ActionSupport();
	ServletContext servletContext = getServletContext();
	ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
	PowerManager powerManager = (PowerManager) ctx.getBean("powerManager");
	MyProperties myProperties = (MyProperties) ctx.getBean("myProperties");	
	public void run() {
	    while (true) {
		try{
		 //System.out.println("MeterStatusXMLXML..");		 
		 Element powerstatus = new Element("powerstatus");
	         Document doc = new Document(powerstatus);
		 doc.setRootElement(powerstatus);
			
	         AppProperty deviceType = powerManager.getAppPropertyById(108L);
		 List<PowerController> pc = powerManager.getPowerControllerListByDeviceType(deviceType);
		 for (int i = 0; i < pc.size(); i++) {		  
		  PowerController p = pc.get(i);
		  System.out.println("PowerController="+p.getName());
		  String server=p.getIp();
		  int port=p.getPort();
		  List<PowerControllerReader> al=powerManager.getReaderByController(p);
		  for(int j=0;j<al.size();j++){
		      PowerControllerReader pr=al.get(j);
		      Reader reader=pr.getReader();
		      int readerId=reader.getReaderId();
		      int status=device.checkPowerStatus(server, port, readerId);
		      System.out.println("serverip="+server+"--port="+port+"--reader="+reader+"--readerName="+reader.getName()+"--status="+status);
		      
		      //如果與DB不一致 強制修正
		      int currentStatus= powerManager.getDEM510CCurrentStatus(reader);
		      if(currentStatus!=status)
		      {
			  if(currentStatus==1){
			      device.setPowerStatus(server, port, readerId,true);
			  }else{
			      device.setPowerStatus(server, port, readerId,false);
			  }			  
		      }
		      
		      Element door = new Element("door");
		      door.setAttribute(new Attribute("id", String.valueOf(reader.getId())));
		      doc.getRootElement().addContent(door);		      
		   
		      Element classroom = new Element("classroom");
		      ClassRoom cr = pr.getClassRoom();
		      classroom.setText(pr.getClassRoom().getId());
		      door.addContent(classroom);
		      
		      // powercontroller名稱
		      Element powercontroller = new Element("powercontroller");
		      powercontroller.setText(URLEncoder.encode(p.getName(),"utf8"));
		      door.addContent(powercontroller);

			// powercontroller IP
			Element powercontrollerIP = new Element("powercontrollerIP");
			powercontrollerIP.setText(p.getIp());
			door.addContent(powercontrollerIP);

			// 讀卡機台號
			Element rid = new Element("readerId");
			rid.setText(String.valueOf(reader.getReaderId()));
			door.addContent(rid);  
			
			// 是否開啟
			Element ste = new Element("status");
			if(status==1){
			    ste.setText("ON");
			}else if(status==0){
			    ste.setText("OFF");
			}			
			door.addContent(ste);
			
			// 狀態模式
			Element state = new Element("state");
			state.setText(reader.getState().getValueUs());
			door.addContent(state);
			
			// 目前時間
			Element time = new Element("time");
			time.setText(Tools.formatSimpleDate2(Tools.getCurrentTimestamp()));
			door.addContent(time);
		      
		      
		      sleep(1000);
		   }
		 }
		 
		 XMLOutputter xmlOutput = new XMLOutputter();
		 Format format = Format.getPrettyFormat();
		 format.setEncoding("UTF-8");
		 xmlOutput.setFormat(format.getPrettyFormat());
		 xmlOutput.output(doc,new FileWriter(myProperties.getG50filePath()+ "DEM510CStatus.xml"));

		}catch (Exception ex){
			System.out.println("MeterStatusXML() error="+ex.toString());
		}
	    }		
       }	
    }

    
}
