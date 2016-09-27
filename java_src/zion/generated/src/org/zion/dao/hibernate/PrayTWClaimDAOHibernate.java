package org.zion.dao.hibernate;

import org.zion.value.PrayTWClaim;
import org.zion.dao.PrayTWClaimDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jan 07 15:37:44 CST 2015
*/

public class PrayTWClaimDAOHibernate extends CommonDAOHibernate implements PrayTWClaimDAO
{

    public PrayTWClaimDAOHibernate()
    {
    }

    public void savePrayTWClaim(PrayTWClaim val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removePrayTWClaim(PrayTWClaim val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removePrayTWClaim(Long id)
    {
        PrayTWClaim obj = findPrayTWClaimById(id);
        getHibernateTemplate().delete(obj);
    }

    public PrayTWClaim findPrayTWClaimById(Long id)
    {
        if (id == null)
            return null;
        PrayTWClaim obj = (PrayTWClaim)getHibernateTemplate().get(org.zion.value.PrayTWClaim.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(org.zion.value.PrayTWClaim.class, id);
        else
            return obj;
    }

    public List<PrayTWClaim> findAllPrayTWClaim()
    {
        return getHibernateTemplate().find("from PrayTWClaim");
    }
    public List<PrayTW> findPraytwList()
    {
        return new ArrayList<PrayTW>(); // TODO
    }

    public List<Member> findMemberList()
    {
        return new ArrayList<Member>(); // TODO
    }

}

