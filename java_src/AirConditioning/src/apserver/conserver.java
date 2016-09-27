package apserver;
import java.net.*;
import java.io.*;
public class conserver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動產生方法 Stub
		InputStream Is; 
		OutputStream Os;
		DataInputStream DIS; 
		PrintStream PS; 

        System.out.println("connect..");
        try{        
          String ip="140.129.140.54";	
          int port=8082;          
          Socket socket = new Socket(ip, port);
          
          PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
          String writeTo="001001001tncc5953A1";
		  out.println(writeTo);
		  out.close();
		  
		  socket.close();

        }catch(Exception e){
        	System.out.println(e.toString());
        }
        
	}

}
