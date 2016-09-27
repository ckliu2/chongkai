package org.zion.dao.hibernate;

import org.zion.value.EveryBible;
import org.zion.dao.EveryBibleDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jan 07 15:37:44 CST 2015
*/

public class EveryBibleDAOHibernate extends CommonDAOHibernate implements EveryBibleDAO
{

    public EveryBibleDAOHibernate()
    {
    }

    public void saveEveryBible(EveryBible val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeEveryBible(EveryBible val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeEveryBible(Long id)
    {
        EveryBible obj = findEveryBibleById(id);
        getHibernateTemplate().delete(obj);
    }

    public EveryBible findEveryBibleById(Long id)
    {
        if (id == null)
            return null;
        EveryBible obj = (EveryBible)getHibernateTemplate().get(org.zion.value.EveryBible.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(org.zion.value.EveryBible.class, id);
        else
            return obj;
    }

    public List<EveryBible> findAllEveryBible()
    {
        return getHibernateTemplate().find("from EveryBible");
    }
    public List<Member> findMemberList()
    {
        return new ArrayList<Member>(); // TODO
    }

}

