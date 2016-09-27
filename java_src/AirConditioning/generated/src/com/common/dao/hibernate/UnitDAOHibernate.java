package com.common.dao.hibernate;

import com.common.value.Unit;
import com.common.dao.UnitDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Dec 12 16:17:33 CST 2013
*/

public class UnitDAOHibernate extends CommonDAOHibernate implements UnitDAO
{

    public UnitDAOHibernate()
    {
    }

    public void saveUnit(Unit val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeUnit(Unit val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeUnit(Long id)
    {
        Unit obj = findUnitById(id);
        getHibernateTemplate().delete(obj);
    }

    public Unit findUnitById(Long id)
    {
        if (id == null)
            return null;
        Unit obj = (Unit)getHibernateTemplate().get(com.common.value.Unit.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(com.common.value.Unit.class, id);
        else
            return obj;
    }

    public List<Unit> findAllUnit()
    {
        return getHibernateTemplate().find("from Unit");
    }
}

