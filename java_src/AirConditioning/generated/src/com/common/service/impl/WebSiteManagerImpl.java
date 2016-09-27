package com.common.service.impl;

import com.common.service.WebSiteManager;
import com.common.dao.WebSiteDAO;
import com.common.value.WebSite;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Dec 12 16:17:33 CST 2013
*/

public class WebSiteManagerImpl extends CommonManagerImpl implements WebSiteManager
{

    public WebSiteManagerImpl()
    {
    }

    public WebSiteDAO getGenericDAO()
    {
        return (WebSiteDAO)super.getGenericDAO();
    }

    public void setGenericDAO(WebSiteDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveWebSite(WebSite val)
    {
        getGenericDAO().saveWebSite(val);
    }

    public void removeWebSite(WebSite val)
    {
        getGenericDAO().removeWebSite(val);
    }

    public void removeWebSite(Long id)
    {
        getGenericDAO().removeWebSite(id);
    }

    public WebSite getWebSiteById(Long id)
    {
         return getGenericDAO().findWebSiteById(id);
    }

    public List<WebSite> getWebSiteList()
    {
        return getGenericDAO().findAllWebSite();
    }
    public Long[] getIdsFromFunctionCategoryList(List<FunctionCategory> lst)
    {
        return getGenericDAO().getIdsFromFunctionCategoryList(lst);
    }

    public List<FunctionCategory> getFunctionCategoryListByIds(Long[] ids)
    {
        return getGenericDAO().getFunctionCategoryListByIds(ids);
    }

}

