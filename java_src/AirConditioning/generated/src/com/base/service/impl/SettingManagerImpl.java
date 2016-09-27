package com.base.service.impl;

import com.base.service.SettingManager;
import com.base.dao.SettingDAO;
import com.base.value.Setting;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Oct 17 16:59:08 CST 2013
*/

public class SettingManagerImpl extends CommonManagerImpl implements SettingManager
{

    public SettingManagerImpl()
    {
    }

    public SettingDAO getGenericDAO()
    {
        return (SettingDAO)super.getGenericDAO();
    }

    public void setGenericDAO(SettingDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveSetting(Setting val)
    {
        getGenericDAO().saveSetting(val);
    }

    public void removeSetting(Setting val)
    {
        getGenericDAO().removeSetting(val);
    }

    public void removeSetting(Long id)
    {
        getGenericDAO().removeSetting(id);
    }

    public Setting getSettingById(Long id)
    {
         return getGenericDAO().findSettingById(id);
    }

    public List<Setting> getSettingList()
    {
        return getGenericDAO().findAllSetting();
    }
}

