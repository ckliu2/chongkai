package test;
import java.net.*;
import java.io.*;

public class SOAP2 {

	public static void main(String[] args) {

         try{
        	 System.out.println("---------------------Send--------------------");
             
        	 String xmldata="<?xml version=\"1.0\" encoding=\"utf-8\"?> \r\n"+
                            "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">  \r\n"+
                            "<soap:Body> \r\n"+
                            "<SetDevicePowerStatus xmlns=\"http://tquark.com.tw/OGSystem/\"> \r\n"+
                            "<DeviceNo>C0203</DeviceNo> \r\n"+
                            "<Status>On</Status> \r\n"+
                            "</SetDevicePowerStatus> \r\n"+
                            "</soap:Body> \r\n"+
                            "</soap:Envelope>";
        	  
               String hostname = "140.129.140.153";
               int port = 99;
               InetAddress  addr = InetAddress.getByName(hostname);
               Socket sock = new Socket(addr, port);
                             
               BufferedWriter  wr = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream(),"UTF-8"));
               
               wr.write("POST /OGWeb/OGWebService/OGWebService.asmx HTTP/1.1");
               wr.write("\r\n");
               wr.write("Host: 140.129.140.153");
               wr.write("\r\n");
               wr.write("Content-Type: text/xml; charset=utf-8");
               wr.write("\r\n");
               wr.write("Content-Length: " + xmldata.length()); 
               wr.write("\r\n");
               wr.write("SOAPAction: \"http://tquark.com.tw/OGSystem/SetDevicePowerStatus\" ");
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
