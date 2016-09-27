package service;
import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import java.io.*;
import java.net.*;
import tncc.wpc.service.wpcManager;
import tncc.wpc.web.action.*;







public class wpcServer extends HttpServlet {	
	private static ServerSocket serverSocket;
	DataInputStream  in; 
	com.opensymphony.xwork.ActionSupport ww= new com.opensymphony.xwork.ActionSupport();
	static public String receice="";
	
	
	public void init() throws ServletException {
		try{
		  System.out.println("**** wpcServer init() listen "+ww.getText("wpc.serversocket.port")+" port ****");
          serverSocket = new ServerSocket( Integer.parseInt(ww.getText("wpc.serversocket.port")) );
		  Thread thread = new Thread(new listenClient(serverSocket));
		  thread.start();
		}catch (Exception ex) {		
			System.out.println(ex.toString());
	    }
	}
	
	
	public static String getReceice() {
		return receice;
	}

	public static void setReceice(String receice) {
		wpcServer.receice = receice;
	}
}



class listenClient implements Runnable {
	
	private ServerSocket serverSocket;
	private Socket clientSocket;
	DataInputStream  in;
	DataOutputStream out;
	com.opensymphony.xwork.ActionSupport ww= new com.opensymphony.xwork.ActionSupport();
	
	/*ServletContext servletContext=getServletContext(); 
    ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
    wpcManager manager=(wpcManager) ctx.getBean("wpcManager");
	*/
	public listenClient(ServerSocket serverSocket) throws Exception {
		this.serverSocket = serverSocket;
	}
	
	public void run() {
		try {
			while(true) {
				clientSocket = serverSocket.accept();
				//System.out.println("Connection from " + clientSocket.getInetAddress().getHostAddress());	
				in  = new DataInputStream (clientSocket.getInputStream());				
				String inData=in.readLine();
				//System.out.println("receive Data="+inData);		
				//sendToPolice(inData); //傳送至警衛室
				setSimulation(inData); //模擬WEB
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	//模擬WEB
	public void setSimulation(String msg){
		try{	         
			int num;
            byte buf[]=new byte[4096];
            String s=ww.getText("wpc.sysDetection.url")+"?msg="+msg;
            //System.out.println("setSimulation s="+s);
			URL url=new URL(s);
			//URL url=new URL("http://140.129.140.55:8080/wpc/sysDetection.html?msg="+msg);
            DataInputStream di = new DataInputStream(url.openStream());	
		   /* while(( num=di.read(buf)) !=-1 )	{
        	    //System.out.write(buf,0,num);                       
           }		   
		   System.out.println(">>> " + url + " 開啟成功!!"); */		 
		  }catch(Exception e){
			  System.out.println("simulationWeb() fail------->"+e.toString());
		  }
		
	}
	
	
	
	
	
	
	//傳送至警衛室
	public void sendToPolice(String msg){
		 try{	          
			  String ip=ww.getText("wpc.police.ip");	
	          int port=Integer.parseInt( ww.getText("wpc.police.port") );          
	          Socket socket = new Socket(ip, port);	          
	          PrintWriter out = new PrintWriter(socket.getOutputStream(),true);	        
			  out.println(msg);
			  System.out.println("sendToPolice() to "+ww.getText("wpc.police.ip"));
			  out.close();			  
			  socket.close();
		  }catch(Exception e){
			  System.out.println("sendToPolice() fail");
		  }
		
	}
	
}
