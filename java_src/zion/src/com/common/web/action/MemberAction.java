package com.common.web.action;

import com.common.value.*;
import com.common.service.CommonManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.*;

public class MemberAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private Member member;
    private Long[] groupsIds;
    private Long[] gradesIds;
    private Long[] teamsIds;
	private Set<Group> newGroups = new HashSet();
    private Set<Grade> newGrades = new HashSet();
    private Set<Team> newTeams = new HashSet();
    private String keyword="";
    
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
        }
        member.setLastModifiedDate(ts);
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
    
    public List<Group> getGroupsList()
    {
        return getGenericManager().getGroupList();
    }
    
    
    public List<Group> getGroupList()
    {
        List<Group> al = getGenericManager().getGroupList();
        if (al != null) {
    		Set groups=member.getGroups();
   		    if(groups!=null){
   	        Iterator i = member.getGroups().iterator(); 
   	    		 while (i.hasNext()) {
   	    			Group g= (Group) i.next();   	               
   	                al.remove(g);
   	            } 
   		     }    		
           }
        return al;
    }
    
    public Set<Group> getObject_groupList()
    {
    	Set groups=member.getGroups();
		 if(groups!=null){
			 return member.getGroups();
		 }else{
			 return   newGroups;
		 }   	
    }
    
       
	public List<Grade> getGradeAllList()
    {
        List<Grade> al = getGenericManager().getGradeList();
        if (al != null) {   
    	 Set grades=member.getGrades();
   		 if(grades!=null){
   	        Iterator i = member.getGrades().iterator(); 
   	    		 while (i.hasNext()) {
   	    			Grade g= (Grade) i.next();
   	                al.remove(g);
   	         } 
   		   }        	
        }
        return  al;
    }
	
	public Set<Grade> getGrade_memberList(){		 
     	Set grades=member.getGrades();
          if(grades!=null){
            return member.getGrades();
          }else{
              return  newGrades;
          }
	}

	
	public List<Team> getTeamAllList()
    {
        List<Team> al = getGenericManager().getTeamList();
        if (al != null) {   
    	 Set teams=member.getTeams();
   		 if(teams!=null){
   	        Iterator i = member.getTeams().iterator(); 
   	    		 while (i.hasNext()) {
   	    			Team t= (Team) i.next();
   	                al.remove(t);
   	         } 
   		   }        	
        }
        return  al;
    }
	
	public Set<Team> getTeam_memberList(){		 
     	Set teams=member.getTeams();
          if(teams!=null){
            return member.getTeams();
          }else{
              return   newTeams;
          }
	}
	
	
    public void setGroupsIds(Long[] val)
    {
        groupsIds = val;
    }

    public Long[] getGroupsIds()
    {
        return groupsIds;
    }

    public List<Grade> getGradesList()
    {
        return getGenericManager().getGradeList();
    }

    public void setGradesIds(Long[] val)
    {
        gradesIds = val;
    }

    public Long[] getGradesIds()
    {
        return gradesIds;
    }

    public List<Unit> getUnitsList()
    {
        return getGenericManager().getUnitList();
    }


    public List<Team> getTeamsList()
    {
        return getGenericManager().getTeamList();
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
    	
    	if(!keyword.equals("")){   
    		System.out.println("keyword is not null");
    		return getGenericManager().getQueryMemberList(keyword.trim());
    		
    	}else{
    		System.out.println("keyword is null");
    		return getGenericManager().getMemberList();
    	}  
    	
    }

      
    public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}
