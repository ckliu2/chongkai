package com.common.web.action;

import com.common.value.*;
import com.common.service.CommonManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;

import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jun 23 14:20:09 CST 2010
*/

public class DepartmentAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private Department department;
    private Long[] membersIds;
    private Long[] selectedDepartmentIds;
	private Set<Member> newMembers = new HashSet();
    
    public DepartmentAction()
    {
        log = LogFactory.getLog(com.common.web.action.DepartmentAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("DEPARTMENT");
    }

    public Department getDepartment()
    {
        return department;
    }

    public void setDepartment(Department val)
    {
        department = val;
    }

    public void setGenericManager(CommonManager m)
    {
        super.setGenericManager(m);
    }

    public CommonManager getGenericManager()
    {
        return (CommonManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeDepartment(department.getId());
        return DELETE;
    }

    public String edit()
    {
        if (department == null) {
            department = new Department();
        } else if (department.getId() != null) {
            department = getGenericManager().getDepartmentById(department.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedDepartmentIds != null && selectedDepartmentIds.length > 0) {
            Department obj = getGenericManager().getDepartmentById(selectedDepartmentIds[0]);
            obj.setId(null);
            department = obj;
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
            if (inputValidation(department) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(Department val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        java.sql.Timestamp ts = Tools.getCurrentTimestamp();
        if (department.getId() == null) {
            department.setCreatedDate(ts);
            department.setCreatedUser(getSessionUser().getLoginId());
        }
        department.setLastModifiedDate(ts);
        department.setLastModifiedUser(getSessionUser().getLoginId());
        getGenericManager().saveDepartment(department);
        return SUCCESS;
    }

    public String list()
    {
        return SUCCESS;
    }

    protected void beanToForm()
    {
        log.info("enter beanToForm()");
        membersIds = getGenericManager().getIdsFromMemberList(department.getMembers());
        log.info("exit beanToForm()");
    }

    protected void formToBean()
    {
        log.info("enter formToBean()");
        department.setMembers(getGenericManager().getMemberListByIds(membersIds)); 
        log.info("exit formToBean()");
    }

    public void setMembersIds(Long[] val)
    {
        membersIds = val;
    }

    public Long[] getMembersIds()
    {
        return membersIds;
    }

    public List<Department> getDepartmentList()
    {
        return getGenericManager().getDepartmentList();
    }

    public void setSelectedDepartmentIds(Long[] val)
    {
        selectedDepartmentIds = val;
    }

    public Long[] getSelectedDepartmentIds()
    {
        return selectedDepartmentIds;
    }
    
    public Set<Member> getNewMembers() {
		return newMembers;
	}

	public void setNewMembers(Set<Member> newMembers) {
		this.newMembers = newMembers;
	}
    
    public List<Member> getMemberList()
    {
        List<Member> al = getGenericManager().getMemberList();
        if (al != null) {        	
    	Set members=department.getMembers();
   		 if(members!=null){
   	        Iterator i = department.getMembers().iterator(); 
   	    		 while (i.hasNext()) {
   	    			Member m= (Member) i.next();   	               
   	                al.remove(m);
   	         } 
   		  }   		 
        }
        return  al;
    }
    
    public Set<Member> getObject_memberList()
    {
    	Set members=department.getMembers();
		 if(members!=null){
			 return department.getMembers();
		 }else{
			 return   newMembers;
		 }
    }
}
