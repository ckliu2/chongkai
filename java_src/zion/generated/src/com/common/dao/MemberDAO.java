package com.common.dao;

import com.common.value.Member;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Dec 18 16:53:07 CST 2014
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

    public abstract Long[] getIdsFromGradeList(List<Grade> lst);

    public abstract List<Grade> getGradeListByIds(Long[] ids);

    public abstract Long[] getIdsFromTeamList(List<Team> lst);

    public abstract List<Team> getTeamListByIds(Long[] ids);

}

