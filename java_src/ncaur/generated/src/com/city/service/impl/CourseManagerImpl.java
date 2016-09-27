package com.city.service.impl;

import com.city.service.CourseManager;
import com.city.dao.CourseDAO;
import com.city.value.Course;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu May 19 17:41:56 CST 2016
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
    public List<UploadedFile> getCoursefileList()
    {
        return getGenericDAO().findCoursefileList();
    }

    public List<UploadedFile> getEmailfileList()
    {
        return getGenericDAO().findEmailfileList();
    }

    public Long[] getIdsFromGroupList(List<Group> lst)
    {
        return getGenericDAO().getIdsFromGroupList(lst);
    }

    public List<Group> getGroupListByIds(Long[] ids)
    {
        return getGenericDAO().getGroupListByIds(ids);
    }

    public Long[] getIdsFromUploadedFileList(List<UploadedFile> lst)
    {
        return getGenericDAO().getIdsFromUploadedFileList(lst);
    }

    public List<UploadedFile> getUploadedFileListByIds(Long[] ids)
    {
        return getGenericDAO().getUploadedFileListByIds(ids);
    }

}

