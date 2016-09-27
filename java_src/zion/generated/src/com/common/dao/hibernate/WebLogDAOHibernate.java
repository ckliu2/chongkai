package com.common.dao.hibernate;

import com.common.value.WebLog;
import com.common.dao.WebLogDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Dec 18 16:53:07 CST 2014
*/

public class WebLogDAOHibernate extends CommonDAOHibernate implements WebLogDAO
{

    public WebLogDAOHibernate()
    {
    }

    public void saveWebLog(WebLog val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeWebLog(WebLog val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeWebLog(Long id)
    {
        WebLog obj = findWebLogById(id);
        getHibernateTemplate().delete(obj);
    }

    public WebLog findWebLogById(Long id)
    {
        if (id == null)
            return null;
        WebLog obj = (WebLog)getHibernateTemplate().get(com.common.value.WebLog.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(com.common.value.WebLog.class, id);
        else
            return obj;
    }

    public List<WebLog> findAllWebLog()
    {
        return getHibernateTemplate().find("from WebLog");
    }
}

