package com.web.dao.hibernate;

import com.web.value.PerRefer;
import com.web.dao.PerReferDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu May 19 17:41:56 CST 2016
*/

public class PerReferDAOHibernate extends CommonDAOHibernate implements PerReferDAO
{

    public PerReferDAOHibernate()
    {
    }

    public void savePerRefer(PerRefer val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removePerRefer(PerRefer val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removePerRefer(Long id)
    {
        PerRefer obj = findPerReferById(id);
        getHibernateTemplate().delete(obj);
    }

    public PerRefer findPerReferById(Long id)
    {
        if (id == null)
            return null;
        PerRefer obj = (PerRefer)getHibernateTemplate().get(com.web.value.PerRefer.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(com.web.value.PerRefer.class, id);
        else
            return obj;
    }

    public List<PerRefer> findAllPerRefer()
    {
        return getHibernateTemplate().find("from PerRefer");
    }
    public List<Member> findTeacherList()
    {
        return new ArrayList<Member>(); // TODO
    }

}

