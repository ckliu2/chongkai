package com.web.web.action;

import com.web.value.Room;
import com.web.service.RoomManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu May 19 17:41:56 CST 2016
*/

public class RoomAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private Room room;
    private Long[] selectedRoomIds;

    public RoomAction()
    {
        log = LogFactory.getLog(com.web.web.action.RoomAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("ROOM");
    }

    public Room getRoom()
    {
        return room;
    }

    public void setRoom(Room val)
    {
        room = val;
    }

    public void setGenericManager(RoomManager m)
    {
        super.setGenericManager(m);
    }

    public RoomManager getGenericManager()
    {
        return (RoomManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeRoom(room.getId());
        return DELETE;
    }

    public String edit()
    {
        if (room == null) {
            room = new Room();
        } else if (room.getId() != null) {
            room = getGenericManager().getRoomById(room.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedRoomIds != null && selectedRoomIds.length > 0) {
            Room obj = getGenericManager().getRoomById(selectedRoomIds[0]);
            obj.setId(null);
            room = obj;
        }
        beanToForm();

        return SUCCESS;
    }

    public String execute()
    {
        log.info("entering 'execute' method");
        if (getDelete() != null) {
            return delete();
        } else {
            formToBean();
            if (inputValidation(room) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(Room val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        java.sql.Timestamp ts = Tools.getCurrentTimestamp();
        if (room.getId() == null) {
            room.setCreatedDate(ts);
            room.setCreatedUser(getSessionUser().getLoginId());
        }
        room.setLastModifiedDate(ts);
        room.setLastModifiedUser(getSessionUser().getLoginId());
        getGenericManager().saveRoom(room);
        return SUCCESS;
    }

    public String list()
    {
        return SUCCESS;
    }

    protected void beanToForm()
    {
        log.info("enter beanToForm()");
        log.info("exit beanToForm()");
    }

    protected void formToBean()
    {
        log.info("enter formToBean()");
        log.info("exit formToBean()");
    }
    public List<Room> getRoomList()
    {
        return getGenericManager().getRoomList();
    }

    public void setSelectedRoomIds(Long[] val)
    {
        selectedRoomIds = val;
    }

    public Long[] getSelectedRoomIds()
    {
        return selectedRoomIds;
    }
}
