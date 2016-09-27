package org.zion.dao.hibernate;

import org.zion.value.PrayStreet;
import org.zion.dao.PrayStreetDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jan 07 15:37:44 CST 2015
*/

public class PrayStreetDAOHibernate extends CommonDAOHibernate implements PrayStreetDAO
{

    public PrayStreetDAOHibernate()
    {
    }

    public void savePrayStreet(PrayStreet val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removePrayStreet(PrayStreet val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removePrayStreet(Long id)
    {
        PrayStreet obj = findPrayStreetById(id);
        getHibernateTemplate().delete(obj);
    }

    public PrayStreet findPrayStreetById(Long id)
    {
        if (id == null)
            return null;
        PrayStreet obj = (PrayStreet)getHibernateTemplate().get(org.zion.value.PrayStreet.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(org.zion.value.PrayStreet.class, id);
        else
            return obj;
    }

    public List<PrayStreet> findAllPrayStreet()
    {
        return getHibernateTemplate().find("from PrayStreet");
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

    public List<PrayTW> findPraytwList()
    {
        return new ArrayList<PrayTW>(); // TODO
    }

}

