package com.common.dao.hibernate;

import com.common.value.Team;
import com.common.dao.TeamDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Dec 18 16:53:07 CST 2014
*/

public class TeamDAOHibernate extends CommonDAOHibernate implements TeamDAO
{

    public TeamDAOHibernate()
    {
    }

    public void saveTeam(Team val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeTeam(Team val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeTeam(Long id)
    {
        Team obj = findTeamById(id);
        getHibernateTemplate().delete(obj);
    }

    public Team findTeamById(Long id)
    {
        if (id == null)
            return null;
        Team obj = (Team)getHibernateTemplate().get(com.common.value.Team.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(com.common.value.Team.class, id);
        else
            return obj;
    }

    public List<Team> findAllTeam()
    {
        return getHibernateTemplate().find("from Team");
    }
    public List<Member> findPrimaryLeaderList()
    {
        return new ArrayList<Member>(); // TODO
    }

    public List<Member> findSecondLeaderList()
    {
        return new ArrayList<Member>(); // TODO
    }

    public Long[] getIdsFromMemberList(List tlist)
    {
        ArrayList<Long> al = new ArrayList<Long>();
        if (tlist != null) {
            for (int i = 0; i < tlist.size(); i++) {
                Member t = (Member) tlist.get(i);
                if (t != null)
                    al.add(t.getId());
            }
        }
        Long lng[] = new Long[al.size()];
        al.toArray(lng);
        
        return lng;
    }

    public List getMemberListByIds(Long[] ids)
    {
        ArrayList<Member> al = new ArrayList<Member>();
        if (ids != null) {
            for (int i = 0; i < ids.length; i++) {
                Member t = (Member) findMemberById(ids[i]);
                if (t != null)
                    al.add(t);
            }
        }
        return al;
    }
}

