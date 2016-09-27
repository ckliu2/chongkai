package com.base.service.impl;

import com.base.service.AppPropertyManager;
import com.base.dao.AppPropertyDAO;
import com.base.value.AppProperty;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Dec 12 16:17:33 CST 2013
*/

public class AppPropertyManagerImpl extends CommonManagerImpl implements AppPropertyManager
{

    public AppPropertyManagerImpl()
    {
    }

    public AppPropertyDAO getGenericDAO()
    {
        return (AppPropertyDAO)super.getGenericDAO();
    }

    public void setGenericDAO(AppPropertyDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveAppProperty(AppProperty val)
    {
        getGenericDAO().saveAppProperty(val);
    }

    public void removeAppProperty(AppProperty val)
    {
        getGenericDAO().removeAppProperty(val);
    }

    public void removeAppProperty(Long id)
    {
        getGenericDAO().removeAppProperty(id);
    }

    public AppProperty getAppPropertyById(Long id)
    {
         return getGenericDAO().findAppPropertyById(id);
    }

    public List<AppProperty> getAppPropertyList()
    {
        return getGenericDAO().findAllAppProperty();
    }
}

