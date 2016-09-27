package com.web.dao;

import com.web.value.RoomAppForm;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jun 04 15:59:11 CST 2014
*/

public interface RoomAppFormDAO extends CommonDAO 
{
    public abstract void saveRoomAppForm(RoomAppForm val);

    public abstract void removeRoomAppForm(RoomAppForm val);

    public abstract void removeRoomAppForm(Long id);

    public abstract RoomAppForm findRoomAppFormById(Long id);

    public abstract List<RoomAppForm> findAllRoomAppForm();
    public abstract List<Clock> findApplyBeginClockList();
    public abstract List<Clock> findApplyEndClockList();
    public abstract List<Member> findLastModifiedUserList();
    public abstract List<Member> findCreatedUserList();
    public abstract Long[] getIdsFromRoomList(List<Room> lst);

    public abstract List<Room> getRoomListByIds(Long[] ids);

}

