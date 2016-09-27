package com.web.dao.hibernate;

import com.web.value.CheckingState;
import com.web.dao.CheckingStateDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu May 19 17:41:56 CST 2016
*/

public class CheckingStateDAOHibernate extends CommonDAOHibernate implements CheckingStateDAO
{

    public CheckingStateDAOHibernate()
    {
    }

    public void saveCheckingState(CheckingState val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeCheckingState(CheckingState val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeCheckingState(Long id)
    {
        CheckingState obj = findCheckingStateById(id);
        getHibernateTemplate().delete(obj);
    }

    public CheckingState findCheckingStateById(Long id)
    {
        if (id == null)
            return null;
        CheckingState obj = (CheckingState)getHibernateTemplate().get(com.web.value.CheckingState.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(com.web.value.CheckingState.class, id);
        else
            return obj;
    }

    public List<CheckingState> findAllCheckingState()
    {
        return getHibernateTemplate().find("from CheckingState");
    }
    public List<Member> findCreatedUserList()
    {
        return new ArrayList<Member>(); // TODO
    }

}

