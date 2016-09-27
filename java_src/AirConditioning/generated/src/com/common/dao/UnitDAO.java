package com.common.dao;

import com.common.value.Unit;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Dec 12 16:17:33 CST 2013
*/

public interface UnitDAO extends CommonDAO 
{
    public abstract void saveUnit(Unit val);

    public abstract void removeUnit(Unit val);

    public abstract void removeUnit(Long id);

    public abstract Unit findUnitById(Long id);

    public abstract List<Unit> findAllUnit();
}

