package org.zion.service.impl;

import org.zion.service.PrayYouManager;
import org.zion.dao.PrayYouDAO;
import org.zion.value.PrayYou;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jan 07 15:37:44 CST 2015
*/

public class PrayYouManagerImpl extends CommonManagerImpl implements PrayYouManager
{

    public PrayYouManagerImpl()
    {
    }

    public PrayYouDAO getGenericDAO()
    {
        return (PrayYouDAO)super.getGenericDAO();
    }

    public void setGenericDAO(PrayYouDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void savePrayYou(PrayYou val)
    {
        getGenericDAO().savePrayYou(val);
    }

    public void removePrayYou(PrayYou val)
    {
        getGenericDAO().removePrayYou(val);
    }

    public void removePrayYou(Long id)
    {
        getGenericDAO().removePrayYou(id);
    }

    public PrayYou getPrayYouById(Long id)
    {
         return getGenericDAO().findPrayYouById(id);
    }

    public List<PrayYou> getPrayYouList()
    {
        return getGenericDAO().findAllPrayYou();
    }
    public List<PrayMe> getPraymeList()
    {
        return getGenericDAO().findPraymeList();
    }

    public List<Member> getMemberList()
    {
        return getGenericDAO().findMemberList();
    }

}

