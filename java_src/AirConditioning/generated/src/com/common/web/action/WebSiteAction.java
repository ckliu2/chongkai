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
    Created Date: Thu Dec 12 16:17:33 CST 2013
*/

public class WebSiteAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private WebSite webSite;
    private Long[] functionCategoryIds;
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
        functionCategoryIds = getGenericManager().getIdsFromFunctionCategoryList(webSite.getFunctionCategory());
        log.info("exit beanToForm()");
    }

    protected void formToBean()
    {
        log.info("enter formToBean()");
        webSite.setCountry(getAppPropertyById(webSite.getCountryId())); 
        webSite.setSeoTitle(getAppPropertyById(webSite.getSeoTitleId())); 
        webSite.setSeoKeyword(getAppPropertyById(webSite.getSeoKeywordId())); 
        webSite.setSeoDesc(getAppPropertyById(webSite.getSeoDescId())); 
        webSite.setFunctionCategory(getGenericManager().getFunctionCategoryListByIds(functionCategoryIds)); 
        log.info("exit formToBean()");
    }
    public List<AppProperty> getCountryList()
    {
        return super.getAppPropertyList("webSite.country");
    }

    public List<AppProperty> getSeoTitleList()
    {
        return super.getAppPropertyList("webSite.seoTitle");
    }

    public List<AppProperty> getSeoKeywordList()
    {
        return super.getAppPropertyList("webSite.seoKeyword");
    }

    public List<AppProperty> getSeoDescList()
    {
        return super.getAppPropertyList("webSite.seoDesc");
    }

    public List<FunctionCategory> getFunctionCategoryList()
    {
        List<FunctionCategory> al = getGenericManager().getFunctionCategoryList();
        if (al != null) {
            if (webSite.getFunctionCategory() != null)
                al.removeAll(webSite.getFunctionCategory());
            return al;
        }
        return new ArrayList<FunctionCategory>();
    }

    public List<FunctionCategory> getObject_functionCategoryList()
    {
        return (webSite.getFunctionCategory() == null) ? new ArrayList<FunctionCategory>() : webSite.getFunctionCategory();
    }

    public void setFunctionCategoryIds(Long[] val)
    {
        functionCategoryIds = val;
    }

    public Long[] getFunctionCategoryIds()
    {
        return functionCategoryIds;
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
