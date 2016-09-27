package org.zion.dao.hibernate;

import org.zion.value.BibleLection;
import org.zion.dao.BibleLectionDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jan 07 15:37:44 CST 2015
*/

public class BibleLectionDAOHibernate extends CommonDAOHibernate implements BibleLectionDAO
{

    public BibleLectionDAOHibernate()
    {
    }

    public void saveBibleLection(BibleLection val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeBibleLection(BibleLection val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeBibleLection(Long id)
    {
        BibleLection obj = findBibleLectionById(id);
        getHibernateTemplate().delete(obj);
    }

    public BibleLection findBibleLectionById(Long id)
    {
        if (id == null)
            return null;
        BibleLection obj = (BibleLection)getHibernateTemplate().get(org.zion.value.BibleLection.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(org.zion.value.BibleLection.class, id);
        else
            return obj;
    }

    public List<BibleLection> findAllBibleLection()
    {
        return getHibernateTemplate().find("from BibleLection");
    }
}

