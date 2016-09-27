package service;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import tncc.wpc.value.Room;
import tncc.wpc.value.Sensor;

public class test0813 {

	static com.opensymphony.xwork.ActionSupport ww= new com.opensymphony.xwork.ActionSupport();
	static String OGWebService="http://140.118.18.221/OGWeb/OGWebService/OGWebService.asmx";
	
    public static void main(String[] args) {
    	//setDevicePowerStatus("¥~»«±JªÙ-1501",true);
    	System.out.println("inquireDevicePowerStatus="+inquireDevicePowerStatus("¥~»«±JªÙ-1501"));
    }
    
    
	
	public static void main2(String[] args) {
		// TODO Auto-generated method stub

		
		URL url = null;
	    HttpURLConnection httpurlconnection = null;
         try{
        	 System.out.println("---------------------Send--------------------");

	 
String xmldata =
"<?xml version=\"1.0\" encoding=\"utf-8\"?>	\r\n"+
"<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\"> \r\n"+
"<soap:Body> \r\n"+
  "<SetGroup2 xmlns=\"http://tquark.com.tw/OGSystem/\"> \r\n"+
    "<GroupNo>C01</GroupNo> \r\n"+
    "<GroupName>Computer Of Center</GroupName> \r\n"+
    "<InfoClass> \r\n"+
      "<ManagerNos> \r\n"+
        "<string>950201</string> \r\n"+
      "</ManagerNos> \r\n"+
      "<MemberNos> \r\n"+
        "<string>950201</string> \r\n"+
      "</MemberNos> \r\n"+
    "</InfoClass> \r\n"+
    "<downloadMode>Queue</downloadMode> \r\n"+
  "</SetGroup2> \r\n"+
"</soap:Body> \r\n"+
"</soap:Envelope> \r\n"
;


        	 url = new URL(OGWebService);

             httpurlconnection = (HttpURLConnection) url.openConnection();
             httpurlconnection.setDoOutput(true);
             httpurlconnection.setRequestMethod("POST");
             httpurlconnection.setRequestProperty("Content-type","text/xml; charset=utf-8");
             httpurlconnection.setRequestProperty("Content-Length",String.valueOf(xmldata.length()));

             
             httpurlconnection.getOutputStream().write(xmldata.getBytes());
             httpurlconnection.getOutputStream().flush();
             httpurlconnection.getOutputStream().close();
             //System.out.println(xmldata);
             
             //System.out.println("---------------------Response--------------------");	
             
             int code = httpurlconnection.getResponseCode();             
             System.out.println("code   " + code);      
             System.out.println("Msg   " + httpurlconnection.getResponseMessage());
             System.out.println("Content-Length   " + httpurlconnection.getContentLength());
             
             BufferedReader rd = new BufferedReader(new InputStreamReader(httpurlconnection.getInputStream()));
             String line;
             while((line = rd.readLine()) != null){
       	      //System.out.println(line);
             }
             

         }catch(Exception e){
        	 System.out.println(e.toString());
         }
         
 }
	
	
	public static String inquireOGerver(String xmldata){
		String value="";
         try{     
        	 System.out.println("inquireOGerver...");
        	 URL url = null;
        	 HttpURLConnection httpurlconnection = null;
        	 url = new URL(OGWebService);
        	 //url = new URL(ww.getText("OGWebService"));             
             httpurlconnection = (HttpURLConnection) url.openConnection();
             httpurlconnection = (HttpURLConnection) url.openConnection();
             httpurlconnection.setDoOutput(true);
             httpurlconnection.setRequestMethod("POST");
             httpurlconnection.setRequestProperty("Content-type","text/xml; charset=utf-8");
             httpurlconnection.setRequestProperty("Content-Length",String.valueOf(xmldata.length()));             
             httpurlconnection.getOutputStream().write(xmldata.getBytes("utf-8"));
             httpurlconnection.getOutputStream().flush();
             httpurlconnection.getOutputStream().close();
             System.out.println("---------------------Response--------------------");	
             InputStreamReader isr = new InputStreamReader(httpurlconnection.getInputStream(), "UTF-8");
             BufferedReader rd = new BufferedReader(isr);
             //BufferedReader rd = new BufferedReader(new InputStreamReader(httpurlconnection.getInputStream()));
              String line;
              while((line = rd.readLine()) != null){
            	  value+=line;
        	      //System.out.println("line="+line);
              }
              rd.close();
              httpurlconnection.disconnect();
		}catch(Exception e){
			System.out.println("InquireOGerver error="+e.toString());
		}
		return value;
	}
	
	public static boolean setOGerver(String xmldata){
		boolean value=false;
         try{               	 
        	 URL url = null;
        	 HttpURLConnection httpurlconnection = null;
        	 url = new URL(OGWebService);
        	 //url = new URL(ww.getText("OGWebService"));             
             httpurlconnection = (HttpURLConnection) url.openConnection();
             httpurlconnection = (HttpURLConnection) url.openConnection();
             httpurlconnection.setDoOutput(true);
             httpurlconnection.setRequestMethod("POST");
             httpurlconnection.setRequestProperty("Content-type","text/xml; charset=utf-8");
             httpurlconnection.setRequestProperty("Content-Length",String.valueOf(xmldata.length()));             
             httpurlconnection.getOutputStream().write(xmldata.getBytes("utf-8"));
             httpurlconnection.getOutputStream().flush();
             httpurlconnection.getOutputStream().close();
             String msg=httpurlconnection.getResponseMessage();
             int code = httpurlconnection.getResponseCode();    
            
              System.out.println(xmldata);
              System.out.println("code   " + code);   
              System.out.println("Msg   " + httpurlconnection.getResponseMessage());
              if(code==200 && msg.equals("OK")){
            	  value=true;
              }  
              
              //System.out.println("---------------------Response--------------------");	
              InputStreamReader isr = new InputStreamReader(httpurlconnection.getInputStream(), "UTF-8");
              BufferedReader rd = new BufferedReader(isr);
              //BufferedReader rd = new BufferedReader(new InputStreamReader(httpurlconnection.getInputStream()));
              String line;
              while((line = rd.readLine()) != null){
        	      System.out.println(line);
              }
              rd.close();
              
              
              httpurlconnection.disconnect();
		}catch(Exception e){
			//System.out.println("setOGerver error="+e.toString());
		}
		return value;
	}
	
	
	
	public static boolean inquireDevicePowerStatus(String door){		
		boolean ps=false;	
   	    String xmldata ="<?xml version=\"1.0\" encoding=\"utf-8\"?> \r\n"+
	                    "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\"> \r\n"+
	                    "<soap:Body> \r\n"+
	                    "<InquireDevicePowerStatus  xmlns=\"http://tquark.com.tw/OGSystem/\"> \r\n"+
	                    "<DeviceNo>"+door+"</DeviceNo> \r\n"+        			     
	                    "</InquireDevicePowerStatus > \r\n"+
	                    "</soap:Body> \r\n"+
	                    "</soap:Envelope> \r\n";  
   	    System.out.println("inquireDevicePowerStatus="+xmldata);
      	String xml= inquireOGerver(xmldata);
      	System.out.println("xml="+xml);
      	
      	 try {  
      	
      		OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream("D://tmp//a3.xml"),"UTF-8");
      		out.write(xml);
      		out.flush();
      	    out.close();

      
      		
      		File fXmlFile=new File("D://tmp//a3.xml");
      		
      		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
      	    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();      	 
      	    Document doc = dBuilder.parse(fXmlFile);
      	  
      	    doc.getDocumentElement().normalize();      	 
      	    NodeList nList = doc.getElementsByTagName("InquireDevicePowerStatusResult");
      	    System.out.println("-----------------------"+nList.getLength());      	 
      	    for (int temp = 0; temp < nList.getLength(); temp++) {      	    	
      	    	 Node nNode = nList.item(temp);	    
        	       if (nNode.getNodeType() == Node.ELEMENT_NODE) {      	 
        	          Element eElement = (Element) nNode;
        	          String Status=getTagValue("Status",eElement);
        	          System.out.println("Status="+Status);
        	           if(Status.equals("On")){
        	        	   ps=true;
        	        	   System.out.println("ps=true");
        	           }else{
        	        	   ps=false;
        	        	   System.out.println("ps=false");
        	           }
        	       }
      	    	
      	    }
      	    System.out.println("result ps="+ps);
      	  } catch (Exception e) {
      	    e.printStackTrace();
      	  }
      	  
      	return ps;
		
	}
	
	
	public static boolean setDevicePowerStatus(String door,boolean powerstatus){		
       	 String power="";
       	 if(powerstatus==true){
       		power="On";
       	 }else{
       		power="Off"; 
       	 }		
		String xmldata ="<?xml version=\"1.0\" encoding=\"utf-8\"?> \r\n"+
		 "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\"> \r\n"+
		  "<soap:Body> \r\n"+
		    "<SetDevicePowerStatus xmlns=\"http://tquark.com.tw/OGSystem/\"> \r\n"+
		      "<DeviceNo>"+door+"</DeviceNo> \r\n"+		  
		      "<Status>"+power+"</Status> \r\n"+
		    "</SetDevicePowerStatus> \r\n"+
		  "</soap:Body> \r\n"+
		 "</soap:Envelope> \r\n"; 
       	 
       	return setOGerver(xmldata);			
		
	}
	
	public static boolean InquireDevicePowerStatus(String door){		

		String xmldata ="<?xml version=\"1.0\" encoding=\"utf-8\"?> \r\n"+
		 "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\"> \r\n"+
		  "<soap:Body> \r\n"+
		    "<InquireDevicePowerStatus xmlns=\"http://tquark.com.tw/OGSystem/\"> \r\n"+
		      "<DeviceNo>"+door+"</DeviceNo> \r\n"+	  
		    "</InquireDevicePowerStatus> \r\n"+
		  "</soap:Body> \r\n"+
		 "</soap:Envelope> \r\n"; 
		
		
      	 
   	   return false;
		
	}

	
	 private static String getTagValue(String sTag, Element eElement){
		    NodeList nlList= eElement.getElementsByTagName(sTag).item(0).getChildNodes();
		    Node nValue = (Node) nlList.item(0); 
		 
		    return nValue.getNodeValue();    
	}
	 
	 
		public static boolean clearGroup(String groupId){	
 	 
			String xmldata =
			"<?xml version=\"1.0\" encoding=\"utf-8\"?> \r\n"+
			"<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\"> \r\n"+
			  "<soap:Body> \r\n"+
			    "<ClearGroupMembers2 xmlns=\"http://tquark.com.tw/OGSystem/\"> \r\n"+
			      "<GroupNo>"+groupId+"</GroupNo> \r\n"+
			      "<downloadMode>Queue</downloadMode> \r\n"+
			    "</ClearGroupMembers2> \r\n"+
			  "</soap:Body>\r\n"+
			"</soap:Envelope>\r\n"
			;	       	 
	       	return setOGerver(xmldata);		
		}
		
		
		
		public static boolean setGroup(List lst,String groupID){	

			String m="";
			for(int i=0;i<lst.size();i++){
				m+="<string>"+lst.get(i)+"</string>\r\n";
			}			
			String xmldata =
			"<?xml version=\"1.0\" encoding=\"utf-8\"?>	\r\n"+
			"<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\"> \r\n"+
			  "<soap:Body> \r\n"+
			    "<SetGroup2 xmlns=\"http://tquark.com.tw/OGSystem/\"> \r\n"+
			      "<GroupNo>"+groupID+"</GroupNo> \r\n"+
			      "<GroupName>Computer Of Center</GroupName>\r\n"+
			      "<InfoClass>\r\n"+      	
			        "<MemberNos>\r\n"+
			          m+
			          //"<string>950201</string>\r\n"+		
			        "</MemberNos>\r\n"+
			      "</InfoClass>\r\n"+
			      "<downloadMode>Queue</downloadMode>\r\n"+
			    "</SetGroup2>\r\n"+
			  "</soap:Body>\r\n"+
			"</soap:Envelope>\r\n"
			;       	 
	       	return setOGerver(xmldata);		
		}
		
		public static boolean setDeleteGroupMembers(List lst,String groupID){	
	
			String m="";
			for(int i=0;i<lst.size();i++){
				m+="<string>"+lst.get(i)+"</string>\r\n";
			}			
			String xmldata =
			"<?xml version=\"1.0\" encoding=\"utf-8\"?>	\r\n"+
			"<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\"> \r\n"+
			  "<soap:Body> \r\n"+
			    "<DeleteGroupMembers2 xmlns=\"http://tquark.com.tw/OGSystem/\"> \r\n"+
			      "<GroupNo>"+groupID+"</GroupNo> \r\n"+
			        "<MemberNos>\r\n"+
			          m+			       
			        "</MemberNos>\r\n"+
			  
			      "<downloadMode>Queue</downloadMode>\r\n"+
			    "</DeleteGroupMembers2>\r\n"+
			  "</soap:Body>\r\n"+
			"</soap:Envelope>\r\n"
			;       	 
	       	return setOGerver(xmldata);		
		}
	

}
