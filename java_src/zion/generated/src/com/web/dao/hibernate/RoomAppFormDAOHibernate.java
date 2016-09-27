package com.web.dao.hibernate;

import com.web.value.RoomAppForm;
import com.web.dao.RoomAppFormDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jun 04 15:59:11 CST 2014
*/

public class RoomAppFormDAOHibernate extends CommonDAOHibernate implements RoomAppFormDAO
{

    public RoomAppFormDAOHibernate()
    {
    }

    public void saveRoomAppForm(RoomAppForm val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeRoomAppForm(RoomAppForm val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeRoomAppForm(Long id)
    {
        RoomAppForm obj = findRoomAppFormById(id);
        getHibernateTemplate().delete(obj);
    }

    public RoomAppForm findRoomAppFormById(Long id)
    {
        if (id == null)
            return null;
        RoomAppForm obj = (RoomAppForm)getHibernateTemplate().get(com.web.value.RoomAppForm.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(com.web.value.RoomAppForm.class, id);
        else
            return obj;
    }

    public List<RoomAppForm> findAllRoomAppForm()
    {
        return getHibernateTemplate().find("from RoomAppForm");
    }
    public List<Clock> findApplyBeginClockList()
    {
        return new ArrayList<Clock>(); // TODO
    }

    public List<Clock> findApplyEndClockList()
    {
        return new ArrayList<Clock>(); // TODO
    }

    public List<Member> findLastModifiedUserList()
    {
        return new ArrayList<Member>(); // TODO
    }

    public List<Member> findCreatedUserList()
    {
        return new ArrayList<Member>(); // TODO
    }

    public Long[] getIdsFromRoomList(List tlist)
    {
        ArrayList<Long> al = new ArrayList<Long>();
        if (tlist != null) {
            for (int i = 0; i < tlist.size(); i++) {
                Room t = (Room) tlist.get(i);
                if (t != null)
                    al.add(t.getId());
            }
        }
        Long lng[] = new Long[al.size()];
        al.toArray(lng);
        
        return lng;
    }

    public List getRoomListByIds(Long[] ids)
    {
        ArrayList<Room> al = new ArrayList<Room>();
        if (ids != null) {
            for (int i = 0; i < ids.length; i++) {
                Room t = (Room) findRoomById(ids[i]);
                if (t != null)
                    al.add(t);
            }
        }
        return al;
    }
}

