package tncc.reserve.web.action;

import tncc.reserve.value.Course;
import tncc.reserve.service.CourseManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Mar 20 16:19:30 CST 2014
*/

public class CourseAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private Course course;
    private Long[] selectedCourseIds;

    public CourseAction()
    {
        log = LogFactory.getLog(tncc.reserve.web.action.CourseAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("COURSE");
    }

    public Course getCourse()
    {
        return course;
    }

    public void setCourse(Course val)
    {
        course = val;
    }

    public void setGenericManager(CourseManager m)
    {
        super.setGenericManager(m);
    }

    public CourseManager getGenericManager()
    {
        return (CourseManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeCourse(course.getId());
        return DELETE;
    }

    public String edit()
    {
        if (course == null) {
            course = new Course();
        } else if (course.getId() != null) {
            course = getGenericManager().getCourseById(course.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedCourseIds != null && selectedCourseIds.length > 0) {
            Course obj = getGenericManager().getCourseById(selectedCourseIds[0]);
            obj.setId(null);
            course = obj;
        }
        beanToForm();

        return SUCCESS;
    }

    public String execute()
    {
        log.info("entering 'execute' method");
        if (getDelete() != null) {
            return delete();
        } else {
            formToBean();
            if (inputValidation(course) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(Course val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveCourse(course);
        return SUCCESS;
    }

    public String list()
    {
        return SUCCESS;
    }

    protected void beanToForm()
    {
        log.info("enter beanToForm()");
        log.info("exit beanToForm()");
    }

    protected void formToBean()
    {
        log.info("enter formToBean()");
        log.info("exit formToBean()");
    }
    public List<Course> getCourseList()
    {
        return getGenericManager().getCourseList();
    }

    public void setSelectedCourseIds(Long[] val)
    {
        selectedCourseIds = val;
    }

    public Long[] getSelectedCourseIds()
    {
        return selectedCourseIds;
    }
}
