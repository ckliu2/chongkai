package org.zion.dao.hibernate;

import org.zion.value.Pray;
import org.zion.dao.PrayDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jan 07 15:37:44 CST 2015
*/

public class PrayDAOHibernate extends CommonDAOHibernate implements PrayDAO
{

    public PrayDAOHibernate()
    {
    }

    public void savePray(Pray val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removePray(Pray val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removePray(Long id)
    {
        Pray obj = findPrayById(id);
        getHibernateTemplate().delete(obj);
    }

    public Pray findPrayById(Long id)
    {
        if (id == null)
            return null;
        Pray obj = (Pray)getHibernateTemplate().get(org.zion.value.Pray.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(org.zion.value.Pray.class, id);
        else
            return obj;
    }

    public List<Pray> findAllPray()
    {
        return getHibernateTemplate().find("from Pray");
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

