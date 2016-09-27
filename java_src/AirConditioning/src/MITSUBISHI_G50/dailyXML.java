package MITSUBISHI_G50;

import java.io.*; 
import java.net.URLEncoder;
import java.util.*; 
import org.jdom.*; 
import org.jdom.input.*; 
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;


public class dailyXML {
	
	public static void test(){
		System.out.println("dailyXML test..");
		try{
			Element packet = new Element("Packet");
			Document doc = new Document(packet);
			doc.setRootElement(packet);			
			Element command = new Element("Command");
			command.setText("setRequest");
			doc.getRootElement().addContent(command);			
			Element databaseManager = new Element("DatabaseManager");			
			Element scheduleControl = new Element("ScheduleControl");			
			Element todayList = new Element("TodayList");
			
			scheduleControl.addContent(todayList);
			
			databaseManager.addContent(scheduleControl);
			
			
			todayList.setAttribute("Group", "25");
			
			
			
			Element todayRecord = new Element("TodayRecord");			
			todayRecord.setAttribute(new Attribute("Index", "1"));
			todayRecord.setAttribute(new Attribute("Hour", "2"));
			todayRecord.setAttribute(new Attribute("Minute", "30"));
			todayRecord.setAttribute(new Attribute("Drive", "ON"));
			todayRecord.setAttribute(new Attribute("Mode", "FAN"));
			todayRecord.setAttribute(new Attribute("SetTemp", "25"));	
			todayRecord.setAttribute(new Attribute("SetBack", ""));
			todayRecord.setAttribute(new Attribute("DriveItem", ""));
			todayRecord.setAttribute(new Attribute("ModeItem", ""));
			todayRecord.setAttribute(new Attribute("SetTempItem", ""));
			//todayRecord.setAttribute(new Attribute("FanSpeed", "HIGH"));
			
			/*
			 Index="1" Hour="10" Minute="0" Drive="OFF" Mode="COOL" SetTemp="" SetBack="" DriveItem="" ModeItem="" SetTempItem="" 
			 */
			todayList.addContent(todayRecord);		
			
			doc.getRootElement().addContent(databaseManager);		
			
			
			
			XMLOutputter xmlOutput = new XMLOutputter();
	      	Format format = Format.getPrettyFormat();
	        format.setEncoding("UTF-8");
			xmlOutput.setFormat(format.getPrettyFormat());
			//xmlOutput.output(doc, new FileWriter("d:\\tmp\\file3.xml"));
			
			String xml;
			xml=xmlOutput.outputString(doc);
			System.out.println(xml);
			
			DeviceConnection dc=new DeviceConnection("140.118.58.225",25);
			System.out.println("-------------response--------------------");
			System.out.println(dc.sendCommand(xml));
			//System.out.println(URLEncoder.encode("¤¤¤å","utf8"));
			
			}catch(Exception e){
				System.out.println(e.toString());
			}
	}
	
	public static void main(String[] args) {	
        test();
   }
	
}
