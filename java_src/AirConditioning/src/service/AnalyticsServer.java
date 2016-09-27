package service;
import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import org.springframework.context.ApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import tncc.wpc.service.wpcManager;
import tncc.wpc.value.*;

import org.springframework.web.context.support.*;

import com.base.util.Tools;
import com.base.value.*;
import com.opensymphony.xwork.ActionContext;

import java.io.*;
//載入JDOM類別
import org.jdom.*;
import org.jdom.output.XMLOutputter;
import com.common.util.XMLHelper;


public class AnalyticsServer extends HttpServlet {
	com.opensymphony.xwork.ActionSupport ww= new com.opensymphony.xwork.ActionSupport();
	
	public void init() throws ServletException {
		try{
			
		  System.out.println("**** AnalyticsServer init()  ****");
		  Thread thread = new Thread(new AnalyticsRule(Integer.parseInt(ww.getText("wpc.sysDetection.sec"))));
		  thread.start();
		}catch (Exception ex) {		
			System.out.println(ex.toString());
	    }
	}	
	
	class AnalyticsRule extends Thread {		
		ArrayList<Sensor> sensorserr = new ArrayList<Sensor>();
		DataInputStream  in;
		DataOutputStream out;
		int sec;
		int i=0;
		com.opensymphony.xwork.ActionSupport ww= new com.opensymphony.xwork.ActionSupport();
		ServletContext servletContext=getServletContext(); 
        ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        wpcManager manager=(wpcManager) ctx.getBean("wpcManager");
		
		public AnalyticsRule(int sec) throws Exception {
			this.sec=sec;
		}
		
		public void run() {
			try {
				while(true) {	
					//System.out.println("=========== AnalyticsRule =========="+i);
					
					java.sql.Timestamp ts = Tools.getCurrentTimestamp();
			    	//保全規則
			    	List<Rule> rules=manager.getRuleList();
			    	  for(int i=0;i<rules.size();i++){
			    		  Rule rule=(Rule)rules.get(i);
			    		  System.out.println("rule name="+rule.getName());
			    		  List l=rule.getConditions();
			    		    for(int j=0;j<l.size();j++){
			    		    	AppProperty a=(AppProperty)l.get(j);			    		    	
			    		    	//System.out.println("l="+a.getId()+"__"+a.getSubKind()+" "+a.getValueTw());
			    		    	
			    		    	switch(Integer.parseInt(String.valueOf(a.getId()))){

			    		    	   case 27:  //設備回傳值
			    				       
					    		   break; 
			    			       case 28:  //異常次數.時間			    				      
			    				       
						    	   break;
			    		    	}
			    		    }		    		    

		    		    	 
			    		    List<Sensor> sensor =manager.isRuleSetup(rule.getTimes(), rule.getDeviceProperty(), rule.getStatus());
			    		    sensorserr.addAll(sensor);
			    		    
			    		    //建立根元素	
			    	        Element rootElement = new Element("DeviceStatus");
			    	        Document document = new Document(rootElement);
			    	        //建立子元素
			    	        
				    		for(int j=0;j<sensor.size();j++){	    		    		 
		    		    	      System.out.println("有問題的sensor="+sensor.get(j).getName());
		    		    	      
		    		    	      Element statusElement = new Element("status");
		    		    	      rootElement.addContent(statusElement);
		    		    	      
		    		    	      Element sensorElement = new Element("sensor");
		    		    	      sensorElement.addContent(String.valueOf(sensor.get(j).getId()));
		    		    	      statusElement.addContent(sensorElement);
		    		    	      
					    	      /*Element sensorElement = new Element("sensor");
					    	      sensorElement.addContent(String.valueOf(sensor.get(j).getId()));
					    	      rootElement.addContent(sensorElement);	*/  
				    		}
				    		
				    		/*if(sensor.size()==0){
		    		    	      Element statusElement = new Element("status");
		    		    	      rootElement.addContent(statusElement);
		    		    	      
		    		    	      Element sensorElement = new Element("sensor");
		    		    	     
		    		    	      statusElement.addContent(sensorElement);
				    		}*/


			    	        
			    	     // 輸出XML文件        			    	        
			    	        XMLHelper.createXmlFile(document, ww.getText("wpc.status.xml"));
			    		    

			    		  
			    	  }
			    	  
			    	  
		    		   /*for(int j=0;j<sensorserr.size();j++){
 		    		 
	    		    	System.out.println("有問題的sensor="+sensorserr.get(j).getName());
  		    	       }*/
					
					
					
					
					
					sleep(sec);
					i++;
				}
			}
			catch (Exception ex) {
				System.out.println("AnalyticsRule() error..");
				System.out.println(ex.toString());
			}
		}	

	}	
	
}
