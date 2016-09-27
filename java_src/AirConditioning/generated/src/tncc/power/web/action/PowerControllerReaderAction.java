package tncc.power.web.action;

import tncc.power.value.PowerControllerReader;
import tncc.power.service.PowerControllerReaderManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Mar 20 16:19:30 CST 2014
*/

public class PowerControllerReaderAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private PowerControllerReader powerControllerReader;
    private Long[] selectedPowerControllerReaderIds;

    public PowerControllerReaderAction()
    {
        log = LogFactory.getLog(tncc.power.web.action.PowerControllerReaderAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("POWERCONTROLLERREADER");
    }

    public PowerControllerReader getPowerControllerReader()
    {
        return powerControllerReader;
    }

    public void setPowerControllerReader(PowerControllerReader val)
    {
        powerControllerReader = val;
    }

    public void setGenericManager(PowerControllerReaderManager m)
    {
        super.setGenericManager(m);
    }

    public PowerControllerReaderManager getGenericManager()
    {
        return (PowerControllerReaderManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removePowerControllerReader(powerControllerReader.getId());
        return DELETE;
    }

    public String edit()
    {
        if (powerControllerReader == null) {
            powerControllerReader = new PowerControllerReader();
        } else if (powerControllerReader.getId() != null) {
            powerControllerReader = getGenericManager().getPowerControllerReaderById(powerControllerReader.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedPowerControllerReaderIds != null && selectedPowerControllerReaderIds.length > 0) {
            PowerControllerReader obj = getGenericManager().getPowerControllerReaderById(selectedPowerControllerReaderIds[0]);
            obj.setId(null);
            powerControllerReader = obj;
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
            if (inputValidation(powerControllerReader) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(PowerControllerReader val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().savePowerControllerReader(powerControllerReader);
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
        powerControllerReader.setPowerController(getGenericManager().getPowerControllerById(powerControllerReader.getPowerControllerId())); 
        powerControllerReader.setReader(getGenericManager().getReaderById(powerControllerReader.getReaderId())); 
        powerControllerReader.setClassRoom(getGenericManager().getClassRoomById(powerControllerReader.getClassRoomId())); 
        powerControllerReader.setCourse(getGenericManager().getCourseById(powerControllerReader.getCourseId())); 
        log.info("exit formToBean()");
    }
    public List<PowerController> getPowerControllerList()
    {
        return getGenericManager().getPowerControllerList(); // TODO
    }

    public List<Reader> getReaderList()
    {
        return getGenericManager().getReaderList(); // TODO
    }

    public List<ClassRoom> getClassRoomList()
    {
        return getGenericManager().getClassRoomList(); // TODO
    }

    public List<Course> getCourseList()
    {
        return getGenericManager().getCourseList(); // TODO
    }

    public List<PowerControllerReader> getPowerControllerReaderList()
    {
        return getGenericManager().getPowerControllerReaderList();
    }

    public void setSelectedPowerControllerReaderIds(Long[] val)
    {
        selectedPowerControllerReaderIds = val;
    }

    public Long[] getSelectedPowerControllerReaderIds()
    {
        return selectedPowerControllerReaderIds;
    }
}
