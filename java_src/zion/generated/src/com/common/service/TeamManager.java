package com.common.service;

import com.common.value.Team;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Dec 18 16:53:07 CST 2014
*/

public interface TeamManager extends CommonManager 
{
    public abstract void saveTeam(Team val);

    public abstract void removeTeam(Team val);

    public abstract void removeTeam(Long id);

    public abstract Team getTeamById(Long id);

    public abstract List<Team> getTeamList();
    public abstract List<Member> getPrimaryLeaderList();
    public abstract List<Member> getSecondLeaderList();
    public abstract Long[] getIdsFromMemberList(List<Member> lst);

    public abstract List<Member> getMemberListByIds(Long[] ids);

}

