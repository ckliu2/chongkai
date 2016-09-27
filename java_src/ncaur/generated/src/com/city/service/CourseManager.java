package com.city.service;

import com.city.value.Course;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu May 19 17:41:56 CST 2016
*/

public interface CourseManager extends CommonManager 
{
    public abstract void saveCourse(Course val);

    public abstract void removeCourse(Course val);

    public abstract void removeCourse(Long id);

    public abstract Course getCourseById(Long id);

    public abstract List<Course> getCourseList();
    public abstract List<UploadedFile> getCoursefileList();
    public abstract List<UploadedFile> getEmailfileList();
    public abstract Long[] getIdsFromGroupList(List<Group> lst);

    public abstract List<Group> getGroupListByIds(Long[] ids);

    public abstract Long[] getIdsFromUploadedFileList(List<UploadedFile> lst);

    public abstract List<UploadedFile> getUploadedFileListByIds(Long[] ids);

}

