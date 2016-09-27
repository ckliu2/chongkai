package com.common.web.action;

import com.common.value.WebSite;
import com.common.service.WebSiteManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Dec 18 16:53:07 CST 2014
*/

public class WebSiteAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private WebSite webSite;
    private Long[] selectedWebSiteIds;

    public WebSiteAction()
    {
        log = LogFactory.getLog(com.common.web.action.WebSiteAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("WEBSITE");
    }

    public WebSite getWebSite()
    {
        return webSite;
    }

    public void setWebSite(WebSite val)
    {
        webSite = val;
    }

    public void setGenericManager(WebSiteManager m)
    {
        super.setGenericManager(m);
    }

    public WebSiteManager getGenericManager()
    {
        return (WebSiteManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeWebSite(webSite.getId());
        return DELETE;
    }

    public String edit()
    {
        if (webSite == null) {
            webSite = new WebSite();
        } else if (webSite.getId() != null) {
            webSite = getGenericManager().getWebSiteById(webSite.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedWebSiteIds != null && selectedWebSiteIds.length > 0) {
            WebSite obj = getGenericManager().getWebSiteById(selectedWebSiteIds[0]);
            obj.setId(null);
            webSite = obj;
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
            if (inputValidation(webSite) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(WebSite val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveWebSite(webSite);
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
        webSite.setLanguage(getMiscCodeById(webSite.getLanguageId())); 
        log.info("exit formToBean()");
    }
    public List<MiscCode> getLanguageList()
    {
        return super.getAppPropertyList("webSite.language");
    }

    public List<WebSite> getWebSiteList()
    {
        return getGenericManager().getWebSiteList();
    }

    public void setSelectedWebSiteIds(Long[] val)
    {
        selectedWebSiteIds = val;
    }

    public Long[] getSelectedWebSiteIds()
    {
        return selectedWebSiteIds;
    }
}
