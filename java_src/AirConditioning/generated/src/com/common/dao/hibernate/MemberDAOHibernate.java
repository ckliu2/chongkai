package com.common.dao.hibernate;

import com.common.value.Member;
import com.common.dao.MemberDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Dec 12 16:17:33 CST 2013
*/

public class MemberDAOHibernate extends CommonDAOHibernate implements MemberDAO
{

    public MemberDAOHibernate()
    {
    }

    public void saveMember(Member val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeMember(Member val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeMember(Long id)
    {
        Member obj = findMemberById(id);
        getHibernateTemplate().delete(obj);
    }

    public Member findMemberById(Long id)
    {
        if (id == null)
            return null;
        Member obj = (Member)getHibernateTemplate().get(com.common.value.Member.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(com.common.value.Member.class, id);
        else
            return obj;
    }

    public List<Member> findAllMember()
    {
        return getHibernateTemplate().find("from Member");
    }
    public Long[] getIdsFromGroupList(List tlist)
    {
        ArrayList<Long> al = new ArrayList<Long>();
        if (tlist != null) {
            for (int i = 0; i < tlist.size(); i++) {
                Group t = (Group) tlist.get(i);
                if (t != null)
                    al.add(t.getId());
            }
        }
        Long lng[] = new Long[al.size()];
        al.toArray(lng);
        
        return lng;
    }

    public List getGroupListByIds(Long[] ids)
    {
        ArrayList<Group> al = new ArrayList<Group>();
        if (ids != null) {
            for (int i = 0; i < ids.length; i++) {
                Group t = (Group) findGroupById(ids[i]);
                if (t != null)
                    al.add(t);
            }
        }
        return al;
    }
}

