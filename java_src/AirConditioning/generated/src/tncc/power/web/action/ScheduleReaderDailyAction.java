package tncc.power.web.action;

import tncc.power.value.ScheduleReaderDaily;
import tncc.power.service.ScheduleReaderDailyManager;
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

public class ScheduleReaderDailyAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private ScheduleReaderDaily scheduleReaderDaily;
    private String scheduledDate;
    private Long[] selectedScheduleReaderDailyIds;

    public ScheduleReaderDailyAction()
    {
        log = LogFactory.getLog(tncc.power.web.action.ScheduleReaderDailyAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("SCHEDULEREADERDAILY");
    }

    public ScheduleReaderDaily getScheduleReaderDaily()
    {
        return scheduleReaderDaily;
    }

    public void setScheduleReaderDaily(ScheduleReaderDaily val)
    {
        scheduleReaderDaily = val;
    }

    public void setGenericManager(ScheduleReaderDailyManager m)
    {
        super.setGenericManager(m);
    }

    public ScheduleReaderDailyManager getGenericManager()
    {
        return (ScheduleReaderDailyManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeScheduleReaderDaily(scheduleReaderDaily.getId());
        return DELETE;
    }

    public String edit()
    {
        if (scheduleReaderDaily == null) {
            scheduleReaderDaily = new ScheduleReaderDaily();
        } else if (scheduleReaderDaily.getId() != null) {
            scheduleReaderDaily = getGenericManager().getScheduleReaderDailyById(scheduleReaderDaily.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedScheduleReaderDailyIds != null && selectedScheduleReaderDailyIds.length > 0) {
            ScheduleReaderDaily obj = getGenericManager().getScheduleReaderDailyById(selectedScheduleReaderDailyIds[0]);
            obj.setId(null);
            scheduleReaderDaily = obj;
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
            if (inputValidation(scheduleReaderDaily) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(ScheduleReaderDaily val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveScheduleReaderDaily(scheduleReaderDaily);
        return SUCCESS;
    }

    public String list()
    {
        return SUCCESS;
    }

    protected void beanToForm()
    {
        log.info("enter beanToForm()");
        scheduledDate = Tools.dateToString(scheduleReaderDaily.getScheduledDate());
        log.info("exit beanToForm()");
    }

    protected void formToBean()
    {
        log.info("enter formToBean()");
        scheduleReaderDaily.setScheduledDate(Tools.convertToDate(scheduledDate)); 
        scheduleReaderDaily.setReader(getGenericManager().getReaderById(scheduleReaderDaily.getReaderId())); 
        scheduleReaderDaily.setScheduleDaily(getGenericManager().getScheduleDailyById(scheduleReaderDaily.getScheduleDailyId())); 
        scheduleReaderDaily.setType(getAppPropertyById(scheduleReaderDaily.getTypeId())); 
        scheduleReaderDaily.setPowerController(getGenericManager().getPowerControllerById(scheduleReaderDaily.getPowerControllerId())); 
        log.info("exit formToBean()");
    }
    public void setScheduledDate(String val)
    {
        scheduledDate = val;
    }

    public String getScheduledDate()
    {
        return scheduledDate;
    }

    public List<Reader> getReaderList()
    {
        return getGenericManager().getReaderList(); // TODO
    }

    public List<ScheduleDaily> getScheduleDailyList()
    {
        return getGenericManager().getScheduleDailyList(); // TODO
    }

    public List<AppProperty> getTypeList()
    {
        return super.getAppPropertyList("scheduleReaderDaily.type");
    }

    public List<PowerController> getPowerControllerList()
    {
        return getGenericManager().getPowerControllerList(); // TODO
    }

    public List<ScheduleReaderDaily> getScheduleReaderDailyList()
    {
        return getGenericManager().getScheduleReaderDailyList();
    }

    public void setSelectedScheduleReaderDailyIds(Long[] val)
    {
        selectedScheduleReaderDailyIds = val;
    }

    public Long[] getSelectedScheduleReaderDailyIds()
    {
        return selectedScheduleReaderDailyIds;
    }
}
