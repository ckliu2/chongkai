package org.zion.dao;

import org.zion.value.TodayBible;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Tue Jan 06 17:19:58 CST 2015
*/

public interface TodayBibleDAO extends CommonDAO 
{
    public abstract void saveTodayBible(TodayBible val);

    public abstract void removeTodayBible(TodayBible val);

    public abstract void removeTodayBible(Long id);

    public abstract TodayBible findTodayBibleById(Long id);

    public abstract List<TodayBible> findAllTodayBible();
}

