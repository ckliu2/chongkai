package com.city.dao;

import com.base.value.AppProperty;
import com.city.value.*;

import java.util.*;

import com.common.dao.CommonDAO;
import com.common.value.Member;


public interface CityDAO extends CommonDAO 
{
    //Course
    public abstract void saveCourse(Course val);
    public abstract void removeCourse(Course val);
    public abstract void removeCourse(Long id);
    public abstract Course findCourseById(Long id);
    public abstract List<Course> findAllCourse();  
    public abstract List<CourseMember> getCourseMemberListByCourse(Course course);
    public abstract boolean isExistCourseMember(Course course,Member member);
    public abstract void deleteCourseMember(Course course,Member member);
    public abstract Course getLastCourse(AppProperty type);
    public abstract List<Course> getCourseTypeList(AppProperty type);
    public abstract Set getCoursePhotosByIds(Long[] ids);
    
    //CourseMember    
    public abstract void saveCourseMember(CourseMember val);
    public abstract void removeCourseMember(CourseMember val);
    public abstract void removeCourseMember(Long id);
    public abstract CourseMember findCourseMemberById(Long id);
    public abstract List<CourseMember> findAllCourseMember();
    public abstract CourseMember getCourseMember(Course course,Member member);
    public abstract List<CourseMember> getCourseMemberListByMember(Member member);
}

