package com.city.service;

import com.city.value.CourseMember;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu May 19 17:41:56 CST 2016
*/

public interface CourseMemberManager extends CommonManager 
{
    public abstract void saveCourseMember(CourseMember val);

    public abstract void removeCourseMember(CourseMember val);

    public abstract void removeCourseMember(Long id);

    public abstract CourseMember getCourseMemberById(Long id);

    public abstract List<CourseMember> getCourseMemberList();
    public abstract List<Course> getCourseList();
    public abstract List<Member> getMemberList();
}

