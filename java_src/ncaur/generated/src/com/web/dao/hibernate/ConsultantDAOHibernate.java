package com.web.dao.hibernate;

import com.web.value.Consultant;
import com.web.dao.ConsultantDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu May 19 17:41:56 CST 2016
*/

public class ConsultantDAOHibernate extends CommonDAOHibernate implements ConsultantDAO
{

    public ConsultantDAOHibernate()
    {
    }

    public void saveConsultant(Consultant val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeConsultant(Consultant val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeConsultant(Long id)
    {
        Consultant obj = findConsultantById(id);
        getHibernateTemplate().delete(obj);
    }

    public Consultant findConsultantById(Long id)
    {
        if (id == null)
            return null;
        Consultant obj = (Consultant)getHibernateTemplate().get(com.web.value.Consultant.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(com.web.value.Consultant.class, id);
        else
            return obj;
    }

    public List<Consultant> findAllConsultant()
    {
        return getHibernateTemplate().find("from Consultant");
    }
    public List<Member> findMemberList()
    {
        return new ArrayList<Member>(); // TODO
    }

}

