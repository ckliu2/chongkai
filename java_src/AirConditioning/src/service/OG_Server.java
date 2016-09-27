package service;
import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.context.ApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;
import tncc.wpc.service.wpcManager;
import tncc.power.service.*;
import tncc.power.value.*;
import tncc.power.value.Reader;
import tncc.wpc.value.*;

import org.springframework.web.context.support.*;

import MITSUBISHI_G50.Device;
import MITSUBISHI_G50.DeviceConnection;

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
import java.io.BufferedOutputStream;


public class OG_Server extends HttpServlet {
	com.opensymphony.xwork.ActionSupport ww= new com.opensymphony.xwork.ActionSupport();
    private String dbuser="tncc";        //登入帳號
    private String dbpsd="tncc5952";           //登入密碼
    private String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";  //驅動程式
    private String dburl="jdbc:sqlserver://140.129.117.243:1433;DatabaseName=Power" ;    //連線
    
    private String ogurl="jdbc:sqlserver://140.129.140.58:1433;DatabaseName=OGSystem" ;    //連線
    private String oguser="schuser2";        //登入帳號
    private String ogpsd="mark2aixujxu";           //登入密碼
    public void init() throws ServletException {
		try{			
		  System.out.println("**** OG_Server init()  ****");
		  Thread thread = new Thread(new OG_ServerXML());
		  thread.start();	
		}catch (Exception ex) {		
			System.out.println(ex.toString());
	    }
	}	
	
	class OG_ServerXML extends Thread {		
		int i=0;
		com.opensymphony.xwork.ActionSupport ww= new com.opensymphony.xwork.ActionSupport();
		ServletContext servletContext=getServletContext(); 
        ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        PowerManager powerManager=(PowerManager) ctx.getBean("powerManager");
        MyProperties myProperties = (MyProperties)ctx.getBean("myProperties");
		public void run() {
			try {
				while(true) {	                   
					//System.out.println("OG_Server....");
				    try {	
				    	
				    	Element powerstatus = new Element("powerstatus");
			    		Document doc = new Document(powerstatus);
			    		doc.setRootElement(powerstatus);
			    		
			    		int k=1;
			    		AppProperty deviceType=powerManager.getAppPropertyById(46L);
				    	List<PowerController> pc=powerManager.getPowerControllerListByDeviceType(deviceType);
				      	for(int j=0;j<pc.size();j++){
				      		PowerController p=pc.get(j);
				      		//System.out.println(p.getName()+"--"+p.getIp());					      
				           try{
				        	   List ls=p.getReader();
				        	   for(int i=0;i<ls.size();i++){
				        		  Reader reader=(Reader)ls.get(i);
				        		  String status=OGServer.inquireDevicePowerStatus(reader.getName());
				        		  //System.out.println(reader.getName()+"--status="+status);
				        		  
				        		  //Element
				        		   Element door = new Element("door");		
					               door.setAttribute("id", String.valueOf(reader.getId()));
					               powerstatus.addContent(door);	
					               
					               Element mystatus = new Element("status");	
					               String ps="";						         
						           if(status.equals("true")){
						        	   ps="ON";						        	 
						           }else if(status.equals("false")){
						        	   ps="OFF";
						           }else{
						        	   ps="disconnection";
						           }
					               mystatus.addContent(ps);
					               door.addContent(mystatus); 
					               
					               Element time = new Element("time");				      
					               time.addContent(String.valueOf(Tools.getCurrentTimestamp()));
					               door.addContent(time); 		
					              
				        		  //Element
				        		  
				        		  
				        	   }	
				            }catch(Exception e){
				                	System.out.println(e.toString());
				            }				            
				      	}
                        
				      	XMLOutputter xmlOutput = new XMLOutputter();	
			    		xmlOutput.setFormat(Format.getPrettyFormat());  			    		
			    		xmlOutput.output(doc, new FileWriter(myProperties.getG50filePath()+"status1.xml"));
				        	
				      } catch (Exception e) {
				    	System.out.println("G50_Server errot="+e.toString());
				      } 
					sleep(5000);
					i++;
				}
			}
			catch (Exception ex) {
				System.out.println("DeviceStatusXML() error..");
				System.out.println(ex.toString());
			}
		}	
	}
	
	
	public CurrentUser getCurrentUser(String door){
		CurrentUser c=new CurrentUser();
		try{
		      Class.forName(driver);
		      Connection conn = DriverManager.getConnection(ogurl,oguser,ogpsd);
	    	  String sql=" select top 1 g.t_number,Employee=e.t_number+'['+e.t_Name+']',b.t_Time,during=DATEDIFF(minute, b.t_Time, getdate())"+
                          " from BizAttnDoorIOLog b,OGAtt g,OGEmp e "+
                          " where b.t_Device=g.t_pk and b.t_CardNo=e.t_MainCardNo "+
                          " and b.t_InOrOut=1 and g.t_number='"+door+"' order by b.t_Time desc";
	    	  
	    	  Statement Stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);	        
	    	  ResultSet rs= Stmt.executeQuery(sql);  
	    	  while(rs.next()){
                   c.setDoor(door);                   
                   c.setEmployee(rs.getString("Employee"));
                   c.setUseTime(rs.getString("t_Time"));
                   c.setDuring(rs.getInt("during"));
			  }
		      conn.close(); 
		}catch(Exception e){
			System.out.println(e);
		}
		return c;
	}
	
	
}
