package org.zion.dao;

import org.zion.value.PrayTWGlobal;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jan 07 15:37:44 CST 2015
*/

public interface PrayTWGlobalDAO extends CommonDAO 
{
    public abstract void savePrayTWGlobal(PrayTWGlobal val);

    public abstract void removePrayTWGlobal(PrayTWGlobal val);

    public abstract void removePrayTWGlobal(Long id);

    public abstract PrayTWGlobal findPrayTWGlobalById(Long id);

    public abstract List<PrayTWGlobal> findAllPrayTWGlobal();
}

