package tncc.wpc.web.action;

import tncc.wpc.value.*;
import tncc.wpc.service.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;
import com.base.value.SessionUser;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Jan 30 12:11:00 CST 2010
*/

public class SensorAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private Sensor sensor;
    private Long[] selectedSensorIds;

    public SensorAction()
    {
        log = LogFactory.getLog(tncc.wpc.web.action.SensorAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("SENSOR");
    }

    public Sensor getSensor()
    {
        return sensor;
    }

    public void setSensor(Sensor val)
    {
        sensor = val;
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
        getGenericManager().removeSensor(sensor.getId());
        return DELETE;
    }

    public String edit()
    {
        if (sensor == null) {
            sensor = new Sensor();
        } else if (sensor.getId() != null) {
            sensor = getGenericManager().getSensorById(sensor.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedSensorIds != null && selectedSensorIds.length > 0) {
            Sensor obj = getGenericManager().getSensorById(selectedSensorIds[0]);
            obj.setId(null);
            sensor = obj;
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
            if (inputValidation(sensor) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(Sensor val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveSensor(sensor);
        return SUCCESS;
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
        SessionUser s=(SessionUser)getSession().getAttribute("user");    
        sensor.setMember(s.getMember()); 
        sensor.setCreatedDate(Tools.getCurrentTimestamp());      
        sensor.setCreatedUser(s.getMember()); 
        sensor.setController(getGenericManager().getControllerById(sensor.getControllerId())); 
        sensor.setDeviceProperty(getGenericManager().getDevicePropertyById(sensor.getDevicePropertyId())); 
        sensor.setMydvr(getGenericManager().getMyDVRById(sensor.getMydvrId())); 
        log.info("exit formToBean()");
    }


    public List<Controller> getControllerList()
    {
        return getGenericManager().getControllerList(); // TODO
    }

    public List<Sensor> getSensorList()
    {
        return getGenericManager().getSensorList();
    }

    public void setSelectedSensorIds(Long[] val)
    {
        selectedSensorIds = val;
    }

    public Long[] getSelectedSensorIds()
    {
        return selectedSensorIds;
    }
    
    public List<DeviceProperty> getDevicePropertyList()
    {
        return getGenericManager().getDevicePropertyList(); // TODO
    }
    
    public List<MyDVR> getMyDVRList()
    {
        return getGenericManager().getMyDVRList(); // TODO
    }

}
