package com.web.service;

import com.web.value.Room;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu May 19 17:41:56 CST 2016
*/

public interface RoomManager extends CommonManager 
{
    public abstract void saveRoom(Room val);

    public abstract void removeRoom(Room val);

    public abstract void removeRoom(Long id);

    public abstract Room getRoomById(Long id);

    public abstract List<Room> getRoomList();
    public abstract List<Member> getLastModifiedUserList();
    public abstract List<Member> getCreatedUserList();
}

