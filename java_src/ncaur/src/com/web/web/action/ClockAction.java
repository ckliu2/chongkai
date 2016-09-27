package com.web.web.action;

import com.web.value.*;
import com.web.service.WebManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;


public class ClockAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private Clock clock;
    private Long[] selectedClockIds;

    public ClockAction()
    {
        log = LogFactory.getLog(com.web.web.action.ClockAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("CLOCK");
    }

    public Clock getClock()
    {
        return clock;
    }

    public void setClock(Clock val)
    {
        clock = val;
    }

    public void setGenericManager(WebManager m)
    {
        super.setGenericManager(m);
    }

    public WebManager getGenericManager()
    {
        return (WebManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeClock(clock.getId());
        return DELETE;
    }

    public String edit()
    {
        if (clock == null) {
            clock = new Clock();
        } else if (clock.getId() != null) {
            clock = getGenericManager().getClockById(clock.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedClockIds != null && selectedClockIds.length > 0) {
            Clock obj = getGenericManager().getClockById(selectedClockIds[0]);
            obj.setId(null);
            clock = obj;
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
            if (inputValidation(clock) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(Clock val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        java.sql.Timestamp ts = Tools.getCurrentTimestamp();
        if (clock.getId() == null) {
            clock.setCreatedDate(ts);
            clock.setCreatedUser(getSessionUser().getMember());
        }
        clock.setLastModifiedDate(ts);
        clock.setLastModifiedUser(getSessionUser().getMember());
        getGenericManager().saveClock(clock);
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
        log.info("exit formToBean()");
    }
    public List<Clock> getClockList()
    {
        return getGenericManager().getClockList();
    }

    public void setSelectedClockIds(Long[] val)
    {
        selectedClockIds = val;
    }

    public Long[] getSelectedClockIds()
    {
        return selectedClockIds;
    }
}
