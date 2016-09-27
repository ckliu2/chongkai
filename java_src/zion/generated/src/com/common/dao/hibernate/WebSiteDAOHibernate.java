package com.common.dao.hibernate;

import com.common.value.WebSite;
import com.common.dao.WebSiteDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Dec 18 16:53:07 CST 2014
*/

public class WebSiteDAOHibernate extends CommonDAOHibernate implements WebSiteDAO
{

    public WebSiteDAOHibernate()
    {
    }

    public void saveWebSite(WebSite val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeWebSite(WebSite val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeWebSite(Long id)
    {
        WebSite obj = findWebSiteById(id);
        getHibernateTemplate().delete(obj);
    }

    public WebSite findWebSiteById(Long id)
    {
        if (id == null)
            return null;
        WebSite obj = (WebSite)getHibernateTemplate().get(com.common.value.WebSite.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(com.common.value.WebSite.class, id);
        else
            return obj;
    }

    public List<WebSite> findAllWebSite()
    {
        return getHibernateTemplate().find("from WebSite");
    }
}

