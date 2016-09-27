package com.web.dao;

import com.web.value.SubItem;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu May 19 17:41:56 CST 2016
*/

public interface SubItemDAO extends CommonDAO 
{
    public abstract void saveSubItem(SubItem val);

    public abstract void removeSubItem(SubItem val);

    public abstract void removeSubItem(Long id);

    public abstract SubItem findSubItemById(Long id);

    public abstract List<SubItem> findAllSubItem();
    public abstract List<Member> findLastModifiedUserList();
    public abstract List<Member> findCreatedUserList();
    public abstract List<SubMenu> findSubMenuList();
}

