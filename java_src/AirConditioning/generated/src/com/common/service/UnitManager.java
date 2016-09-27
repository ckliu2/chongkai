package com.common.service;

import com.common.value.Unit;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Dec 12 16:17:33 CST 2013
*/

public interface UnitManager extends CommonManager 
{
    public abstract void saveUnit(Unit val);

    public abstract void removeUnit(Unit val);

    public abstract void removeUnit(Long id);

    public abstract Unit getUnitById(Long id);

    public abstract List<Unit> getUnitList();
}

