package com.web.dao.hibernate;

import com.web.value.BolgClass;
import com.web.dao.BolgClassDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jun 04 15:59:11 CST 2014
*/

public class BolgClassDAOHibernate extends CommonDAOHibernate implements BolgClassDAO
{

    public BolgClassDAOHibernate()
    {
    }

    public void saveBolgClass(BolgClass val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeBolgClass(BolgClass val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeBolgClass(Long id)
    {
        BolgClass obj = findBolgClassById(id);
        getHibernateTemplate().delete(obj);
    }

    public BolgClass findBolgClassById(Long id)
    {
        if (id == null)
            return null;
        BolgClass obj = (BolgClass)getHibernateTemplate().get(com.web.value.BolgClass.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(com.web.value.BolgClass.class, id);
        else
            return obj;
    }

    public List<BolgClass> findAllBolgClass()
    {
        return getHibernateTemplate().find("from BolgClass");
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

