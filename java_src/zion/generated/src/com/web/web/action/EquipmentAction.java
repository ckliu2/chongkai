package com.web.web.action;

import com.web.value.Equipment;
import com.web.service.EquipmentManager;
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

public class EquipmentAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private Equipment equipment;
    private Long[] selectedEquipmentIds;

    public EquipmentAction()
    {
        log = LogFactory.getLog(com.web.web.action.EquipmentAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("EQUIPMENT");
    }

    public Equipment getEquipment()
    {
        return equipment;
    }

    public void setEquipment(Equipment val)
    {
        equipment = val;
    }

    public void setGenericManager(EquipmentManager m)
    {
        super.setGenericManager(m);
    }

    public EquipmentManager getGenericManager()
    {
        return (EquipmentManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeEquipment(equipment.getId());
        return DELETE;
    }

    public String edit()
    {
        if (equipment == null) {
            equipment = new Equipment();
        } else if (equipment.getId() != null) {
            equipment = getGenericManager().getEquipmentById(equipment.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedEquipmentIds != null && selectedEquipmentIds.length > 0) {
            Equipment obj = getGenericManager().getEquipmentById(selectedEquipmentIds[0]);
            obj.setId(null);
            equipment = obj;
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
            if (inputValidation(equipment) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(Equipment val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        java.sql.Timestamp ts = Tools.getCurrentTimestamp();
        if (equipment.getId() == null) {
            equipment.setCreatedDate(ts);
            equipment.setCreatedUser(getSessionUser().getLoginId());
        }
        equipment.setLastModifiedDate(ts);
        equipment.setLastModifiedUser(getSessionUser().getLoginId());
        getGenericManager().saveEquipment(equipment);
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
        equipment.setDepartment(getGenericManager().getDepartmentById(equipment.getDepartmentId())); 
        log.info("exit formToBean()");
    }
    public List<Department> getDepartmentList()
    {
        return getGenericManager().getDepartmentList(); // TODO
    }

    public List<Equipment> getEquipmentList()
    {
        return getGenericManager().getEquipmentList();
    }

    public void setSelectedEquipmentIds(Long[] val)
    {
        selectedEquipmentIds = val;
    }

    public Long[] getSelectedEquipmentIds()
    {
        return selectedEquipmentIds;
    }
}
