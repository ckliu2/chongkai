package tncc.reserve.dao;

import tncc.reserve.value.Course;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Mar 20 16:19:30 CST 2014
*/

public interface CourseDAO extends CommonDAO 
{
    public abstract void saveCourse(Course val);

    public abstract void removeCourse(Course val);

    public abstract void removeCourse(Long id);

    public abstract Course findCourseById(Long id);

    public abstract List<Course> findAllCourse();
}

