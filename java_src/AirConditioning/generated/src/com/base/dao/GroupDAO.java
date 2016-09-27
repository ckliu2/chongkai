package com.base.dao;

import com.base.value.Group;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Dec 12 16:17:33 CST 2013
*/

public interface GroupDAO extends CommonDAO 
{
    public abstract void saveGroup(Group val);

    public abstract void removeGroup(Group val);

    public abstract void removeGroup(Long id);

    public abstract Group findGroupById(Long id);

    public abstract List<Group> findAllGroup();
    public abstract Long[] getIdsFromMemberList(List<Member> lst);

    public abstract List<Member> getMemberListByIds(Long[] ids);

}

