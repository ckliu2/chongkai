package tncc.power.web.action;

import tncc.power.value.Log;
import tncc.power.service.LogManager;
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

public class LogAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private Log log;
    private Long[] selectedLogIds;

    public LogAction()
    {
        log = LogFactory.getLog(tncc.power.web.action.LogAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("LOG");
    }

    public Log getLog()
    {
        return log;
    }

    public void setLog(Log val)
    {
        log = val;
    }

    public void setGenericManager(LogManager m)
    {
        super.setGenericManager(m);
    }

    public LogManager getGenericManager()
    {
        return (LogManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeLog(log.getId());
        return DELETE;
    }

    public String edit()
    {
        if (log == null) {
            log = new Log();
        } else if (log.getId() != null) {
            log = getGenericManager().getLogById(log.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedLogIds != null && selectedLogIds.length > 0) {
            Log obj = getGenericManager().getLogById(selectedLogIds[0]);
            obj.setId(null);
            log = obj;
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
            if (inputValidation(log) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(Log val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveLog(log);
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
        log.setType(getAppPropertyById(log.getTypeId())); 
        log.setScheduleDaily(getGenericManager().getScheduleDailyById(log.getScheduleDailyId())); 
        log.setReader(getGenericManager().getReaderById(log.getReaderId())); 
        log.info("exit formToBean()");
    }
    public List<AppProperty> getTypeList()
    {
        return super.getAppPropertyList("log.type");
    }

    public List<ScheduleDaily> getScheduleDailyList()
    {
        return getGenericManager().getScheduleDailyList(); // TODO
    }

    public List<Reader> getReaderList()
    {
        return getGenericManager().getReaderList(); // TODO
    }

    public List<Log> getLogList()
    {
        return getGenericManager().getLogList();
    }

    public void setSelectedLogIds(Long[] val)
    {
        selectedLogIds = val;
    }

    public Long[] getSelectedLogIds()
    {
        return selectedLogIds;
    }
}
