package test;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import org.jdom.*;
import org.jdom.filter.ElementFilter;
import org.jdom.filter.Filter;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;
import org.jdom.output.Format;

public class test3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{ 
			SAXBuilder builder = new SAXBuilder(); 
			Document doc = builder.build(new File("D://tmp//status.xml"));
			Element rootNode = doc.getRootElement();
			
			List list = rootNode.getChildren("door");
			for (int i = 0; i < list.size(); i++) {				 
				   Element node = (Element) list.get(i);
				   String id=node.getAttribute("id").getValue();
				   
				 
					
				   node.getChild("settemp").setText("200000");
				   
				   System.out.println("id : " + id);
				   System.out.println("settemp: " + node.getChildText("settemp"));
				   System.out.println("inlettemp: " + node.getChildText("inlettemp"));
				   System.out.println("time:" + node.getChildText("time"));
				   System.out.println("----------------------------------------"); 
				}
			
			XMLOutputter xmlOutput = new XMLOutputter();
	      	Format format = Format.getPrettyFormat();
	        format.setEncoding("UTF-8");
    		xmlOutput.setFormat(format.getPrettyFormat());
    		System.out.println( xmlOutput.outputString(doc) );

		}catch(Exception e){
			System.out.println(e.toString());
		}
	}

}
