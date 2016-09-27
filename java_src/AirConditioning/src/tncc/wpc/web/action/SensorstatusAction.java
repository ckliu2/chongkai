package tncc.wpc.web.action;

import tncc.wpc.value.*;
import tncc.wpc.service.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;
import com.common.mail.*;
/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Jan 30 15:17:56 CST 2010
*/

public class SensorstatusAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private Sensorstatus sensorstatus;
    private Long[] selectedSensorstatusIds;
    

    public SensorstatusAction()
    {    	
    	log = LogFactory.getLog(tncc.wpc.web.action.SensorstatusAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("SENSORSTATUS");
    }

    public Sensorstatus getSensorstatus()
    {
        return sensorstatus;
    }

    public void setSensorstatus(Sensorstatus val)
    {
        sensorstatus = val;
    }

    public void setGenericManager(wpcManager m)
    {
        super.setGenericManager(m);
    }

    public wpcManager getGenericManager()
    {
        return (wpcManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeSensorstatus(sensorstatus.getId());
        return DELETE;
    }

    public String edit()
    {
        if (sensorstatus == null) {
            sensorstatus = new Sensorstatus();
        } else if (sensorstatus.getId() != null) {
            sensorstatus = getGenericManager().getSensorstatusById(sensorstatus.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedSensorstatusIds != null && selectedSensorstatusIds.length > 0) {
            Sensorstatus obj = getGenericManager().getSensorstatusById(selectedSensorstatusIds[0]);
            obj.setId(null);
            sensorstatus = obj;
        }
        beanToForm();

        return SUCCESS;
    }

    public String execute()
    {
        log.info("entering 'execute' method");
        if (getDelete() != null) {
            return delete();
        } else {
            formToBean();
            if (inputValidation(sensorstatus) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(Sensorstatus val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        System.out.println("sensorstatus save()");
        getGenericManager().saveSensorstatus(sensorstatus);
        setPolicy();
        return SUCCESS;
    }
    
    
    public void setPolicy(){
        //如果有問題要寄mail

        	try{
        		//如果有異常
        		
        		//System.out.println("Sensor().getName()="+sensorstatus.getSensor().getName());
        		PolicyActiontest policy=new PolicyActiontest();
        		policy.setWorkflow(sensorstatus.getSensor(),sensorstatus.getStatus());
        		/*MailHelper m=new MailHelper();
        	    Sensor s=getGenericManager().getSensorById(sensorstatus.getSensorId());
        	    String msg="時間:"+s.getCreatedDate()+"<br>建築物:"+s.getController().getRoom().getBuilding().getName()+"<br>監控範圍:"+s.getController().getRoom().getName()+"<br>控制器:"+s.getController().getName()+"<br>感應器:"+s.getName()+"<hr><Font Color='red'  size: x-large>出現異常訊息,請再次確認!</Font>";
        	    m.sendHtmlMail("mark@mail.tnu.edu.tw", "DVR監控系統", "DVR監控系統通知信", msg);*/
        	  }catch(Exception e){
        		System.out.println("policy Error!="+e.toString());
        	  }
        	

        //如果有問題要寄mail
    }

    public String list()
    {
        return SUCCESS;
    }

    protected void beanToForm()
    {
        log.info("enter beanToForm()");
         
        log.info("exit beanToForm()");
    }

    protected void formToBean()
    {
        log.info("enter formToBean()");
        sensorstatus.setCreatedDate(Tools.getCurrentTimestamp());
        sensorstatus.setSensor(getGenericManager().getSensorById(sensorstatus.getSensorId())); 
        //System.out.println("sensorstatus formToBean()");        
        log.info("exit formToBean()");
    }
    
    
    
    
    public List<Sensor> getSensorList()
    {
        return getGenericManager().getSensorList(); // TODO
    }

    public List<Sensorstatus> getSensorstatusList()
    {
        return getGenericManager().getSensorstatusList();
    }

    public void setSelectedSensorstatusIds(Long[] val)
    {
        selectedSensorstatusIds = val;
    }

    public Long[] getSelectedSensorstatusIds()
    {
        return selectedSensorstatusIds;
    }   
}
