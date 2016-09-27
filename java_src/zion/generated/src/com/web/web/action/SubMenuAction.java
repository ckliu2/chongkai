package com.web.web.action;

import com.web.value.SubMenu;
import com.web.service.SubMenuManager;
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

public class SubMenuAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private SubMenu subMenu;
    private Long[] selectedSubMenuIds;

    public SubMenuAction()
    {
        log = LogFactory.getLog(com.web.web.action.SubMenuAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("SUBMENU");
    }

    public SubMenu getSubMenu()
    {
        return subMenu;
    }

    public void setSubMenu(SubMenu val)
    {
        subMenu = val;
    }

    public void setGenericManager(SubMenuManager m)
    {
        super.setGenericManager(m);
    }

    public SubMenuManager getGenericManager()
    {
        return (SubMenuManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeSubMenu(subMenu.getId());
        return DELETE;
    }

    public String edit()
    {
        if (subMenu == null) {
            subMenu = new SubMenu();
        } else if (subMenu.getId() != null) {
            subMenu = getGenericManager().getSubMenuById(subMenu.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedSubMenuIds != null && selectedSubMenuIds.length > 0) {
            SubMenu obj = getGenericManager().getSubMenuById(selectedSubMenuIds[0]);
            obj.setId(null);
            subMenu = obj;
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
            if (inputValidation(subMenu) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(SubMenu val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        java.sql.Timestamp ts = Tools.getCurrentTimestamp();
        if (subMenu.getId() == null) {
            subMenu.setCreatedDate(ts);
            subMenu.setCreatedUser(getSessionUser().getLoginId());
        }
        subMenu.setLastModifiedDate(ts);
        subMenu.setLastModifiedUser(getSessionUser().getLoginId());
        getGenericManager().saveSubMenu(subMenu);
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
        subMenu.setMenu(getGenericManager().getMenuById(subMenu.getMenuId())); 
        subMenu.setLinkType(getAppPropertyById(subMenu.getLinkTypeId())); 
        log.info("exit formToBean()");
    }
    public List<Menu> getMenuList()
    {
        return getGenericManager().getMenuList(); // TODO
    }

    public List<AppProperty> getLinkTypeList()
    {
        return super.getAppPropertyList("subMenu.linkType");
    }

    public List<SubMenu> getSubMenuList()
    {
        return getGenericManager().getSubMenuList();
    }

    public void setSelectedSubMenuIds(Long[] val)
    {
        selectedSubMenuIds = val;
    }

    public Long[] getSelectedSubMenuIds()
    {
        return selectedSubMenuIds;
    }
}
