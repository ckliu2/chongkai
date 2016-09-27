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
   		     //�]�Ʀ^�ǭ�
		       try{
		    	   String deviceReturn=rule.getStatus().getValueUs();			    	  
			         if(deviceReturn.equals(String.valueOf(status) )){
			        	 result++;
			        	 System.out.println("�ŦX�]�Ʀ^�ǭ�");			        	 
			        	 msg+= ruleConditions(rule,"�ŦX����(�]�Ʀ^�ǭ�)",deviceReturn);
			         }
		       }catch(Exception e){}		       
		     //�]�Ʀ^�ǭ�		       
		       
   		     //���`����&�ɶ�
		       int cycle=0,time=0;		       
		       Times ts=rule.getTimes();
		          if(ts!=null){
		        	  cycle=ts.getCycle();
		        	  time=ts.getTime();
		        	  if( cycle!=0 && time!=0 ){
		        	     boolean c=wpcManager.isCycleTimeError(cycle,time,sensor);
		        	      if(c){
		        		    result++;
		        		    msg+= ruleConditions(rule,"�ŦX����(���`����&�ɶ�)",cycle+"��"+"/"+time+"��");
		        	       }		
		        	         System.out.println("���`����&�ɶ�="+c);		        	 
		        	         
		        	  }
		         }
		     //���`����&�ɶ�  	 
		       
    		 //���`����ɶ�(��)
		        if(during!=0){
		           boolean b=wpcManager.isDuringError(during,sensor) ;
		             if(b){
		            	 result++;
		            	 msg+= ruleConditions( rule,"�ŦX����(���`����ɶ���)",during+"��" );
		             }
		           System.out.println("���`����ɶ�(��)="+b);		        
		          
		        }		        
    		   //���`����ɶ�(��)
		        
		        if(decision.equals("OR")){
		        	if(result>0){
		        		 System.out.println("Ĳ�o�O���W�hOR="+msg);
		        		 send(sensor,msg,"mark@mail.tnu.edu.tw",rule);
		        	}
		        }else{
		        	if(result==4){
		        		System.out.println("Ĳ�o�O���W�hAND="+msg);
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
		  String buildinfo="�ɶ�:"+s.getCreatedDate()+"<br>�ؿv��:"+s.getController().getRoom().getBuilding().getName()+"<br>�ʱ��d��:"+s.getController().getRoom().getName()+"<br>���:"+s.getController().getName()+"<br>�P����:"+s.getName()+"<br>�]���ݩ�:"+s.getDeviceProperty().getName()+"<hr><Font Color='red'  size: x-large>�X�{���`�T��,�ЦA���T�{!</Font><hr>";
		  
		  String info=buildinfo + "Ĳ�o�O���W�h" +"<br>"+ msg;
		  info+= "<hr>�ƥ󵥯ŦW��:"+rule.getEvenLevel().getName() +"<br>�ƥ�q���u�T:"+rule.getEvenLevel().getShortMessage()+"<br>�ƥ�q�����T:"+rule.getEvenLevel().getLongMessage();
		  
		  MailHelper m=new MailHelper();
		  
		  //MailHelper m=new MailHelper("mark@mail.tnu.edu.tw", "DVR�ʱ��t��", "DVR�ʱ��t�γq���H", info);
		 // m.start();
		  //m.sendHtmlMail("mark@mail.tnu.edu.tw", "DVR�ʱ��t��", "DVR�ʱ��t�γq���H", info);
		}catch(Exception e){
			System.out.println("send error!");
		}
   }
	
	
	//����sensor
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
