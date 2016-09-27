package tncc.power.web.action;

import tncc.power.value.ClearDaily;
import tncc.power.service.ClearDailyManager;
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

public class ClearDailyAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private ClearDaily clearDaily;
    private Long[] selectedClearDailyIds;

    public ClearDailyAction()
    {
        log = LogFactory.getLog(tncc.power.web.action.ClearDailyAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("CLEARDAILY");
    }

    public ClearDaily getClearDaily()
    {
        return clearDaily;
    }

    public void setClearDaily(ClearDaily val)
    {
        clearDaily = val;
    }

    public void setGenericManager(ClearDailyManager m)
    {
        super.setGenericManager(m);
    }

    public ClearDailyManager getGenericManager()
    {
        return (ClearDailyManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeClearDaily(clearDaily.getId());
        return DELETE;
    }

    public String edit()
    {
        if (clearDaily == null) {
            clearDaily = new ClearDaily();
        } else if (clearDaily.getId() != null) {
            clearDaily = getGenericManager().getClearDailyById(clearDaily.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedClearDailyIds != null && selectedClearDailyIds.length > 0) {
            ClearDaily obj = getGenericManager().getClearDailyById(selectedClearDailyIds[0]);
            obj.setId(null);
            clearDaily = obj;
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
            if (inputValidation(clearDaily) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(ClearDaily val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveClearDaily(clearDaily);
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
        clearDaily.setReader(getGenericManager().getReaderById(clearDaily.getReaderId())); 
        clearDaily.setPowercontroller(getGenericManager().getPowerControllerById(clearDaily.getPowercontrollerId())); 
        log.info("exit formToBean()");
    }
    public List<Reader> getReaderList()
    {
        return getGenericManager().getReaderList(); // TODO
    }

    public List<PowerController> getPowercontrollerList()
    {
        return getGenericManager().getPowercontrollerList(); // TODO
    }

    public List<ClearDaily> getClearDailyList()
    {
        return getGenericManager().getClearDailyList();
    }

    public void setSelectedClearDailyIds(Long[] val)
    {
        selectedClearDailyIds = val;
    }

    public Long[] getSelectedClearDailyIds()
    {
        return selectedClearDailyIds;
    }
}
