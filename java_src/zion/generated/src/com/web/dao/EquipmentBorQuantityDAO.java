package com.web.dao;

import com.web.value.EquipmentBorQuantity;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jun 04 15:59:11 CST 2014
*/

public interface EquipmentBorQuantityDAO extends CommonDAO 
{
    public abstract void saveEquipmentBorQuantity(EquipmentBorQuantity val);

    public abstract void removeEquipmentBorQuantity(EquipmentBorQuantity val);

    public abstract void removeEquipmentBorQuantity(Long id);

    public abstract EquipmentBorQuantity findEquipmentBorQuantityById(Long id);

    public abstract List<EquipmentBorQuantity> findAllEquipmentBorQuantity();
    public abstract List<Equipment> findEquipmentList();
}

