package com.web.service.impl;

import com.web.service.MenuManager;
import com.web.dao.MenuDAO;
import com.web.value.Menu;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu May 19 17:41:56 CST 2016
*/

public class MenuManagerImpl extends CommonManagerImpl implements MenuManager
{

    public MenuManagerImpl()
    {
    }

    public MenuDAO getGenericDAO()
    {
        return (MenuDAO)super.getGenericDAO();
    }

    public void setGenericDAO(MenuDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveMenu(Menu val)
    {
        getGenericDAO().saveMenu(val);
    }

    public void removeMenu(Menu val)
    {
        getGenericDAO().removeMenu(val);
    }

    public void removeMenu(Long id)
    {
        getGenericDAO().removeMenu(id);
    }

    public Menu getMenuById(Long id)
    {
         return getGenericDAO().findMenuById(id);
    }

    public List<Menu> getMenuList()
    {
        return getGenericDAO().findAllMenu();
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

