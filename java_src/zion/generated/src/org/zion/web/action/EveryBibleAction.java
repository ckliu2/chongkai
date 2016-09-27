package org.zion.web.action;

import org.zion.value.EveryBible;
import org.zion.service.EveryBibleManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jan 07 15:37:44 CST 2015
*/

public class EveryBibleAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private EveryBible everyBible;
    private String startDate;
    private Long[] selectedEveryBibleIds;

    public EveryBibleAction()
    {
        log = LogFactory.getLog(org.zion.web.action.EveryBibleAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("EVERYBIBLE");
    }

    public EveryBible getEveryBible()
    {
        return everyBible;
    }

    public void setEveryBible(EveryBible val)
    {
        everyBible = val;
    }

    public void setGenericManager(EveryBibleManager m)
    {
        super.setGenericManager(m);
    }

    public EveryBibleManager getGenericManager()
    {
        return (EveryBibleManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeEveryBible(everyBible.getId());
        return DELETE;
    }

    public String edit()
    {
        if (everyBible == null) {
            everyBible = new EveryBible();
        } else if (everyBible.getId() != null) {
            everyBible = getGenericManager().getEveryBibleById(everyBible.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedEveryBibleIds != null && selectedEveryBibleIds.length > 0) {
            EveryBible obj = getGenericManager().getEveryBibleById(selectedEveryBibleIds[0]);
            obj.setId(null);
            everyBible = obj;
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
            if (inputValidation(everyBible) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(EveryBible val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveEveryBible(everyBible);
        return SUCCESS;
    }

    public String list()
    {
        return SUCCESS;
    }

    protected void beanToForm()
    {
        log.info("enter beanToForm()");
        startDate = Tools.dateToString(everyBible.getStartDate());
        log.info("exit beanToForm()");
    }

    protected void formToBean()
    {
        log.info("enter formToBean()");
        everyBible.setStartDate(Tools.convertToDate(startDate)); 
        everyBible.setMember(getGenericManager().getMemberById(everyBible.getMemberId())); 
        log.info("exit formToBean()");
    }
    public void setStartDate(String val)
    {
        startDate = val;
    }

    public String getStartDate()
    {
        return startDate;
    }

    public List<Member> getMemberList()
    {
        return getGenericManager().getMemberList(); // TODO
    }

    public List<EveryBible> getEveryBibleList()
    {
        return getGenericManager().getEveryBibleList();
    }

    public void setSelectedEveryBibleIds(Long[] val)
    {
        selectedEveryBibleIds = val;
    }

    public Long[] getSelectedEveryBibleIds()
    {
        return selectedEveryBibleIds;
    }
}
