package com.web.web.action;

import com.web.value.*;
import com.web.service.WebManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.*;

public class CheckingStateAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private CheckingState checkingState;
    private Long[] selectedCheckingStateIds;

    public CheckingStateAction()
    {
        log = LogFactory.getLog(com.web.web.action.CheckingStateAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("CHECKINGSTATE");
    }

    public CheckingState getCheckingState()
    {
        return checkingState;
    }

    public void setCheckingState(CheckingState val)
    {
        checkingState = val;
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
        getGenericManager().removeCheckingState(checkingState.getId());
        return DELETE;
    }

    public String edit()
    {
        if (checkingState == null) {
            checkingState = new CheckingState();
        } else if (checkingState.getId() != null) {
            checkingState = getGenericManager().getCheckingStateById(checkingState.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedCheckingStateIds != null && selectedCheckingStateIds.length > 0) {
            CheckingState obj = getGenericManager().getCheckingStateById(selectedCheckingStateIds[0]);
            obj.setId(null);
            checkingState = obj;
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
            if (inputValidation(checkingState) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(CheckingState val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveCheckingState(checkingState);
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
        checkingState.setState(getAppPropertyById(checkingState.getStateId())); 
        log.info("exit formToBean()");
    }
    public List<AppProperty> getStateList()
    {
        return super.getAppPropertyList("checking.state");
    }

    public List<CheckingState> getCheckingStateList()
    {
        return getGenericManager().getCheckingStateList();
    }

    public void setSelectedCheckingStateIds(Long[] val)
    {
        selectedCheckingStateIds = val;
    }

    public Long[] getSelectedCheckingStateIds()
    {
        return selectedCheckingStateIds;
    }
}
