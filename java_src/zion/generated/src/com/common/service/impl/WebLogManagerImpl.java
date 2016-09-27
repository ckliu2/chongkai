package com.common.service.impl;

import com.common.service.WebLogManager;
import com.common.dao.WebLogDAO;
import com.common.value.WebLog;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Dec 18 16:53:07 CST 2014
*/

public class WebLogManagerImpl extends CommonManagerImpl implements WebLogManager
{

    public WebLogManagerImpl()
    {
    }

    public WebLogDAO getGenericDAO()
    {
        return (WebLogDAO)super.getGenericDAO();
    }

    public void setGenericDAO(WebLogDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveWebLog(WebLog val)
    {
        getGenericDAO().saveWebLog(val);
    }

    public void removeWebLog(WebLog val)
    {
        getGenericDAO().removeWebLog(val);
    }

    public void removeWebLog(Long id)
    {
        getGenericDAO().removeWebLog(id);
    }

    public WebLog getWebLogById(Long id)
    {
         return getGenericDAO().findWebLogById(id);
    }

    public List<WebLog> getWebLogList()
    {
        return getGenericDAO().findAllWebLog();
    }
}

