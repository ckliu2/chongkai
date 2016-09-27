package com.common.service.impl;

import com.common.service.MemberManager;
import com.common.dao.MemberDAO;
import com.common.value.Member;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Dec 12 16:17:33 CST 2013
*/

public class MemberManagerImpl extends CommonManagerImpl implements MemberManager
{

    public MemberManagerImpl()
    {
    }

    public MemberDAO getGenericDAO()
    {
        return (MemberDAO)super.getGenericDAO();
    }

    public void setGenericDAO(MemberDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveMember(Member val)
    {
        getGenericDAO().saveMember(val);
    }

    public void removeMember(Member val)
    {
        getGenericDAO().removeMember(val);
    }

    public void removeMember(Long id)
    {
        getGenericDAO().removeMember(id);
    }

    public Member getMemberById(Long id)
    {
         return getGenericDAO().findMemberById(id);
    }

    public List<Member> getMemberList()
    {
        return getGenericDAO().findAllMember();
    }
    public Long[] getIdsFromGroupList(List<Group> lst)
    {
        return getGenericDAO().getIdsFromGroupList(lst);
    }

    public List<Group> getGroupListByIds(Long[] ids)
    {
        return getGenericDAO().getGroupListByIds(ids);
    }

}

