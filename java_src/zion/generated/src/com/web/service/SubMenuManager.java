package com.web.service;

import com.web.value.SubMenu;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jun 04 15:59:11 CST 2014
*/

public interface SubMenuManager extends CommonManager 
{
    public abstract void saveSubMenu(SubMenu val);

    public abstract void removeSubMenu(SubMenu val);

    public abstract void removeSubMenu(Long id);

    public abstract SubMenu getSubMenuById(Long id);

    public abstract List<SubMenu> getSubMenuList();
    public abstract List<Menu> getMenuList();
    public abstract List<Member> getLastModifiedUserList();
    public abstract List<Member> getCreatedUserList();
}

