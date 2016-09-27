package MITSUBISHI_G50;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URLEncoder;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;




import org.jdom.output.XMLOutputter;

public class createXml {

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
		Element mnet = new Element("Mnet");
		
		mnet.setAttribute(new Attribute("Group", "12"));
		mnet.setAttribute(new Attribute("Drive", "OFF"));
		mnet.setAttribute(new Attribute("SetTemp", "26"));
		mnet.setAttribute(new Attribute("AirDirection", "HORIZONTAL"));
		mnet.setAttribute(new Attribute("FanSpeed", "LOW"));	
		mnet.setAttribute(new Attribute("test", "中文"));
		databaseManager.addContent(mnet);		
		
		doc.getRootElement().addContent(databaseManager);		
		
		
		
		XMLOutputter xmlOutput = new XMLOutputter();
      	Format format = Format.getPrettyFormat();
        format.setEncoding("UTF-8");
		xmlOutput.setFormat(format.getPrettyFormat());
		xmlOutput.output(doc, new FileWriter("d:\\tmp\\file2.xml"));
		
		String xml;
		xml=xmlOutput.outputString(doc);
		//System.out.println(xml);
		
		System.out.println(URLEncoder.encode("中文","utf8"));
		
		}catch(Exception e){
			System.out.println(e.toString());
		}
		
		
	}

}
