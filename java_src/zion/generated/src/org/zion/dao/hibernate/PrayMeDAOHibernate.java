package org.zion.dao.hibernate;

import org.zion.value.PrayMe;
import org.zion.dao.PrayMeDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jan 07 15:37:44 CST 2015
*/

public class PrayMeDAOHibernate extends CommonDAOHibernate implements PrayMeDAO
{

    public PrayMeDAOHibernate()
    {
    }

    public void savePrayMe(PrayMe val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removePrayMe(PrayMe val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removePrayMe(Long id)
    {
        PrayMe obj = findPrayMeById(id);
        getHibernateTemplate().delete(obj);
    }

    public PrayMe findPrayMeById(Long id)
    {
        if (id == null)
            return null;
        PrayMe obj = (PrayMe)getHibernateTemplate().get(org.zion.value.PrayMe.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(org.zion.value.PrayMe.class, id);
        else
            return obj;
    }

    public List<PrayMe> findAllPrayMe()
    {
        return getHibernateTemplate().find("from PrayMe");
    }
    public List<Member> findMemberList()
    {
        return new ArrayList<Member>(); // TODO
    }

}

