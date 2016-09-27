package test;

import java.util.Iterator;
import javax.xml.soap.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;

import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class SOAPClient {
	
	public static void main(String[] args) {
		try{
			/*
			SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
			SOAPConnection soapConnection = soapConnectionFactory.createConnection();
			String url = "http://http://info.ntust.edu.tw/faith/ws2004/classroom.asmx";
            SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(), url);
            printSOAPResponse(soapResponse);
            soapConnection.close();
            */
			SOAPMessage s=createSOAPRequest();
			printSOAPResponse(s);

		}catch(Exception e){
			System.out.println(e.toString());
		}

	}
	
	private static SOAPMessage createSOAPRequest() throws Exception {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String serverURI = "http://tempuri.org/ws2004/classroom";
        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("course_room", serverURI);
        // SOAP Body
        SOAPBody soapBody = envelope.getBody();
        SOAPElement soapBodyElem = soapBody.addChildElement("course_room");
        
        SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("v_semester");
        soapBodyElem2.addTextNode("1021");
        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("id");
        soapBodyElem1.addTextNode("nexmsart");
        

        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", serverURI  );
       
       
        
        soapMessage.saveChanges();

        /* Print the request message */
        System.out.println("Request SOAP Message = ");
        
        XMLOutputter xmlOutput = new XMLOutputter();	
		xmlOutput.setFormat(Format.getPrettyFormat());
	
		//xmlOutput.outputString();
        soapMessage.writeTo(System.out);
        System.out.println();

        return soapMessage;
    }

    /**
     * Method used to print the SOAP Response
     */
    private static void printSOAPResponse(SOAPMessage soapResponse) throws Exception {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        Source sourceContent = soapResponse.getSOAPPart().getContent();
        System.out.print("\nResponse SOAP Message = ");
        StreamResult result = new StreamResult(System.out);
        transformer.transform(sourceContent, result);
    }

}
