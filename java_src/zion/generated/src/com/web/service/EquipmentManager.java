package com.web.service;

import com.web.value.Equipment;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jun 04 15:59:11 CST 2014
*/

public interface EquipmentManager extends CommonManager 
{
    public abstract void saveEquipment(Equipment val);

    public abstract void removeEquipment(Equipment val);

    public abstract void removeEquipment(Long id);

    public abstract Equipment getEquipmentById(Long id);

    public abstract List<Equipment> getEquipmentList();
    public abstract List<Department> getDepartmentList();
    public abstract List<Member> getLastModifiedUserList();
    public abstract List<Member> getCreatedUserList();
}

