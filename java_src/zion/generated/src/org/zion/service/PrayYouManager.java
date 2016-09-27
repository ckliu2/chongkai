package org.zion.service;

import org.zion.value.PrayYou;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jan 07 15:37:44 CST 2015
*/

public interface PrayYouManager extends CommonManager 
{
    public abstract void savePrayYou(PrayYou val);

    public abstract void removePrayYou(PrayYou val);

    public abstract void removePrayYou(Long id);

    public abstract PrayYou getPrayYouById(Long id);

    public abstract List<PrayYou> getPrayYouList();
    public abstract List<PrayMe> getPraymeList();
    public abstract List<Member> getMemberList();
}

