package com.web.service.impl;

import com.web.service.ClockManager;
import com.web.dao.ClockDAO;
import com.web.value.Clock;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu May 19 17:41:56 CST 2016
*/

public class ClockManagerImpl extends CommonManagerImpl implements ClockManager
{

    public ClockManagerImpl()
    {
    }

    public ClockDAO getGenericDAO()
    {
        return (ClockDAO)super.getGenericDAO();
    }

    public void setGenericDAO(ClockDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveClock(Clock val)
    {
        getGenericDAO().saveClock(val);
    }

    public void removeClock(Clock val)
    {
        getGenericDAO().removeClock(val);
    }

    public void removeClock(Long id)
    {
        getGenericDAO().removeClock(id);
    }

    public Clock getClockById(Long id)
    {
         return getGenericDAO().findClockById(id);
    }

    public List<Clock> getClockList()
    {
        return getGenericDAO().findAllClock();
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

