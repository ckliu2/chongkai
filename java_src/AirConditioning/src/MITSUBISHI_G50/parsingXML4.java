package MITSUBISHI_G50;

import java.io.*; 
import java.util.*; 

import org.jdom.*; 
import org.jdom.xpath.*;
import org.jdom.input.*; 
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.jdom.filter.Filter;
import org.jdom.filter.ElementFilter;


public class parsingXML4 {
	
	public static void main(String[] args) {
	
	ArrayList<Device> al = new ArrayList<Device>();	
	 try{ 
		 
		SAXBuilder builder = new SAXBuilder(); 
		Document doc = builder.build(new File("D://tmp//status.xml"));
		 List<Element> roots = (List) XPath.selectNodes(doc, "//door[@id='250']");
		 System.out.println("roots.size()="+roots.size());
		 for (Element el : roots) {
	            String status = el.getChildText("status");
	            String time = el.getChildText("time");
	            System.out.println(status);
	            System.out.println(time);
	            
	            Element statusa = el.getChild("status");
	            statusa.setText("UUUDD");
	          
	            
		 }
		 
		 XMLOutputter xmlOutput = new XMLOutputter();		 
			// display nice nice
			xmlOutput.setFormat(Format.getPrettyFormat());
			xmlOutput.output(doc, new FileWriter("d:\\tmp\\file2.xml"));
	
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
