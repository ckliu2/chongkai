package tncc.wpc.web.action;

import tncc.wpc.value.*;
import tncc.wpc.service.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.opensymphony.xwork.ActionContext;
import com.base.util.Tools;
import com.base.value.*;
//import spring
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.*;
import org.springframework.web.context.support.WebApplicationContextUtils;
import javax.servlet.*;
import javax.servlet.http.*;
import com.opensymphony.xwork.ActionContext;
import com.opensymphony.xwork.ActionSupport;
import com.common.mail.MailHelper;

//extends CommonActionSupport
public class PolicyActiontest extends  ActionSupport
{
	ServletContext servletContext =  getSession().getServletContext();
	ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
	wpcManager wpcManager =(wpcManager) ctx.getBean("wpcManager");
	int i=0;
	String msg;	
	public void setWorkflow(Sensor sensor,int status){
    	try{       
    	    System.out.println(sensor.getName()+"  status="+status);
    	    DeviceProperty deviceProperty=sensor.getDeviceProperty();   
    	              
    	   }catch(Exception e){
    		System.out.println("PolicyAction setWorkflow="+e.toString());
    	  }
    	}
	

	
	public void setWorkflow1(Sensor sensor,int status){
    	try{
       
    	System.out.println(sensor.getName()+"  status="+status);
    	DeviceProperty deviceProperty=sensor.getDeviceProperty();    	
    	//System.out.println("deviceProperty.getName()="+deviceProperty.getName());
    	
    	List<Rule> rules=wpcManager.getRuleListByDeviceProperty(deviceProperty);
    	  for(int i=0;i<rules.size();i++){
    		   Rule rule=(Rule)rules.get(i);   
    		   String decision=rule.getDecision().getValueTw(); 
   		       int during=rule.getDuring();  
   		       int result=0;
   		    
   		       String msg="";
   		     //設備回傳值
		       try{
		    	   String deviceReturn=rule.getStatus().getValueUs();			    	  
			         if(deviceReturn.equals(String.valueOf(status) )){
			        	 result++;
			        	 System.out.println("符合設備回傳值");			        	 
			        	 msg+= ruleConditions(rule,"符合條件(設備回傳值)",deviceReturn);
			         }
		       }catch(Exception e){}		       
		     //設備回傳值		       
		       
   		     //異常次數&時間
		       int cycle=0,time=0;		       
		       Times ts=rule.getTimes();
		          if(ts!=null){
		        	  cycle=ts.getCycle();
		        	  time=ts.getTime();
		        	  if( cycle!=0 && time!=0 ){
		        	     boolean c=wpcManager.isCycleTimeError(cycle,time,sensor);
		        	      if(c){
		        		    result++;
		        		    msg+= ruleConditions(rule,"符合條件(異常次數&時間)",cycle+"次"+"/"+time+"秒");
		        	       }		
		        	         System.out.println("異常次數&時間="+c);		        	 
		        	         
		        	  }
		         }
		     //異常次數&時間  	 
		       
    		 //異常持續時間(秒)
		        if(during!=0){
		           boolean b=wpcManager.isDuringError(during,sensor) ;
		             if(b){
		            	 result++;
		            	 msg+= ruleConditions( rule,"符合條件(異常持續時間秒)",during+"秒" );
		             }
		           System.out.println("異常持續時間(秒)="+b);		        
		          
		        }		        
    		   //異常持續時間(秒)
		        
		        if(decision.equals("OR")){
		        	if(result>0){
		        		 System.out.println("觸發保全規則OR="+msg);
		        		 send(sensor,msg,"mark@mail.tnu.edu.tw",rule);
		        	}
		        }else{
		        	if(result==4){
		        		System.out.println("觸發保全規則AND="+msg);
		        		send(sensor,msg,"mark@mail.tnu.edu.tw",rule);
		        	}
		        }
		        
    	   } 	
  
    	}catch(Exception e){
    		System.out.println("PolicyAction setWorkflow="+e.toString());
    	}
    	
    }
	
	public String ruleConditions(Rule r,String txt,String value){
		return r.getName()+" ----> "+txt+" ----> "+value+"\n";
	}
	
	public void send(Sensor s,String msg,String sender,Rule rule){
		try{
		  String buildinfo="時間:"+s.getCreatedDate()+"<br>建築物:"+s.getController().getRoom().getBuilding().getName()+"<br>監控範圍:"+s.getController().getRoom().getName()+"<br>控制器:"+s.getController().getName()+"<br>感應器:"+s.getName()+"<br>設備屬性:"+s.getDeviceProperty().getName()+"<hr><Font Color='red'  size: x-large>出現異常訊息,請再次確認!</Font><hr>";
		  
		  String info=buildinfo + "觸發保全規則" +"<br>"+ msg;
		  info+= "<hr>事件等級名稱:"+rule.getEvenLevel().getName() +"<br>事件通報短訊:"+rule.getEvenLevel().getShortMessage()+"<br>事件通報長訊:"+rule.getEvenLevel().getLongMessage();
		  
		  MailHelper m=new MailHelper();
		  
		  //MailHelper m=new MailHelper("mark@mail.tnu.edu.tw", "DVR監控系統", "DVR監控系統通知信", info);
		 // m.start();
		  //m.sendHtmlMail("mark@mail.tnu.edu.tw", "DVR監控系統", "DVR監控系統通知信", info);
		}catch(Exception e){
			System.out.println("send error!");
		}
   }
	
	
	//接收sensor
	public void setSysDetection(String value){
		try{
			System.out.println("setSysDetection");
			/*System.out.println("setSysDetection.."+i);
			i++;*/
		}catch(Exception e){
			System.out.println("sysDetection() error!");
		}
	}
	
	public String list(){
		System.out.println("PolicyAction list()");
		return SUCCESS;
	}
	
	
    public HttpSession getSession() 
    {
        ActionContext ctx = ActionContext.getContext();
        HttpServletRequest req = (HttpServletRequest) ctx.get("com.opensymphony.xwork.dispatcher.HttpServletRequest");
        HttpSession session = req.getSession();    
        return session;
    }
    
	public String getMsg() {
		return msg;
	}



	public void setMsg(String msg) {
		this.msg = msg;
	}

   
}
