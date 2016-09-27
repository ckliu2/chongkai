package MITSUBISHI_G50;

import java.io.*; 
import java.util.*; 

import org.jdom.*; 
import org.jdom.input.*; 


public class parsingXML2 {
	
	public static void main(String[] args) {
	
	ArrayList<Device> al = new ArrayList<Device>();	
	 try{ 
		SAXBuilder builder = new SAXBuilder(); 
		Document doc = builder.build(new File("D://tmp//a.xml"));
		Element rootNode = doc.getRootElement();
		List list = rootNode.getChildren("DatabaseManager");		
		Element databaseManager=rootNode.getChild("DatabaseManager");
		Element controlGroup=databaseManager.getChild("ScheduleControl");
		Element driveList=controlGroup.getChild("TodayList");
		List ls=driveList.getChildren();
		System.out.println("ls.size()="+ls.size());		
		//Index="1" Hour="1" Minute="0" Drive="" Mode="" SetTemp="" SetBack="" DriveItem="" ModeItem="" SetTempItem=""
		for(int i=0;i<ls.size();i++){			
			Element todayRecord = (Element) ls.get(i);			
		    System.out.println(i+"=driveRecord Group: " + todayRecord.getAttributeValue("Hour"));
		    Device g50=new Device();
		    g50.setIndex(Integer.parseInt(todayRecord.getAttributeValue("Index")));
		    g50.setHour(Integer.parseInt(todayRecord.getAttributeValue("Hour")));
		    g50.setMinute(Integer.parseInt(todayRecord.getAttributeValue("Minute")));
		    g50.setDrive(todayRecord.getAttributeValue("Drive"));
		    g50.setMode(todayRecord.getAttributeValue("Mode"));
		    g50.setSetTemp(todayRecord.getAttributeValue("SetTemp"));
		    g50.setSetBack(todayRecord.getAttributeValue("SetBack"));
		    g50.setDriveItem(todayRecord.getAttributeValue("DriveItem"));
		    g50.setModeItem(todayRecord.getAttributeValue("ModeItem"));
		    g50.setSetTempItem(todayRecord.getAttributeValue("SetTempItem"));
		    al.add(g50);
		}
		
	} catch (Exception e) { 
		  System.out.println(e.toString());
	} 
	
  }
	
}
