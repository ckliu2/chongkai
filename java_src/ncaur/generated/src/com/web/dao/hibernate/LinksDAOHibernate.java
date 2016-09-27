package com.web.dao.hibernate;

import com.web.value.Links;
import com.web.dao.LinksDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu May 19 17:41:56 CST 2016
*/

public class LinksDAOHibernate extends CommonDAOHibernate implements LinksDAO
{

    public LinksDAOHibernate()
    {
    }

    public void saveLinks(Links val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeLinks(Links val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeLinks(Long id)
    {
        Links obj = findLinksById(id);
        getHibernateTemplate().delete(obj);
    }

    public Links findLinksById(Long id)
    {
        if (id == null)
            return null;
        Links obj = (Links)getHibernateTemplate().get(com.web.value.Links.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(com.web.value.Links.class, id);
        else
            return obj;
    }

    public List<Links> findAllLinks()
    {
        return getHibernateTemplate().find("from Links");
    }
    public List<Member> findLastModifiedUserList()
    {
        return new ArrayList<Member>(); // TODO
    }

    public List<Member> findCreatedUserList()
    {
        return new ArrayList<Member>(); // TODO
    }

    public List<UploadedFile> findPhotoList()
    {
        return new ArrayList<UploadedFile>(); // TODO
    }

}

