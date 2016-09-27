package MITSUBISHI_G50;

import java.io.*; 
import java.util.*; 

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.jdom.*; 
import org.jdom.xpath.*;
import org.jdom.input.*; 
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.jdom.filter.Filter;
import org.jdom.filter.ElementFilter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class parsingXML5 {
	
	public static void main(String[] args) {

	 try{ 
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
  	    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
  	    Document doc = dBuilder.parse("D://tmp//a1.xml");
  	    doc.getDocumentElement().normalize();      	 
  	    NodeList nList = doc.getElementsByTagName("InquireDevicePowerStatusResult");
  	    System.out.println("-----------------------"+nList.getLength());      	 
  	    for (int temp = 0; temp < nList.getLength(); temp++) {
  	    	System.out.println("temp="+temp);  
  	    	 Node nNode = nList.item(temp);	    
    	       if (nNode.getNodeType() == Node.ELEMENT_NODE) {      	 
    	          Element eElement = (Element) nNode;
    	          String Status=getTagValue("Status",eElement);
    	          System.out.println("Status="+Status);
    	       }
  	    	
  	    }
		
	
	} catch (Exception e) { 
		  System.out.println(e.toString());
	} 
	
  }
	
	 private static String getTagValue(String sTag, Element eElement){
		    NodeList nlList= eElement.getElementsByTagName(sTag).item(0).getChildNodes();
		    Node nValue = (Node) nlList.item(0); 
		 
		    return nValue.getNodeValue();    
	}
	

	
}
