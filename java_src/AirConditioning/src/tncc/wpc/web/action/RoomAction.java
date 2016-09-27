package tncc.wpc.web.action;

import tncc.wpc.value.*;
import tncc.wpc.service.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;
import com.base.value.SessionUser;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Fri Jan 29 14:30:29 CST 2010
*/

public class RoomAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private Room room;
    private Long[] selectedRoomIds;

    public RoomAction()
    {
        log = LogFactory.getLog(tncc.wpc.web.action.RoomAction.class);
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

    public void setGenericManager(wpcManager m)
    {
        super.setGenericManager(m);
    }

    public wpcManager getGenericManager()
    {
        return (wpcManager) super.getGenericManager();
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
        
        SessionUser s=(SessionUser)getSession().getAttribute("user");    
        room.setMember(s.getMember()); 
        room.setCreatedDate(Tools.getCurrentTimestamp());      
        room.setCreatedUser(s.getMember());      
        room.setBuilding(getGenericManager().getBuildingById(room.getBuildingId())); 
        log.info("exit formToBean()");
    }


    public List<Building> getBuildingList()
    {
        return getGenericManager().getBuildingList(); // TODO
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
