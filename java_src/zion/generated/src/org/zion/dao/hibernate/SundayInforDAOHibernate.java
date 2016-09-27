package org.zion.dao.hibernate;

import org.zion.value.SundayInfor;
import org.zion.dao.SundayInforDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jan 07 15:37:44 CST 2015
*/

public class SundayInforDAOHibernate extends CommonDAOHibernate implements SundayInforDAO
{

    public SundayInforDAOHibernate()
    {
    }

    public void saveSundayInfor(SundayInfor val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeSundayInfor(SundayInfor val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeSundayInfor(Long id)
    {
        SundayInfor obj = findSundayInforById(id);
        getHibernateTemplate().delete(obj);
    }

    public SundayInfor findSundayInforById(Long id)
    {
        if (id == null)
            return null;
        SundayInfor obj = (SundayInfor)getHibernateTemplate().get(org.zion.value.SundayInfor.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(org.zion.value.SundayInfor.class, id);
        else
            return obj;
    }

    public List<SundayInfor> findAllSundayInfor()
    {
        return getHibernateTemplate().find("from SundayInfor");
    }
}

