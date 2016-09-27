package test;


import java.net.*;

import javax.xml.soap.*;


public class SOAP3 {
	public static void main(String[] args) {
    try{
    	SOAPConnectionFactory sfCon = SOAPConnectionFactory.newInstance();
        SOAPConnection connection = sfCon.createConnection();
        SOAPFactory soapFactory = SOAPFactory.newInstance();
        String serverURI = "http://tempuri.org/ws2004/classroom/course_room";
        URL endpoint = new URL("http://info.ntust.edu.tw/faith/ws2004/classroom.asmx");
        MessageFactory msfactory = MessageFactory.newInstance();
        SOAPMessage message = msfactory.createMessage();
    
        Name course_room = soapFactory.createName("course_room");
   
  
        SOAPBody body = message.getSOAPBody();
        SOAPBodyElement courseElement =body.addBodyElement(course_room);
        
       
        //courseElement.addNamespaceDeclaration("xmlns", "http://tempuri.org/ws2004/classroom");
    
        SOAPElement id = courseElement.addChildElement("id");
        id.addTextNode("nexmsart");
        courseElement.addChildElement(id);
    
        SOAPElement v_semester = courseElement.addChildElement("v_semester");
        v_semester.addTextNode("1021");
        courseElement.addChildElement(v_semester);
        
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
