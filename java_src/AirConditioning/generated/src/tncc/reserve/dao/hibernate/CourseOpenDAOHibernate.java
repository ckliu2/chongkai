package tncc.reserve.dao.hibernate;

import tncc.reserve.value.CourseOpen;
import tncc.reserve.dao.CourseOpenDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Mar 20 16:19:30 CST 2014
*/

public class CourseOpenDAOHibernate extends CommonDAOHibernate implements CourseOpenDAO
{

    public CourseOpenDAOHibernate()
    {
    }

    public void saveCourseOpen(CourseOpen val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeCourseOpen(CourseOpen val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeCourseOpen(Long id)
    {
        CourseOpen obj = findCourseOpenById(id);
        getHibernateTemplate().delete(obj);
    }

    public CourseOpen findCourseOpenById(Long id)
    {
        if (id == null)
            return null;
        CourseOpen obj = (CourseOpen)getHibernateTemplate().get(tncc.reserve.value.CourseOpen.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(tncc.reserve.value.CourseOpen.class, id);
        else
            return obj;
    }

    public List<CourseOpen> findAllCourseOpen()
    {
        return getHibernateTemplate().find("from CourseOpen");
    }
    public List<Course> findCourseList()
    {
        return new ArrayList<Course>(); // TODO
    }

    public List<Member> findTeacherList()
    {
        return new ArrayList<Member>(); // TODO
    }

    public List<ClassRoom> findClassroomList()
    {
        return new ArrayList<ClassRoom>(); // TODO
    }

}

