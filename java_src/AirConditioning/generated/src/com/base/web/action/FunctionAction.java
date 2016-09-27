package com.base.web.action;

import com.base.value.Function;
import com.base.service.FunctionManager;
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

public class FunctionAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private Function function;
    private String editBegin;
    private String editEnd;
    private Long[] authorityIds;
    private Long[] selectedFunctionIds;

    public FunctionAction()
    {
        log = LogFactory.getLog(com.base.web.action.FunctionAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("FUNCTION");
    }

    public Function getFunction()
    {
        return function;
    }

    public void setFunction(Function val)
    {
        function = val;
    }

    public void setGenericManager(FunctionManager m)
    {
        super.setGenericManager(m);
    }

    public FunctionManager getGenericManager()
    {
        return (FunctionManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeFunction(function.getId());
        return DELETE;
    }

    public String edit()
    {
        if (function == null) {
            function = new Function();
        } else if (function.getId() != null) {
            function = getGenericManager().getFunctionById(function.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedFunctionIds != null && selectedFunctionIds.length > 0) {
            Function obj = getGenericManager().getFunctionById(selectedFunctionIds[0]);
            obj.setId(null);
            function = obj;
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
            if (inputValidation(function) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(Function val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveFunction(function);
        return SUCCESS;
    }

    public String list()
    {
        return SUCCESS;
    }

    protected void beanToForm()
    {
        log.info("enter beanToForm()");
        editBegin = Tools.dateToString(function.getEditBegin());
        editEnd = Tools.dateToString(function.getEditEnd());
        log.info("exit beanToForm()");
    }

    protected void formToBean()
    {
        log.info("enter formToBean()");
        function.setEditBegin(Tools.convertToDate(editBegin)); 
        function.setEditEnd(Tools.convertToDate(editEnd)); 
        function.setCategory(getGenericManager().getFunctionCategoryById(function.getCategoryId())); 
        log.info("exit formToBean()");
    }
    public void setEditBegin(String val)
    {
        editBegin = val;
    }

    public String getEditBegin()
    {
        return editBegin;
    }

    public void setEditEnd(String val)
    {
        editEnd = val;
    }

    public String getEditEnd()
    {
        return editEnd;
    }

    public List<FunctionCategory> getCategoryList()
    {
        return getGenericManager().getCategoryList(); // TODO
    }

    public void setAuthorityIds(Long[] val)
    {
        authorityIds = val;
    }

    public Long[] getAuthorityIds()
    {
        return authorityIds;
    }

    public List<Function> getFunctionList()
    {
        return getGenericManager().getFunctionList();
    }

    public void setSelectedFunctionIds(Long[] val)
    {
        selectedFunctionIds = val;
    }

    public Long[] getSelectedFunctionIds()
    {
        return selectedFunctionIds;
    }
}
