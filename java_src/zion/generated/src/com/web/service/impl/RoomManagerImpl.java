package com.web.service.impl;

import com.web.service.RoomManager;
import com.web.dao.RoomDAO;
import com.web.value.Room;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jun 04 15:59:11 CST 2014
*/

public class RoomManagerImpl extends CommonManagerImpl implements RoomManager
{

    public RoomManagerImpl()
    {
    }

    public RoomDAO getGenericDAO()
    {
        return (RoomDAO)super.getGenericDAO();
    }

    public void setGenericDAO(RoomDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveRoom(Room val)
    {
        getGenericDAO().saveRoom(val);
    }

    public void removeRoom(Room val)
    {
        getGenericDAO().removeRoom(val);
    }

    public void removeRoom(Long id)
    {
        getGenericDAO().removeRoom(id);
    }

    public Room getRoomById(Long id)
    {
         return getGenericDAO().findRoomById(id);
    }

    public List<Room> getRoomList()
    {
        return getGenericDAO().findAllRoom();
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

