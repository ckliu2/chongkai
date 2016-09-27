package test;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;




import org.jdom.output.XMLOutputter;

import MITSUBISHI_G50.DeviceConnection;

import com.base.util.Tools;

public class TimingXML {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try{
		// TODO Auto-generated method stub
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
		
		//Year="2013" Month="8" Day="1" Hour="21" Minute="28" Second="0"
		
		doc.getRootElement().addContent(databaseManager);		
		
		
		
		XMLOutputter xmlOutput = new XMLOutputter();
      	Format format = Format.getPrettyFormat();
        format.setEncoding("UTF-8");
		xmlOutput.setFormat(format.getPrettyFormat());
		//xmlOutput.output(doc, new FileWriter("d:\\tmp\\file2.xml"));
		
		String xml;
		xml=xmlOutput.outputString(doc);
		System.out.println(xml);
		
		DeviceConnection c=new DeviceConnection("140.118.58.225");
		System.out.println( c.sendCommand(xml) );

		}catch(Exception e){
			System.out.println(e.toString());
		}
		
		
	}

}
