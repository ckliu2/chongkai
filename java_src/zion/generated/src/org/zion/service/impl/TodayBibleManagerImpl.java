package org.zion.service.impl;

import org.zion.service.TodayBibleManager;
import org.zion.dao.TodayBibleDAO;
import org.zion.value.TodayBible;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Tue Jan 06 17:19:58 CST 2015
*/

public class TodayBibleManagerImpl extends CommonManagerImpl implements TodayBibleManager
{

    public TodayBibleManagerImpl()
    {
    }

    public TodayBibleDAO getGenericDAO()
    {
        return (TodayBibleDAO)super.getGenericDAO();
    }

    public void setGenericDAO(TodayBibleDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveTodayBible(TodayBible val)
    {
        getGenericDAO().saveTodayBible(val);
    }

    public void removeTodayBible(TodayBible val)
    {
        getGenericDAO().removeTodayBible(val);
    }

    public void removeTodayBible(Long id)
    {
        getGenericDAO().removeTodayBible(id);
    }

    public TodayBible getTodayBibleById(Long id)
    {
         return getGenericDAO().findTodayBibleById(id);
    }

    public List<TodayBible> getTodayBibleList()
    {
        return getGenericDAO().findAllTodayBible();
    }
}

