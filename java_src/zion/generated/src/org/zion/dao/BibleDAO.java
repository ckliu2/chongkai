package org.zion.dao;

import org.zion.value.Bible;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jan 07 15:37:44 CST 2015
*/

public interface BibleDAO extends CommonDAO 
{
    public abstract void saveBible(Bible val);

    public abstract void removeBible(Bible val);

    public abstract void removeBible(Long id);

    public abstract Bible findBibleById(Long id);

    public abstract List<Bible> findAllBible();
}

