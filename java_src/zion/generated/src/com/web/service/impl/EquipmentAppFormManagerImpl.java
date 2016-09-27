package com.web.service.impl;

import com.web.service.EquipmentAppFormManager;
import com.web.dao.EquipmentAppFormDAO;
import com.web.value.EquipmentAppForm;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jun 04 15:59:11 CST 2014
*/

public class EquipmentAppFormManagerImpl extends CommonManagerImpl implements EquipmentAppFormManager
{

    public EquipmentAppFormManagerImpl()
    {
    }

    public EquipmentAppFormDAO getGenericDAO()
    {
        return (EquipmentAppFormDAO)super.getGenericDAO();
    }

    public void setGenericDAO(EquipmentAppFormDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveEquipmentAppForm(EquipmentAppForm val)
    {
        getGenericDAO().saveEquipmentAppForm(val);
    }

    public void removeEquipmentAppForm(EquipmentAppForm val)
    {
        getGenericDAO().removeEquipmentAppForm(val);
    }

    public void removeEquipmentAppForm(Long id)
    {
        getGenericDAO().removeEquipmentAppForm(id);
    }

    public EquipmentAppForm getEquipmentAppFormById(Long id)
    {
         return getGenericDAO().findEquipmentAppFormById(id);
    }

    public List<EquipmentAppForm> getEquipmentAppFormList()
    {
        return getGenericDAO().findAllEquipmentAppForm();
    }
    public List<Room> getRoomList()
    {
        return getGenericDAO().findRoomList();
    }

    public List<Clock> getApplyBeginClockList()
    {
        return getGenericDAO().findApplyBeginClockList();
    }

    public List<Clock> getApplyEndClockList()
    {
        return getGenericDAO().findApplyEndClockList();
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

