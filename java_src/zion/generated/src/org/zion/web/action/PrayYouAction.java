package org.zion.web.action;

import org.zion.value.PrayYou;
import org.zion.service.PrayYouManager;
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

public class PrayYouAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private PrayYou prayYou;
    private Long[] selectedPrayYouIds;

    public PrayYouAction()
    {
        log = LogFactory.getLog(org.zion.web.action.PrayYouAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("PRAYYOU");
    }

    public PrayYou getPrayYou()
    {
        return prayYou;
    }

    public void setPrayYou(PrayYou val)
    {
        prayYou = val;
    }

    public void setGenericManager(PrayYouManager m)
    {
        super.setGenericManager(m);
    }

    public PrayYouManager getGenericManager()
    {
        return (PrayYouManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removePrayYou(prayYou.getId());
        return DELETE;
    }

    public String edit()
    {
        if (prayYou == null) {
            prayYou = new PrayYou();
        } else if (prayYou.getId() != null) {
            prayYou = getGenericManager().getPrayYouById(prayYou.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedPrayYouIds != null && selectedPrayYouIds.length > 0) {
            PrayYou obj = getGenericManager().getPrayYouById(selectedPrayYouIds[0]);
            obj.setId(null);
            prayYou = obj;
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
            if (inputValidation(prayYou) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(PrayYou val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().savePrayYou(prayYou);
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
        prayYou.setPrayme(getGenericManager().getPrayMeById(prayYou.getPraymeId())); 
        prayYou.setMember(getGenericManager().getMemberById(prayYou.getMemberId())); 
        log.info("exit formToBean()");
    }
    public List<PrayMe> getPraymeList()
    {
        return getGenericManager().getPraymeList(); // TODO
    }

    public List<Member> getMemberList()
    {
        return getGenericManager().getMemberList(); // TODO
    }

    public List<PrayYou> getPrayYouList()
    {
        return getGenericManager().getPrayYouList();
    }

    public void setSelectedPrayYouIds(Long[] val)
    {
        selectedPrayYouIds = val;
    }

    public Long[] getSelectedPrayYouIds()
    {
        return selectedPrayYouIds;
    }
}
