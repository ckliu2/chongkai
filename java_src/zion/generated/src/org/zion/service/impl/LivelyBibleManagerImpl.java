package org.zion.service.impl;

import org.zion.service.LivelyBibleManager;
import org.zion.dao.LivelyBibleDAO;
import org.zion.value.LivelyBible;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jan 07 15:37:44 CST 2015
*/

public class LivelyBibleManagerImpl extends CommonManagerImpl implements LivelyBibleManager
{

    public LivelyBibleManagerImpl()
    {
    }

    public LivelyBibleDAO getGenericDAO()
    {
        return (LivelyBibleDAO)super.getGenericDAO();
    }

    public void setGenericDAO(LivelyBibleDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveLivelyBible(LivelyBible val)
    {
        getGenericDAO().saveLivelyBible(val);
    }

    public void removeLivelyBible(LivelyBible val)
    {
        getGenericDAO().removeLivelyBible(val);
    }

    public void removeLivelyBible(Long id)
    {
        getGenericDAO().removeLivelyBible(id);
    }

    public LivelyBible getLivelyBibleById(Long id)
    {
         return getGenericDAO().findLivelyBibleById(id);
    }

    public List<LivelyBible> getLivelyBibleList()
    {
        return getGenericDAO().findAllLivelyBible();
    }
}

