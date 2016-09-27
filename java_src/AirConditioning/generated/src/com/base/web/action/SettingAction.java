package com.base.web.action;

import com.base.value.Setting;
import com.base.service.SettingManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Oct 17 16:59:08 CST 2013
*/

public class SettingAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private Setting setting;
    private Long[] selectedSettingIds;

    public SettingAction()
    {
        log = LogFactory.getLog(com.base.web.action.SettingAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("SETTING");
    }

    public Setting getSetting()
    {
        return setting;
    }

    public void setSetting(Setting val)
    {
        setting = val;
    }

    public void setGenericManager(SettingManager m)
    {
        super.setGenericManager(m);
    }

    public SettingManager getGenericManager()
    {
        return (SettingManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeSetting(setting.getId());
        return DELETE;
    }

    public String edit()
    {
        if (setting == null) {
            setting = new Setting();
        } else if (setting.getId() != null) {
            setting = getGenericManager().getSettingById(setting.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedSettingIds != null && selectedSettingIds.length > 0) {
            Setting obj = getGenericManager().getSettingById(selectedSettingIds[0]);
            obj.setId(null);
            setting = obj;
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
            if (inputValidation(setting) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(Setting val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveSetting(setting);
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
    public List<Setting> getSettingList()
    {
        return getGenericManager().getSettingList();
    }

    public void setSelectedSettingIds(Long[] val)
    {
        selectedSettingIds = val;
    }

    public Long[] getSelectedSettingIds()
    {
        return selectedSettingIds;
    }
}
