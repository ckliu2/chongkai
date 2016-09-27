package com.common.service.impl;

import com.common.service.UnitManager;
import com.common.dao.UnitDAO;
import com.common.value.Unit;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Dec 12 16:17:33 CST 2013
*/

public class UnitManagerImpl extends CommonManagerImpl implements UnitManager
{

    public UnitManagerImpl()
    {
    }

    public UnitDAO getGenericDAO()
    {
        return (UnitDAO)super.getGenericDAO();
    }

    public void setGenericDAO(UnitDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveUnit(Unit val)
    {
        getGenericDAO().saveUnit(val);
    }

    public void removeUnit(Unit val)
    {
        getGenericDAO().removeUnit(val);
    }

    public void removeUnit(Long id)
    {
        getGenericDAO().removeUnit(id);
    }

    public Unit getUnitById(Long id)
    {
         return getGenericDAO().findUnitById(id);
    }

    public List<Unit> getUnitList()
    {
        return getGenericDAO().findAllUnit();
    }
}

