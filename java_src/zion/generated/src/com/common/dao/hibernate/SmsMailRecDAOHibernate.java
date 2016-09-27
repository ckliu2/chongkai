package com.common.dao.hibernate;

import com.common.value.SmsMailRec;
import com.common.dao.SmsMailRecDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Dec 18 16:53:07 CST 2014
*/

public class SmsMailRecDAOHibernate extends CommonDAOHibernate implements SmsMailRecDAO
{

    public SmsMailRecDAOHibernate()
    {
    }

    public void saveSmsMailRec(SmsMailRec val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeSmsMailRec(SmsMailRec val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeSmsMailRec(Long id)
    {
        SmsMailRec obj = findSmsMailRecById(id);
        getHibernateTemplate().delete(obj);
    }

    public SmsMailRec findSmsMailRecById(Long id)
    {
        if (id == null)
            return null;
        SmsMailRec obj = (SmsMailRec)getHibernateTemplate().get(com.common.value.SmsMailRec.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(com.common.value.SmsMailRec.class, id);
        else
            return obj;
    }

    public List<SmsMailRec> findAllSmsMailRec()
    {
        return getHibernateTemplate().find("from SmsMailRec");
    }
    public List<Member> findTargetList()
    {
        return new ArrayList<Member>(); // TODO
    }

    public List<Member> findMemberList()
    {
        return new ArrayList<Member>(); // TODO
    }

}

