package com.city.web.action;

import com.city.value.CourseMember;
import com.city.service.CourseMemberManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu May 19 17:41:56 CST 2016
*/

public class CourseMemberAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private CourseMember courseMember;
    private Long[] selectedCourseMemberIds;

    public CourseMemberAction()
    {
        log = LogFactory.getLog(com.city.web.action.CourseMemberAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("COURSEMEMBER");
    }

    public CourseMember getCourseMember()
    {
        return courseMember;
    }

    public void setCourseMember(CourseMember val)
    {
        courseMember = val;
    }

    public void setGenericManager(CourseMemberManager m)
    {
        super.setGenericManager(m);
    }

    public CourseMemberManager getGenericManager()
    {
        return (CourseMemberManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeCourseMember(courseMember.getId());
        return DELETE;
    }

    public String edit()
    {
        if (courseMember == null) {
            courseMember = new CourseMember();
        } else if (courseMember.getId() != null) {
            courseMember = getGenericManager().getCourseMemberById(courseMember.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedCourseMemberIds != null && selectedCourseMemberIds.length > 0) {
            CourseMember obj = getGenericManager().getCourseMemberById(selectedCourseMemberIds[0]);
            obj.setId(null);
            courseMember = obj;
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
            if (inputValidation(courseMember) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(CourseMember val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        java.sql.Timestamp ts = Tools.getCurrentTimestamp();
        if (courseMember.getId() == null) {
            courseMember.setCreatedDate(ts);
            courseMember.setCreatedUser(getSessionUser().getLoginId());
        }
        courseMember.setLastModifiedDate(ts);
        courseMember.setLastModifiedUser(getSessionUser().getLoginId());
        getGenericManager().saveCourseMember(courseMember);
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
        courseMember.setCourse(getGenericManager().getCourseById(courseMember.getCourseId())); 
        courseMember.setMember(getGenericManager().getMemberById(courseMember.getMemberId())); 
        log.info("exit formToBean()");
    }
    public List<Course> getCourseList()
    {
        return getGenericManager().getCourseList(); // TODO
    }

    public List<Member> getMemberList()
    {
        return getGenericManager().getMemberList(); // TODO
    }

    public List<CourseMember> getCourseMemberList()
    {
        return getGenericManager().getCourseMemberList();
    }

    public void setSelectedCourseMemberIds(Long[] val)
    {
        selectedCourseMemberIds = val;
    }

    public Long[] getSelectedCourseMemberIds()
    {
        return selectedCourseMemberIds;
    }
}
