package com.base.dao.hibernate;

import com.base.value.FunctionCategory;
import com.base.dao.FunctionCategoryDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Dec 12 16:17:33 CST 2013
*/

public class FunctionCategoryDAOHibernate extends CommonDAOHibernate implements FunctionCategoryDAO
{

    public FunctionCategoryDAOHibernate()
    {
    }

    public void saveFunctionCategory(FunctionCategory val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeFunctionCategory(FunctionCategory val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeFunctionCategory(Long id)
    {
        FunctionCategory obj = findFunctionCategoryById(id);
        getHibernateTemplate().delete(obj);
    }

    public FunctionCategory findFunctionCategoryById(Long id)
    {
        if (id == null)
            return null;
        FunctionCategory obj = (FunctionCategory)getHibernateTemplate().get(com.base.value.FunctionCategory.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(com.base.value.FunctionCategory.class, id);
        else
            return obj;
    }

    public List<FunctionCategory> findAllFunctionCategory()
    {
        return getHibernateTemplate().find("from FunctionCategory");
    }
}

