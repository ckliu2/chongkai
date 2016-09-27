package org.zion.dao;

import org.zion.value.PrayYou;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jan 07 15:37:44 CST 2015
*/

public interface PrayYouDAO extends CommonDAO 
{
    public abstract void savePrayYou(PrayYou val);

    public abstract void removePrayYou(PrayYou val);

    public abstract void removePrayYou(Long id);

    public abstract PrayYou findPrayYouById(Long id);

    public abstract List<PrayYou> findAllPrayYou();
    public abstract List<PrayMe> findPraymeList();
    public abstract List<Member> findMemberList();
}

