package com.web.dao.hibernate;

import com.web.value.Room;
import com.web.dao.RoomDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jun 04 15:59:11 CST 2014
*/

public class RoomDAOHibernate extends CommonDAOHibernate implements RoomDAO
{

    public RoomDAOHibernate()
    {
    }

    public void saveRoom(Room val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeRoom(Room val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeRoom(Long id)
    {
        Room obj = findRoomById(id);
        getHibernateTemplate().delete(obj);
    }

    public Room findRoomById(Long id)
    {
        if (id == null)
            return null;
        Room obj = (Room)getHibernateTemplate().get(com.web.value.Room.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(com.web.value.Room.class, id);
        else
            return obj;
    }

    public List<Room> findAllRoom()
    {
        return getHibernateTemplate().find("from Room");
    }
    public List<Member> findLastModifiedUserList()
    {
        return new ArrayList<Member>(); // TODO
    }

    public List<Member> findCreatedUserList()
    {
        return new ArrayList<Member>(); // TODO
    }

}

