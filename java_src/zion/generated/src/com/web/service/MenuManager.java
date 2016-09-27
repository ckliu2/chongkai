package com.web.service;

import com.web.value.Menu;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jun 04 15:59:11 CST 2014
*/

public interface MenuManager extends CommonManager 
{
    public abstract void saveMenu(Menu val);

    public abstract void removeMenu(Menu val);

    public abstract void removeMenu(Long id);

    public abstract Menu getMenuById(Long id);

    public abstract List<Menu> getMenuList();
    public abstract List<Member> getLastModifiedUserList();
    public abstract List<Member> getCreatedUserList();
}

