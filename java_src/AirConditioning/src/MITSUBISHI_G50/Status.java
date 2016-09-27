package MITSUBISHI_G50;

import java.io.StringReader;
import java.util.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.*;

import tncc.power.service.PowerManager;
import tncc.power.value.PowerController;

public class Status extends HttpServlet{

	com.opensymphony.xwork.ActionSupport ww= new com.opensymphony.xwork.ActionSupport();
	/*
	ServletContext servletContext=getServletContext(); 
    ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
    */
     
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//showStatus();
		
		DeviceConnection c=new DeviceConnection("140.118.58.226");
        List<Device> al=c.getDeviceStatus();
        for(int i=0;i<al.size();i++){
        	Device d=al.get(i);
        	if(d.getGroup().equals("25")){
        	System.out.println(i+"--Group="+d.getGroup()+"--Drive="+d.getDrive()+"--SetTemp="+d.getSetTemp()+"--InletTemp="+d.getInletTemp());
        	}
         }
        
		/*
		DeviceConnection c=new DeviceConnection("140.118.58.226",25);
		String cmd=c.getTodayList(c.deviceNo);
		System.out.println(cmd);
		String response=c.sendCommand(cmd);
		System.out.println(response);
		*/
		
		
/*
 		SAXBuilder builder = new SAXBuilder(); 						
		Document doc = builder.build(new StringReader(response));
		XMLOutputter xmlOutput = new XMLOutputter();
      	Format format = Format.getPrettyFormat();
        format.setEncoding("UTF-8");
		xmlOutput.setFormat(format.getPrettyFormat());
		xmlOutput.outputString(doc);
		
		System.out.println(xmlOutput.outputString(doc));
		}catch(Exception e){
			System.out.println(e.toString());
		}
 */
		
		//Device d=c.deviceProperty(1);
		//System.out.println("Group="+d.getGroup()+"--SetTemp="+d.getSetTemp()+"--Drive="+d.getDrive()+"--Mode="+d.getMode()+"--DriveItem="+d.getDriveItem()+"--ModeItem="+d.getModeItem()+"--SetTempItem="+d.getSetTempItem()+"--FilterItem="+d.getFilterItem());
		/*
		 d.setGroup(driveRecord.getAttributeValue("Group"));
						  d.setSetTemp(driveRecord.getAttributeValue("SetTemp"));
						  d.setDrive(driveRecord.getAttributeValue("Drive"));
						  d.setMode(driveRecord.getAttributeValue("Mode"));
						  d.setDriveItem(driveRecord.getAttributeValue("DriveItem"));
						  d.setModeItem(driveRecord.getAttributeValue("ModeItem"));
						  d.setSetTempItem(driveRecord.getAttributeValue("SetTempItem"));
						  d.setFilterItem(driveRecord.getAttributeValue("FilterItem"));
					
		 */
        
	}
	
    public static String showStatus(){
		String xml="";
    	try{
    		Element powerstatus = new Element("powerstatus");
    		Document doc = new Document(powerstatus);
    		doc.setRootElement(powerstatus);
    		
    		Element door = new Element("door");
    		door.setAttribute(new Attribute("id", "E00011"));    	
    		doc.getRootElement().addContent(door);
    		
    		//狀態
    		Element status = new Element("status");
    		status.setText("OFF");
    		door.addContent(status);	
    		
    		//設定溫度
    		Element settemp = new Element("settemp");
    		settemp.setText("26");
    		door.addContent(settemp);
    		
    		//室內溫度
    		Element inlettemp = new Element("inlettemp");
    		inlettemp.setText("28");
    		door.addContent(inlettemp);
    		
    		XMLOutputter xmlOutput = new XMLOutputter();	
    		xmlOutput.setFormat(Format.getPrettyFormat());    	
    		xml=xmlOutput.outputString(doc);
    		System.out.println(xml);
    		
    		/*
    		Connection c=new Connection("140.118.58.225");
            List<Device> al=c.getDeviceStatus();
            for(int i=0;i<al.size();i++){
            	Device d=al.get(i);
            	System.out.println(i+"--Group="+d.getGroup()+"--Drive="+d.getDrive()+"--SetTemp="+d.getSetTemp()+"--InletTemp="+d.getInletTemp());
            }
            */
			
		}catch(Exception e){
			System.out.println("showStatus error!");
		}
		return xml;
	}

}
