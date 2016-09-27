package com.web.dao;

import com.web.value.Room;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jun 04 15:59:11 CST 2014
*/

public interface RoomDAO extends CommonDAO 
{
    public abstract void saveRoom(Room val);

    public abstract void removeRoom(Room val);

    public abstract void removeRoom(Long id);

    public abstract Room findRoomById(Long id);

    public abstract List<Room> findAllRoom();
    public abstract List<Member> findLastModifiedUserList();
    public abstract List<Member> findCreatedUserList();
}

