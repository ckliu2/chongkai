package com.base.service.impl;

import com.base.service.UploadedFileManager;
import com.base.dao.UploadedFileDAO;
import com.base.value.UploadedFile;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Dec 18 16:53:07 CST 2014
*/

public class UploadedFileManagerImpl extends CommonManagerImpl implements UploadedFileManager
{

    public UploadedFileManagerImpl()
    {
    }

    public UploadedFileDAO getGenericDAO()
    {
        return (UploadedFileDAO)super.getGenericDAO();
    }

    public void setGenericDAO(UploadedFileDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveUploadedFile(UploadedFile val)
    {
        getGenericDAO().saveUploadedFile(val);
    }

    public void removeUploadedFile(UploadedFile val)
    {
        getGenericDAO().removeUploadedFile(val);
    }

    public void removeUploadedFile(Long id)
    {
        getGenericDAO().removeUploadedFile(id);
    }

    public UploadedFile getUploadedFileById(Long id)
    {
         return getGenericDAO().findUploadedFileById(id);
    }

    public List<UploadedFile> getUploadedFileList()
    {
        return getGenericDAO().findAllUploadedFile();
    }
}

