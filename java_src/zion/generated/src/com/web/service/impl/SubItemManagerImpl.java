package com.web.service.impl;

import com.web.service.SubItemManager;
import com.web.dao.SubItemDAO;
import com.web.value.SubItem;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jun 04 15:59:11 CST 2014
*/

public class SubItemManagerImpl extends CommonManagerImpl implements SubItemManager
{

    public SubItemManagerImpl()
    {
    }

    public SubItemDAO getGenericDAO()
    {
        return (SubItemDAO)super.getGenericDAO();
    }

    public void setGenericDAO(SubItemDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveSubItem(SubItem val)
    {
        getGenericDAO().saveSubItem(val);
    }

    public void removeSubItem(SubItem val)
    {
        getGenericDAO().removeSubItem(val);
    }

    public void removeSubItem(Long id)
    {
        getGenericDAO().removeSubItem(id);
    }

    public SubItem getSubItemById(Long id)
    {
         return getGenericDAO().findSubItemById(id);
    }

    public List<SubItem> getSubItemList()
    {
        return getGenericDAO().findAllSubItem();
    }
    public List<Member> getLastModifiedUserList()
    {
        return getGenericDAO().findLastModifiedUserList();
    }

    public List<Member> getCreatedUserList()
    {
        return getGenericDAO().findCreatedUserList();
    }

    public List<SubMenu> getSubMenuList()
    {
        return getGenericDAO().findSubMenuList();
    }

}

