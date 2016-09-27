package com.web.web.action;

import com.web.value.RoomAppForm;
import com.web.service.RoomAppFormManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jun 04 15:59:11 CST 2014
*/

public class RoomAppFormAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private RoomAppForm roomAppForm;
    private String date;
    private String borrowDate;
    private Long[] roomIds;
    private Long[] selectedRoomAppFormIds;

    public RoomAppFormAction()
    {
        log = LogFactory.getLog(com.web.web.action.RoomAppFormAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("ROOMAPPFORM");
    }

    public RoomAppForm getRoomAppForm()
    {
        return roomAppForm;
    }

    public void setRoomAppForm(RoomAppForm val)
    {
        roomAppForm = val;
    }

    public void setGenericManager(RoomAppFormManager m)
    {
        super.setGenericManager(m);
    }

    public RoomAppFormManager getGenericManager()
    {
        return (RoomAppFormManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeRoomAppForm(roomAppForm.getId());
        return DELETE;
    }

    public String edit()
    {
        if (roomAppForm == null) {
            roomAppForm = new RoomAppForm();
        } else if (roomAppForm.getId() != null) {
            roomAppForm = getGenericManager().getRoomAppFormById(roomAppForm.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedRoomAppFormIds != null && selectedRoomAppFormIds.length > 0) {
            RoomAppForm obj = getGenericManager().getRoomAppFormById(selectedRoomAppFormIds[0]);
            obj.setId(null);
            roomAppForm = obj;
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
            if (inputValidation(roomAppForm) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(RoomAppForm val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        java.sql.Timestamp ts = Tools.getCurrentTimestamp();
        if (roomAppForm.getId() == null) {
            roomAppForm.setCreatedDate(ts);
            roomAppForm.setCreatedUser(getSessionUser().getLoginId());
        }
        roomAppForm.setLastModifiedDate(ts);
        roomAppForm.setLastModifiedUser(getSessionUser().getLoginId());
        getGenericManager().saveRoomAppForm(roomAppForm);
        return SUCCESS;
    }

    public String list()
    {
        return SUCCESS;
    }

    protected void beanToForm()
    {
        log.info("enter beanToForm()");
        date = Tools.dateToString(roomAppForm.getDate());
        borrowDate = Tools.dateToString(roomAppForm.getBorrowDate());
        roomIds = getGenericManager().getIdsFromRoomList(roomAppForm.getRoom());
        log.info("exit beanToForm()");
    }

    protected void formToBean()
    {
        log.info("enter formToBean()");
        roomAppForm.setDate(Tools.convertToDate(date)); 
        roomAppForm.setBorrowDate(Tools.convertToDate(borrowDate)); 
        roomAppForm.setMeeting(getAppPropertyById(roomAppForm.getMeetingId())); 
        roomAppForm.setApplyBeginClock(getGenericManager().getClockById(roomAppForm.getApplyBeginClockId())); 
        roomAppForm.setApplyEndClock(getGenericManager().getClockById(roomAppForm.getApplyEndClockId())); 
        roomAppForm.setRoom(getGenericManager().getRoomListByIds(roomIds)); 
        log.info("exit formToBean()");
    }
    public void setDate(String val)
    {
        date = val;
    }

    public String getDate()
    {
        return date;
    }

    public void setBorrowDate(String val)
    {
        borrowDate = val;
    }

    public String getBorrowDate()
    {
        return borrowDate;
    }

    public List<AppProperty> getMeetingList()
    {
        return super.getAppPropertyList("roomAppForm.meeting");
    }

    public List<Clock> getApplyBeginClockList()
    {
        return getGenericManager().getApplyBeginClockList(); // TODO
    }

    public List<Clock> getApplyEndClockList()
    {
        return getGenericManager().getApplyEndClockList(); // TODO
    }

    public List<Room> getRoomList()
    {
        List<Room> al = getGenericManager().getRoomList();
        if (al != null) {
            if (roomAppForm.getRoom() != null)
                al.removeAll(roomAppForm.getRoom());
            return al;
        }
        return new ArrayList<Room>();
    }

    public List<Room> getObject_roomList()
    {
        return (roomAppForm.getRoom() == null) ? new ArrayList<Room>() : roomAppForm.getRoom();
    }

    public void setRoomIds(Long[] val)
    {
        roomIds = val;
    }

    public Long[] getRoomIds()
    {
        return roomIds;
    }

    public List<RoomAppForm> getRoomAppFormList()
    {
        return getGenericManager().getRoomAppFormList();
    }

    public void setSelectedRoomAppFormIds(Long[] val)
    {
        selectedRoomAppFormIds = val;
    }

    public Long[] getSelectedRoomAppFormIds()
    {
        return selectedRoomAppFormIds;
    }
}
