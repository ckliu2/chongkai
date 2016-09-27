package com.base.dao.hibernate;

import com.base.value.UploadedFile;
import com.base.dao.UploadedFileDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Dec 18 16:53:07 CST 2014
*/

public class UploadedFileDAOHibernate extends CommonDAOHibernate implements UploadedFileDAO
{

    public UploadedFileDAOHibernate()
    {
    }

    public void saveUploadedFile(UploadedFile val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeUploadedFile(UploadedFile val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeUploadedFile(Long id)
    {
        UploadedFile obj = findUploadedFileById(id);
        getHibernateTemplate().delete(obj);
    }

    public UploadedFile findUploadedFileById(Long id)
    {
        if (id == null)
            return null;
        UploadedFile obj = (UploadedFile)getHibernateTemplate().get(com.base.value.UploadedFile.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(com.base.value.UploadedFile.class, id);
        else
            return obj;
    }

    public List<UploadedFile> findAllUploadedFile()
    {
        return getHibernateTemplate().find("from UploadedFile");
    }
}

