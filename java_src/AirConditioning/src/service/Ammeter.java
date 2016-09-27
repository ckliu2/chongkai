package service;

import java.net.*;
import java.io.*;
import java.util.*;
import java.util.zip.*; 


public class Ammeter {
	
	public static void main(String[] args) {
		try{
			byte[] outStream1 = new byte[8];	
			
			
            outStream1[0] = 0;
            outStream1[1] = 3;
            outStream1[2] = 0;
            outStream1[3] = 0;
            outStream1[4] = 0;
            outStream1[5] = 2;
            outStream1[6] = 69;
            outStream1[7] = 90;
            
            System.out.println(outStream1[0]+"---"+outStream1[1]+"--"+outStream1[2]+"---"+outStream1[3]+"---"+outStream1[4]+"---"+outStream1[5]+"---6="+outStream1[6]+"---7="+outStream1[7]);
            
            byte b1 = (byte)0x00;
            byte b2 = (byte)0xC5;

            System.out.println("b1="+toUnsigned(b1));
            System.out.println("b2="+toUnsigned(b2));


            
            //byte[] CRC=new byte[2];            
            //GetCRC(outStream1, CRC);
            /*
            int h=toInt(197);
            int l=toInt(218);
            
           //-128----125---128----128----128----126
            System.out.println("h="+h+"----l="+l);
            System.out.println(" CRC high byte="+CRC[0]+"-----CRC low byte="+CRC[1]);
            // command ===  xx  03  00  00  00  02  CRC(low)  CRC(high)

            /*
             *  h=69----l=90
            byte[] test = new byte[8];
            test[0] = -128;
            
            int a= toInt(0);
            int b= toInt(3);
            int c= toInt(2);
            int d= toInt(255);
            */
            // CRC(low)=197 CRC(high)=218


            //System.out.println("outStream1[5]="+outStream1[5]);
       	 System.out.println("---------------------Send--------------------");
         
         String hostname = "140.129.140.19";
         int port = 4660;
         InetAddress  addr = InetAddress.getByName(hostname);
         Socket sock = new Socket(addr, port); 
	     DataOutputStream outData = new DataOutputStream(sock.getOutputStream());      
	     outData.write(outStream1,0,outStream1.length); 		       
	     outData.flush();

	       
         System.out.println("---------------------Response--------------------");	
         
         BufferedInputStream in = new java.io.BufferedInputStream(sock.getInputStream());
         byte[] b = new byte[1024];
         String data = "";
         int length;
         while ((length = in.read(b)) > 0)// <=0的話就是結束了
         {
             data += new String(b, 0, length);
         }

         System.out.println("我取得的值:" + data);
         in.close();
         in = null;

         
         
         // Response
        /*
         BufferedReader rd = new BufferedReader(new InputStreamReader(sock.getInputStream()));
         String line;
         while((line = rd.readLine()) != null){
   	      System.out.println(line);
         }
         */
         sock.close();
            
		}catch(Exception e){
       	 System.out.println(e.toString());
        }
		
	}
	
	
	static void GetCRC(byte[] message,  byte[] CRC) // message : Modbus指令 ； CRC : 2 Byte Checksum
    {
        int CRCFull = 0xFFFF; // CRC 的初值設成 0xFFFF
        byte CRCHigh = 127, CRCLow = 127; // CRC 的 High byte 和 Low byte
        char CRCLSB; // CRC Least signficant bit


        for (int i = 0; i < (message.length) - 2; i++)
        {
            CRCFull = (int)(CRCFull ^ message[i]); // exclusive or 


            for (int j = 0; j < 8; j++)
            {
                CRCLSB = (char)(CRCFull & 0x0001); // 取得 Least signficant bit
                CRCFull = (int)((CRCFull >> 1) & 0x7FFF); // 移去 Least signficant bit，前補0


                if (CRCLSB == 1) // 如果 Least signficant bit 為 1
                    CRCFull = (int)(CRCFull ^ 0xA001);
            }
        }
        CRC[1] = CRCHigh = (byte)((CRCFull >> 8) & 0xFF); // CRC high byte 在 後
        CRC[0] = CRCLow = (byte)(CRCFull & 0xFF); // CRC low byte 在前
    }
	
	/** 
	* from byte to int, because of byte in java is signed 
	*/  
	private static int toInt(int b) {  
	 return  b -128;  
	}  
	
	/**
	 * from byte to int, because of byte in java is signed
	 
	private static int toInt(int b) {
		return b >= 0 ? (int)b : (int)(b + 256);
	}
 */

	
	
	
	
/*
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         try{
        	 System.out.println("---------------------Send--------------------");
               
               String hostname = "140.129.140.19";
               int port = 4660;
               InetAddress  addr = InetAddress.getByName(hostname);
               Socket sock = new Socket(addr, port);      
               

               
		       DataOutputStream outData = new DataOutputStream(sock.getOutputStream()); 
	          //crc low 1A height=1C  C5DA
		       //String Cmdstring="000300000002C5DA";
		       //byte[] Data=GetCheckSum(Cmdstring);
		       byte[] Data=new byte[8];
		       Data[0]=0x00;
		       Data[1]=0x03;
		       Data[2]=0x00;
		       Data[3]=0x00;
		       Data[4]=0x00;
		       Data[5]=0x02;
		       Data[6]=0x16;
		       //Data[7]=218;
		       
		       Byte bObj1 = new Byte("03");
               System.out.println("bObj1="+bObj1);
		       
		       
		       //byte[] Data=Cmdstring.getBytes();    
		       outData.write(Data,0,Data.length); 		       
		      
		       
               System.out.println("---------------------Response--------------------");	
               // Response
               BufferedReader rd = new BufferedReader(new InputStreamReader(sock.getInputStream()));
               String line;
               while((line = rd.readLine()) != null){
         	      System.out.println(line);
               }
               //sock.close();
         }catch(Exception e){
        	 System.out.println(e.toString());
         }
 }
	*/
/*	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Ammeter..");
		try{
			   String ip="140.129.140.19";
			   int port=4660;
			   Socket socket = new Socket(ip,port);  
		       DataOutputStream outData = new DataOutputStream(socket.getOutputStream()); 
		       
               //crc low 1A height=1C  C5DA
		       String Cmdstring="000300000002C5DA";
		       byte[] Data=GetCheckSum(Cmdstring);
		       //byte[] Data=Cmdstring.getBytes();    
		       outData.write(Data,0,Data.length); 		       
		       outData.close();
		       socket.close();
		       
		       //接收資料
		   

			   
			   
		    }catch(Exception e){
		    	System.out.println(e.toString());
		    }      
		}
*/	
	/*			   
	   CRC32   crc   =   new   CRC32(); 
	   
	   crc.update( "000300000002".getBytes()); 
	   System.out.println("crc="+crc.getValue()); 
	   doChecksum("D://tmp//crc.txt");
*/
	
	private static void doChecksum(String fileName) {

        try {

            CheckedInputStream cis = null;
            long fileSize = 0;
            try {
                // Computer CRC32 checksum
                cis = new CheckedInputStream(
                        new FileInputStream(fileName), new CRC32());

                fileSize = new File(fileName).length();
                
            } catch (FileNotFoundException e) {
                System.err.println("File not found.");
                System.exit(1);
            }

            byte[] buf = new byte[128];
            while(cis.read(buf) >= 0) {
            }

            long checksum = cis.getChecksum().getValue();
            
            
            
            System.out.println(checksum + " " + fileSize + " " + fileName);

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }


    }

	public static short toUnsigned(byte b) { 
	    return (short)(b & 0xff);
	}

	
	
	
	//計算校驗和
    public static byte[] GetCheckSum(String Cmdstring)
	{		
		int iPos = Cmdstring.length();
		byte[] CmdBuff = new byte[iPos];
		
		//轉換
	     for(int i=0;i<iPos;i++){
	    	 char c=Cmdstring.charAt(i);	    	
	    	 CmdBuff[i]=(byte)c;
	     }	
		CmdBuff[0]=(byte)(CmdBuff[0]-0x30);
		byte btemp=0;
		for(int i=0;i<iPos-3;i++)
			btemp+=CmdBuff[i];

		CmdBuff[iPos-3]   = (byte)((btemp >> 4) + 0x30);
		CmdBuff[iPos-2] = (byte)((btemp & 0x0F) + 0x30);
		CmdBuff[iPos-1] = 0x0D;		
		
	     for(int i=0;i<iPos;i++){	    	
	    	 System.out.println("Af => CmdBuff["+i+"]="+CmdBuff[i]);	    	
	     }

		return CmdBuff;
	}
	
	
	
	
	}





