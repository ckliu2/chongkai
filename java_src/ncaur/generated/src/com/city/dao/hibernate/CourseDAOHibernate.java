package com.city.dao.hibernate;

import com.city.value.Course;
import com.city.dao.CourseDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu May 19 17:41:56 CST 2016
*/

public class CourseDAOHibernate extends CommonDAOHibernate implements CourseDAO
{

    public CourseDAOHibernate()
    {
    }

    public void saveCourse(Course val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeCourse(Course val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeCourse(Long id)
    {
        Course obj = findCourseById(id);
        getHibernateTemplate().delete(obj);
    }

    public Course findCourseById(Long id)
    {
        if (id == null)
            return null;
        Course obj = (Course)getHibernateTemplate().get(com.city.value.Course.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(com.city.value.Course.class, id);
        else
            return obj;
    }

    public List<Course> findAllCourse()
    {
        return getHibernateTemplate().find("from Course");
    }
    public List<UploadedFile> findCoursefileList()
    {
        return new ArrayList<UploadedFile>(); // TODO
    }

    public List<UploadedFile> findEmailfileList()
    {
        return new ArrayList<UploadedFile>(); // TODO
    }

    public Long[] getIdsFromGroupList(List tlist)
    {
        ArrayList<Long> al = new ArrayList<Long>();
        if (tlist != null) {
            for (int i = 0; i < tlist.size(); i++) {
                Group t = (Group) tlist.get(i);
                if (t != null)
                    al.add(t.getId());
            }
        }
        Long lng[] = new Long[al.size()];
        al.toArray(lng);
        
        return lng;
    }

    public List getGroupListByIds(Long[] ids)
    {
        ArrayList<Group> al = new ArrayList<Group>();
        if (ids != null) {
            for (int i = 0; i < ids.length; i++) {
                Group t = (Group) findGroupById(ids[i]);
                if (t != null)
                    al.add(t);
            }
        }
        return al;
    }
    public Long[] getIdsFromUploadedFileList(List tlist)
    {
        ArrayList<Long> al = new ArrayList<Long>();
        if (tlist != null) {
            for (int i = 0; i < tlist.size(); i++) {
                UploadedFile t = (UploadedFile) tlist.get(i);
                if (t != null)
                    al.add(t.getId());
            }
        }
        Long lng[] = new Long[al.size()];
        al.toArray(lng);
        
        return lng;
    }

    public List getUploadedFileListByIds(Long[] ids)
    {
        ArrayList<UploadedFile> al = new ArrayList<UploadedFile>();
        if (ids != null) {
            for (int i = 0; i < ids.length; i++) {
                UploadedFile t = (UploadedFile) findUploadedFileById(ids[i]);
                if (t != null)
                    al.add(t);
            }
        }
        return al;
    }
}

