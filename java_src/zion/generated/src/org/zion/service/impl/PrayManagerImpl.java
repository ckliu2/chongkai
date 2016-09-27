package org.zion.service.impl;

import org.zion.service.PrayManager;
import org.zion.dao.PrayDAO;
import org.zion.value.Pray;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jan 07 15:37:44 CST 2015
*/

public class PrayManagerImpl extends CommonManagerImpl implements PrayManager
{

    public PrayManagerImpl()
    {
    }

    public PrayDAO getGenericDAO()
    {
        return (PrayDAO)super.getGenericDAO();
    }

    public void setGenericDAO(PrayDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void savePray(Pray val)
    {
        getGenericDAO().savePray(val);
    }

    public void removePray(Pray val)
    {
        getGenericDAO().removePray(val);
    }

    public void removePray(Long id)
    {
        getGenericDAO().removePray(id);
    }

    public Pray getPrayById(Long id)
    {
         return getGenericDAO().findPrayById(id);
    }

    public List<Pray> getPrayList()
    {
        return getGenericDAO().findAllPray();
    }
    public List<Member> getLastModifiedUserList()
    {
        return getGenericDAO().findLastModifiedUserList();
    }

    public List<Member> getCreatedUserList()
    {
        return getGenericDAO().findCreatedUserList();
    }

}

