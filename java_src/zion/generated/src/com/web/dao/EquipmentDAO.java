package com.web.dao;

import com.web.value.Equipment;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jun 04 15:59:11 CST 2014
*/

public interface EquipmentDAO extends CommonDAO 
{
    public abstract void saveEquipment(Equipment val);

    public abstract void removeEquipment(Equipment val);

    public abstract void removeEquipment(Long id);

    public abstract Equipment findEquipmentById(Long id);

    public abstract List<Equipment> findAllEquipment();
    public abstract List<Department> findDepartmentList();
    public abstract List<Member> findLastModifiedUserList();
    public abstract List<Member> findCreatedUserList();
}

