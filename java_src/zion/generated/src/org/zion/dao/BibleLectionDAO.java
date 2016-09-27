package org.zion.dao;

import org.zion.value.BibleLection;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jan 07 15:37:44 CST 2015
*/

public interface BibleLectionDAO extends CommonDAO 
{
    public abstract void saveBibleLection(BibleLection val);

    public abstract void removeBibleLection(BibleLection val);

    public abstract void removeBibleLection(Long id);

    public abstract BibleLection findBibleLectionById(Long id);

    public abstract List<BibleLection> findAllBibleLection();
}

