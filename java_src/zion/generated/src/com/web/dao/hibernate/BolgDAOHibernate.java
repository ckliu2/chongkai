package com.web.dao.hibernate;

import com.web.value.Bolg;
import com.web.dao.BolgDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jun 04 15:59:11 CST 2014
*/

public class BolgDAOHibernate extends CommonDAOHibernate implements BolgDAO
{

    public BolgDAOHibernate()
    {
    }

    public void saveBolg(Bolg val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeBolg(Bolg val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeBolg(Long id)
    {
        Bolg obj = findBolgById(id);
        getHibernateTemplate().delete(obj);
    }

    public Bolg findBolgById(Long id)
    {
        if (id == null)
            return null;
        Bolg obj = (Bolg)getHibernateTemplate().get(com.web.value.Bolg.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(com.web.value.Bolg.class, id);
        else
            return obj;
    }

    public List<Bolg> findAllBolg()
    {
        return getHibernateTemplate().find("from Bolg");
    }
    public List<Member> findLastModifiedUserList()
    {
        return new ArrayList<Member>(); // TODO
    }

    public List<Member> findCreatedUserList()
    {
        return new ArrayList<Member>(); // TODO
    }

    public List<UploadedFile> findFileList()
    {
        return new ArrayList<UploadedFile>(); // TODO
    }

    public List<UploadedFile> findPhotoList()
    {
        return new ArrayList<UploadedFile>(); // TODO
    }

    public List<BolgClass> findBolgClassList()
    {
        return new ArrayList<BolgClass>(); // TODO
    }

}

