package apserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import apserver.watcher.Reader;




public class socket {
	
	private static ServerSocket serverSocket;
	DataInputStream  in; 
	public static String recive="";
	Init init=new Init();

	public socket(){
		try{
		  System.out.println("socket  listen 8082 init()");
          serverSocket = new ServerSocket( 8082 );
		  Thread thread = new Thread(new listen(serverSocket));
		  thread.start();
		  //init.start();
		}catch (Exception ex) {		
			System.out.println(ex.toString());
	    }
	}
	
	
	//listen
	class listen implements Runnable {
		private ServerSocket serverSocket;
		private Socket clientSocket;
		DataInputStream  in;
		DataOutputStream out;

		public listen(ServerSocket serverSocket) throws Exception {
			this.serverSocket = serverSocket;
		}
		
		public void run() {
			try {
				while(true) {
					clientSocket = serverSocket.accept();	
					
					
					
					System.out.println("Connection from " + clientSocket.getInetAddress().getHostAddress());	
					in  = new DataInputStream (clientSocket.getInputStream());				
					String inData=in.readLine();
					System.out.println("receive Data="+inData);						
					setRecive(inData);
					
				}
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	 }	
	
	public static String getRecive() {
		return recive;
	}


	public static void setRecive(String recive) {
		socket.recive = recive;
	}
	
	  /**
	 * ²MªÅreceive data
	 * */
		 class  Init extends Thread{
			int i=0;
			public void run(){	
				try{
					while(true){
					
				     System.out.println("Init() setRecive()");
				     
				     System.out.println("init() getRecive().length()"+getRecive().length());
				    /* if(getRecive().length()==0){
					   setRecive("");
				     }
				     setRecive("");*/
				     setRecive("");
				     
					 sleep(1000);	
					}
				}catch(Exception e){
					 System.out.println("Init() fail..");
				}
			}
		}
}
