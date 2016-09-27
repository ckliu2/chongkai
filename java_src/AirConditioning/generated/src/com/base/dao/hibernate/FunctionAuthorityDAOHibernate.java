package com.base.dao.hibernate;

import com.base.value.FunctionAuthority;
import com.base.dao.FunctionAuthorityDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Dec 12 16:17:33 CST 2013
*/

public class FunctionAuthorityDAOHibernate extends CommonDAOHibernate implements FunctionAuthorityDAO
{

    public FunctionAuthorityDAOHibernate()
    {
    }

    public void saveFunctionAuthority(FunctionAuthority val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeFunctionAuthority(FunctionAuthority val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeFunctionAuthority(Long id)
    {
        FunctionAuthority obj = findFunctionAuthorityById(id);
        getHibernateTemplate().delete(obj);
    }

    public FunctionAuthority findFunctionAuthorityById(Long id)
    {
        if (id == null)
            return null;
        FunctionAuthority obj = (FunctionAuthority)getHibernateTemplate().get(com.base.value.FunctionAuthority.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(com.base.value.FunctionAuthority.class, id);
        else
            return obj;
    }

    public List<FunctionAuthority> findAllFunctionAuthority()
    {
        return getHibernateTemplate().find("from FunctionAuthority");
    }
    public List<Group> findGroupList()
    {
        return new ArrayList<Group>(); // TODO
    }

}

