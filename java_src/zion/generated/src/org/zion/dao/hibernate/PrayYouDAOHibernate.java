package org.zion.dao.hibernate;

import org.zion.value.PrayYou;
import org.zion.dao.PrayYouDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jan 07 15:37:44 CST 2015
*/

public class PrayYouDAOHibernate extends CommonDAOHibernate implements PrayYouDAO
{

    public PrayYouDAOHibernate()
    {
    }

    public void savePrayYou(PrayYou val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removePrayYou(PrayYou val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removePrayYou(Long id)
    {
        PrayYou obj = findPrayYouById(id);
        getHibernateTemplate().delete(obj);
    }

    public PrayYou findPrayYouById(Long id)
    {
        if (id == null)
            return null;
        PrayYou obj = (PrayYou)getHibernateTemplate().get(org.zion.value.PrayYou.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(org.zion.value.PrayYou.class, id);
        else
            return obj;
    }

    public List<PrayYou> findAllPrayYou()
    {
        return getHibernateTemplate().find("from PrayYou");
    }
    public List<PrayMe> findPraymeList()
    {
        return new ArrayList<PrayMe>(); // TODO
    }

    public List<Member> findMemberList()
    {
        return new ArrayList<Member>(); // TODO
    }

}

