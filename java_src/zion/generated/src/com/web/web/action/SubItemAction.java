package com.web.web.action;

import com.web.value.SubItem;
import com.web.service.SubItemManager;
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

public class SubItemAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private SubItem subItem;
    private Long[] selectedSubItemIds;

    public SubItemAction()
    {
        log = LogFactory.getLog(com.web.web.action.SubItemAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("SUBITEM");
    }

    public SubItem getSubItem()
    {
        return subItem;
    }

    public void setSubItem(SubItem val)
    {
        subItem = val;
    }

    public void setGenericManager(SubItemManager m)
    {
        super.setGenericManager(m);
    }

    public SubItemManager getGenericManager()
    {
        return (SubItemManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeSubItem(subItem.getId());
        return DELETE;
    }

    public String edit()
    {
        if (subItem == null) {
            subItem = new SubItem();
        } else if (subItem.getId() != null) {
            subItem = getGenericManager().getSubItemById(subItem.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedSubItemIds != null && selectedSubItemIds.length > 0) {
            SubItem obj = getGenericManager().getSubItemById(selectedSubItemIds[0]);
            obj.setId(null);
            subItem = obj;
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
            if (inputValidation(subItem) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(SubItem val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        java.sql.Timestamp ts = Tools.getCurrentTimestamp();
        if (subItem.getId() == null) {
            subItem.setCreatedDate(ts);
            subItem.setCreatedUser(getSessionUser().getLoginId());
        }
        subItem.setLastModifiedDate(ts);
        subItem.setLastModifiedUser(getSessionUser().getLoginId());
        getGenericManager().saveSubItem(subItem);
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
        subItem.setSubMenu(getGenericManager().getSubMenuById(subItem.getSubMenuId())); 
        subItem.setLinkType(getAppPropertyById(subItem.getLinkTypeId())); 
        log.info("exit formToBean()");
    }
    public List<SubMenu> getSubMenuList()
    {
        return getGenericManager().getSubMenuList(); // TODO
    }

    public List<AppProperty> getLinkTypeList()
    {
        return super.getAppPropertyList("subItem.linkType");
    }

    public List<SubItem> getSubItemList()
    {
        return getGenericManager().getSubItemList();
    }

    public void setSelectedSubItemIds(Long[] val)
    {
        selectedSubItemIds = val;
    }

    public Long[] getSelectedSubItemIds()
    {
        return selectedSubItemIds;
    }
}
