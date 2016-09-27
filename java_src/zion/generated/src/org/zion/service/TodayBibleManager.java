package org.zion.service;

import org.zion.value.TodayBible;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Tue Jan 06 17:19:58 CST 2015
*/

public interface TodayBibleManager extends CommonManager 
{
    public abstract void saveTodayBible(TodayBible val);

    public abstract void removeTodayBible(TodayBible val);

    public abstract void removeTodayBible(Long id);

    public abstract TodayBible getTodayBibleById(Long id);

    public abstract List<TodayBible> getTodayBibleList();
}

