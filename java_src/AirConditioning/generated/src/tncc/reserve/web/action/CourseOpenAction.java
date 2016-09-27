package tncc.reserve.web.action;

import tncc.reserve.value.CourseOpen;
import tncc.reserve.service.CourseOpenManager;
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

public class CourseOpenAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private CourseOpen courseOpen;
    private Long[] selectedCourseOpenIds;

    public CourseOpenAction()
    {
        log = LogFactory.getLog(tncc.reserve.web.action.CourseOpenAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("COURSEOPEN");
    }

    public CourseOpen getCourseOpen()
    {
        return courseOpen;
    }

    public void setCourseOpen(CourseOpen val)
    {
        courseOpen = val;
    }

    public void setGenericManager(CourseOpenManager m)
    {
        super.setGenericManager(m);
    }

    public CourseOpenManager getGenericManager()
    {
        return (CourseOpenManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeCourseOpen(courseOpen.getId());
        return DELETE;
    }

    public String edit()
    {
        if (courseOpen == null) {
            courseOpen = new CourseOpen();
        } else if (courseOpen.getId() != null) {
            courseOpen = getGenericManager().getCourseOpenById(courseOpen.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedCourseOpenIds != null && selectedCourseOpenIds.length > 0) {
            CourseOpen obj = getGenericManager().getCourseOpenById(selectedCourseOpenIds[0]);
            obj.setId(null);
            courseOpen = obj;
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
            if (inputValidation(courseOpen) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(CourseOpen val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveCourseOpen(courseOpen);
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
        courseOpen.setCourse(getGenericManager().getCourseById(courseOpen.getCourseId())); 
        courseOpen.setTeacher(getGenericManager().getMemberById(courseOpen.getTeacherId())); 
        courseOpen.setClassroom(getGenericManager().getClassRoomById(courseOpen.getClassroomId())); 
        log.info("exit formToBean()");
    }
    public List<Course> getCourseList()
    {
        return getGenericManager().getCourseList(); // TODO
    }

    public List<Member> getTeacherList()
    {
        return getGenericManager().getTeacherList(); // TODO
    }

    public List<ClassRoom> getClassroomList()
    {
        return getGenericManager().getClassroomList(); // TODO
    }

    public List<CourseOpen> getCourseOpenList()
    {
        return getGenericManager().getCourseOpenList();
    }

    public void setSelectedCourseOpenIds(Long[] val)
    {
        selectedCourseOpenIds = val;
    }

    public Long[] getSelectedCourseOpenIds()
    {
        return selectedCourseOpenIds;
    }
}
