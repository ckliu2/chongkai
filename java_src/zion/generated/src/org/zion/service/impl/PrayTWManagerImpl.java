package org.zion.service.impl;

import org.zion.service.PrayTWManager;
import org.zion.dao.PrayTWDAO;
import org.zion.value.PrayTW;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jan 07 15:37:44 CST 2015
*/

public class PrayTWManagerImpl extends CommonManagerImpl implements PrayTWManager
{

    public PrayTWManagerImpl()
    {
    }

    public PrayTWDAO getGenericDAO()
    {
        return (PrayTWDAO)super.getGenericDAO();
    }

    public void setGenericDAO(PrayTWDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void savePrayTW(PrayTW val)
    {
        getGenericDAO().savePrayTW(val);
    }

    public void removePrayTW(PrayTW val)
    {
        getGenericDAO().removePrayTW(val);
    }

    public void removePrayTW(Long id)
    {
        getGenericDAO().removePrayTW(id);
    }

    public PrayTW getPrayTWById(Long id)
    {
         return getGenericDAO().findPrayTWById(id);
    }

    public List<PrayTW> getPrayTWList()
    {
        return getGenericDAO().findAllPrayTW();
    }
    public List<UploadedFile> getMapList()
    {
        return getGenericDAO().findMapList();
    }

    public List<UploadedFile> getPhoto1List()
    {
        return getGenericDAO().findPhoto1List();
    }

    public List<UploadedFile> getPhoto2List()
    {
        return getGenericDAO().findPhoto2List();
    }

    public List<UploadedFile> getPhoto3List()
    {
        return getGenericDAO().findPhoto3List();
    }

}

