package tncc.power.web.action;

import tncc.power.value.Reader;
import tncc.power.service.ReaderManager;
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

public class ReaderAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private Reader reader;
    private Long[] scheduleDailysIds;
    private Long[] selectedReaderIds;

    public ReaderAction()
    {
        log = LogFactory.getLog(tncc.power.web.action.ReaderAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("READER");
    }

    public Reader getReader()
    {
        return reader;
    }

    public void setReader(Reader val)
    {
        reader = val;
    }

    public void setGenericManager(ReaderManager m)
    {
        super.setGenericManager(m);
    }

    public ReaderManager getGenericManager()
    {
        return (ReaderManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeReader(reader.getId());
        return DELETE;
    }

    public String edit()
    {
        if (reader == null) {
            reader = new Reader();
        } else if (reader.getId() != null) {
            reader = getGenericManager().getReaderById(reader.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedReaderIds != null && selectedReaderIds.length > 0) {
            Reader obj = getGenericManager().getReaderById(selectedReaderIds[0]);
            obj.setId(null);
            reader = obj;
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
            if (inputValidation(reader) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(Reader val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        java.sql.Timestamp ts = Tools.getCurrentTimestamp();
        if (reader.getId() == null) {
            reader.setCreatedDate(ts);
            reader.setCreatedUser(getSessionUser().getLoginId());
        }
        reader.setLastModifiedDate(ts);
        reader.setLastModifiedUser(getSessionUser().getLoginId());
        getGenericManager().saveReader(reader);
        return SUCCESS;
    }

    public String list()
    {
        return SUCCESS;
    }

    protected void beanToForm()
    {
        log.info("enter beanToForm()");
        scheduleDailysIds = getGenericManager().getIdsFromScheduleDailyList(reader.getScheduleDailys());
        log.info("exit beanToForm()");
    }

    protected void formToBean()
    {
        log.info("enter formToBean()");
        reader.setDrive(getAppPropertyById(reader.getDriveId())); 
        reader.setMode(getAppPropertyById(reader.getModeId())); 
        reader.setFanSpeed(getAppPropertyById(reader.getFanSpeedId())); 
        reader.setDriveItem(getAppPropertyById(reader.getDriveItemId())); 
        reader.setModeItem(getAppPropertyById(reader.getModeItemId())); 
        reader.setTempItem(getAppPropertyById(reader.getTempItemId())); 
        reader.setFilterItem(getAppPropertyById(reader.getFilterItemId())); 
        reader.setLock(getAppPropertyById(reader.getLockId())); 
        reader.setState(getAppPropertyById(reader.getStateId())); 
        reader.setScheduleDailys(getGenericManager().getScheduleDailyListByIds(scheduleDailysIds)); 
        log.info("exit formToBean()");
    }
    public List<AppProperty> getDriveList()
    {
        return super.getAppPropertyList("reader.drive");
    }

    public List<AppProperty> getModeList()
    {
        return super.getAppPropertyList("reader.mode");
    }

    public List<AppProperty> getFanSpeedList()
    {
        return super.getAppPropertyList("reader.fanSpeed");
    }

    public List<AppProperty> getDriveItemList()
    {
        return super.getAppPropertyList("reader.driveItem");
    }

    public List<AppProperty> getModeItemList()
    {
        return super.getAppPropertyList("reader.modeItem");
    }

    public List<AppProperty> getTempItemList()
    {
        return super.getAppPropertyList("reader.tempItem");
    }

    public List<AppProperty> getFilterItemList()
    {
        return super.getAppPropertyList("reader.filterItem");
    }

    public List<AppProperty> getLockList()
    {
        return super.getAppPropertyList("reader.lock");
    }

    public List<AppProperty> getStateList()
    {
        return super.getAppPropertyList("reader.state");
    }

    public List<Set> getScheduleDailysList()
    {
        return getGenericManager().getScheduleDailysList(); // TODO
    }

    public void setScheduleDailysIds(Long[] val)
    {
        scheduleDailysIds = val;
    }

    public Long[] getScheduleDailysIds()
    {
        return scheduleDailysIds;
    }

    public List<Reader> getReaderList()
    {
        return getGenericManager().getReaderList();
    }

    public void setSelectedReaderIds(Long[] val)
    {
        selectedReaderIds = val;
    }

    public Long[] getSelectedReaderIds()
    {
        return selectedReaderIds;
    }
}
