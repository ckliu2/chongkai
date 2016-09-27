package tncc.reserve.dao.hibernate;

import tncc.reserve.value.Course;
import tncc.reserve.dao.CourseDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Mar 20 16:19:30 CST 2014
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
        Course obj = (Course)getHibernateTemplate().get(tncc.reserve.value.Course.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(tncc.reserve.value.Course.class, id);
        else
            return obj;
    }

    public List<Course> findAllCourse()
    {
        return getHibernateTemplate().find("from Course");
    }
}

