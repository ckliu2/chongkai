package org.zion.dao.hibernate;

import org.zion.value.LivelyBible;
import org.zion.dao.LivelyBibleDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jan 07 15:37:44 CST 2015
*/

public class LivelyBibleDAOHibernate extends CommonDAOHibernate implements LivelyBibleDAO
{

    public LivelyBibleDAOHibernate()
    {
    }

    public void saveLivelyBible(LivelyBible val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeLivelyBible(LivelyBible val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeLivelyBible(Long id)
    {
        LivelyBible obj = findLivelyBibleById(id);
        getHibernateTemplate().delete(obj);
    }

    public LivelyBible findLivelyBibleById(Long id)
    {
        if (id == null)
            return null;
        LivelyBible obj = (LivelyBible)getHibernateTemplate().get(org.zion.value.LivelyBible.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(org.zion.value.LivelyBible.class, id);
        else
            return obj;
    }

    public List<LivelyBible> findAllLivelyBible()
    {
        return getHibernateTemplate().find("from LivelyBible");
    }
}

