package service;
import java.net.*;
import java.io.*;
import java.util.*;
import java.util.zip.*; 

public class test  {

	public static void main(String[] args) {
	 try{
		Byte[] Data = new Byte[8];
		Data[0] = 0x00;
		Data[1] = 0x03;
		Data[2] = 0x00;
		Data[3] = 0x00;
		Data[4] = 0x00;
		Data[5] = 0x02;
		Data[6] = 0x00;

		String hostname = "140.129.140.19";
        int port = 4660;
        InetAddress  addr = InetAddress.getByName(hostname);
        Socket sock = new Socket(addr, port);      
        DataOutputStream outData = new DataOutputStream(sock.getOutputStream()); 
        //outData.write(Data,0,Data.length); 	
       

        
        
        sock.close();
        
        
	 }catch(Exception e){
    	  System.out.println(e.toString());
      }
        
		
		
	}

}
