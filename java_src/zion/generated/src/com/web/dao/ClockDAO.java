package com.web.dao;

import com.web.value.Clock;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jun 04 15:59:11 CST 2014
*/

public interface ClockDAO extends CommonDAO 
{
    public abstract void saveClock(Clock val);

    public abstract void removeClock(Clock val);

    public abstract void removeClock(Long id);

    public abstract Clock findClockById(Long id);

    public abstract List<Clock> findAllClock();
    public abstract List<Member> findLastModifiedUserList();
    public abstract List<Member> findCreatedUserList();
}

