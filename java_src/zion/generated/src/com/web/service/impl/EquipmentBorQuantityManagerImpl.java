package com.web.service.impl;

import com.web.service.EquipmentBorQuantityManager;
import com.web.dao.EquipmentBorQuantityDAO;
import com.web.value.EquipmentBorQuantity;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jun 04 15:59:11 CST 2014
*/

public class EquipmentBorQuantityManagerImpl extends CommonManagerImpl implements EquipmentBorQuantityManager
{

    public EquipmentBorQuantityManagerImpl()
    {
    }

    public EquipmentBorQuantityDAO getGenericDAO()
    {
        return (EquipmentBorQuantityDAO)super.getGenericDAO();
    }

    public void setGenericDAO(EquipmentBorQuantityDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveEquipmentBorQuantity(EquipmentBorQuantity val)
    {
        getGenericDAO().saveEquipmentBorQuantity(val);
    }

    public void removeEquipmentBorQuantity(EquipmentBorQuantity val)
    {
        getGenericDAO().removeEquipmentBorQuantity(val);
    }

    public void removeEquipmentBorQuantity(Long id)
    {
        getGenericDAO().removeEquipmentBorQuantity(id);
    }

    public EquipmentBorQuantity getEquipmentBorQuantityById(Long id)
    {
         return getGenericDAO().findEquipmentBorQuantityById(id);
    }

    public List<EquipmentBorQuantity> getEquipmentBorQuantityList()
    {
        return getGenericDAO().findAllEquipmentBorQuantity();
    }
    public List<Equipment> getEquipmentList()
    {
        return getGenericDAO().findEquipmentList();
    }

}

