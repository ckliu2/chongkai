package org.zion.dao.hibernate;

import org.zion.value.PrayTWGlobal;
import org.zion.dao.PrayTWGlobalDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jan 07 15:37:44 CST 2015
*/

public class PrayTWGlobalDAOHibernate extends CommonDAOHibernate implements PrayTWGlobalDAO
{

    public PrayTWGlobalDAOHibernate()
    {
    }

    public void savePrayTWGlobal(PrayTWGlobal val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removePrayTWGlobal(PrayTWGlobal val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removePrayTWGlobal(Long id)
    {
        PrayTWGlobal obj = findPrayTWGlobalById(id);
        getHibernateTemplate().delete(obj);
    }

    public PrayTWGlobal findPrayTWGlobalById(Long id)
    {
        if (id == null)
            return null;
        PrayTWGlobal obj = (PrayTWGlobal)getHibernateTemplate().get(org.zion.value.PrayTWGlobal.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(org.zion.value.PrayTWGlobal.class, id);
        else
            return obj;
    }

    public List<PrayTWGlobal> findAllPrayTWGlobal()
    {
        return getHibernateTemplate().find("from PrayTWGlobal");
    }
}

