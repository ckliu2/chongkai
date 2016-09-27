package com.base.dao.hibernate;

import com.base.value.Function;
import com.base.dao.FunctionDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Dec 12 16:17:33 CST 2013
*/

public class FunctionDAOHibernate extends CommonDAOHibernate implements FunctionDAO
{

    public FunctionDAOHibernate()
    {
    }

    public void saveFunction(Function val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeFunction(Function val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeFunction(Long id)
    {
        Function obj = findFunctionById(id);
        getHibernateTemplate().delete(obj);
    }

    public Function findFunctionById(Long id)
    {
        if (id == null)
            return null;
        Function obj = (Function)getHibernateTemplate().get(com.base.value.Function.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(com.base.value.Function.class, id);
        else
            return obj;
    }

    public List<Function> findAllFunction()
    {
        return getHibernateTemplate().find("from Function");
    }
    public List<FunctionCategory> findCategoryList()
    {
        return new ArrayList<FunctionCategory>(); // TODO
    }

}

