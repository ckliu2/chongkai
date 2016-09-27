package MITSUBISHI_G50;

import java.io.*; 
import java.util.*; 

import org.jdom.*; 
import org.jdom.input.*; 


public class parsingXML3 {
	
	public static void main(String[] args) {
	
	ArrayList<Device> al = new ArrayList<Device>();	
	 try{ 
		SAXBuilder builder = new SAXBuilder(); 
		Document doc = builder.build(new File("D://tmp//a.xml"));
		Element rootNode = doc.getRootElement();
		List list = rootNode.getChildren("DatabaseManager");		
		Element databaseManager=rootNode.getChild("DatabaseManager");
		Element controlGroup=databaseManager.getChild("ScheduleControl");
		List ls=controlGroup.getChildren();
		System.out.println("ls.size()="+ls.size());			
		for(int i=0;i<ls.size();i++){
		  Element wpatternList = (Element) ls.get(i);
		  
		  List task=wpatternList.getChildren();
		  for(int j=0;j<task.size();j++){
			  Element wpatternRecord = (Element) task.get(j);	
			  Calendar cal=scheduleCalendar(Integer.parseInt(wpatternList.getAttributeValue("Pattern")));
			  
			  System.out.println(i+"=wpatternRecord Group: " + wpatternRecord.getAttributeValue("Hour")+"--Pattern="+wpatternList.getAttributeValue("Pattern")+"--cal="+cal.getTime().getDate()+"--week="+cal.getTime().getDay()+"--year="+cal.getTime().getYear());
			  
			  Device g50=new Device();
			  g50.setCalendar(cal);
			  g50.setIndex(Integer.parseInt(wpatternRecord.getAttributeValue("Index")));
			  g50.setHour(Integer.parseInt(wpatternRecord.getAttributeValue("Hour")));
			  g50.setMinute(Integer.parseInt(wpatternRecord.getAttributeValue("Minute")));
			  g50.setWeek(Integer.parseInt(wpatternList.getAttributeValue("Pattern")));
			  g50.setDrive(wpatternRecord.getAttributeValue("Drive"));
			  g50.setMode(wpatternRecord.getAttributeValue("Mode"));
			  g50.setSetTemp(wpatternRecord.getAttributeValue("SetTemp"));
			  g50.setSetBack(wpatternRecord.getAttributeValue("SetBack"));
			  g50.setDriveItem(wpatternRecord.getAttributeValue("DriveItem"));
			  g50.setModeItem(wpatternRecord.getAttributeValue("ModeItem"));
			  g50.setSetTempItem(wpatternRecord.getAttributeValue("SetTempItem"));		    
			  al.add(g50);  
		  }		
		}
		
	} catch (Exception e) { 
		  System.out.println(e.toString());
	} 
	
  }
	
 public static Calendar scheduleCalendar(int week){	 
	 Calendar c = Calendar.getInstance();                   
	 c = Calendar.getInstance();  
	 c.set(Calendar.DAY_OF_WEEK, week);	
	 return c;
 }
	
}
