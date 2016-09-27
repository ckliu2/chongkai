package org.zion.dao.hibernate;

import org.zion.value.PrayTW;
import org.zion.dao.PrayTWDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jan 07 15:37:44 CST 2015
*/

public class PrayTWDAOHibernate extends CommonDAOHibernate implements PrayTWDAO
{

    public PrayTWDAOHibernate()
    {
    }

    public void savePrayTW(PrayTW val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removePrayTW(PrayTW val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removePrayTW(Long id)
    {
        PrayTW obj = findPrayTWById(id);
        getHibernateTemplate().delete(obj);
    }

    public PrayTW findPrayTWById(Long id)
    {
        if (id == null)
            return null;
        PrayTW obj = (PrayTW)getHibernateTemplate().get(org.zion.value.PrayTW.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(org.zion.value.PrayTW.class, id);
        else
            return obj;
    }

    public List<PrayTW> findAllPrayTW()
    {
        return getHibernateTemplate().find("from PrayTW");
    }
    public List<UploadedFile> findMapList()
    {
        return new ArrayList<UploadedFile>(); // TODO
    }

    public List<UploadedFile> findPhoto1List()
    {
        return new ArrayList<UploadedFile>(); // TODO
    }

    public List<UploadedFile> findPhoto2List()
    {
        return new ArrayList<UploadedFile>(); // TODO
    }

    public List<UploadedFile> findPhoto3List()
    {
        return new ArrayList<UploadedFile>(); // TODO
    }

}

