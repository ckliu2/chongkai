package org.zion.dao;

import org.zion.value.PrayMe;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jan 07 15:37:44 CST 2015
*/

public interface PrayMeDAO extends CommonDAO 
{
    public abstract void savePrayMe(PrayMe val);

    public abstract void removePrayMe(PrayMe val);

    public abstract void removePrayMe(Long id);

    public abstract PrayMe findPrayMeById(Long id);

    public abstract List<PrayMe> findAllPrayMe();
    public abstract List<Member> findMemberList();
}

