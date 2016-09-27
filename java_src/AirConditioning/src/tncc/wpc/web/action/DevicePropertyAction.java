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
    Created Date: Tue Feb 02 14:20:47 CST 2010
*/

public class DevicePropertyAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private DeviceProperty deviceProperty;
    private Long[] selectedDevicePropertyIds;

    public DevicePropertyAction()
    {
        log = LogFactory.getLog(tncc.wpc.web.action.DevicePropertyAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("DEVICEPROPERTY");
    }

    public DeviceProperty getDeviceProperty()
    {
        return deviceProperty;
    }

    public void setDeviceProperty(DeviceProperty val)
    {
        deviceProperty = val;
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
        getGenericManager().removeDeviceProperty(deviceProperty.getId());
        return DELETE;
    }

    public String edit()
    {
        if (deviceProperty == null) {
            deviceProperty = new DeviceProperty();
        } else if (deviceProperty.getId() != null) {
            deviceProperty = getGenericManager().getDevicePropertyById(deviceProperty.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedDevicePropertyIds != null && selectedDevicePropertyIds.length > 0) {
            DeviceProperty obj = getGenericManager().getDevicePropertyById(selectedDevicePropertyIds[0]);
            obj.setId(null);
            deviceProperty = obj;
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
            if (inputValidation(deviceProperty) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(DeviceProperty val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveDeviceProperty(deviceProperty);
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
        deviceProperty.setMember(s.getMember()); 
        deviceProperty.setCreatedDate(Tools.getCurrentTimestamp());      
        deviceProperty.setCreatedUser(s.getMember());          
        deviceProperty.setMember(getGenericManager().getMemberById(deviceProperty.getMemberId())); 
        log.info("exit formToBean()");
    }


    public List<DeviceProperty> getDevicePropertyList()
    {
        return getGenericManager().getDevicePropertyList();
    }

    public void setSelectedDevicePropertyIds(Long[] val)
    {
        selectedDevicePropertyIds = val;
    }

    public Long[] getSelectedDevicePropertyIds()
    {
        return selectedDevicePropertyIds;
    }
    
    public List<Rule> getRuleList()
    {
        return getGenericManager().getRuleList(); // TODO
    }
}
