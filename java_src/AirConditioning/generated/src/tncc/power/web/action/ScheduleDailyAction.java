package tncc.power.web.action;

import tncc.power.value.ScheduleDaily;
import tncc.power.service.ScheduleDailyManager;
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

public class ScheduleDailyAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private ScheduleDaily scheduleDaily;
    private String scheduledDate;
    private Long[] readersIds;
    private Long[] selectedScheduleDailyIds;

    public ScheduleDailyAction()
    {
        log = LogFactory.getLog(tncc.power.web.action.ScheduleDailyAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("SCHEDULEDAILY");
    }

    public ScheduleDaily getScheduleDaily()
    {
        return scheduleDaily;
    }

    public void setScheduleDaily(ScheduleDaily val)
    {
        scheduleDaily = val;
    }

    public void setGenericManager(ScheduleDailyManager m)
    {
        super.setGenericManager(m);
    }

    public ScheduleDailyManager getGenericManager()
    {
        return (ScheduleDailyManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeScheduleDaily(scheduleDaily.getId());
        return DELETE;
    }

    public String edit()
    {
        if (scheduleDaily == null) {
            scheduleDaily = new ScheduleDaily();
        } else if (scheduleDaily.getId() != null) {
            scheduleDaily = getGenericManager().getScheduleDailyById(scheduleDaily.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedScheduleDailyIds != null && selectedScheduleDailyIds.length > 0) {
            ScheduleDaily obj = getGenericManager().getScheduleDailyById(selectedScheduleDailyIds[0]);
            obj.setId(null);
            scheduleDaily = obj;
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
            if (inputValidation(scheduleDaily) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(ScheduleDaily val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        java.sql.Timestamp ts = Tools.getCurrentTimestamp();
        if (scheduleDaily.getId() == null) {
            scheduleDaily.setCreatedDate(ts);
            scheduleDaily.setCreatedUser(getSessionUser().getLoginId());
        }
        scheduleDaily.setLastModifiedDate(ts);
        scheduleDaily.setLastModifiedUser(getSessionUser().getLoginId());
        getGenericManager().saveScheduleDaily(scheduleDaily);
        return SUCCESS;
    }

    public String list()
    {
        return SUCCESS;
    }

    protected void beanToForm()
    {
        log.info("enter beanToForm()");
        scheduledDate = Tools.dateToString(scheduleDaily.getScheduledDate());
        readersIds = getGenericManager().getIdsFromReaderList(scheduleDaily.getReaders());
        log.info("exit beanToForm()");
    }

    protected void formToBean()
    {
        log.info("enter formToBean()");
        scheduleDaily.setScheduledDate(Tools.convertToDate(scheduledDate)); 
        scheduleDaily.setDrive(getAppPropertyById(scheduleDaily.getDriveId())); 
        scheduleDaily.setMode(getAppPropertyById(scheduleDaily.getModeId())); 
        scheduleDaily.setFanSpeed(getAppPropertyById(scheduleDaily.getFanSpeedId())); 
        scheduleDaily.setLock(getAppPropertyById(scheduleDaily.getLockId())); 
        scheduleDaily.setDriveItem(getAppPropertyById(scheduleDaily.getDriveItemId())); 
        scheduleDaily.setModeItem(getAppPropertyById(scheduleDaily.getModeItemId())); 
        scheduleDaily.setTempItem(getAppPropertyById(scheduleDaily.getTempItemId())); 
        scheduleDaily.setFilterItem(getAppPropertyById(scheduleDaily.getFilterItemId())); 
        scheduleDaily.setType(getAppPropertyById(scheduleDaily.getTypeId())); 
        scheduleDaily.setReaders(getGenericManager().getReaderListByIds(readersIds)); 
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

    public List<AppProperty> getDriveList()
    {
        return super.getAppPropertyList("scheduleDaily.drive");
    }

    public List<AppProperty> getModeList()
    {
        return super.getAppPropertyList("scheduleDaily.mode");
    }

    public List<AppProperty> getFanSpeedList()
    {
        return super.getAppPropertyList("scheduleDaily.fanSpeed");
    }

    public List<AppProperty> getLockList()
    {
        return super.getAppPropertyList("scheduleDaily.lock");
    }

    public List<AppProperty> getDriveItemList()
    {
        return super.getAppPropertyList("scheduleDaily.driveItem");
    }

    public List<AppProperty> getModeItemList()
    {
        return super.getAppPropertyList("scheduleDaily.modeItem");
    }

    public List<AppProperty> getTempItemList()
    {
        return super.getAppPropertyList("scheduleDaily.tempItem");
    }

    public List<AppProperty> getFilterItemList()
    {
        return super.getAppPropertyList("scheduleDaily.filterItem");
    }

    public List<AppProperty> getTypeList()
    {
        return super.getAppPropertyList("scheduleDaily.type");
    }

    public List<Set> getReadersList()
    {
        return getGenericManager().getReadersList(); // TODO
    }

    public void setReadersIds(Long[] val)
    {
        readersIds = val;
    }

    public Long[] getReadersIds()
    {
        return readersIds;
    }

    public List<ScheduleDaily> getScheduleDailyList()
    {
        return getGenericManager().getScheduleDailyList();
    }

    public void setSelectedScheduleDailyIds(Long[] val)
    {
        selectedScheduleDailyIds = val;
    }

    public Long[] getSelectedScheduleDailyIds()
    {
        return selectedScheduleDailyIds;
    }
}
