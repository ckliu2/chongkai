package org.zion.service.impl;

import org.zion.service.PrayStreetManager;
import org.zion.dao.PrayStreetDAO;
import org.zion.value.PrayStreet;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jan 07 15:37:44 CST 2015
*/

public class PrayStreetManagerImpl extends CommonManagerImpl implements PrayStreetManager
{

    public PrayStreetManagerImpl()
    {
    }

    public PrayStreetDAO getGenericDAO()
    {
        return (PrayStreetDAO)super.getGenericDAO();
    }

    public void setGenericDAO(PrayStreetDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void savePrayStreet(PrayStreet val)
    {
        getGenericDAO().savePrayStreet(val);
    }

    public void removePrayStreet(PrayStreet val)
    {
        getGenericDAO().removePrayStreet(val);
    }

    public void removePrayStreet(Long id)
    {
        getGenericDAO().removePrayStreet(id);
    }

    public PrayStreet getPrayStreetById(Long id)
    {
         return getGenericDAO().findPrayStreetById(id);
    }

    public List<PrayStreet> getPrayStreetList()
    {
        return getGenericDAO().findAllPrayStreet();
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

    public List<PrayTW> getPraytwList()
    {
        return getGenericDAO().findPraytwList();
    }

}

