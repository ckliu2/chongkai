package org.zion.service.impl;

import org.zion.service.PrayMeManager;
import org.zion.dao.PrayMeDAO;
import org.zion.value.PrayMe;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jan 07 15:37:44 CST 2015
*/

public class PrayMeManagerImpl extends CommonManagerImpl implements PrayMeManager
{

    public PrayMeManagerImpl()
    {
    }

    public PrayMeDAO getGenericDAO()
    {
        return (PrayMeDAO)super.getGenericDAO();
    }

    public void setGenericDAO(PrayMeDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void savePrayMe(PrayMe val)
    {
        getGenericDAO().savePrayMe(val);
    }

    public void removePrayMe(PrayMe val)
    {
        getGenericDAO().removePrayMe(val);
    }

    public void removePrayMe(Long id)
    {
        getGenericDAO().removePrayMe(id);
    }

    public PrayMe getPrayMeById(Long id)
    {
         return getGenericDAO().findPrayMeById(id);
    }

    public List<PrayMe> getPrayMeList()
    {
        return getGenericDAO().findAllPrayMe();
    }
    public List<Member> getMemberList()
    {
        return getGenericDAO().findMemberList();
    }

}

