package tncc.reserve.service.impl;

import tncc.reserve.service.CourseManager;
import tncc.reserve.dao.CourseDAO;
import tncc.reserve.value.Course;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Mar 20 16:19:30 CST 2014
*/

public class CourseManagerImpl extends CommonManagerImpl implements CourseManager
{

    public CourseManagerImpl()
    {
    }

    public CourseDAO getGenericDAO()
    {
        return (CourseDAO)super.getGenericDAO();
    }

    public void setGenericDAO(CourseDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveCourse(Course val)
    {
        getGenericDAO().saveCourse(val);
    }

    public void removeCourse(Course val)
    {
        getGenericDAO().removeCourse(val);
    }

    public void removeCourse(Long id)
    {
        getGenericDAO().removeCourse(id);
    }

    public Course getCourseById(Long id)
    {
         return getGenericDAO().findCourseById(id);
    }

    public List<Course> getCourseList()
    {
        return getGenericDAO().findAllCourse();
    }
}

