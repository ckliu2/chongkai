package com.web.service.impl;

import com.web.service.EquipmentManager;
import com.web.dao.EquipmentDAO;
import com.web.value.Equipment;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jun 04 15:59:11 CST 2014
*/

public class EquipmentManagerImpl extends CommonManagerImpl implements EquipmentManager
{

    public EquipmentManagerImpl()
    {
    }

    public EquipmentDAO getGenericDAO()
    {
        return (EquipmentDAO)super.getGenericDAO();
    }

    public void setGenericDAO(EquipmentDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveEquipment(Equipment val)
    {
        getGenericDAO().saveEquipment(val);
    }

    public void removeEquipment(Equipment val)
    {
        getGenericDAO().removeEquipment(val);
    }

    public void removeEquipment(Long id)
    {
        getGenericDAO().removeEquipment(id);
    }

    public Equipment getEquipmentById(Long id)
    {
         return getGenericDAO().findEquipmentById(id);
    }

    public List<Equipment> getEquipmentList()
    {
        return getGenericDAO().findAllEquipment();
    }
    public List<Department> getDepartmentList()
    {
        return getGenericDAO().findDepartmentList();
    }

    public List<Member> getLastModifiedUserList()
    {
        return getGenericDAO().findLastModifiedUserList();
    }

    public List<Member> getCreatedUserList()
    {
        return getGenericDAO().findCreatedUserList();
    }

}

