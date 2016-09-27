package com.web.service.impl;

import com.web.service.BolgManager;
import com.web.dao.BolgDAO;
import com.web.value.Bolg;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jun 04 15:59:11 CST 2014
*/

public class BolgManagerImpl extends CommonManagerImpl implements BolgManager
{

    public BolgManagerImpl()
    {
    }

    public BolgDAO getGenericDAO()
    {
        return (BolgDAO)super.getGenericDAO();
    }

    public void setGenericDAO(BolgDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveBolg(Bolg val)
    {
        getGenericDAO().saveBolg(val);
    }

    public void removeBolg(Bolg val)
    {
        getGenericDAO().removeBolg(val);
    }

    public void removeBolg(Long id)
    {
        getGenericDAO().removeBolg(id);
    }

    public Bolg getBolgById(Long id)
    {
         return getGenericDAO().findBolgById(id);
    }

    public List<Bolg> getBolgList()
    {
        return getGenericDAO().findAllBolg();
    }
    public List<Member> getLastModifiedUserList()
    {
        return getGenericDAO().findLastModifiedUserList();
    }

    public List<Member> getCreatedUserList()
    {
        return getGenericDAO().findCreatedUserList();
    }

    public List<UploadedFile> getFileList()
    {
        return getGenericDAO().findFileList();
    }

    public List<UploadedFile> getPhotoList()
    {
        return getGenericDAO().findPhotoList();
    }

    public List<BolgClass> getBolgClassList()
    {
        return getGenericDAO().findBolgClassList();
    }

}

