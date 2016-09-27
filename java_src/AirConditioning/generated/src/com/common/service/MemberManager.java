package com.common.service;

import com.common.value.Member;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Dec 12 16:17:33 CST 2013
*/

public interface MemberManager extends CommonManager 
{
    public abstract void saveMember(Member val);

    public abstract void removeMember(Member val);

    public abstract void removeMember(Long id);

    public abstract Member getMemberById(Long id);

    public abstract List<Member> getMemberList();
    public abstract Long[] getIdsFromGroupList(List<Group> lst);

    public abstract List<Group> getGroupListByIds(Long[] ids);

}

