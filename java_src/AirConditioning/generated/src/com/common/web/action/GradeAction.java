package com.common.web.action;

import com.common.value.Grade;
import com.common.service.GradeManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Dec 12 16:17:33 CST 2013
*/

public class GradeAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private Grade grade;
    private Long[] membersIds;
    private Long[] selectedGradeIds;

    public GradeAction()
    {
        log = LogFactory.getLog(com.common.web.action.GradeAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("GRADE");
    }

    public Grade getGrade()
    {
        return grade;
    }

    public void setGrade(Grade val)
    {
        grade = val;
    }

    public void setGenericManager(GradeManager m)
    {
        super.setGenericManager(m);
    }

    public GradeManager getGenericManager()
    {
        return (GradeManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeGrade(grade.getId());
        return DELETE;
    }

    public String edit()
    {
        if (grade == null) {
            grade = new Grade();
        } else if (grade.getId() != null) {
            grade = getGenericManager().getGradeById(grade.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedGradeIds != null && selectedGradeIds.length > 0) {
            Grade obj = getGenericManager().getGradeById(selectedGradeIds[0]);
            obj.setId(null);
            grade = obj;
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
            if (inputValidation(grade) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(Grade val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveGrade(grade);
        return SUCCESS;
    }

    public String list()
    {
        return SUCCESS;
    }

    protected void beanToForm()
    {
        log.info("enter beanToForm()");
        membersIds = getGenericManager().getIdsFromMemberList(grade.getMembers());
        log.info("exit beanToForm()");
    }

    protected void formToBean()
    {
        log.info("enter formToBean()");
        grade.setMembers(getGenericManager().getMemberListByIds(membersIds)); 
        log.info("exit formToBean()");
    }
    public List<Set> getMembersList()
    {
        return getGenericManager().getMembersList(); // TODO
    }

    public void setMembersIds(Long[] val)
    {
        membersIds = val;
    }

    public Long[] getMembersIds()
    {
        return membersIds;
    }

    public List<Grade> getGradeList()
    {
        return getGenericManager().getGradeList();
    }

    public void setSelectedGradeIds(Long[] val)
    {
        selectedGradeIds = val;
    }

    public Long[] getSelectedGradeIds()
    {
        return selectedGradeIds;
    }
}
