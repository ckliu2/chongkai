package MITSUBISHI_G50;

import java.util.*;
import java.sql.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.*;

import com.base.util.Tools;

import tncc.power.service.PowerManager;
import tncc.power.value.PowerController;

public class Status1 extends HttpServlet{

	com.opensymphony.xwork.ActionSupport ww= new com.opensymphony.xwork.ActionSupport();
	/*
	ServletContext servletContext=getServletContext(); 
    ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
    */
     
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//showStatus();
		/*
		1	с눌속1F좦2F	140.118.58.225
        4	с눌속3F좦4F	140.118.58.226
        5	с눌속5F좦6F	140.118.58.227
		*/
		
		int controller=5;
		System.out.println("response start="+Tools.getCurrentTimestamp());
		DeviceConnection c=new DeviceConnection("140.118.58.225");
        List<Device> al=c.getDeviceStatus();
        for(int i=0;i<al.size();i++){
        	Device d=al.get(i); 
        	System.out.println(i+"--Group="+d.getGroup()+"--Drive="+d.getDrive()+"--SetTemp="+d.getSetTemp()+"--d.getDriveItem()="+d.getDriveItem());
        	
        	//String sql="INSERT INTO G50(controller,reader,settemp,drive,mode,driveItem,modeItem,setTempItem,filterItem)VALUES('"+controller+"','"+d.getGroup()+"','"+d.getSetTemp()+"','"+d.getDrive()+"','"+d.getMode()+"','"+d.getDriveItem()+"','"+d.getModeItem()+"','"+d.getSetTempItem()+"','"+d.getFilterItem()+"')";
        	//setModify(sql);
        
        }
        System.out.println("response end="+Tools.getCurrentTimestamp());
        
        
	}
	
	
	
	public static void setModify(String Modify){
		  try{
			  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		      Connection conn = DriverManager.getConnection("jdbc:sqlserver://203.71.172.251:1433;DatabaseName=AirConditioning","schuser","davidjeff");		      
		      Statement Stmt = conn.createStatement();
		      Stmt.execute(Modify);
	          conn.close();
		  }catch(Exception e){
	         System.out.println("setModify error");         
		  }
		}

}
