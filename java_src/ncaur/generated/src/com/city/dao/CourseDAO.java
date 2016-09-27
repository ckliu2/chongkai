package com.city.dao;

import com.city.value.Course;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu May 19 17:41:56 CST 2016
*/

public interface CourseDAO extends CommonDAO 
{
    public abstract void saveCourse(Course val);

    public abstract void removeCourse(Course val);

    public abstract void removeCourse(Long id);

    public abstract Course findCourseById(Long id);

    public abstract List<Course> findAllCourse();
    public abstract List<UploadedFile> findCoursefileList();
    public abstract List<UploadedFile> findEmailfileList();
    public abstract Long[] getIdsFromGroupList(List<Group> lst);

    public abstract List<Group> getGroupListByIds(Long[] ids);

    public abstract Long[] getIdsFromUploadedFileList(List<UploadedFile> lst);

    public abstract List<UploadedFile> getUploadedFileListByIds(Long[] ids);

}

