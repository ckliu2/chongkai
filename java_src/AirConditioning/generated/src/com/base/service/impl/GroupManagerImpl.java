package com.base.service.impl;

import com.base.service.GroupManager;
import com.base.dao.GroupDAO;
import com.base.value.Group;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Dec 12 16:17:33 CST 2013
*/

public class GroupManagerImpl extends CommonManagerImpl implements GroupManager
{

    public GroupManagerImpl()
    {
    }

    public GroupDAO getGenericDAO()
    {
        return (GroupDAO)super.getGenericDAO();
    }

    public void setGenericDAO(GroupDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveGroup(Group val)
    {
        getGenericDAO().saveGroup(val);
    }

    public void removeGroup(Group val)
    {
        getGenericDAO().removeGroup(val);
    }

    public void removeGroup(Long id)
    {
        getGenericDAO().removeGroup(id);
    }

    public Group getGroupById(Long id)
    {
         return getGenericDAO().findGroupById(id);
    }

    public List<Group> getGroupList()
    {
        return getGenericDAO().findAllGroup();
    }
    public Long[] getIdsFromMemberList(List<Member> lst)
    {
        return getGenericDAO().getIdsFromMemberList(lst);
    }

    public List<Member> getMemberListByIds(Long[] ids)
    {
        return getGenericDAO().getMemberListByIds(ids);
    }

}

