package org.zion.web.action;

import org.zion.value.*;
import org.zion.service.PrayManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;

import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;
import com.base.value.SessionUser;

import org.json.JSONArray;
import org.json.JSONObject;


public class PrayTWClaimAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private PrayTWClaim prayTWClaim;
    private Long[] selectedPrayTWClaimIds;
	PrayTW praytw;

    public PrayTWClaimAction()
    {
        log = LogFactory.getLog(org.zion.web.action.PrayTWClaimAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("PRAYTWCLAIM");
    }

    public PrayTWClaim getPrayTWClaim()
    {
        return prayTWClaim;
    }

    public void setPrayTWClaim(PrayTWClaim val)
    {
        prayTWClaim = val;
    }

    public void setGenericManager(PrayManager m)
    {
        super.setGenericManager(m);
    }

    public PrayManager getGenericManager()
    {
        return (PrayManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removePrayTWClaim(prayTWClaim.getId());
        return DELETE;
    }

    public String edit()
    {
        if (prayTWClaim == null) {
            prayTWClaim = new PrayTWClaim();
        } else if (prayTWClaim.getId() != null) {
            prayTWClaim = getGenericManager().getPrayTWClaimById(prayTWClaim.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedPrayTWClaimIds != null && selectedPrayTWClaimIds.length > 0) {
            PrayTWClaim obj = getGenericManager().getPrayTWClaimById(selectedPrayTWClaimIds[0]);
            obj.setId(null);
            prayTWClaim = obj;
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
            if (inputValidation(prayTWClaim) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(PrayTWClaim val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().savePrayTWClaim(prayTWClaim);
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
        prayTWClaim.setPraytw(getGenericManager().getPrayTWById(prayTWClaim.getPraytwId())); 
        prayTWClaim.setMember(getGenericManager().getMemberById(prayTWClaim.getMemberId())); 
        log.info("exit formToBean()");
    }
    
    
    public List<PrayTWClaim> getPrayTWClaimList()
    {
        return getGenericManager().getPrayTWClaimList();
    }

    public void setSelectedPrayTWClaimIds(Long[] val)
    {
        selectedPrayTWClaimIds = val;
    }

    public Long[] getSelectedPrayTWClaimIds()
    {
        return selectedPrayTWClaimIds;
    }
    
    public PrayTW getPraytw() {
		return praytw;
	}

	public void setPraytw(PrayTW praytw) {
		this.praytw = praytw;
	}
	
	
    
    public ArrayList<JSONObject> prayTWClaimByMember() throws Exception{   
        ArrayList<JSONObject> al = new ArrayList<JSONObject>(); 
        System.out.println("prayTWClaimByMember praytw.id="+praytw.getId());     
        try{   
          SessionUser s=(SessionUser)getSession().getAttribute("user"); 
          praytw=getGenericManager().getPrayTWById(praytw.getId());
          if(s!=null){
        	  System.out.println("s!=null");
          }else{        	  
        	  List<PrayTWClaim> ls=getGenericManager().getPrayTWClaimListByPrayTW(praytw);
        	  for(int i=0;i<ls.size();i++){
        		  PrayTWClaim claim=ls.get(i);
        		  JSONObject p = new JSONObject();
        		  p.accumulate("member",claim.getMember().getNickname());
        		  p.accumulate("createdDate",claim.getCreatedDate());
        		  al.add(p);
        	  }
        	  System.out.println("s==null");
          }
        	
        }catch(Exception e){
        	
        }
        return al;
    }    
    
}
