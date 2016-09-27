package com.web.service.impl;

import com.web.service.BulletinManager;
import com.web.dao.BulletinDAO;
import com.web.value.Bulletin;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu May 19 17:41:56 CST 2016
*/

public class BulletinManagerImpl extends CommonManagerImpl implements BulletinManager
{

    public BulletinManagerImpl()
    {
    }

    public BulletinDAO getGenericDAO()
    {
        return (BulletinDAO)super.getGenericDAO();
    }

    public void setGenericDAO(BulletinDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveBulletin(Bulletin val)
    {
        getGenericDAO().saveBulletin(val);
    }

    public void removeBulletin(Bulletin val)
    {
        getGenericDAO().removeBulletin(val);
    }

    public void removeBulletin(Long id)
    {
        getGenericDAO().removeBulletin(id);
    }

    public Bulletin getBulletinById(Long id)
    {
         return getGenericDAO().findBulletinById(id);
    }

    public List<Bulletin> getBulletinList()
    {
        return getGenericDAO().findAllBulletin();
    }
    public List<Member> getLastModifiedUserList()
    {
        return getGenericDAO().findLastModifiedUserList();
    }

    public List<Member> getCreatedUserList()
    {
        return getGenericDAO().findCreatedUserList();
    }

    public List<UploadedFile> getMyfileList()
    {
        return getGenericDAO().findMyfileList();
    }

    public List<UploadedFile> getVoiceList()
    {
        return getGenericDAO().findVoiceList();
    }

    public List<UploadedFile> getVedioList()
    {
        return getGenericDAO().findVedioList();
    }

    public List<UploadedFile> getFrontcoverList()
    {
        return getGenericDAO().findFrontcoverList();
    }

}

