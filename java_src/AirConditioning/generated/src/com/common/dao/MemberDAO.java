package com.common.dao;

import com.common.value.Member;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Dec 12 16:17:33 CST 2013
*/

public interface MemberDAO extends CommonDAO 
{
    public abstract void saveMember(Member val);

    public abstract void removeMember(Member val);

    public abstract void removeMember(Long id);

    public abstract Member findMemberById(Long id);

    public abstract List<Member> findAllMember();
    public abstract Long[] getIdsFromGroupList(List<Group> lst);

    public abstract List<Group> getGroupListByIds(Long[] ids);

}

