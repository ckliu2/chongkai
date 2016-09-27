package com.common.dao;

import com.common.value.Team;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Dec 18 16:53:07 CST 2014
*/

public interface TeamDAO extends CommonDAO 
{
    public abstract void saveTeam(Team val);

    public abstract void removeTeam(Team val);

    public abstract void removeTeam(Long id);

    public abstract Team findTeamById(Long id);

    public abstract List<Team> findAllTeam();
    public abstract List<Member> findPrimaryLeaderList();
    public abstract List<Member> findSecondLeaderList();
    public abstract Long[] getIdsFromMemberList(List<Member> lst);

    public abstract List<Member> getMemberListByIds(Long[] ids);

}

