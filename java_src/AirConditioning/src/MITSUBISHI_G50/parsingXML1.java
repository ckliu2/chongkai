package MITSUBISHI_G50;

import java.io.*; 
import java.util.*; 
import org.jdom.*; 
import org.jdom.input.*; 


public class parsingXML1 {
	
	public static void main(String[] args) {
		
	 try{ 
		SAXBuilder builder = new SAXBuilder(); 
		Document doc = builder.build(new File("D://tmp//file0725.xml"));
		Element rootNode = doc.getRootElement();
		List list = rootNode.getChildren("DatabaseManager");
		System.out.println(list.size());
		Element databaseManager=rootNode.getChild("DatabaseManager");
		Element controlGroup=databaseManager.getChild("ControlGroup");
		Element driveList=controlGroup.getChild("DriveList");
		List ls=driveList.getChildren();
		//System.out.println("ls.size()="+ls.size());		
		for(int i=0;i<ls.size();i++){			
			Element driveRecord = (Element) ls.get(i);			
		    System.out.println(i+"=driveRecord Group: " + driveRecord.getAttributeValue("Group"));
		}
		
	} catch (Exception e) { 
		  System.out.println(e.toString());
	} 
	
  }
	
}
