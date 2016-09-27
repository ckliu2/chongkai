package com.web.web.action;

import com.web.value.EquipmentBorQuantity;
import com.web.service.EquipmentBorQuantityManager;
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

public class EquipmentBorQuantityAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private EquipmentBorQuantity equipmentBorQuantity;
    private Long[] selectedEquipmentBorQuantityIds;

    public EquipmentBorQuantityAction()
    {
        log = LogFactory.getLog(com.web.web.action.EquipmentBorQuantityAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("EQUIPMENTBORQUANTITY");
    }

    public EquipmentBorQuantity getEquipmentBorQuantity()
    {
        return equipmentBorQuantity;
    }

    public void setEquipmentBorQuantity(EquipmentBorQuantity val)
    {
        equipmentBorQuantity = val;
    }

    public void setGenericManager(EquipmentBorQuantityManager m)
    {
        super.setGenericManager(m);
    }

    public EquipmentBorQuantityManager getGenericManager()
    {
        return (EquipmentBorQuantityManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeEquipmentBorQuantity(equipmentBorQuantity.getId());
        return DELETE;
    }

    public String edit()
    {
        if (equipmentBorQuantity == null) {
            equipmentBorQuantity = new EquipmentBorQuantity();
        } else if (equipmentBorQuantity.getId() != null) {
            equipmentBorQuantity = getGenericManager().getEquipmentBorQuantityById(equipmentBorQuantity.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedEquipmentBorQuantityIds != null && selectedEquipmentBorQuantityIds.length > 0) {
            EquipmentBorQuantity obj = getGenericManager().getEquipmentBorQuantityById(selectedEquipmentBorQuantityIds[0]);
            obj.setId(null);
            equipmentBorQuantity = obj;
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
            if (inputValidation(equipmentBorQuantity) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(EquipmentBorQuantity val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveEquipmentBorQuantity(equipmentBorQuantity);
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
        equipmentBorQuantity.setEquipment(getGenericManager().getEquipmentById(equipmentBorQuantity.getEquipmentId())); 
        log.info("exit formToBean()");
    }
    public List<Equipment> getEquipmentList()
    {
        return getGenericManager().getEquipmentList(); // TODO
    }

    public List<EquipmentBorQuantity> getEquipmentBorQuantityList()
    {
        return getGenericManager().getEquipmentBorQuantityList();
    }

    public void setSelectedEquipmentBorQuantityIds(Long[] val)
    {
        selectedEquipmentBorQuantityIds = val;
    }

    public Long[] getSelectedEquipmentBorQuantityIds()
    {
        return selectedEquipmentBorQuantityIds;
    }
}
