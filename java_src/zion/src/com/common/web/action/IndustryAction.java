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
    Created Date: Thu Jun 10 16:17:09 CST 2010
*/

public class IndustryAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private Industry industry;
    private Long[] membersIds;
    private Long[] selectedIndustryIds;
	private Set<Member> newMembers = new HashSet();

    public IndustryAction()
    {
        log = LogFactory.getLog(com.common.web.action.IndustryAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("INDUSTRY");
    }

    public Industry getIndustry()
    {
        return industry;
    }

    public void setIndustry(Industry val)
    {
        industry = val;
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
        getGenericManager().removeIndustry(industry.getId());
        return DELETE;
    }

    public String edit()
    {
        if (industry == null) {
            industry = new Industry();
        } else if (industry.getId() != null) {
            industry = getGenericManager().getIndustryById(industry.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedIndustryIds != null && selectedIndustryIds.length > 0) {
            Industry obj = getGenericManager().getIndustryById(selectedIndustryIds[0]);
            obj.setId(null);
            industry = obj;
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
            if (inputValidation(industry) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(Industry val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveIndustry(industry);
        return SUCCESS;
    }

    public String list()
    {
        return SUCCESS;
    }

    protected void beanToForm()
    {
        log.info("enter beanToForm()");
        membersIds = getGenericManager().getIdsFromMemberList(industry.getMembers());
        log.info("exit beanToForm()");
    }

    protected void formToBean()
    {
        log.info("enter formToBean()");
        industry.setMembers(getGenericManager().getMemberListByIds(membersIds)); 
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

    public List<Industry> getIndustryList()
    {
        return getGenericManager().getIndustryList();
    }

    public void setSelectedIndustryIds(Long[] val)
    {
        selectedIndustryIds = val;
    }

    public Long[] getSelectedIndustryIds()
    {
        return selectedIndustryIds;
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
    	Set members=industry.getMembers();
   		 if(members!=null){
   	        Iterator i = industry.getMembers().iterator(); 
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
    	Set members=industry.getMembers();
		 if(members!=null){
			 return industry.getMembers();
		 }else{
			 return   newMembers;
		 }
    }
}
