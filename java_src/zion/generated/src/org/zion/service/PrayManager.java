package org.zion.service;

import org.zion.value.Pray;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jan 07 15:37:44 CST 2015
*/

public interface PrayManager extends CommonManager 
{
    public abstract void savePray(Pray val);

    public abstract void removePray(Pray val);

    public abstract void removePray(Long id);

    public abstract Pray getPrayById(Long id);

    public abstract List<Pray> getPrayList();
    public abstract List<Member> getLastModifiedUserList();
    public abstract List<Member> getCreatedUserList();
}

