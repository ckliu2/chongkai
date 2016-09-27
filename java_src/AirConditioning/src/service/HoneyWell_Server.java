package service;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

import HoneyWell.ComparatorDevice;
import HoneyWell.DT200;
import HoneyWell.Device;
import MITSUBISHI_G50.*;

import javax.servlet.*;
import javax.servlet.http.*;

import org.springframework.context.ApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import service.JNATest.CHelloWorld;
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
import com.sun.jna.Library;
import com.sun.jna.Native;

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

public class HoneyWell_Server extends HttpServlet {
    
    static List<Device> al;
    static List<Device> status=new ArrayList<Device>();
    com.opensymphony.xwork.ActionSupport ww = new com.opensymphony.xwork.ActionSupport();
    
    public void init() throws ServletException {
	try {
	    System.out.println("**** HoneyWell_Server init()  ****");
	    Thread thread = new Thread(new HoneyWell_ServerStatusXML());
	    thread.start();
	} catch (Exception ex) {
	    System.out.println(ex.toString());
	}
    }

    class HoneyWell_ServerStatusXML extends Thread {
	int i = 0;
	
	com.opensymphony.xwork.ActionSupport ww = new com.opensymphony.xwork.ActionSupport();
	ServletContext servletContext = getServletContext();
	ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
	PowerManager powerManager = (PowerManager) ctx.getBean("powerManager");
	MyProperties myProperties = (MyProperties) ctx.getBean("myProperties");
	
	public void run() {
	    try {
		while (true) {
		    try {			
			//System.out.println("HoneyWell_ServerStatusXML..");
			System.setProperty("jna.library.path", Tools.getAppProperties().getProperty("dll_parh"));
			Timestamp start = Tools.getCurrentTimestamp();
			//System.out.println("HoneyWell_ServerStatusXML=" + start);
			// 更新面板
			Element powerstatus = new Element("powerstatus");
			Document doc = new Document(powerstatus);
			doc.setRootElement(powerstatus);
			AppProperty deviceType = powerManager.getAppPropertyById(94L);
			List<PowerController> pc = powerManager.getPowerControllerListByDeviceType(deviceType);
			for (int j = 0; j < pc.size(); j++) {
			    PowerController p = pc.get(j);
			    boolean scocket=Tools.socketTest(p.getIp(), p.getPort());
			    try {
				if(scocket==true){
				short port = Short.parseShort(String.valueOf(p.getPort()));
				short type = 0;
				short uid = Short.parseShort(String.valueOf(p.getDeviceId()));
				short[] status_array = new short[32 * 11];
				short returncode = HoneyWell.DT200.DT200Mobus.instance.dt200_global_status_get(p.getIp(),port, type, uid, status_array);
				//System.out.println("returncode=" + returncode);
				//System.out.println(p.getName() + "--ip="+ p.getIp() + "--port=" + p.getPort()+ "--uid=" + uid+"--returncode=" + returncode);
				if (returncode == 0) {
				    al = HoneyWell.DT200.getDeviceStatus(status_array, p);	
				    pstatus(al);
				    //System.out.println("al.size()=" + al.size());
                                   
				    for (int i = 0; i < al.size(); i++) {
					Device d = al.get(i);
					try {
					    PowerControllerReader cc = powerManager.getReaderByControllerDeviceNo(p,Integer.parseInt(d.getGroup()));
					    //System.out.println("" + p.getName()+ "--" + d.getGroup());
					    if (cc != null) {
						Reader reader = cc.getReader();
						//System.out.println("reader=" + reader.getName());
						Element door = new Element("door");
						door.setAttribute(new Attribute("id", String.valueOf(cc.getReader().getId())));
						doc.getRootElement().addContent(door);

						// 教室
						Element classroom = new Element("classroom");
						ClassRoom cr = cc.getClassRoom();
						if (cr != null) {
						    classroom.setText(cc.getClassRoom().getId());
						} else {
						    classroom.setText("0");
						}
						door.addContent(classroom);

						// powercontroller名稱
						Element powercontroller = new Element("powercontroller");
						powercontroller.setText(URLEncoder.encode(cc.getPowerController().getName(),"utf8"));
						door.addContent(powercontroller);

						// powercontroller IP
						Element powercontrollerIP = new Element("powercontrollerIP");
						powercontrollerIP.setText(cc.getPowerController().getIp());
						door.addContent(powercontrollerIP);

						// 讀卡機台號
						Element readerId = new Element("readerId");
						readerId.setText(String.valueOf(reader.getReaderId()));
						door.addContent(readerId);  
						
						// 狀態
						Element status = new Element("status");
						status.setText(d.getDrive());
						door.addContent(status);
						
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

						// 儲存目前電源使用狀態
						if (d.getDrive().equals("ON")) {
						    reader.setPowerstatus(true);
						} else {
						    reader.setPowerstatus(false);
						}
						
						// 狀態模式
						Element state = new Element("state");
						state.setText(reader.getState().getValueUs());
						door.addContent(state);

						// information
						Element information = new Element("information");
						information.setText(URLEncoder.encode(reader.getInformation(),"utf8"));
						door.addContent(information);

						// 設定溫度
						Element settemp = new Element("settemp");
						settemp.setText(String.valueOf(d.getSetTemp()));
						door.addContent(settemp);

						// 室內溫度
						Element inlettemp = new Element("inlettemp");
						inlettemp.setText(d.getInletTemp());
						door.addContent(inlettemp);

						// 目前時間
						Element time = new Element("time");
						time.setText(Tools.formatSimpleDate2(Tools.getCurrentTimestamp()));
						door.addContent(time);
						
						// 鎖定狀態
						Element lock = new Element("lock");
						String lock_txt;
						if (d.getLock().equals("1")) {
						    lock_txt = "鎖定";
						} else {
						    lock_txt = "解除";
						}
						
						lock.setText(URLEncoder.encode(lock_txt, "utf8"));
						door.addContent(lock);

						Element lockId = new Element("lockId");
						lockId.setText(d.getLock());
						door.addContent(lockId);

						powerManager.saveReader(reader);
						
					    }
					 
					
					} catch (Exception e) {
					    System.out.println(e.toString());
					}
				    }				    
				}
			      }else{
				//網路連線error
				 Log log=new Log();
				 log.setCreatedDate(Tools.getCurrentTimestamp());
				 String msg=p.getName()+"連線失敗!";
				 log.setMsg(msg);
				 AppProperty type=powerManager.getAppPropertyById(107L);
				 log.setType(type);
				 powerManager.saveLog(log);				  
			      }
			    } catch (Exception e) {
				System.out.println("HoneyWell_Server error="+ e.toString());
			    }			    
			}
			
                        
			XMLOutputter xmlOutput = new XMLOutputter();
			Format format = Format.getPrettyFormat();
			format.setEncoding("UTF-8");
			xmlOutput.setFormat(format.getPrettyFormat());
			xmlOutput.output(doc,new FileWriter(myProperties.getG50filePath()+ "honeywellstatus.xml"));
  
		    } catch (Exception e) {
			System.out.println("HoneyWell_Server errot="+ e.toString());
		    }
		    sleep(500);
		    i++;
		}
	    } catch (Exception ex) {
		System.out.println("HoneyWell_ServerStatusXML() error..");
		System.out.println(ex.toString());
	    }
	}
    }
    
    public void pstatus(List<Device> ls){
	try{	    
	    for(int i=0;i<ls.size();i++){		
		Device d=ls.get(i);			
		//更新status		
		for(int j=0;j<status.size();j++){
		    Device dx=status.get(j);		    
		    if(dx.getId().equals(d.getId())){
			status.remove(j);						
		    }
		}		
		status.add(d);
	    }
	    panelCheck(); //面版監控  
	}catch(Exception e){
	    System.out.println("status error="+e.toString());
	}
    }
    
    public void panelCheck(){
	try{
	    ServletContext servletContext = getServletContext();
	    ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
	    PowerManager powerManager = (PowerManager) ctx.getBean("powerManager");
	   	
	    System.out.println("********************* panelCheck start **********************");
	    
	    for(int i=0;i<status.size();i++){
	     Device d=status.get(i);
	     try{
		 PowerControllerReader r=powerManager.getReaderByControllerDeviceNo(d.getPowerController(),Integer.parseInt(d.getGroup()));
		 Device current=powerManager.getHoneyWellCurrentStatus(r.getReader());
		 //System.out.println(i+"=="+r.getReader().getName()+"--now="+d.getDetection()+"--db="+current.getDetection()+"--pass="+r.getReader().getPass()+"--lock="+current.getLock());
		 
		 //取得系統溫度上限
		 BasicInfo b=powerManager.getBasicInfo();
		 int templimit=Integer.parseInt(String.valueOf(b.getTemplimit())+"0");
		 int user_temp=Integer.parseInt(String.valueOf(d.getSetTemp()).replace(".", ""));
		
		 System.out.println(i+"=="+r.getReader().getName()+"--now="+d.getDetection()+"--db="+current.getDetection()+"--pass="+r.getReader().getPass()+"--lock="+current.getLock()+"--");
		 
		 
		 
		 if(r.getReader().getPass()==false){
		   if(!d.getDetection().equals(current.getDetection()) && current.getDetection()!=null && d.getDetection()!=null)
		   {
		     System.out.println("reset reader="+r.getReader().getName());						          
		     DT200.setDevice(r.getPowerController(),r.getReader(),current.getDrive(),current.getMode(),current.getSetTemp(),current.getFanSpeed(),current.getLock(),templimit,user_temp);
		   }
		 }
		 
	     }catch(Exception e){
		 System.out.println("error controller="+d.getPowerController().getName()+"--id="+d.getGroup());
	     }
	    }
	    
	    
	    System.out.println("********************* panelCheck end **********************");
		
	}catch(Exception e){
	    System.out.println("panelCheck error="+e.toString());
	}
    }

}
