package com.web.dao;

import com.web.value.EquipmentAppForm;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jun 04 15:59:11 CST 2014
*/

public interface EquipmentAppFormDAO extends CommonDAO 
{
    public abstract void saveEquipmentAppForm(EquipmentAppForm val);

    public abstract void removeEquipmentAppForm(EquipmentAppForm val);

    public abstract void removeEquipmentAppForm(Long id);

    public abstract EquipmentAppForm findEquipmentAppFormById(Long id);

    public abstract List<EquipmentAppForm> findAllEquipmentAppForm();
    public abstract List<Room> findRoomList();
    public abstract List<Clock> findApplyBeginClockList();
    public abstract List<Clock> findApplyEndClockList();
    public abstract List<Member> findLastModifiedUserList();
    public abstract List<Member> findCreatedUserList();
}

