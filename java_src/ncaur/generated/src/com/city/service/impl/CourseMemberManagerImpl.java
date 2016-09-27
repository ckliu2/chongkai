package com.city.service.impl;

import com.city.service.CourseMemberManager;
import com.city.dao.CourseMemberDAO;
import com.city.value.CourseMember;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu May 19 17:41:56 CST 2016
*/

public class CourseMemberManagerImpl extends CommonManagerImpl implements CourseMemberManager
{

    public CourseMemberManagerImpl()
    {
    }

    public CourseMemberDAO getGenericDAO()
    {
        return (CourseMemberDAO)super.getGenericDAO();
    }

    public void setGenericDAO(CourseMemberDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveCourseMember(CourseMember val)
    {
        getGenericDAO().saveCourseMember(val);
    }

    public void removeCourseMember(CourseMember val)
    {
        getGenericDAO().removeCourseMember(val);
    }

    public void removeCourseMember(Long id)
    {
        getGenericDAO().removeCourseMember(id);
    }

    public CourseMember getCourseMemberById(Long id)
    {
         return getGenericDAO().findCourseMemberById(id);
    }

    public List<CourseMember> getCourseMemberList()
    {
        return getGenericDAO().findAllCourseMember();
    }
    public List<Course> getCourseList()
    {
        return getGenericDAO().findCourseList();
    }

    public List<Member> getMemberList()
    {
        return getGenericDAO().findMemberList();
    }

}

