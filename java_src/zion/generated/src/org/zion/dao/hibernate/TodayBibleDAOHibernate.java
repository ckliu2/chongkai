package org.zion.dao.hibernate;

import org.zion.value.TodayBible;
import org.zion.dao.TodayBibleDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Tue Jan 06 17:19:58 CST 2015
*/

public class TodayBibleDAOHibernate extends CommonDAOHibernate implements TodayBibleDAO
{

    public TodayBibleDAOHibernate()
    {
    }

    public void saveTodayBible(TodayBible val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeTodayBible(TodayBible val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeTodayBible(Long id)
    {
        TodayBible obj = findTodayBibleById(id);
        getHibernateTemplate().delete(obj);
    }

    public TodayBible findTodayBibleById(Long id)
    {
        if (id == null)
            return null;
        TodayBible obj = (TodayBible)getHibernateTemplate().get(org.zion.value.TodayBible.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(org.zion.value.TodayBible.class, id);
        else
            return obj;
    }

    public List<TodayBible> findAllTodayBible()
    {
        return getHibernateTemplate().find("from TodayBible");
    }
}

