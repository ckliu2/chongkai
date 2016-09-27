package tncc.reserve.action;

import tncc.wpc.value.*;
import tncc.wpc.service.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.io.FileWriter;
import java.util.*;

import javax.servlet.ServletContext;

import com.common.value.Member;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.*;

import tncc.power.service.PowerManager;
import tncc.reserve.service.ReserveManager;
import tncc.reserve.value.*;
import tncc.power.value.*;
import MITSUBISHI_G50.*;

public class QuartzAction extends CommonActionSupport
{
	Long readerId;
	Reader reader;

	public void setGenericManager(ReserveManager m)
    {
        super.setGenericManager(m);
    }

    public ReserveManager getGenericManager()
    {
        return (ReserveManager) super.getGenericManager();
    }
    
    public Long getReaderId() {
		return readerId;
	}

	public void setReaderId(Long readerId) {
		this.readerId = readerId;
	}
	
	public Reader getReader() {
		return reader;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}
    
    public String list(){
    	return SUCCESS;
    }
    
    public String download(){
    	System.out.println("QuartzAction download..");
    	try {           	
	        //List<ClassRoom> ls=getGenericManager().getClassRoomList();
    		ArrayList<ClassRoom> ls=new ArrayList<ClassRoom>();
	        ClassRoom cr=getGenericManager().getClassRoomById("TR209");
	        ls.add(cr);
	        
	        for(int i=0;i<ls.size();i++){	        	
	        	ClassRoom classroom=ls.get(i);
	        	System.out.println(classroom.getId());
	        	
	        	Set readers=classroom.getReaders();
       		    Iterator k = readers.iterator(); 
  	    		 while (k.hasNext()) {
  	    		  Reader r= (Reader) k.next();
  	    		  PowerController pc=getGenericManager().getPowerControllerByReader(r);
  	    		  
 	    		  Element packet = new Element("Packet");
 	    		  Document doc = new Document(packet);
 	    		  doc.setRootElement(packet);
 	    		  
 	    		  String desc=classroom.getId()+"--"+r.getId();
 	    		  Element memo = new Element("memo"); 
 	    		  memo.setAttribute(new Attribute("desc", String.valueOf(desc)));
 	    		  //doc.getRootElement().addContent(memo);
	    		  
 	    		
 	    		  Element command = new Element("Command");
 	    		  command.setText("setRequest");
 	    		  doc.getRootElement().addContent(command);
 	    		
 	    		  Element databaseManager = new Element("DatabaseManager");
 	    		  Element scheduleControl = new Element("ScheduleControl");
	        	
	        	   for(int w=1;w<=7;w++){	        		
	        		 Element wpatternList = new Element("WPatternList");
	        		 wpatternList.setAttribute(new Attribute("Pattern", String.valueOf(w)));
	        		 wpatternList.setAttribute(new Attribute("Group", String.valueOf(r.getReaderId())));
	        		 scheduleControl.addContent(wpatternList);
	        		 
	        		 List<CourseOpen> ls1=getGenericManager().getCourseOpenListByWeek(classroom,w); 
	        		  int count=1; 
	        		  for(int y=0;y<ls1.size();y++){
	        			 CourseOpen c=ls1.get(y);
	        			 /*
	  	        		 String startHour=c.getStartTime().substring(0,2);
	  	        		 String startMinute=c.getStartTime().substring(2,4);
	  	        		 String endHour=c.getEndTime().substring(0,2);
	  	        		 String endMinute=c.getEndTime().substring(2,4); 
	  	        		 */
	        			 String startHour=c.getReservation().substring(0,2);
	  	        		 String startMinute=c.getReservation().substring(2,4);
	  	        		 String endHour=c.getReservation().substring(0,2);
	  	        		 String endMinute=c.getReservation().substring(2,4);	  	        		 
	  	        		 String active=c.getActive();
	  	        		 	  	        		 
	  	        		 Element wpatternRecord = new Element("WPatternRecord"); 
	  	        		   
	  	        		 if(active.equals("on")){
	  	        			 wpatternRecord.setAttribute(new Attribute("testid", String.valueOf(c.getId())));
	  	        		     wpatternRecord.setAttribute(new Attribute("Index", String.valueOf(count)));
			        	     wpatternRecord.setAttribute(new Attribute("Hour", startHour));
		  	        	     wpatternRecord.setAttribute(new Attribute("Minute", startMinute));	  	        		 
		  	        	     wpatternRecord.setAttribute(new Attribute("Drive", ""));    
		  	        	     wpatternRecord.setAttribute(new Attribute("DriveItem", r.getDriveItem().getValueUs()));
	  	        		 }
	  	        		 if(active.equals("off")){
	  	        			 wpatternRecord.setAttribute(new Attribute("testid", String.valueOf(c.getId())));
	  	        			 wpatternRecord.setAttribute(new Attribute("Index", String.valueOf(count)));
			        		 wpatternRecord.setAttribute(new Attribute("Hour", endHour));
		  	        		 wpatternRecord.setAttribute(new Attribute("Minute", endMinute));	  	        		 
		  	        		 wpatternRecord.setAttribute(new Attribute("Drive", "OFF")); 
		  	        		 wpatternRecord.setAttribute(new Attribute("DriveItem", "CHK_ON"));
		  	        	 }
	  	        		 wpatternRecord.setAttribute(new Attribute("Mode", "COOL"));
	  	        		 wpatternRecord.setAttribute(new Attribute("SetTemp",String.valueOf(r.getTemp())));
	  	        		 wpatternRecord.setAttribute(new Attribute("SetBack", ""));
	  	        		 //wpatternRecord.setAttribute(new Attribute("DriveItem", r.getDriveItem().getValueUs()));
	  	        		 wpatternRecord.setAttribute(new Attribute("ModeItem", r.getModeItem().getValueUs()));
	  	        		 wpatternRecord.setAttribute(new Attribute("SetTempItem", r.getTempItem().getValueUs()));
	  	        		 wpatternList.addContent(wpatternRecord);	 
	  	        		 count++;
	        		   }
	        	  }
	        	  
	        	  databaseManager.addContent(scheduleControl);
	        	  doc.getRootElement().addContent(databaseManager);
	        	  System.out.println("------------------------------------");
	 			  XMLOutputter xmlOutput = new XMLOutputter();
	 			  xmlOutput.setFormat(Format.getPrettyFormat());
	 			  //xmlOutput.output(doc, new FileWriter("d:\\tmp\\w.xml"));
	 			  String cmd=xmlOutput.outputString(doc);
	 			  //System.out.println(cmd);
	 			  //傳送G50
	 			  if(r.getActive()==true){
	 			   DeviceConnection dc=new DeviceConnection(pc.getIp(),r.getReaderId());
	 			   dc.sendCommand(cmd);	
	 			  }
	        	} 
	        }        
	        
        }catch(Exception e){
			System.out.println("QuartzG50 setSchedule error="+e.toString());
		}
        return SUCCESS;
    }
    
    
    public String sendWeeklyByReader(){
    	//發布到G50
        try{
        	reader=getGenericManager().getReaderById(reader.getId());
        	PowerController pc=getGenericManager().getPowerControllerByReader(reader);
        	PowerControllerReader pcr=getGenericManager().getReaderByControllerDeviceNo(reader);
        	ClassRoom classroom=pcr.getClassRoom();
        	System.out.println("sendWeeklyByReader reader.id="+reader.getId());
        	
   		    Element packet = new Element("Packet");
   		    Document doc = new Document(packet);
   		    doc.setRootElement(packet);
   		  
   		    String desc=classroom.getId()+"--"+reader.getId();
   		    Element memo = new Element("memo"); 
   		    memo.setAttribute(new Attribute("desc", String.valueOf(desc)));
   		   //doc.getRootElement().addContent(memo);
  		
   		    Element command = new Element("Command");
   		    command.setText("setRequest");
   		    doc.getRootElement().addContent(command);
   		
   		    Element databaseManager = new Element("DatabaseManager");
   		    Element scheduleControl = new Element("ScheduleControl");
      	
      	     for(int w=1;w<=7;w++){	        		
      		   Element wpatternList = new Element("WPatternList");
      		   wpatternList.setAttribute(new Attribute("Pattern", String.valueOf(w)));
      		   wpatternList.setAttribute(new Attribute("Group", String.valueOf(reader.getReaderId())));
      		   scheduleControl.addContent(wpatternList);
      		 
      		  List<CourseOpen> ls1=getGenericManager().getCourseOpenListByWeek(classroom,w); 
      		   int count=1; 
      		   for(int y=0;y<ls1.size();y++){
      			     CourseOpen c=ls1.get(y);
	        		 String startHour=c.getStartTime().substring(0,2);
	        		 String startMinute=c.getStartTime().substring(2,4);
	        		 String endHour=c.getEndTime().substring(0,2);
	        		 String endMinute=c.getEndTime().substring(2,4); 	  	        
	        		 String active=c.getActive();
	        		 
	        		 Element wpatternRecord = new Element("WPatternRecord"); 
	        		   
	        		 if(active.equals("on")){
	        			 wpatternRecord.setAttribute(new Attribute("testid", String.valueOf(c.getId())));
	        		     wpatternRecord.setAttribute(new Attribute("Index", String.valueOf(count)));
		        	     wpatternRecord.setAttribute(new Attribute("Hour", startHour));
	  	        	     wpatternRecord.setAttribute(new Attribute("Minute", startMinute));	  	        		 
	  	        	     wpatternRecord.setAttribute(new Attribute("Drive", ""));    
	  	        	   wpatternRecord.setAttribute(new Attribute("DriveItem", reader.getDriveItem().getValueUs()));
	        		 }
	        		 if(active.equals("off")){
	        			 wpatternRecord.setAttribute(new Attribute("testid", String.valueOf(c.getId())));
	        			 wpatternRecord.setAttribute(new Attribute("Index", String.valueOf(count)));
		        		 wpatternRecord.setAttribute(new Attribute("Hour", endHour));
	  	        		 wpatternRecord.setAttribute(new Attribute("Minute", endMinute));	  	        		 
	  	        		 wpatternRecord.setAttribute(new Attribute("Drive", "OFF")); 
	  	        		 wpatternRecord.setAttribute(new Attribute("DriveItem", "CHK_ON"));	  	        		 
	  	        	 }
	        		 wpatternRecord.setAttribute(new Attribute("Mode", "COOL"));
	        		 wpatternRecord.setAttribute(new Attribute("SetTemp",String.valueOf(reader.getTemp())));
	        		 wpatternRecord.setAttribute(new Attribute("SetBack", ""));
	        		 //wpatternRecord.setAttribute(new Attribute("DriveItem", r.getDriveItem().getValueUs()));
	        		 wpatternRecord.setAttribute(new Attribute("ModeItem", reader.getModeItem().getValueUs()));
	        		 wpatternRecord.setAttribute(new Attribute("SetTempItem", reader.getTempItem().getValueUs()));
	        		 wpatternList.addContent(wpatternRecord);	 
	        		 count++;
      		   }
      	  }
      	  
      	  databaseManager.addContent(scheduleControl);
      	  doc.getRootElement().addContent(databaseManager);
      	  System.out.println("------------------------------------");
			  XMLOutputter xmlOutput = new XMLOutputter();
			  xmlOutput.setFormat(Format.getPrettyFormat());
			  //xmlOutput.output(doc, new FileWriter("d:\\tmp\\w.xml"));
			  String cmd=xmlOutput.outputString(doc);
			  //System.out.println(cmd);
			  //傳送G50
			  if(reader.getActive()==true){
			   DeviceConnection dc=new DeviceConnection(pc.getIp(),reader.getReaderId());
			   dc.sendCommand(cmd);	
			  }
        	
        }catch(Exception e){
         System.out.println("sendWeeklyByReader error="+e.toString());	
        }
    	return SUCCESS;
    }
    
   
    
}
