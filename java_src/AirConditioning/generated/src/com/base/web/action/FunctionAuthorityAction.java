package com.base.web.action;

import com.base.value.FunctionAuthority;
import com.base.service.FunctionAuthorityManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Dec 12 16:17:33 CST 2013
*/

public class FunctionAuthorityAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private FunctionAuthority functionAuthority;
    private Long[] selectedFunctionAuthorityIds;

    public FunctionAuthorityAction()
    {
        log = LogFactory.getLog(com.base.web.action.FunctionAuthorityAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("FUNCTIONAUTHORITY");
    }

    public FunctionAuthority getFunctionAuthority()
    {
        return functionAuthority;
    }

    public void setFunctionAuthority(FunctionAuthority val)
    {
        functionAuthority = val;
    }

    public void setGenericManager(FunctionAuthorityManager m)
    {
        super.setGenericManager(m);
    }

    public FunctionAuthorityManager getGenericManager()
    {
        return (FunctionAuthorityManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeFunctionAuthority(functionAuthority.getId());
        return DELETE;
    }

    public String edit()
    {
        if (functionAuthority == null) {
            functionAuthority = new FunctionAuthority();
        } else if (functionAuthority.getId() != null) {
            functionAuthority = getGenericManager().getFunctionAuthorityById(functionAuthority.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedFunctionAuthorityIds != null && selectedFunctionAuthorityIds.length > 0) {
            FunctionAuthority obj = getGenericManager().getFunctionAuthorityById(selectedFunctionAuthorityIds[0]);
            obj.setId(null);
            functionAuthority = obj;
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
            if (inputValidation(functionAuthority) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(FunctionAuthority val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveFunctionAuthority(functionAuthority);
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
        functionAuthority.setGroup(getGenericManager().getGroupById(functionAuthority.getGroupId())); 
        log.info("exit formToBean()");
    }
    public List<Group> getGroupList()
    {
        return getGenericManager().getGroupList(); // TODO
    }

    public List<FunctionAuthority> getFunctionAuthorityList()
    {
        return getGenericManager().getFunctionAuthorityList();
    }

    public void setSelectedFunctionAuthorityIds(Long[] val)
    {
        selectedFunctionAuthorityIds = val;
    }

    public Long[] getSelectedFunctionAuthorityIds()
    {
        return selectedFunctionAuthorityIds;
    }
}
