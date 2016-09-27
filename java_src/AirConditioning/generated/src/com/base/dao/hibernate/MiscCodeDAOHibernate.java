package com.base.dao.hibernate;

import com.base.value.MiscCode;
import com.base.dao.MiscCodeDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Dec 12 16:17:33 CST 2013
*/

public class MiscCodeDAOHibernate extends CommonDAOHibernate implements MiscCodeDAO
{

    public MiscCodeDAOHibernate()
    {
    }

    public void saveMiscCode(MiscCode val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeMiscCode(MiscCode val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeMiscCode(Long id)
    {
        MiscCode obj = findMiscCodeById(id);
        getHibernateTemplate().delete(obj);
    }

    public MiscCode findMiscCodeById(Long id)
    {
        if (id == null)
            return null;
        MiscCode obj = (MiscCode)getHibernateTemplate().get(com.base.value.MiscCode.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(com.base.value.MiscCode.class, id);
        else
            return obj;
    }

    public List<MiscCode> findAllMiscCode()
    {
        return getHibernateTemplate().find("from MiscCode");
    }
}

