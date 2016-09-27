package com.web.dao.hibernate;

import com.web.value.Clock;
import com.web.dao.ClockDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu May 19 17:41:56 CST 2016
*/

public class ClockDAOHibernate extends CommonDAOHibernate implements ClockDAO
{

    public ClockDAOHibernate()
    {
    }

    public void saveClock(Clock val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeClock(Clock val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeClock(Long id)
    {
        Clock obj = findClockById(id);
        getHibernateTemplate().delete(obj);
    }

    public Clock findClockById(Long id)
    {
        if (id == null)
            return null;
        Clock obj = (Clock)getHibernateTemplate().get(com.web.value.Clock.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(com.web.value.Clock.class, id);
        else
            return obj;
    }

    public List<Clock> findAllClock()
    {
        return getHibernateTemplate().find("from Clock");
    }
    public List<Member> findLastModifiedUserList()
    {
        return new ArrayList<Member>(); // TODO
    }

    public List<Member> findCreatedUserList()
    {
        return new ArrayList<Member>(); // TODO
    }

}

