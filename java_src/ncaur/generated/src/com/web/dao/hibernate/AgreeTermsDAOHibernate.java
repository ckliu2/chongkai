package com.web.dao.hibernate;

import com.web.value.AgreeTerms;
import com.web.dao.AgreeTermsDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu May 19 17:41:56 CST 2016
*/

public class AgreeTermsDAOHibernate extends CommonDAOHibernate implements AgreeTermsDAO
{

    public AgreeTermsDAOHibernate()
    {
    }

    public void saveAgreeTerms(AgreeTerms val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeAgreeTerms(AgreeTerms val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeAgreeTerms(Long id)
    {
        AgreeTerms obj = findAgreeTermsById(id);
        getHibernateTemplate().delete(obj);
    }

    public AgreeTerms findAgreeTermsById(Long id)
    {
        if (id == null)
            return null;
        AgreeTerms obj = (AgreeTerms)getHibernateTemplate().get(com.web.value.AgreeTerms.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(com.web.value.AgreeTerms.class, id);
        else
            return obj;
    }

    public List<AgreeTerms> findAllAgreeTerms()
    {
        return getHibernateTemplate().find("from AgreeTerms");
    }
    public List<Member> findCreatedUserList()
    {
        return new ArrayList<Member>(); // TODO
    }

}

