package tncc.reserve.service;

import tncc.reserve.value.Course;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Mar 20 16:19:30 CST 2014
*/

public interface CourseManager extends CommonManager 
{
    public abstract void saveCourse(Course val);

    public abstract void removeCourse(Course val);

    public abstract void removeCourse(Long id);

    public abstract Course getCourseById(Long id);

    public abstract List<Course> getCourseList();
}

