package com.web.dao;

import com.web.value.SubMenu;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jun 04 15:59:11 CST 2014
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

