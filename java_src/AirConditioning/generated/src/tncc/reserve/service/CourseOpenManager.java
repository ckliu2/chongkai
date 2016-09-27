package tncc.reserve.service;

import tncc.reserve.value.CourseOpen;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Mar 20 16:19:30 CST 2014
*/

public interface CourseOpenManager extends CommonManager 
{
    public abstract void saveCourseOpen(CourseOpen val);

    public abstract void removeCourseOpen(CourseOpen val);

    public abstract void removeCourseOpen(Long id);

    public abstract CourseOpen getCourseOpenById(Long id);

    public abstract List<CourseOpen> getCourseOpenList();
    public abstract List<Course> getCourseList();
    public abstract List<Member> getTeacherList();
    public abstract List<ClassRoom> getClassroomList();
}

