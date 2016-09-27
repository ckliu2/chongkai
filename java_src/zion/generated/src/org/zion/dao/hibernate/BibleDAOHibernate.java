package org.zion.dao.hibernate;

import org.zion.value.Bible;
import org.zion.dao.BibleDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jan 07 15:37:44 CST 2015
*/

public class BibleDAOHibernate extends CommonDAOHibernate implements BibleDAO
{

    public BibleDAOHibernate()
    {
    }

    public void saveBible(Bible val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeBible(Bible val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeBible(Long id)
    {
        Bible obj = findBibleById(id);
        getHibernateTemplate().delete(obj);
    }

    public Bible findBibleById(Long id)
    {
        if (id == null)
            return null;
        Bible obj = (Bible)getHibernateTemplate().get(org.zion.value.Bible.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(org.zion.value.Bible.class, id);
        else
            return obj;
    }

    public List<Bible> findAllBible()
    {
        return getHibernateTemplate().find("from Bible");
    }
}

