package com.city.dao.hibernate;

import com.city.value.CourseMember;
import com.city.dao.CourseMemberDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu May 19 17:41:56 CST 2016
*/

public class CourseMemberDAOHibernate extends CommonDAOHibernate implements CourseMemberDAO
{

    public CourseMemberDAOHibernate()
    {
    }

    public void saveCourseMember(CourseMember val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeCourseMember(CourseMember val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeCourseMember(Long id)
    {
        CourseMember obj = findCourseMemberById(id);
        getHibernateTemplate().delete(obj);
    }

    public CourseMember findCourseMemberById(Long id)
    {
        if (id == null)
            return null;
        CourseMember obj = (CourseMember)getHibernateTemplate().get(com.city.value.CourseMember.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(com.city.value.CourseMember.class, id);
        else
            return obj;
    }

    public List<CourseMember> findAllCourseMember()
    {
        return getHibernateTemplate().find("from CourseMember");
    }
    public List<Course> findCourseList()
    {
        return new ArrayList<Course>(); // TODO
    }

    public List<Member> findMemberList()
    {
        return new ArrayList<Member>(); // TODO
    }

}

