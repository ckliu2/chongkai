package com.city.dao;

import com.city.value.CourseMember;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu May 19 17:41:56 CST 2016
*/

public interface CourseMemberDAO extends CommonDAO 
{
    public abstract void saveCourseMember(CourseMember val);

    public abstract void removeCourseMember(CourseMember val);

    public abstract void removeCourseMember(Long id);

    public abstract CourseMember findCourseMemberById(Long id);

    public abstract List<CourseMember> findAllCourseMember();
    public abstract List<Course> findCourseList();
    public abstract List<Member> findMemberList();
}

