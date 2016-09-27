package com.base.web.action;

import com.base.value.AppProperty;
import com.base.service.AppPropertyManager;
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

public class AppPropertyAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private AppProperty appProperty;
    private Long[] selectedAppPropertyIds;

    public AppPropertyAction()
    {
        log = LogFactory.getLog(com.base.web.action.AppPropertyAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("APPPROPERTY");
    }

    public AppProperty getAppProperty()
    {
        return appProperty;
    }

    public void setAppProperty(AppProperty val)
    {
        appProperty = val;
    }

    public void setGenericManager(AppPropertyManager m)
    {
        super.setGenericManager(m);
    }

    public AppPropertyManager getGenericManager()
    {
        return (AppPropertyManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeAppProperty(appProperty.getId());
        return DELETE;
    }

    public String edit()
    {
        if (appProperty == null) {
            appProperty = new AppProperty();
        } else if (appProperty.getId() != null) {
            appProperty = getGenericManager().getAppPropertyById(appProperty.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedAppPropertyIds != null && selectedAppPropertyIds.length > 0) {
            AppProperty obj = getGenericManager().getAppPropertyById(selectedAppPropertyIds[0]);
            obj.setId(null);
            appProperty = obj;
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
            if (inputValidation(appProperty) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(AppProperty val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveAppProperty(appProperty);
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
    public List<AppProperty> getAppPropertyList()
    {
        return getGenericManager().getAppPropertyList();
    }

    public void setSelectedAppPropertyIds(Long[] val)
    {
        selectedAppPropertyIds = val;
    }

    public Long[] getSelectedAppPropertyIds()
    {
        return selectedAppPropertyIds;
    }
}
