package com.common.web.action;

import com.common.value.Member;
import com.common.service.MemberManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Dec 18 16:53:07 CST 2014
*/

public class MemberAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private Member member;
    private Long[] groupsIds;
    private Long[] gradesIds;
    private Long[] teamsIds;
    private Long[] selectedMemberIds;

    public MemberAction()
    {
        log = LogFactory.getLog(com.common.web.action.MemberAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("MEMBER");
    }

    public Member getMember()
    {
        return member;
    }

    public void setMember(Member val)
    {
        member = val;
    }

    public void setGenericManager(MemberManager m)
    {
        super.setGenericManager(m);
    }

    public MemberManager getGenericManager()
    {
        return (MemberManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeMember(member.getId());
        return DELETE;
    }

    public String edit()
    {
        if (member == null) {
            member = new Member();
        } else if (member.getId() != null) {
            member = getGenericManager().getMemberById(member.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedMemberIds != null && selectedMemberIds.length > 0) {
            Member obj = getGenericManager().getMemberById(selectedMemberIds[0]);
            obj.setId(null);
            member = obj;
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
            if (inputValidation(member) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(Member val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        java.sql.Timestamp ts = Tools.getCurrentTimestamp();
        if (member.getId() == null) {
            member.setCreatedDate(ts);
            member.setCreatedUser(getSessionUser().getLoginId());
        }
        member.setLastModifiedDate(ts);
        member.setLastModifiedUser(getSessionUser().getLoginId());
        getGenericManager().saveMember(member);
        return SUCCESS;
    }

    public String list()
    {
        return SUCCESS;
    }

    protected void beanToForm()
    {
        log.info("enter beanToForm()");
        groupsIds = getGenericManager().getIdsFromGroupList(member.getGroups());
        gradesIds = getGenericManager().getIdsFromGradeList(member.getGrades());
        teamsIds = getGenericManager().getIdsFromTeamList(member.getTeams());
        log.info("exit beanToForm()");
    }

    protected void formToBean()
    {
        log.info("enter formToBean()");
        member.setGroups(getGenericManager().getGroupListByIds(groupsIds)); 
        member.setGrades(getGenericManager().getGradeListByIds(gradesIds)); 
        member.setTeams(getGenericManager().getTeamListByIds(teamsIds)); 
        log.info("exit formToBean()");
    }
    public List<Set> getGroupsList()
    {
        return getGenericManager().getGroupsList(); // TODO
    }

    public void setGroupsIds(Long[] val)
    {
        groupsIds = val;
    }

    public Long[] getGroupsIds()
    {
        return groupsIds;
    }

    public List<Set> getGradesList()
    {
        return getGenericManager().getGradesList(); // TODO
    }

    public void setGradesIds(Long[] val)
    {
        gradesIds = val;
    }

    public Long[] getGradesIds()
    {
        return gradesIds;
    }

    public List<Set> getTeamsList()
    {
        return getGenericManager().getTeamsList(); // TODO
    }

    public void setTeamsIds(Long[] val)
    {
        teamsIds = val;
    }

    public Long[] getTeamsIds()
    {
        return teamsIds;
    }

    public List<Member> getMemberList()
    {
        return getGenericManager().getMemberList();
    }

    public void setSelectedMemberIds(Long[] val)
    {
        selectedMemberIds = val;
    }

    public Long[] getSelectedMemberIds()
    {
        return selectedMemberIds;
    }
}
