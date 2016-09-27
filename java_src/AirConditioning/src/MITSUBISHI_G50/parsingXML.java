package MITSUBISHI_G50;

import java.io.*; 
import java.util.*; 
import org.jdom.*; 
import org.jdom.input.*; 


public class parsingXML {
	
	public static void main(String[] args) {
		
		long lasting = System.currentTimeMillis(); 
		try{ 
		SAXBuilder builder = new SAXBuilder(); 
		Document doc = builder.build(new File("D://tmp//file.xml"));
		
		//Element databaseManager = doc.getRootElement().getChild("DatabaseManager");
		
		Element rootNode = doc.getRootElement();
		List list = rootNode.getChildren("DatabaseManager");
        System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {			 
			   Element node = (Element) list.get(i);
			   
			   Element Mnet = node.getChild("Mnet");
			   
				//List Mnetlist = MnetNode.getChildren("DatabaseManager");
				
			   System.out.println("Mnet : " + Mnet.toString());
			   
			   System.out.println("Mnet Group: " + Mnet.getAttributeValue("Group"));
			   System.out.println("Mnet Drive: " + Mnet.getAttributeValue("Drive"));
		}
		
		} catch (Exception e) { 
		e.printStackTrace(); 
		} 

		

   }
	
}
