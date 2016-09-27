package org.zion.service;

import org.zion.value.EveryBible;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jan 07 15:37:44 CST 2015
*/

public interface EveryBibleManager extends CommonManager 
{
    public abstract void saveEveryBible(EveryBible val);

    public abstract void removeEveryBible(EveryBible val);

    public abstract void removeEveryBible(Long id);

    public abstract EveryBible getEveryBibleById(Long id);

    public abstract List<EveryBible> getEveryBibleList();
    public abstract List<Member> getMemberList();
}

