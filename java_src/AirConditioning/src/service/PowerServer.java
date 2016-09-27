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
//���JJDOM���O
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
    private String dbuser="tncc";        //�n�J�b��
    private String dbpsd="tncc5952";           //�n�J�K�X
    private String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";  //�X�ʵ{��
    private String dburl="jdbc:sqlserver://140.129.117.243:1433;DatabaseName=Power" ;    //�s�u
    
	
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
							//�������
							System.out.println("�������="+s.getName()+"--"+perc);
							List<tncc.power.value.Reader> readers=s.getReader();
							sr+="<br>";
							for(int i=0;i<readers.size();i++){	
								tncc.power.value.Reader r=readers.get(i);
								System.out.println("Reader="+r.getName());
								int ReaderId=r.getReaderId(); 
								//boolean ps=OGServer.setDevicePowerStatus(r.getName(), false); //�۰ʨ���
								//System.out.println(r.getName()+"---setDevicePowerStatus="+ps);
								sr+="["+r.getName()+"] ";
								//sr+="�w�۰ʨ����q�����:";
								sleep(1000);
							}
							title=Tools.getCurrentTimestamp()+" �ŦX�۰ʨ�������: "+s.getName()+" �w��F�����e�q�ʤ���"+s.getPerc()+"%";
							//�������
							

							
							//�Ұʨƥ�q���{��
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
	 								   Alert(s,rp,a);//�ǰe�q��
	 							    }
	                               
									//�ǰeĵ�� WPC		
									//System.out.println("�ǰeĵ��...");
									//SendCmd("AAAAAAAAA");								
									//�ǰeĵ�� WPC
								   
								   
							     powerManager.saveEvenLog(e);
							   }	
                            }	      
							//�Ұʨƥ�q���{��
							
							
						}
					}
					
					if(title.equals("")){
						title="SAFE";
						//�Ѱ�ĵ�� WPC
						//System.out.println("�Ѱ�ĵ��...");
						//SendCmd("999999999");							
						//�Ѱ�ĵ�� WPC
					}
					
			        Element rootElement = new Element("Event");
			        Document document = new Document(rootElement);
		            Element t = new Element("shutmsg");
		            t.addContent(title+sr);
		            rootElement.addContent(t);
		            XMLHelper.createXmlFile(document, ww.getText("OGWebService.Even.xml"));
					
					System.out.println("�Y�ɹq�O="+rp+"  �����e�q="+contract+" �ιq%="+a);
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
	    		subject="�`�q�t�Υιq�q��";
	    		msg+="�ιq�q�w�F�ιq�w���]�w�з�,�ŦX�U�C�]�w,�t�Τw�Ұʦ۰ʨ����{��,�óq�������H��\n";
	    		msg+="�ɶ�:"+Tools.getCurrentTimestamp()+"\n";	    	
	    		msg+="�۰ʨ����{�� :"+s.getName()+"\n";
	    		msg+="�����e�q :"+basicInfo.getContract()+" (KW)\n";
	    		msg+="�����e�q�ʤ���% :"+s.getPerc()+" %\n";
	    		msg+="<font color='red'>�����ιq�ʤ��� :"+perc+"</font>\n";  
	    		msg+="<font color='red'>�����ιq�˼�(KW) :"+kw+"</font>\n";
	    		msg+="<font color='red'>�۰ʨ����q�����:"+s.getReader()+"</font>\n";
	    		msg+="�ƥ󵥯ŦW�� :"+s.getEvenlevel().getName()+"\n";
	    		msg+="�w���q�����ŦW�� :"+s.getEvenlevel().getMessenger().getName()+"\n";
	    		msg+="�w���q���s�զW�� :"+s.getEvenlevel().getMessenger().getSecuritys()+"\n";
	    		
	    		
	    		String sms=Tools.getCurrentTimestamp()+"�����ιq�˼�"+kw+"(KW)/"+perc+"%,�w�W�L�����e�q�w�۰ʱҰʨ����{��";
	    		List ls=s.getEvenlevel().getMessenger().getSecuritys();	    	
	    		for(int i=0;i<ls.size();i++){
	    			Security group=(Security)ls.get(i);
	    			List members=group.getMembers();
	    			  for(int j=0;j<members.size();j++){
	    				  Member m= (Member)members.get(j);
	    				  MailHelper.sendHtmlMail(m.getEmail(), "�`�q�t��", subject, msg);
	    				  //²�T�q��
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
		    String address = "140.129.140.17";// �s�u��ip
		    int port = 2323;// �s�u��port	 
	        Socket client = new Socket();
	        InetSocketAddress isa = new InetSocketAddress(address, port);
	        try {
	            client.connect(isa, 10000);
	            BufferedOutputStream out = new BufferedOutputStream(client
	                    .getOutputStream());
	            // �e�X�r��	           
	            //String cmd="140.129.121.245*1*7*0";
	            out.write(cmd.getBytes());
	            out.flush();
	            out.close();
	            out = null;
	            client.close();
	            client = null;
	 
	        } catch (java.io.IOException e) {
	            //System.out.println("Socket�s�u�����D !");
	            //System.out.println("IOException :" + e.toString());
	        }
	    }
	    

	  
	  
	    public static void main(String[] args) {
	    	System.out.println("test...");
			
	    	//SMS.FetSendMsg("0958058735", "msg07");
			//�ǰeĵ�� WPC		
			
			//SendCmd("AAAAAAAAA");								
			//�ǰeĵ�� WPC
			
			
				
			SendCmd("999999999");							
			//�Ѱ�ĵ�� WPC
	    }
	  
	
}
