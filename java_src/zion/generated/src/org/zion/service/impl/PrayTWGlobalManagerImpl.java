package org.zion.service.impl;

import org.zion.service.PrayTWGlobalManager;
import org.zion.dao.PrayTWGlobalDAO;
import org.zion.value.PrayTWGlobal;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jan 07 15:37:44 CST 2015
*/

public class PrayTWGlobalManagerImpl extends CommonManagerImpl implements PrayTWGlobalManager
{

    public PrayTWGlobalManagerImpl()
    {
    }

    public PrayTWGlobalDAO getGenericDAO()
    {
        return (PrayTWGlobalDAO)super.getGenericDAO();
    }

    public void setGenericDAO(PrayTWGlobalDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void savePrayTWGlobal(PrayTWGlobal val)
    {
        getGenericDAO().savePrayTWGlobal(val);
    }

    public void removePrayTWGlobal(PrayTWGlobal val)
    {
        getGenericDAO().removePrayTWGlobal(val);
    }

    public void removePrayTWGlobal(Long id)
    {
        getGenericDAO().removePrayTWGlobal(id);
    }

    public PrayTWGlobal getPrayTWGlobalById(Long id)
    {
         return getGenericDAO().findPrayTWGlobalById(id);
    }

    public List<PrayTWGlobal> getPrayTWGlobalList()
    {
        return getGenericDAO().findAllPrayTWGlobal();
    }
}

