package com.web.service;

import com.web.value.RoomAppForm;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jun 04 15:59:11 CST 2014
*/

public interface RoomAppFormManager extends CommonManager 
{
    public abstract void saveRoomAppForm(RoomAppForm val);

    public abstract void removeRoomAppForm(RoomAppForm val);

    public abstract void removeRoomAppForm(Long id);

    public abstract RoomAppForm getRoomAppFormById(Long id);

    public abstract List<RoomAppForm> getRoomAppFormList();
    public abstract List<Clock> getApplyBeginClockList();
    public abstract List<Clock> getApplyEndClockList();
    public abstract List<Member> getLastModifiedUserList();
    public abstract List<Member> getCreatedUserList();
    public abstract Long[] getIdsFromRoomList(List<Room> lst);

    public abstract List<Room> getRoomListByIds(Long[] ids);

}

