package org.zion.service;

import org.zion.value.LivelyBible;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jan 07 15:37:44 CST 2015
*/

public interface LivelyBibleManager extends CommonManager 
{
    public abstract void saveLivelyBible(LivelyBible val);

    public abstract void removeLivelyBible(LivelyBible val);

    public abstract void removeLivelyBible(Long id);

    public abstract LivelyBible getLivelyBibleById(Long id);

    public abstract List<LivelyBible> getLivelyBibleList();
}

