package MITSUBISHI_G50;

import java.io.*;
import java.net.*;
import java.util.*;

import org.jdom.*;
import org.jdom.input.SAXBuilder;
import org.jdom.output.*;
import org.jdom.input.*; 

import com.base.util.Tools;
import com.common.value.Member;

public class DeviceConnection {

	public String ip;
	
	public int deviceNo;
	
	public DeviceConnection(String ip) {
        this.ip = ip;       
    }
	
	public DeviceConnection(String ip,int deviceNo) {
        this.ip = ip;    
        this.deviceNo = deviceNo;  
    }
	
	public Device deviceProperty(int deviceNo){
		Device d=new Device();
		try{			
		  for(int j=0;j<=1;j++){	
		  			  	
			Element packet = new Element("Packet");
			Document doc = new Document(packet);
			doc.setRootElement(packet);
			
			Element command = new Element("Command");
			command.setText("getRequest");			
			doc.getRootElement().addContent(command);
			
			Element databaseManager = new Element("DatabaseManager");			
			doc.getRootElement().addContent(databaseManager);	
			
			Element controlGroup = new Element("ControlGroup");	
			databaseManager.addContent(controlGroup);	
			
			Element driveList = new Element("DriveList");	
			if(j==0){
			 driveList.setAttribute(new Attribute("Area",""));
			}
			controlGroup.addContent(driveList);	
			XMLOutputter xmlOutput = new XMLOutputter();	
			xmlOutput.setFormat(Format.getPrettyFormat());				
			String response=sendCommand(xmlOutput.outputString(doc));
			
			try{ 
					SAXBuilder builder = new SAXBuilder(); 						
					Document doc1 = builder.build(new StringReader(response));
					Element rootNode1 = doc1.getRootElement();
					List list = rootNode1.getChildren("DatabaseManager");
					Element databaseManager1=rootNode1.getChild("DatabaseManager");
					Element controlGroup1=databaseManager1.getChild("ControlGroup");
					Element driveList1=controlGroup1.getChild("DriveList");
					List ls=driveList1.getChildren();
					for(int i=0;i<ls.size();i++){			
						Element driveRecord = (Element) ls.get(i);							
						if(driveRecord.getAttributeValue("Group").equals(String.valueOf(deviceNo)))
						{
						  d.setGroup(driveRecord.getAttributeValue("Group"));
						  d.setSetTemp(driveRecord.getAttributeValue("SetTemp"));
						  d.setDrive(driveRecord.getAttributeValue("Drive"));
						  d.setMode(driveRecord.getAttributeValue("Mode"));
						  d.setDriveItem(driveRecord.getAttributeValue("DriveItem"));
						  d.setModeItem(driveRecord.getAttributeValue("ModeItem"));
						  d.setSetTempItem(driveRecord.getAttributeValue("SetTempItem"));
						  d.setFilterItem(driveRecord.getAttributeValue("FilterItem"));
						}
				     }
				} catch (Exception e) { 
					  System.out.println("error="+e.toString());
				} 
		  }
		}catch(Exception e){
			System.out.println("doubleCheck error!");
		}
        return d;
	}
	
	
    public String sendCommand(String command) {		
		URL url = null;
	    HttpURLConnection httpurlconnection = null;
	    String response="";
         try{
        	 //System.out.println("---------------------Send--------------------");
        	 String seriveUrl = "http://"+ip+"/servlet/MIMEReceiveServlet";
             url = new URL(seriveUrl);
             //System.out.println(seriveUrl);

             httpurlconnection = (HttpURLConnection) url.openConnection();
             httpurlconnection.setDoOutput(true);
             httpurlconnection.setRequestMethod("POST");
             httpurlconnection.setRequestProperty("Content-type","text/xml; charset=utf-8");
             httpurlconnection.setRequestProperty("Content-Length",String.valueOf(command.length()));
             httpurlconnection.getOutputStream().write(command.getBytes());
             httpurlconnection.getOutputStream().flush();
             httpurlconnection.getOutputStream().close();
             
             //System.out.println(command);  
             
             //System.out.println("---------------------Response--------------------");	
             
             int code = httpurlconnection.getResponseCode();   
             
             //System.out.println("code   " + code);      
             //System.out.println("Msg   " + httpurlconnection.getResponseMessage());
             //System.out.println("Content-Length   " + httpurlconnection.getContentLength());
             
             BufferedReader rd = new BufferedReader(new InputStreamReader(httpurlconnection.getInputStream()));
             String line;
             while((line = rd.readLine()) != null){
            	 response+=line;
            	 //System.out.println(line);
             }
             rd.close();            
             
         }catch(Exception e){
        	 response="error";
        	 //System.out.println(e.toString());
         }
         return response;
	}

    
	public List<Device> getDeviceStatus(){
		ArrayList<Device> al = new ArrayList<Device>();
		Device g50=new Device();
		try{
			
		  for(int j=0;j<=1;j++){
			  
		  
			Element packet = new Element("Packet");
			Document doc = new Document(packet);
			doc.setRootElement(packet);
			
			Element command = new Element("Command");
			command.setText("getRequest");			
			doc.getRootElement().addContent(command);
			
			Element databaseManager = new Element("DatabaseManager");			
			doc.getRootElement().addContent(databaseManager);	
			
			Element controlGroup = new Element("ControlGroup");	
			databaseManager.addContent(controlGroup);	
			
			Element driveList = new Element("DriveList");	
			if(j==0){
			 driveList.setAttribute(new Attribute("Area",""));
			}
			controlGroup.addContent(driveList);	
			
			
			XMLOutputter xmlOutput = new XMLOutputter();		 
			// display nice nice
			xmlOutput.setFormat(Format.getPrettyFormat());
			//xmlOutput.output(doc, new FileWriter("d:\\tmp\\file.xml"));
			//System.out.println("query g50 start="+Tools.getCurrentTimestamp());
				
			String response=sendCommand(xmlOutput.outputString(doc));
			
			//System.out.println("query g50 end="+Tools.getCurrentTimestamp());
			
			/*
			System.out.println("response start="+Tools.getCurrentTimestamp());
			System.out.println("************************response start************************");
			System.out.println(response);		
			System.out.println("************************response end************************");
			System.out.println("response end="+Tools.getCurrentTimestamp());
			*/
			 try{ 
				    //System.out.println("xml parsing start="+Tools.getCurrentTimestamp());
					
					SAXBuilder builder = new SAXBuilder(); 						
					Document doc1 = builder.build(new StringReader(response));
					//Document doc1 = builder.build(new File("D://tmp//file0725.xml"));
					Element rootNode1 = doc1.getRootElement();
					List list = rootNode1.getChildren("DatabaseManager");
					//System.out.println(list.size());
					Element databaseManager1=rootNode1.getChild("DatabaseManager");
					Element controlGroup1=databaseManager1.getChild("ControlGroup");
					Element driveList1=controlGroup1.getChild("DriveList");
					List ls=driveList1.getChildren();
					//System.out.println("ls.size()="+ls.size());		
					for(int i=0;i<ls.size();i++){			
						Element driveRecord = (Element) ls.get(i);	
						Device d=new Device();
						d.setGroup(driveRecord.getAttributeValue("Group"));
						d.setDrive(driveRecord.getAttributeValue("Drive"));
						d.setMode(driveRecord.getAttributeValue("Mode"));
						d.setModeStatus(driveRecord.getAttributeValue("ModeStatus"));
						d.setSetTemp(driveRecord.getAttributeValue("SetTemp"));
						d.setTempLimitCool(driveRecord.getAttributeValue("TempLimitCool"));
						d.setTempLimitHeat(driveRecord.getAttributeValue("TempLimitHeat"));
						d.setTempLimit(driveRecord.getAttributeValue("TempLimit"));
						d.setCoolMin(driveRecord.getAttributeValue("CoolMin"));
						d.setCoolMax(driveRecord.getAttributeValue("CoolMax"));						
						d.setHeatMin(driveRecord.getAttributeValue("HeatMin"));
						d.setHeatMax(driveRecord.getAttributeValue("HeatMax"));
						d.setAutoMin(driveRecord.getAttributeValue("AutoMin"));
						d.setAutoMax(driveRecord.getAttributeValue("AutoMax"));
						d.setInletTemp(driveRecord.getAttributeValue("InletTemp"));
						d.setAirDirection(driveRecord.getAttributeValue("AirDirection"));
						d.setFanSpeed(driveRecord.getAttributeValue("FanSpeed"));
						d.setRemoCon(driveRecord.getAttributeValue("RemoCon"));
						d.setDriveItem(driveRecord.getAttributeValue("DriveItem"));
						d.setModeItem(driveRecord.getAttributeValue("ModeItem"));
						d.setSetTempItem(driveRecord.getAttributeValue("SetTempItem"));
						d.setFilterItem(driveRecord.getAttributeValue("FilterItem"));
						d.setVentilation(driveRecord.getAttributeValue("Ventilation"));
						d.setSchedule(driveRecord.getAttributeValue("Schedule"));
						d.setEnergyControl(driveRecord.getAttributeValue("EnergyControl"));
						d.setFilterSign(driveRecord.getAttributeValue("FilterSign"));
						d.setErrorSign(driveRecord.getAttributeValue("ErrorSign"));						
						d.setTurnOff(driveRecord.getAttributeValue("TurnOff"));
						d.setTempDetail(driveRecord.getAttributeValue("TempDetail"));
                        al.add(d);
					    //System.out.println(i+"====driveRecord Group: " + driveRecord.getAttributeValue("Group"));
					}
					 //System.out.println("xml parsing end="+Tools.getCurrentTimestamp());
						
					
				} catch (Exception e) { 
					  //System.out.println("error="+e.toString());
				} 
		  }
		}catch(Exception e){
			System.out.println("getDeviceStatus error!");
		}	
		return al;
	}
	
	public void setDeviceStatus(int deviceNo,String status){
		try{			
						
			Element packet = new Element("Packet");
			Document doc = new Document(packet);
			doc.setRootElement(packet);
			
			Element command = new Element("Command");
			command.setText("setRequest");
			doc.getRootElement().addContent(command);
			
			Element databaseManager = new Element("DatabaseManager");
			Element mnet = new Element("Mnet");
			
			mnet.setAttribute(new Attribute("Group", String.valueOf(deviceNo)));
			mnet.setAttribute(new Attribute("Drive", status));
			
			databaseManager.addContent(mnet);		
			
			doc.getRootElement().addContent(databaseManager);		
			
			XMLOutputter xmlOutput = new XMLOutputter();		 
			// display nice nice
			xmlOutput.setFormat(Format.getPrettyFormat());
			//xmlOutput.output(doc, new FileWriter("d:\\tmp\\file.xml"));
			
			String xml;
			xml=xmlOutput.outputString(doc);
			//System.out.println(xml);
			
			sendCommand(xml);
			
		}catch(Exception e){
			System.out.println("setDeviceStatus error="+e.toString());
		}
	}
	
	
	public List<Device> getDailyStatus(){
		ArrayList<Device> al = new ArrayList<Device>();		
		try{
			Element packet = new Element("Packet");
			Document doc = new Document(packet);
			doc.setRootElement(packet);			
			Element command = new Element("Command");
			command.setText("getRequest");
			doc.getRootElement().addContent(command);			
			Element databaseManager = new Element("DatabaseManager");
			Element scheduleControl = new Element("ScheduleControl");			
			Element todayList = new Element("TodayList");
			todayList.setAttribute(new Attribute("Group", String.valueOf(deviceNo)));
			databaseManager.addContent(scheduleControl);				
			scheduleControl.addContent(todayList);				
			doc.getRootElement().addContent(databaseManager);				
			XMLOutputter xmlOutput = new XMLOutputter();		 
			// display nice nice
			xmlOutput.setFormat(Format.getPrettyFormat());			
			//System.out.println(xmlOutput.outputString(doc));
			//xmlOutput.output(doc, new FileWriter("d:\\tmp\\file.xml"));			
			String response=sendCommand(xmlOutput.outputString(doc));
			
			//System.out.println("************************response************************");
			//System.out.println(response);
			try{ 
				SAXBuilder builder = new SAXBuilder(); 
				Document doc1 = builder.build(new StringReader(response));
				Element rootNode1 = doc1.getRootElement();
				List list1 = rootNode1.getChildren("DatabaseManager");		
				Element databaseManager1=rootNode1.getChild("DatabaseManager");
				Element controlGroup1=databaseManager1.getChild("ScheduleControl");
				Element driveList1=controlGroup1.getChild("TodayList");
				List ls1=driveList1.getChildren();
				//System.out.println("ls.size()="+ls1.size());		
				for(int i=0;i<ls1.size();i++){			
					Element todayRecord = (Element) ls1.get(i);			
				    //System.out.println(i+"=driveRecord Group: " + todayRecord.getAttributeValue("Hour"));
				    Device g50=new Device();
				    g50.setIndex(Integer.parseInt(todayRecord.getAttributeValue("Index")));
				    g50.setYear(Tools.getToday().getYear()+1900);
				    g50.setMonth(Tools.getToday().getMonth());
				    g50.setDate(Tools.getToday().getDate());
				    g50.setWeek(Tools.getToday().getDay());
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
		}catch(Exception e){
			System.out.println("getDailyStatus error!");
		}	
		return al;
	}
	
	
	public List<Device> getWeeklyStatus(){
		ArrayList<Device> al = new ArrayList<Device>();		
		try{
			Element packet = new Element("Packet");
			Document doc = new Document(packet);
			doc.setRootElement(packet);
			
			Element command = new Element("Command");
			command.setText("getRequest");
			doc.getRootElement().addContent(command);
			
			Element databaseManager = new Element("DatabaseManager");
			Element scheduleControl = new Element("ScheduleControl");
			
			Element wpatternList1 = new Element("WPatternList");
			wpatternList1.setAttribute(new Attribute("Group", String.valueOf(deviceNo)));
			wpatternList1.setAttribute(new Attribute("Pattern", "1"));
			
			Element wpatternList2 = new Element("WPatternList");
			wpatternList2.setAttribute(new Attribute("Group", String.valueOf(deviceNo)));
			wpatternList2.setAttribute(new Attribute("Pattern", "2"));
			
			Element wpatternList3 = new Element("WPatternList");
			wpatternList3.setAttribute(new Attribute("Group", String.valueOf(deviceNo)));
			wpatternList3.setAttribute(new Attribute("Pattern", "3"));
			
			Element wpatternList4 = new Element("WPatternList");
			wpatternList4.setAttribute(new Attribute("Group", String.valueOf(deviceNo)));
			wpatternList4.setAttribute(new Attribute("Pattern", "4"));
			
			Element wpatternList5 = new Element("WPatternList");
			wpatternList5.setAttribute(new Attribute("Group", String.valueOf(deviceNo)));
			wpatternList5.setAttribute(new Attribute("Pattern", "5"));
			
			Element wpatternList6 = new Element("WPatternList");
			wpatternList6.setAttribute(new Attribute("Group", String.valueOf(deviceNo)));
			wpatternList6.setAttribute(new Attribute("Pattern", "6"));
			
			Element wpatternList7 = new Element("WPatternList");
			wpatternList7.setAttribute(new Attribute("Group", String.valueOf(deviceNo)));
			wpatternList7.setAttribute(new Attribute("Pattern", "7"));
			
			databaseManager.addContent(scheduleControl);				
			scheduleControl.addContent(wpatternList1);	
			scheduleControl.addContent(wpatternList2);	
			scheduleControl.addContent(wpatternList3);
			scheduleControl.addContent(wpatternList4);
			scheduleControl.addContent(wpatternList5);
			scheduleControl.addContent(wpatternList6);
			scheduleControl.addContent(wpatternList7);			
			doc.getRootElement().addContent(databaseManager);	
			XMLOutputter xmlOutput = new XMLOutputter();		 
			// display nice nice
			xmlOutput.setFormat(Format.getPrettyFormat());
			String response=sendCommand(xmlOutput.outputString(doc));			
			//System.out.println(response);
			
			 try{ 
					SAXBuilder builder = new SAXBuilder(); 
					Document doc1 = builder.build(new StringReader(response));
					Element rootNode1 = doc1.getRootElement();
					List list1 = rootNode1.getChildren("DatabaseManager");		
					Element databaseManager1=rootNode1.getChild("DatabaseManager");
					Element controlGroup1=databaseManager1.getChild("ScheduleControl");
					List ls1=controlGroup1.getChildren();
					//System.out.println("ls1.size()="+ls1.size());			
					for(int i=0;i<ls1.size();i++){
					  Element wpatternList = (Element) ls1.get(i);
					  
					  List task=wpatternList.getChildren();
					  for(int j=0;j<task.size();j++){
						  Element wpatternRecord = (Element) task.get(j);	
						  Calendar cal=scheduleCalendar(Integer.parseInt(wpatternList.getAttributeValue("Pattern")));
						  
						  //System.out.println(i+"=wpatternRecord Group: " + wpatternRecord.getAttributeValue("Hour")+"--Pattern="+wpatternList.getAttributeValue("Pattern")+"--cal="+cal.getTime().getDate()+"--week="+cal.getTime().getDay()+"--year="+cal.getTime().getYear());
						  
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
			
		}catch(Exception e){
			System.out.println("getWeeklyStatus error!");
		}	
		return al;
	}
	
	
	public Calendar scheduleCalendar(int week){	 
		 Calendar c = Calendar.getInstance();                   
		 c = Calendar.getInstance();  
		 c.set(Calendar.DAY_OF_WEEK, week);	
		 return c;
	 }
	
	public String getTiming()
	{
		String xml="";
		try{			
			Element packet = new Element("Packet");
			Document doc = new Document(packet);
			doc.setRootElement(packet);			
			Element command = new Element("Command");
			command.setText("setRequest");
			doc.getRootElement().addContent(command);			
			Element databaseManager = new Element("DatabaseManager");
			Element clock = new Element("Clock");			
			Date d=Tools.getCurrentTimestamp();			
			clock.setAttribute(new Attribute("Year", String.valueOf(d.getYear()+1900) ));
			clock.setAttribute(new Attribute("Month", String.valueOf(d.getMonth()+1)));
			clock.setAttribute(new Attribute("Day", String.valueOf(d.getDate()) ));
			clock.setAttribute(new Attribute("Hour", String.valueOf(d.getHours()) ));
			clock.setAttribute(new Attribute("Minute", String.valueOf(d.getMinutes())  ));	
			clock.setAttribute(new Attribute("Second", String.valueOf(d.getSeconds()) ));
			databaseManager.addContent(clock);
			doc.getRootElement().addContent(databaseManager);	
			XMLOutputter xmlOutput = new XMLOutputter();
	      	Format format = Format.getPrettyFormat();
	        format.setEncoding("UTF-8");
			xmlOutput.setFormat(format.getPrettyFormat());
			xml=xmlOutput.outputString(doc);
			//System.out.println(xml);

			}catch(Exception e){
				System.out.println(e.toString());
			}
		return xml;	
	}
	
	public String getTodayList(int deviceNo)
	{
		String xml="";
		try{			
			Element packet = new Element("Packet");
			Document doc = new Document(packet);
			doc.setRootElement(packet);			
			Element command = new Element("Command");
			command.setText("getRequest");
			doc.getRootElement().addContent(command);			
			Element databaseManager = new Element("DatabaseManager");			
			Element scheduleControl = new Element("ScheduleControl");			
			Element todayList = new Element("TodayList");    			   			
			scheduleControl.addContent(todayList);    			
			databaseManager.addContent(scheduleControl);     
			todayList.setAttribute("Group", String.valueOf(deviceNo) );
			doc.getRootElement().addContent(databaseManager);	
			
			
			XMLOutputter xmlOutput = new XMLOutputter();
	      	Format format = Format.getPrettyFormat();
	        format.setEncoding("UTF-8");
			xmlOutput.setFormat(format.getPrettyFormat());
			xml=xmlOutput.outputString(doc);
			//System.out.println(xml);
			}catch(Exception e){
				System.out.println(e.toString());
			}
		return xml;	
	}
	

}
