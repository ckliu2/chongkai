package org.zion.service;

import org.zion.value.PrayMe;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jan 07 15:37:44 CST 2015
*/

public interface PrayMeManager extends CommonManager 
{
    public abstract void savePrayMe(PrayMe val);

    public abstract void removePrayMe(PrayMe val);

    public abstract void removePrayMe(Long id);

    public abstract PrayMe getPrayMeById(Long id);

    public abstract List<PrayMe> getPrayMeList();
    public abstract List<Member> getMemberList();
}

