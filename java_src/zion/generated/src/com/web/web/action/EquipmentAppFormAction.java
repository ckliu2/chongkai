package com.web.web.action;

import com.web.value.EquipmentAppForm;
import com.web.service.EquipmentAppFormManager;
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

public class EquipmentAppFormAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private EquipmentAppForm equipmentAppForm;
    private String date;
    private String borrowDate;
    private String returnDate;
    private Long[] borrowQuantityIds;
    private Long[] selectedEquipmentAppFormIds;

    public EquipmentAppFormAction()
    {
        log = LogFactory.getLog(com.web.web.action.EquipmentAppFormAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("EQUIPMENTAPPFORM");
    }

    public EquipmentAppForm getEquipmentAppForm()
    {
        return equipmentAppForm;
    }

    public void setEquipmentAppForm(EquipmentAppForm val)
    {
        equipmentAppForm = val;
    }

    public void setGenericManager(EquipmentAppFormManager m)
    {
        super.setGenericManager(m);
    }

    public EquipmentAppFormManager getGenericManager()
    {
        return (EquipmentAppFormManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeEquipmentAppForm(equipmentAppForm.getId());
        return DELETE;
    }

    public String edit()
    {
        if (equipmentAppForm == null) {
            equipmentAppForm = new EquipmentAppForm();
        } else if (equipmentAppForm.getId() != null) {
            equipmentAppForm = getGenericManager().getEquipmentAppFormById(equipmentAppForm.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedEquipmentAppFormIds != null && selectedEquipmentAppFormIds.length > 0) {
            EquipmentAppForm obj = getGenericManager().getEquipmentAppFormById(selectedEquipmentAppFormIds[0]);
            obj.setId(null);
            equipmentAppForm = obj;
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
            if (inputValidation(equipmentAppForm) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(EquipmentAppForm val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        java.sql.Timestamp ts = Tools.getCurrentTimestamp();
        if (equipmentAppForm.getId() == null) {
            equipmentAppForm.setCreatedDate(ts);
            equipmentAppForm.setCreatedUser(getSessionUser().getLoginId());
        }
        equipmentAppForm.setLastModifiedDate(ts);
        equipmentAppForm.setLastModifiedUser(getSessionUser().getLoginId());
        getGenericManager().saveEquipmentAppForm(equipmentAppForm);
        return SUCCESS;
    }

    public String list()
    {
        return SUCCESS;
    }

    protected void beanToForm()
    {
        log.info("enter beanToForm()");
        date = Tools.dateToString(equipmentAppForm.getDate());
        borrowDate = Tools.dateToString(equipmentAppForm.getBorrowDate());
        returnDate = Tools.dateToString(equipmentAppForm.getReturnDate());
        log.info("exit beanToForm()");
    }

    protected void formToBean()
    {
        log.info("enter formToBean()");
        equipmentAppForm.setDate(Tools.convertToDate(date)); 
        equipmentAppForm.setBorrowDate(Tools.convertToDate(borrowDate)); 
        equipmentAppForm.setReturnDate(Tools.convertToDate(returnDate)); 
        equipmentAppForm.setRoom(getGenericManager().getRoomById(equipmentAppForm.getRoomId())); 
        equipmentAppForm.setMeeting(getAppPropertyById(equipmentAppForm.getMeetingId())); 
        equipmentAppForm.setApplyBeginClock(getGenericManager().getClockById(equipmentAppForm.getApplyBeginClockId())); 
        equipmentAppForm.setApplyEndClock(getGenericManager().getClockById(equipmentAppForm.getApplyEndClockId())); 
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

    public void setReturnDate(String val)
    {
        returnDate = val;
    }

    public String getReturnDate()
    {
        return returnDate;
    }

    public List<Room> getRoomList()
    {
        return getGenericManager().getRoomList(); // TODO
    }

    public List<AppProperty> getMeetingList()
    {
        return super.getAppPropertyList("equipmentAppForm.meeting");
    }

    public List<Clock> getApplyBeginClockList()
    {
        return getGenericManager().getApplyBeginClockList(); // TODO
    }

    public List<Clock> getApplyEndClockList()
    {
        return getGenericManager().getApplyEndClockList(); // TODO
    }

    public void setBorrowQuantityIds(Long[] val)
    {
        borrowQuantityIds = val;
    }

    public Long[] getBorrowQuantityIds()
    {
        return borrowQuantityIds;
    }

    public List<EquipmentAppForm> getEquipmentAppFormList()
    {
        return getGenericManager().getEquipmentAppFormList();
    }

    public void setSelectedEquipmentAppFormIds(Long[] val)
    {
        selectedEquipmentAppFormIds = val;
    }

    public Long[] getSelectedEquipmentAppFormIds()
    {
        return selectedEquipmentAppFormIds;
    }
}
