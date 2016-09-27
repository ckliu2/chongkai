package org.zion.web.action;

import org.zion.value.TodayBible;
import org.zion.service.TodayBibleManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Tue Jan 06 17:19:58 CST 2015
*/

public class TodayBibleAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private TodayBible todayBible;
    private Long[] selectedTodayBibleIds;

    public TodayBibleAction()
    {
        log = LogFactory.getLog(org.zion.web.action.TodayBibleAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("TODAYBIBLE");
    }

    public TodayBible getTodayBible()
    {
        return todayBible;
    }

    public void setTodayBible(TodayBible val)
    {
        todayBible = val;
    }

    public void setGenericManager(TodayBibleManager m)
    {
        super.setGenericManager(m);
    }

    public TodayBibleManager getGenericManager()
    {
        return (TodayBibleManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeTodayBible(todayBible.getId());
        return DELETE;
    }

    public String edit()
    {
        if (todayBible == null) {
            todayBible = new TodayBible();
        } else if (todayBible.getId() != null) {
            todayBible = getGenericManager().getTodayBibleById(todayBible.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedTodayBibleIds != null && selectedTodayBibleIds.length > 0) {
            TodayBible obj = getGenericManager().getTodayBibleById(selectedTodayBibleIds[0]);
            obj.setId(null);
            todayBible = obj;
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
            if (inputValidation(todayBible) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(TodayBible val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveTodayBible(todayBible);
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
    public List<TodayBible> getTodayBibleList()
    {
        return getGenericManager().getTodayBibleList();
    }

    public void setSelectedTodayBibleIds(Long[] val)
    {
        selectedTodayBibleIds = val;
    }

    public Long[] getSelectedTodayBibleIds()
    {
        return selectedTodayBibleIds;
    }
}
