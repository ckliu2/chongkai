package com.web.service;

import com.web.value.EquipmentAppForm;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jun 04 15:59:11 CST 2014
*/

public interface EquipmentAppFormManager extends CommonManager 
{
    public abstract void saveEquipmentAppForm(EquipmentAppForm val);

    public abstract void removeEquipmentAppForm(EquipmentAppForm val);

    public abstract void removeEquipmentAppForm(Long id);

    public abstract EquipmentAppForm getEquipmentAppFormById(Long id);

    public abstract List<EquipmentAppForm> getEquipmentAppFormList();
    public abstract List<Room> getRoomList();
    public abstract List<Clock> getApplyBeginClockList();
    public abstract List<Clock> getApplyEndClockList();
    public abstract List<Member> getLastModifiedUserList();
    public abstract List<Member> getCreatedUserList();
}

