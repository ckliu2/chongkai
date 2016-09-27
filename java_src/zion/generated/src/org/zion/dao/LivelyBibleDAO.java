package org.zion.dao;

import org.zion.value.LivelyBible;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jan 07 15:37:44 CST 2015
*/

public interface LivelyBibleDAO extends CommonDAO 
{
    public abstract void saveLivelyBible(LivelyBible val);

    public abstract void removeLivelyBible(LivelyBible val);

    public abstract void removeLivelyBible(Long id);

    public abstract LivelyBible findLivelyBibleById(Long id);

    public abstract List<LivelyBible> findAllLivelyBible();
}

