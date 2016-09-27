package org.zion.web.action;

import org.zion.value.*;
import org.zion.service.PrayManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.*;

import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;


public class PrayMeAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private PrayMe prayMe;
    private Long[] selectedPrayMeIds;
    int active;

    public PrayMeAction()
    {
        log = LogFactory.getLog(org.zion.web.action.PrayMeAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("PRAYME");
    }

    public PrayMe getPrayMe()
    {
        return prayMe;
    }

    public void setPrayMe(PrayMe val)
    {
        prayMe = val;
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
        getGenericManager().removePrayMe(prayMe.getId());
        return DELETE;
    }

    public String edit()
    {
        if (prayMe == null) {
            prayMe = new PrayMe();
        } else if (prayMe.getId() != null) {
            prayMe = getGenericManager().getPrayMeById(prayMe.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedPrayMeIds != null && selectedPrayMeIds.length > 0) {
            PrayMe obj = getGenericManager().getPrayMeById(selectedPrayMeIds[0]);
            obj.setId(null);
            prayMe = obj;
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
            if (inputValidation(prayMe) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(PrayMe val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().savePrayMe(prayMe);
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
        prayMe.setMember(getGenericManager().getMemberById(prayMe.getMemberId())); 
        log.info("exit formToBean()");
    }
    
    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public List<PrayMe> getPrayMeList()
    {
        return getGenericManager().getPrayMeList();
    }

    public void setSelectedPrayMeIds(Long[] val)
    {
        selectedPrayMeIds = val;
    }

    public Long[] getSelectedPrayMeIds()
    {
        return selectedPrayMeIds;
    }
    
    public JSONObject delPrayMe() throws JSONException {
   	JSONObject p = new JSONObject();
   	try {
   	 System.out.println("prayMe.id="+prayMe.getId());   	
   	 getGenericManager().removePrayMe(prayMe.getId());
   	} catch (Exception e) {	   
	    System.out.println("delPrayMe=" + e.toString());
	}
	return p;
    }
    
    public JSONObject displaypray() throws JSONException {
   	JSONObject p = new JSONObject();
   	try {
   	 System.out.println("prayMe.id="+prayMe.getId());   	 
   	 prayMe=getGenericManager().getPrayMeById(prayMe.getId());
   	
   	 if(active==1){
   	  prayMe.setActive(true);
   	 }else{
   	  prayMe.setActive(false);
   	 }
   	 getGenericManager().savePrayMe(prayMe);   	
   	} catch (Exception e) {	   
	    System.out.println("delPrayMe=" + e.toString());
	}
	return p;
    }
    
}
