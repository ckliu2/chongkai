package tncc.wpc.web.action;

import tncc.wpc.value.*;
import tncc.wpc.service.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Tue Feb 02 14:20:47 CST 2010
*/

public class TimesAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private Times times;
    private Long[] selectedTimesIds;

    public TimesAction()
    {
        log = LogFactory.getLog(tncc.wpc.web.action.TimesAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("TIMES");
    }

    public Times getTimes()
    {
        return times;
    }

    public void setTimes(Times val)
    {
        times = val;
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
        getGenericManager().removeTimes(times.getId());
        return DELETE;
    }

    public String edit()
    {
        if (times == null) {
            times = new Times();
        } else if (times.getId() != null) {
            times = getGenericManager().getTimesById(times.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedTimesIds != null && selectedTimesIds.length > 0) {
            Times obj = getGenericManager().getTimesById(selectedTimesIds[0]);
            obj.setId(null);
            times = obj;
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
            if (inputValidation(times) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(Times val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveTimes(times);
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
    public List<Times> getTimesList()
    {
        return getGenericManager().getTimesList();
    }

    public void setSelectedTimesIds(Long[] val)
    {
        selectedTimesIds = val;
    }

    public Long[] getSelectedTimesIds()
    {
        return selectedTimesIds;
    }
}
