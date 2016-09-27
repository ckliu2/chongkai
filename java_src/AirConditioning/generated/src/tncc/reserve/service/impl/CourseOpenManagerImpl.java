package tncc.reserve.service.impl;

import tncc.reserve.service.CourseOpenManager;
import tncc.reserve.dao.CourseOpenDAO;
import tncc.reserve.value.CourseOpen;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Mar 20 16:19:30 CST 2014
*/

public class CourseOpenManagerImpl extends CommonManagerImpl implements CourseOpenManager
{

    public CourseOpenManagerImpl()
    {
    }

    public CourseOpenDAO getGenericDAO()
    {
        return (CourseOpenDAO)super.getGenericDAO();
    }

    public void setGenericDAO(CourseOpenDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveCourseOpen(CourseOpen val)
    {
        getGenericDAO().saveCourseOpen(val);
    }

    public void removeCourseOpen(CourseOpen val)
    {
        getGenericDAO().removeCourseOpen(val);
    }

    public void removeCourseOpen(Long id)
    {
        getGenericDAO().removeCourseOpen(id);
    }

    public CourseOpen getCourseOpenById(Long id)
    {
         return getGenericDAO().findCourseOpenById(id);
    }

    public List<CourseOpen> getCourseOpenList()
    {
        return getGenericDAO().findAllCourseOpen();
    }
    public List<Course> getCourseList()
    {
        return getGenericDAO().findCourseList();
    }

    public List<Member> getTeacherList()
    {
        return getGenericDAO().findTeacherList();
    }

    public List<ClassRoom> getClassroomList()
    {
        return getGenericDAO().findClassroomList();
    }

}

