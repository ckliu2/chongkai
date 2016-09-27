package tncc.power.web.action;

import tncc.power.value.PowerController;
import tncc.power.service.PowerControllerManager;
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

public class PowerControllerAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private PowerController powerController;
    private Long[] readerIds;
    private Long[] selectedPowerControllerIds;

    public PowerControllerAction()
    {
        log = LogFactory.getLog(tncc.power.web.action.PowerControllerAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("POWERCONTROLLER");
    }

    public PowerController getPowerController()
    {
        return powerController;
    }

    public void setPowerController(PowerController val)
    {
        powerController = val;
    }

    public void setGenericManager(PowerControllerManager m)
    {
        super.setGenericManager(m);
    }

    public PowerControllerManager getGenericManager()
    {
        return (PowerControllerManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removePowerController(powerController.getId());
        return DELETE;
    }

    public String edit()
    {
        if (powerController == null) {
            powerController = new PowerController();
        } else if (powerController.getId() != null) {
            powerController = getGenericManager().getPowerControllerById(powerController.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedPowerControllerIds != null && selectedPowerControllerIds.length > 0) {
            PowerController obj = getGenericManager().getPowerControllerById(selectedPowerControllerIds[0]);
            obj.setId(null);
            powerController = obj;
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
            if (inputValidation(powerController) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(PowerController val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().savePowerController(powerController);
        return SUCCESS;
    }

    public String list()
    {
        return SUCCESS;
    }

    protected void beanToForm()
    {
        log.info("enter beanToForm()");
        readerIds = getGenericManager().getIdsFromReaderList(powerController.getReader());
        log.info("exit beanToForm()");
    }

    protected void formToBean()
    {
        log.info("enter formToBean()");
        powerController.setBuilding(getGenericManager().getBuildingById(powerController.getBuildingId())); 
        powerController.setDeviceType(getAppPropertyById(powerController.getDeviceTypeId())); 
        powerController.setReader(getGenericManager().getReaderListByIds(readerIds)); 
        log.info("exit formToBean()");
    }
    public List<Building> getBuildingList()
    {
        return getGenericManager().getBuildingList(); // TODO
    }

    public List<AppProperty> getDeviceTypeList()
    {
        return super.getAppPropertyList("powerController.deviceType");
    }

    public List<List> getReaderList()
    {
        return getGenericManager().getReaderList(); // TODO
    }

    public void setReaderIds(Long[] val)
    {
        readerIds = val;
    }

    public Long[] getReaderIds()
    {
        return readerIds;
    }

    public List<PowerController> getPowerControllerList()
    {
        return getGenericManager().getPowerControllerList();
    }

    public void setSelectedPowerControllerIds(Long[] val)
    {
        selectedPowerControllerIds = val;
    }

    public Long[] getSelectedPowerControllerIds()
    {
        return selectedPowerControllerIds;
    }
}
