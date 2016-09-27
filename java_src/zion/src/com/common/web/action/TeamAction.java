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
    Created Date: Thu Jun 10 10:24:23 CST 2010
*/

public class TeamAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private Team team;
    private Long[] membersIds;
    private Long[] selectedTeamIds;
    private Set<Member> newMembers = new HashSet();

    public TeamAction()
    {
        log = LogFactory.getLog(com.common.web.action.TeamAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("TEAM");
    }

    public Team getTeam()
    {
        return team;
    }

    public void setTeam(Team val)
    {
        team = val;
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
        getGenericManager().removeTeam(team.getId());
        return DELETE;
    }

    public String edit()
    {
        if (team == null) {
            team = new Team();
        } else if (team.getId() != null) {
            team = getGenericManager().getTeamById(team.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedTeamIds != null && selectedTeamIds.length > 0) {
            Team obj = getGenericManager().getTeamById(selectedTeamIds[0]);
            obj.setId(null);
            team = obj;
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
            if (inputValidation(team) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(Team val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveTeam(team);
        return SUCCESS;
    }

    public String list()
    {
        return SUCCESS;
    }

    protected void beanToForm()
    {
        log.info("enter beanToForm()");
        membersIds = getGenericManager().getIdsFromMemberList(team.getMembers());
        log.info("exit beanToForm()");
    }

    protected void formToBean()
    {
        log.info("enter formToBean()");
        team.setPrimaryLeader(getGenericManager().getMemberById(team.getPrimaryLeaderId())); 
        team.setSecondLeader(getGenericManager().getMemberById(team.getSecondLeaderId())); 
        team.setMembers(getGenericManager().getMemberListByIds(membersIds)); 
        log.info("exit formToBean()");
    }


    public List<Member> getMembersList()
    {
        return getGenericManager().getMemberList(); // TODO
    }
    
    
    public List<Member> getMemberList()
    {
        List<Member> al = getGenericManager().getMemberList();
        if (al != null) {        	
    	Set members=team.getMembers();
   		 if(members!=null){
   	        Iterator i = team.getMembers().iterator(); 
   	    		 while (i.hasNext()) {
   	    			Member m= (Member) i.next();   	               
   	                al.remove(m);
   	         } 
   		  }   		 
        }
        return  al;
    }
    
    public Set<Member> getTeam_memberList()
    {
    	Set members=team.getMembers();
		 if(members!=null){
			 return team.getMembers();
		 }else{
			 return   newMembers;
		 }
    }

    public void setMembersIds(Long[] val)
    {
        membersIds = val;
    }

    public Long[] getMembersIds()
    {
        return membersIds;
    }

    public List<Team> getTeamList()
    {
        return getGenericManager().getTeamList();
    }

    public void setSelectedTeamIds(Long[] val)
    {
        selectedTeamIds = val;
    }

    public Long[] getSelectedTeamIds()
    {
        return selectedTeamIds;
    }
    
    public List<Member> getPrimaryLeaderList()
    {
    	/*ArrayList<Member> al = new ArrayList<Member>();
    	Member m=team.getPrimaryLeader();
    	 if(m!=null){
    	   al.add(m);
    	 }
    	return al;*/
    	return getGenericManager().getMemberList(); // TODO
    }

    public List<Member> getSecondLeaderList()
    {
    	/*ArrayList<Member> al = new ArrayList<Member>();
    	Member m=team.getSecondLeader();
   	     if(m!=null){
   	       al.add(m);
   	     }    
    	return al;*/
    	return getGenericManager().getMemberList(); // TODO
    }
}
