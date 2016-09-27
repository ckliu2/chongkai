package tncc.wpc.web.action;

import tncc.wpc.value.*;
import tncc.wpc.service.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;

import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.*;
import com.common.value.*;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Feb 10 14:04:08 CST 2010
*/

public class SecurityAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private Security security;
    private Long[] membersIds;
    private Long[] selectedSecurityIds;

    public SecurityAction()
    {
        log = LogFactory.getLog(tncc.wpc.web.action.SecurityAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("SECURITY");
    }

    public Security getSecurity()
    {
        return security;
    }

    public void setSecurity(Security val)
    {
        security = val;
    }

    public void setGenericManager(wpcManager m)
    {
        super.setGenericManager(m);
    }

    public wpcManager getGenericManager()
    {
        return (wpcManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeSecurity(security.getId());
        return DELETE;
    }

    public String edit()
    {
        if (security == null) {
            security = new Security();
        } else if (security.getId() != null) {
            security = getGenericManager().getSecurityById(security.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedSecurityIds != null && selectedSecurityIds.length > 0) {
            Security obj = getGenericManager().getSecurityById(selectedSecurityIds[0]);
            obj.setId(null);
            security = obj;
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
            if (inputValidation(security) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(Security val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveSecurity(security);
        return SUCCESS;
    }

    public String list()
    {
        return SUCCESS;
    }

    protected void beanToForm()
    {
        log.info("enter beanToForm()");
        
        membersIds = getGenericManager().getIdFromMemberList(security.getMembers());
        log.info("exit beanToForm()");
    }

    protected void formToBean()
    {
        log.info("enter formToBean()");
        
        SessionUser s=(SessionUser)getSession().getAttribute("user");  
        security.setCreatedDate(Tools.getCurrentTimestamp());      
        security.setCreatedUser(s.getMember());  
        security.setMember(s.getMember()); 
        security.setMembers(getGenericManager().getMemberListById(membersIds)); 
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

    public List<Security> getSecurityList()
    {
        return getGenericManager().getSecurityList();
    }

    public void setSelectedSecurityIds(Long[] val)
    {
        selectedSecurityIds = val;
    }

    public Long[] getSelectedSecurityIds()
    {
        return selectedSecurityIds;
    }
    
    public List getMemberList()
    {    	
    	 ArrayList<Member> al = new ArrayList<Member>();
    	  if(security.getMembers()==null){
    		  return al;
    	  }else{
    		  return security.getMembers();
    	  }    
    }
}
