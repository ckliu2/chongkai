package tncc.reserve.dao;

import tncc.reserve.value.CourseOpen;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Mar 20 16:19:30 CST 2014
*/

public interface CourseOpenDAO extends CommonDAO 
{
    public abstract void saveCourseOpen(CourseOpen val);

    public abstract void removeCourseOpen(CourseOpen val);

    public abstract void removeCourseOpen(Long id);

    public abstract CourseOpen findCourseOpenById(Long id);

    public abstract List<CourseOpen> findAllCourseOpen();
    public abstract List<Course> findCourseList();
    public abstract List<Member> findTeacherList();
    public abstract List<ClassRoom> findClassroomList();
}

