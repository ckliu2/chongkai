package com.web.dao;

import com.web.value.SubMenu;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu May 19 17:41:56 CST 2016
*/

public interface SubMenuDAO extends CommonDAO 
{
    public abstract void saveSubMenu(SubMenu val);

    public abstract void removeSubMenu(SubMenu val);

    public abstract void removeSubMenu(Long id);

    public abstract SubMenu findSubMenuById(Long id);

    public abstract List<SubMenu> findAllSubMenu();
    public abstract List<Menu> findMenuList();
    public abstract List<Member> findLastModifiedUserList();
    public abstract List<Member> findCreatedUserList();
}

