package com.base.web.action;

import com.base.value.FunctionCategory;
import com.base.service.FunctionCategoryManager;
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

public class FunctionCategoryAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private FunctionCategory functionCategory;
    private Long[] selectedFunctionCategoryIds;

    public FunctionCategoryAction()
    {
        log = LogFactory.getLog(com.base.web.action.FunctionCategoryAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("FUNCTIONCATEGORY");
    }

    public FunctionCategory getFunctionCategory()
    {
        return functionCategory;
    }

    public void setFunctionCategory(FunctionCategory val)
    {
        functionCategory = val;
    }

    public void setGenericManager(FunctionCategoryManager m)
    {
        super.setGenericManager(m);
    }

    public FunctionCategoryManager getGenericManager()
    {
        return (FunctionCategoryManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeFunctionCategory(functionCategory.getId());
        return DELETE;
    }

    public String edit()
    {
        if (functionCategory == null) {
            functionCategory = new FunctionCategory();
        } else if (functionCategory.getId() != null) {
            functionCategory = getGenericManager().getFunctionCategoryById(functionCategory.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedFunctionCategoryIds != null && selectedFunctionCategoryIds.length > 0) {
            FunctionCategory obj = getGenericManager().getFunctionCategoryById(selectedFunctionCategoryIds[0]);
            obj.setId(null);
            functionCategory = obj;
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
            if (inputValidation(functionCategory) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(FunctionCategory val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveFunctionCategory(functionCategory);
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
    public List<FunctionCategory> getFunctionCategoryList()
    {
        return getGenericManager().getFunctionCategoryList();
    }

    public void setSelectedFunctionCategoryIds(Long[] val)
    {
        selectedFunctionCategoryIds = val;
    }

    public Long[] getSelectedFunctionCategoryIds()
    {
        return selectedFunctionCategoryIds;
    }
}
