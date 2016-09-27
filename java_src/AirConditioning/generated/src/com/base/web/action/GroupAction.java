package com.base.web.action;

import com.base.value.Group;
import com.base.service.GroupManager;
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

public class GroupAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private Group group;
    private Long[] membersIds;
    private Long[] selectedGroupIds;

    public GroupAction()
    {
        log = LogFactory.getLog(com.base.web.action.GroupAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("GROUP");
    }

    public Group getGroup()
    {
        return group;
    }

    public void setGroup(Group val)
    {
        group = val;
    }

    public void setGenericManager(GroupManager m)
    {
        super.setGenericManager(m);
    }

    public GroupManager getGenericManager()
    {
        return (GroupManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeGroup(group.getId());
        return DELETE;
    }

    public String edit()
    {
        if (group == null) {
            group = new Group();
        } else if (group.getId() != null) {
            group = getGenericManager().getGroupById(group.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedGroupIds != null && selectedGroupIds.length > 0) {
            Group obj = getGenericManager().getGroupById(selectedGroupIds[0]);
            obj.setId(null);
            group = obj;
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
            if (inputValidation(group) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(Group val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveGroup(group);
        return SUCCESS;
    }

    public String list()
    {
        return SUCCESS;
    }

    protected void beanToForm()
    {
        log.info("enter beanToForm()");
        membersIds = getGenericManager().getIdsFromMemberList(group.getMembers());
        log.info("exit beanToForm()");
    }

    protected void formToBean()
    {
        log.info("enter formToBean()");
        group.setMembers(getGenericManager().getMemberListByIds(membersIds)); 
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

    public List<Group> getGroupList()
    {
        return getGenericManager().getGroupList();
    }

    public void setSelectedGroupIds(Long[] val)
    {
        selectedGroupIds = val;
    }

    public Long[] getSelectedGroupIds()
    {
        return selectedGroupIds;
    }
}
