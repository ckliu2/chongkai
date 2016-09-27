package org.zion.web.action;

import org.zion.value.PrayMe;
import org.zion.service.PrayMeManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jan 07 15:37:44 CST 2015
*/

public class PrayMeAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private PrayMe prayMe;
    private Long[] selectedPrayMeIds;

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

    public void setGenericManager(PrayMeManager m)
    {
        super.setGenericManager(m);
    }

    public PrayMeManager getGenericManager()
    {
        return (PrayMeManager) super.getGenericManager();
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
    public List<Member> getMemberList()
    {
        return getGenericManager().getMemberList(); // TODO
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
}
