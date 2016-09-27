package com.web.dao.hibernate;

import com.web.value.Bulletin;
import com.web.dao.BulletinDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu May 19 17:41:56 CST 2016
*/

public class BulletinDAOHibernate extends CommonDAOHibernate implements BulletinDAO
{

    public BulletinDAOHibernate()
    {
    }

    public void saveBulletin(Bulletin val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeBulletin(Bulletin val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeBulletin(Long id)
    {
        Bulletin obj = findBulletinById(id);
        getHibernateTemplate().delete(obj);
    }

    public Bulletin findBulletinById(Long id)
    {
        if (id == null)
            return null;
        Bulletin obj = (Bulletin)getHibernateTemplate().get(com.web.value.Bulletin.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(com.web.value.Bulletin.class, id);
        else
            return obj;
    }

    public List<Bulletin> findAllBulletin()
    {
        return getHibernateTemplate().find("from Bulletin");
    }
    public List<Member> findLastModifiedUserList()
    {
        return new ArrayList<Member>(); // TODO
    }

    public List<Member> findCreatedUserList()
    {
        return new ArrayList<Member>(); // TODO
    }

    public List<UploadedFile> findMyfileList()
    {
        return new ArrayList<UploadedFile>(); // TODO
    }

    public List<UploadedFile> findVoiceList()
    {
        return new ArrayList<UploadedFile>(); // TODO
    }

    public List<UploadedFile> findVedioList()
    {
        return new ArrayList<UploadedFile>(); // TODO
    }

    public List<UploadedFile> findFrontcoverList()
    {
        return new ArrayList<UploadedFile>(); // TODO
    }

}

