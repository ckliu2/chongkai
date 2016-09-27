package com.web.service.impl;

import com.web.service.SubMenuManager;
import com.web.dao.SubMenuDAO;
import com.web.value.SubMenu;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jun 04 15:59:11 CST 2014
*/

public class SubMenuManagerImpl extends CommonManagerImpl implements SubMenuManager
{

    public SubMenuManagerImpl()
    {
    }

    public SubMenuDAO getGenericDAO()
    {
        return (SubMenuDAO)super.getGenericDAO();
    }

    public void setGenericDAO(SubMenuDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveSubMenu(SubMenu val)
    {
        getGenericDAO().saveSubMenu(val);
    }

    public void removeSubMenu(SubMenu val)
    {
        getGenericDAO().removeSubMenu(val);
    }

    public void removeSubMenu(Long id)
    {
        getGenericDAO().removeSubMenu(id);
    }

    public SubMenu getSubMenuById(Long id)
    {
         return getGenericDAO().findSubMenuById(id);
    }

    public List<SubMenu> getSubMenuList()
    {
        return getGenericDAO().findAllSubMenu();
    }
    public List<Menu> getMenuList()
    {
        return getGenericDAO().findMenuList();
    }

    public List<Member> getLastModifiedUserList()
    {
        return getGenericDAO().findLastModifiedUserList();
    }

    public List<Member> getCreatedUserList()
    {
        return getGenericDAO().findCreatedUserList();
    }

}

