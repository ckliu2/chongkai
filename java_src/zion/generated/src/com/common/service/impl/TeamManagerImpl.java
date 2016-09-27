package com.common.service.impl;

import com.common.service.TeamManager;
import com.common.dao.TeamDAO;
import com.common.value.Team;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Dec 18 16:53:07 CST 2014
*/

public class TeamManagerImpl extends CommonManagerImpl implements TeamManager
{

    public TeamManagerImpl()
    {
    }

    public TeamDAO getGenericDAO()
    {
        return (TeamDAO)super.getGenericDAO();
    }

    public void setGenericDAO(TeamDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveTeam(Team val)
    {
        getGenericDAO().saveTeam(val);
    }

    public void removeTeam(Team val)
    {
        getGenericDAO().removeTeam(val);
    }

    public void removeTeam(Long id)
    {
        getGenericDAO().removeTeam(id);
    }

    public Team getTeamById(Long id)
    {
         return getGenericDAO().findTeamById(id);
    }

    public List<Team> getTeamList()
    {
        return getGenericDAO().findAllTeam();
    }
    public List<Member> getPrimaryLeaderList()
    {
        return getGenericDAO().findPrimaryLeaderList();
    }

    public List<Member> getSecondLeaderList()
    {
        return getGenericDAO().findSecondLeaderList();
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

