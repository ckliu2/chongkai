package tncc.wpc.web.action;

import tncc.wpc.value.*;
import tncc.wpc.service.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;

import com.common.util.XMLHelper;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;
import com.base.value.SessionUser;

import java.io.*;
//���JJDOM���O
import org.jdom.*;
import org.jdom.output.XMLOutputter;

public class PolicyAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
	String msg;
	File xml;
	;


    public PolicyAction()
    {
        log = LogFactory.getLog(PolicyAction.class);
    }

    public void setGenericManager(wpcManager m)
    {
        super.setGenericManager(m);
    }

    public wpcManager getGenericManager()
    {
        return (wpcManager) super.getGenericManager();
    }

  
    
    public String list()
    {  
    	System.out.println("list()");  
    	
    	// �إ߮ڤ���<addressbook> 	
        Element rootElement = new Element("addressbook");
        Document document = new Document(rootElement);
        // �إߤl����<name>�P���ݩʤΤ��e
        Element nameElement = new Element("name");
        nameElement.setAttribute("age", "26");
        nameElement.addContent("�����N");
        rootElement.addContent(nameElement);
        // �إߤl����<address>
        Element addressElement = new Element("address");
        addressElement.addContent("�x�_���H�q���E�q134��");
        rootElement.addContent(addressElement);
        // �إߤl����<telephone>
        Element telephoneElement = new Element("telephone");
        telephoneElement.addContent("02-27371234");
        rootElement.addContent(telephoneElement);
        // �إߤl����<zip>
        Element zipElement = new Element("zip");
        zipElement.addContent("101");
        rootElement.addContent(zipElement);        

        
     // ��XXML���
        
        
        XMLHelper.createXmlFile(document, getText("wpc.status.xml"));
        
       /* try {
          FileOutputStream output = new FileOutputStream(getText("wpc.status.xml"));	
          XMLOutputter outputter = new XMLOutputter();
          outputter.setNewlines(true);
          outputter.setIndent(true);
          outputter.output(document, output);              
          output.close();
        }catch (Exception e) {          
            System.out.println(e.toString());
          }  
*/

    	
    	return SUCCESS;
    }


    public String analysisSignal()
    {
    	//System.out.println("policyAction() analysisSignal() msg="+msg);    	
    	Sensor sensor=getSensor();
    	//System.out.println(sensor.getName()+"   "+sensor.getDeviceProperty().getName());
    	
    	//Save log
    	Sensorstatus sensorstatus=new Sensorstatus();
    	sensorstatus.setSensor(sensor);
    	sensorstatus.setCreatedDate(Tools.getCurrentTimestamp());
    	sensorstatus.setStatus(0);
    	getGenericManager().saveSensorstatus(sensorstatus);
    	
    	//�O���W�h
    	/*List<Rule> rules=getGenericManager().getRuleList();
    	  for(int i=0;i<rules.size();i++){
    		  Rule rule=(Rule)rules.get(i);
    		  System.out.println();
    	  }*/
    	//�O���W�h
    	
        return SUCCESS;
    }
    
    public List<Sensor> getSensorList(){
    	return getGenericManager().getSensorList();
    }
    
     public Sensor getSensor(){    	
     	String sensorId=msg.substring(18, 19);   	
    	Sensor s=getGenericManager().getSensorById(Long.parseLong(sensorId));
    	return s;
    }
    	

    
    public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	

	public File getXml() {
		return xml;
	}

	public void setXml(File xml) {
		this.xml = xml;
	}
	
	/*
	     public String list()
    {  
    	System.out.println("list()");  
    	
    	// �إ߮ڤ���<addressbook> 	
        Element rootElement = new Element("addressbook");
        Document document = new Document(rootElement);
        // �إߤl����<name>�P���ݩʤΤ��e
        Element nameElement = new Element("name");
        nameElement.setAttribute("age", "26");
        nameElement.addContent("�����N");
        rootElement.addContent(nameElement);
        // �إߤl����<address>
        Element addressElement = new Element("address");
        addressElement.addContent("�x�_���H�q���E�q134��");
        rootElement.addContent(addressElement);
        // �إߤl����<telephone>
        Element telephoneElement = new Element("telephone");
        telephoneElement.addContent("02-27371234");
        rootElement.addContent(telephoneElement);
        // �إߤl����<zip>
        Element zipElement = new Element("zip");
        zipElement.addContent("101");
        rootElement.addContent(zipElement);
        
     // ��XXML���
        
        try {
          FileOutputStream output = new FileOutputStream(getText("wpc.status.xml"));	
          XMLOutputter outputter = new XMLOutputter();
          outputter.setNewlines(true);
          outputter.setIndent(true);
          outputter.output(document, output);
          output.close();
        }catch (Exception e) {          
            System.out.println(e.toString());
          }  


    	
    	return SUCCESS;
    }
    */
	 



   
}
