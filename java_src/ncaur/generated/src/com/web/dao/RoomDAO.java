package com.web.dao;

import com.web.value.Room;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu May 19 17:41:56 CST 2016
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

