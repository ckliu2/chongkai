package test;


import java.net.*;

import javax.xml.soap.*;


public class SOAP4 {
	public static void main(String[] args) {
    try{
    	SOAPConnectionFactory sfCon = SOAPConnectionFactory.newInstance();
        SOAPConnection connection = sfCon.createConnection();
        SOAPFactory soapFactory = SOAPFactory.newInstance();
        String serverURI = "http://tquark.com.tw/OGSystem/SetDevicePowerStatus";
        URL endpoint = new URL("http://140.129.140.153:99/OGWeb/OGWebService/OGWebService.asmx");
        MessageFactory msfactory = MessageFactory.newInstance();
        SOAPMessage message = msfactory.createMessage();
    
        Name course_room = soapFactory.createName("SetDevicePowerStatus");
   
  
        SOAPBody body = message.getSOAPBody();
        SOAPBodyElement courseElement =body.addBodyElement(course_room);
        
       
        //courseElement.addNamespaceDeclaration("xmlns", "http://tempuri.org/ws2004/classroom");
    
        SOAPElement DeviceNo = courseElement.addChildElement("DeviceNo");
        DeviceNo.addTextNode("C0203");
        courseElement.addChildElement(DeviceNo);
    
        SOAPElement Status = courseElement.addChildElement("Status");
        Status.addTextNode("On");
        courseElement.addChildElement(Status);
        
        MimeHeaders headers = message.getMimeHeaders();
        headers.addHeader("SOAPAction", serverURI  );
    
        message.writeTo(System.out);

        System.out.println("********************************");
        SOAPMessage response = connection.call(message, endpoint);
    
        response.writeTo(System.out);
    
    
       connection.close();	
        
	}catch(Exception e){
   	 System.out.println(e.toString());
    }
  }
}
