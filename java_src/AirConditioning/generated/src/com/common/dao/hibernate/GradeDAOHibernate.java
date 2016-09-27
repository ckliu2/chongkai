package com.common.dao.hibernate;

import com.common.value.Grade;
import com.common.dao.GradeDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Dec 12 16:17:33 CST 2013
*/

public class GradeDAOHibernate extends CommonDAOHibernate implements GradeDAO
{

    public GradeDAOHibernate()
    {
    }

    public void saveGrade(Grade val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeGrade(Grade val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeGrade(Long id)
    {
        Grade obj = findGradeById(id);
        getHibernateTemplate().delete(obj);
    }

    public Grade findGradeById(Long id)
    {
        if (id == null)
            return null;
        Grade obj = (Grade)getHibernateTemplate().get(com.common.value.Grade.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(com.common.value.Grade.class, id);
        else
            return obj;
    }

    public List<Grade> findAllGrade()
    {
        return getHibernateTemplate().find("from Grade");
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

