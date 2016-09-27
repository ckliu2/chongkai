package com.base.dao.hibernate;

import com.base.value.AppProperty;
import com.base.dao.AppPropertyDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Dec 12 16:17:33 CST 2013
*/

public class AppPropertyDAOHibernate extends CommonDAOHibernate implements AppPropertyDAO
{

    public AppPropertyDAOHibernate()
    {
    }

    public void saveAppProperty(AppProperty val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeAppProperty(AppProperty val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeAppProperty(Long id)
    {
        AppProperty obj = findAppPropertyById(id);
        getHibernateTemplate().delete(obj);
    }

    public AppProperty findAppPropertyById(Long id)
    {
        if (id == null)
            return null;
        AppProperty obj = (AppProperty)getHibernateTemplate().get(com.base.value.AppProperty.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(com.base.value.AppProperty.class, id);
        else
            return obj;
    }

    public List<AppProperty> findAllAppProperty()
    {
        return getHibernateTemplate().find("from AppProperty");
    }
}

