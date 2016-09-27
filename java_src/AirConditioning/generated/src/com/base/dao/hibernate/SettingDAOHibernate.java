package com.base.dao.hibernate;

import com.base.value.Setting;
import com.base.dao.SettingDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Oct 17 16:59:08 CST 2013
*/

public class SettingDAOHibernate extends CommonDAOHibernate implements SettingDAO
{

    public SettingDAOHibernate()
    {
    }

    public void saveSetting(Setting val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeSetting(Setting val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeSetting(Long id)
    {
        Setting obj = findSettingById(id);
        getHibernateTemplate().delete(obj);
    }

    public Setting findSettingById(Long id)
    {
        if (id == null)
            return null;
        Setting obj = (Setting)getHibernateTemplate().get(com.base.value.Setting.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(com.base.value.Setting.class, id);
        else
            return obj;
    }

    public List<Setting> findAllSetting()
    {
        return getHibernateTemplate().find("from Setting");
    }
}

