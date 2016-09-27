package com.web.service;

import com.web.value.Clock;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu May 19 17:41:56 CST 2016
*/

public interface ClockManager extends CommonManager 
{
    public abstract void saveClock(Clock val);

    public abstract void removeClock(Clock val);

    public abstract void removeClock(Long id);

    public abstract Clock getClockById(Long id);

    public abstract List<Clock> getClockList();
    public abstract List<Member> getLastModifiedUserList();
    public abstract List<Member> getCreatedUserList();
}

