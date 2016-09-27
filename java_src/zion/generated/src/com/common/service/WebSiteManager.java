package com.common.service;

import com.common.value.WebSite;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Dec 18 16:53:07 CST 2014
*/

public interface WebSiteManager extends CommonManager 
{
    public abstract void saveWebSite(WebSite val);

    public abstract void removeWebSite(WebSite val);

    public abstract void removeWebSite(Long id);

    public abstract WebSite getWebSiteById(Long id);

    public abstract List<WebSite> getWebSiteList();
}

