package test;
import java.net.*;
import java.io.*;

public class SOAP {

	public static void main(String[] args) {

         try{
        	 System.out.println("---------------------Send--------------------");
             
        	 String xmldata="<?xml version=\"1.0\" encoding=\"utf-8\"?> \r\n"+
                            "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\"> \r\n"+
                            "<soap:Body> \r\n"+
                            "<course_room xmlns=\"http://tempuri.org/ws2004/classroom\"> \r\n"+
                            "<id>nexmsart</id> \r\n"+
                            "<v_semester>1021</v_semester> \r\n"+
                            "</course_room> \r\n"+
                            "</soap:Body> \r\n"+
                            "</soap:Envelope> \r\n";
        	  
               String hostname = "info.ntust.edu.tw";
               int port = 80;
               InetAddress  addr = InetAddress.getByName(hostname);
               Socket sock = new Socket(addr, port);
                             
               BufferedWriter  wr = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream(),"UTF-8"));
               
               wr.write("POST /faith/ws2004/classroom.asmx HTTP/1.1");
               wr.write("\r\n");
               wr.write("Host: info.ntust.edu.tw");
               wr.write("\r\n");
               wr.write("Content-Type: text/xml; charset=utf-8");
               wr.write("\r\n");
               wr.write("Content-Length: " + xmldata.length()); 
               wr.write("\r\n");
               wr.write("SOAPAction: \"http://tempuri.org/ws2004/classroom/course_room\" ");
               wr.write("\r\n");     
               System.out.println(xmldata);
               //Send data
               wr.write(xmldata);
               wr.flush();
               
               System.out.println("---------------------Response--------------------");	
               // Response
               BufferedReader rd = new BufferedReader(new InputStreamReader(sock.getInputStream()));
               String line;
               while((line = rd.readLine()) != null){
         	      System.out.println(line);
               }
               
         }catch(Exception e){
        	 System.out.println(e.toString());
         }
 }

}
