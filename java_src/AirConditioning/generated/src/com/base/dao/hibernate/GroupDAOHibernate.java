package com.base.dao.hibernate;

import com.base.value.Group;
import com.base.dao.GroupDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Dec 12 16:17:33 CST 2013
*/

public class GroupDAOHibernate extends CommonDAOHibernate implements GroupDAO
{

    public GroupDAOHibernate()
    {
    }

    public void saveGroup(Group val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeGroup(Group val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeGroup(Long id)
    {
        Group obj = findGroupById(id);
        getHibernateTemplate().delete(obj);
    }

    public Group findGroupById(Long id)
    {
        if (id == null)
            return null;
        Group obj = (Group)getHibernateTemplate().get(com.base.value.Group.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(com.base.value.Group.class, id);
        else
            return obj;
    }

    public List<Group> findAllGroup()
    {
        return getHibernateTemplate().find("from Group");
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

