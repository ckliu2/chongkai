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
import com.base.util.Tools;
import com.base.value.*;
import com.opensymphony.xwork.ActionContext;
import java.sql.*;
import java.io.*;
//載入JDOM類別
import org.jdom.*;
import org.jdom.output.XMLOutputter;
import com.common.util.XMLHelper;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.io.BufferedOutputStream;

import com.common.mail.*;
import com.common.value.*;


public class PowerServer extends HttpServlet {
	com.opensymphony.xwork.ActionSupport ww= new com.opensymphony.xwork.ActionSupport();
    private String dbuser="tncc";        //登入帳號
    private String dbpsd="tncc5952";           //登入密碼
    private String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";  //驅動程式
    private String dburl="jdbc:sqlserver://140.129.117.243:1433;DatabaseName=Power" ;    //連線
    
	
    public void init() throws ServletException {
		try{
			
		  System.out.println("**** OGServer init()  ****");
		  Thread thread = new Thread(new RealPower());
		  thread.start();
		}catch (Exception ex) {		
			System.out.println(ex.toString());
	    }
	}	
	
	class RealPower extends Thread {		
		int i=0;
		com.opensymphony.xwork.ActionSupport ww= new com.opensymphony.xwork.ActionSupport();
		ServletContext servletContext=getServletContext(); 
        ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        wpcManager wpcManager=(wpcManager) ctx.getBean("wpcManager");
        PowerManager powerManager=(PowerManager) ctx.getBean("powerManager");

		public void run() {
			try {
				while(true) {	
					//System.out.println("=========== RealPower =========="+i);
					float rp=getRealPower();					
					int contract=powerManager.getBasicInfoById(1L).getContract();
					int a=(int)((rp/contract)*100);		
					

					String title="",sr="";
					List<Shutdown> shutdowns=powerManager.getShutdownList();		

					for(int j=0;j<shutdowns.size();j++){	
						Shutdown s=shutdowns.get(j);
						int perc=s.getPerc();
						//System.out.println(s.getName()+"--"+perc);						
						if(a>perc || a==perc){
							//執行卸載
							System.out.println("執行卸載="+s.getName()+"--"+perc);
							List<tncc.power.value.Reader> readers=s.getReader();
							sr+="<br>";
							for(int i=0;i<readers.size();i++){	
								tncc.power.value.Reader r=readers.get(i);
								System.out.println("Reader="+r.getName());
								int ReaderId=r.getReaderId(); 
								//boolean ps=OGServer.setDevicePowerStatus(r.getName(), false); //自動卸載
								//System.out.println(r.getName()+"---setDevicePowerStatus="+ps);
								sr+="["+r.getName()+"] ";
								//sr+="已自動卸載電源控制器:";
								sleep(1000);
							}
							title=Tools.getCurrentTimestamp()+" 符合自動卸載條件: "+s.getName()+" 已到達契約容量百分比"+s.getPerc()+"%";
							//執行卸載
							

							
							//啟動事件通報程序
							System.out.println(s.getEvenlevel().getName()+"--"+s.getGap());
     		                 EvenLog e=new EvenLog();
						     e.setCreatedDate(Tools.getCurrentTimestamp());
						     e.setKw(rp);
						     e.setPerc(a);
						     e.setShutdownprc(s);	
						     e.setAlertmsg(false);
							EvenLog LastTime=powerManager.getEvenLogLastTime();
                            if(LastTime==null){
                            	powerManager.saveEvenLog(e);
                            }else{
                               
							   if( (Tools.getCurrentTimestamp().getTime() - LastTime.getCreatedDate().getTime() ) >60000){
								   
	                               if( powerManager.isAlert(s.getGap()) ){
	                            	   e.setAlertmsg(true);
	 								   Alert(s,rp,a);//傳送通知
	 							    }
	                               
									//傳送警報 WPC		
									//System.out.println("傳送警報...");
									//SendCmd("AAAAAAAAA");								
									//傳送警報 WPC
								   
								   
							     powerManager.saveEvenLog(e);
							   }	
                            }	      
							//啟動事件通報程序
							
							
						}
					}
					
					if(title.equals("")){
						title="SAFE";
						//解除警報 WPC
						//System.out.println("解除警報...");
						//SendCmd("999999999");							
						//解除警報 WPC
					}
					
			        Element rootElement = new Element("Event");
			        Document document = new Document(rootElement);
		            Element t = new Element("shutmsg");
		            t.addContent(title+sr);
		            rootElement.addContent(t);
		            XMLHelper.createXmlFile(document, ww.getText("OGWebService.Even.xml"));
					
					System.out.println("即時電力="+rp+"  契約容量="+contract+" 用電%="+a);
					sleep(30000);
					i++;
				}
			}
			catch (Exception ex) {
				System.out.println("AnalyticsRule() error..");
				System.out.println(ex.toString());
			}
		}	
		
		
	    public void Alert(Shutdown s,float kw,float perc) {
	    	try{
	    		BasicInfo basicInfo=powerManager.getBasicInfoById(1L);
	    		
	    		String msg="",subject="",mail="";
	    		subject="節電系統用電通知";
	    		msg+="用電量已達用電安全設定標準,符合下列設定,系統已啟動自動卸載程序,並通知相關人員\n";
	    		msg+="時間:"+Tools.getCurrentTimestamp()+"\n";	    	
	    		msg+="自動卸載程序 :"+s.getName()+"\n";
	    		msg+="契約容量 :"+basicInfo.getContract()+" (KW)\n";
	    		msg+="契約容量百分比% :"+s.getPerc()+" %\n";
	    		msg+="<font color='red'>瞬間用電百分比 :"+perc+"</font>\n";  
	    		msg+="<font color='red'>瞬間用電瓦數(KW) :"+kw+"</font>\n";
	    		msg+="<font color='red'>自動卸載電源控制器:"+s.getReader()+"</font>\n";
	    		msg+="事件等級名稱 :"+s.getEvenlevel().getName()+"\n";
	    		msg+="安全通報等級名稱 :"+s.getEvenlevel().getMessenger().getName()+"\n";
	    		msg+="安全通報群組名稱 :"+s.getEvenlevel().getMessenger().getSecuritys()+"\n";
	    		
	    		
	    		String sms=Tools.getCurrentTimestamp()+"瞬間用電瓦數"+kw+"(KW)/"+perc+"%,已超過契約容量已自動啟動卸載程序";
	    		List ls=s.getEvenlevel().getMessenger().getSecuritys();	    	
	    		for(int i=0;i<ls.size();i++){
	    			Security group=(Security)ls.get(i);
	    			List members=group.getMembers();
	    			  for(int j=0;j<members.size();j++){
	    				  Member m= (Member)members.get(j);
	    				  MailHelper.sendHtmlMail(m.getEmail(), "節電系統", subject, msg);
	    				  //簡訊通知
	    				  SMS.FetSendMsg(m.getCellphone(), sms);  
	    			  }
	    		}
	    		
	    	}catch(Exception e){
	    		System.out.println(e.toString());
	    	}	    	
	    }
	}
	
	  public float getRealPower() {  	
	      float power=0;
		  try{        
		      Class.forName(driver);
		      Connection conn = DriverManager.getConnection(dburl,dbuser,dbpsd);
	    	  String sql="select top 1 * from dbo.A01_01 order by id desc";
	    	  Statement Stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);	        
	    	  ResultSet rs= Stmt.executeQuery(sql); 	 
			  while(rs.next()){
				  power=Float.parseFloat(rs.getString("W"));
			  }
		      conn.close(); 
		      //System.out.println("getRealPower=="+power);
	     }catch(Exception e){    	    
	            System.out.println("getRealPower() fail!");	 
	            System.out.println(e.toString());	 
	      }
	     return power;
	  } 
	  
	  

	 
	    public static void SendCmd(String cmd) {	    	
		    String address = "140.129.140.17";// 連線的ip
		    int port = 2323;// 連線的port	 
	        Socket client = new Socket();
	        InetSocketAddress isa = new InetSocketAddress(address, port);
	        try {
	            client.connect(isa, 10000);
	            BufferedOutputStream out = new BufferedOutputStream(client
	                    .getOutputStream());
	            // 送出字串	           
	            //String cmd="140.129.121.245*1*7*0";
	            out.write(cmd.getBytes());
	            out.flush();
	            out.close();
	            out = null;
	            client.close();
	            client = null;
	 
	        } catch (java.io.IOException e) {
	            //System.out.println("Socket連線有問題 !");
	            //System.out.println("IOException :" + e.toString());
	        }
	    }
	    

	  
	  
	    public static void main(String[] args) {
	    	System.out.println("test...");
			
	    	//SMS.FetSendMsg("0958058735", "msg07");
			//傳送警報 WPC		
			
			//SendCmd("AAAAAAAAA");								
			//傳送警報 WPC
			
			
				
			SendCmd("999999999");							
			//解除警報 WPC
	    }
	  
	
}
