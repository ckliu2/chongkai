package MITSUBISHI_G50;

import java.io.*; 
import java.util.*; 

import org.jdom.*; 
import org.jdom.input.*; 


public class parsingXML6 {
	
	public static void main(String[] args) {
		
		long lasting = System.currentTimeMillis(); 
		try{ 
		/*	
		SAXBuilder builder = new SAXBuilder(); 
		Document doc = builder.build(new File("D://tmp//file2.xml"));
		Element rootNode = doc.getRootElement();		
		System.out.println(rootNode.getChildText("Command"));
		*/
			
			SAXBuilder builder = new SAXBuilder(); 
			//Document doc = builder.build(new File("D://tmp//file2.xml"));
			Document doc = builder.build(new StringReader(""));
			Element rootNode = doc.getRootElement();		
			System.out.println(rootNode.getChildText("member"));
		
		
		
		} catch (Exception e) { 
		e.printStackTrace(); 
		} 

		

   }
	
}
