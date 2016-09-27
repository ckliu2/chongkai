package com.web.service;

import com.web.value.SubItem;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jun 04 15:59:11 CST 2014
*/

public interface SubItemManager extends CommonManager 
{
    public abstract void saveSubItem(SubItem val);

    public abstract void removeSubItem(SubItem val);

    public abstract void removeSubItem(Long id);

    public abstract SubItem getSubItemById(Long id);

    public abstract List<SubItem> getSubItemList();
    public abstract List<Member> getLastModifiedUserList();
    public abstract List<Member> getCreatedUserList();
    public abstract List<SubMenu> getSubMenuList();
}

