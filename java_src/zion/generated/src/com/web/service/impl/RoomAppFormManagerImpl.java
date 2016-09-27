package com.web.service.impl;

import com.web.service.RoomAppFormManager;
import com.web.dao.RoomAppFormDAO;
import com.web.value.RoomAppForm;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jun 04 15:59:11 CST 2014
*/

public class RoomAppFormManagerImpl extends CommonManagerImpl implements RoomAppFormManager
{

    public RoomAppFormManagerImpl()
    {
    }

    public RoomAppFormDAO getGenericDAO()
    {
        return (RoomAppFormDAO)super.getGenericDAO();
    }

    public void setGenericDAO(RoomAppFormDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveRoomAppForm(RoomAppForm val)
    {
        getGenericDAO().saveRoomAppForm(val);
    }

    public void removeRoomAppForm(RoomAppForm val)
    {
        getGenericDAO().removeRoomAppForm(val);
    }

    public void removeRoomAppForm(Long id)
    {
        getGenericDAO().removeRoomAppForm(id);
    }

    public RoomAppForm getRoomAppFormById(Long id)
    {
         return getGenericDAO().findRoomAppFormById(id);
    }

    public List<RoomAppForm> getRoomAppFormList()
    {
        return getGenericDAO().findAllRoomAppForm();
    }
    public List<Clock> getApplyBeginClockList()
    {
        return getGenericDAO().findApplyBeginClockList();
    }

    public List<Clock> getApplyEndClockList()
    {
        return getGenericDAO().findApplyEndClockList();
    }

    public List<Member> getLastModifiedUserList()
    {
        return getGenericDAO().findLastModifiedUserList();
    }

    public List<Member> getCreatedUserList()
    {
        return getGenericDAO().findCreatedUserList();
    }

    public Long[] getIdsFromRoomList(List<Room> lst)
    {
        return getGenericDAO().getIdsFromRoomList(lst);
    }

    public List<Room> getRoomListByIds(Long[] ids)
    {
        return getGenericDAO().getRoomListByIds(ids);
    }

}

