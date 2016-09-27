package com.web.web.action;

import com.web.value.AgreeTerms;
import com.web.service.AgreeTermsManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu May 19 17:41:56 CST 2016
*/

public class AgreeTermsAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private AgreeTerms agreeTerms;
    private Long[] selectedAgreeTermsIds;

    public AgreeTermsAction()
    {
        log = LogFactory.getLog(com.web.web.action.AgreeTermsAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("AGREETERMS");
    }

    public AgreeTerms getAgreeTerms()
    {
        return agreeTerms;
    }

    public void setAgreeTerms(AgreeTerms val)
    {
        agreeTerms = val;
    }

    public void setGenericManager(AgreeTermsManager m)
    {
        super.setGenericManager(m);
    }

    public AgreeTermsManager getGenericManager()
    {
        return (AgreeTermsManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeAgreeTerms(agreeTerms.getId());
        return DELETE;
    }

    public String edit()
    {
        if (agreeTerms == null) {
            agreeTerms = new AgreeTerms();
        } else if (agreeTerms.getId() != null) {
            agreeTerms = getGenericManager().getAgreeTermsById(agreeTerms.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedAgreeTermsIds != null && selectedAgreeTermsIds.length > 0) {
            AgreeTerms obj = getGenericManager().getAgreeTermsById(selectedAgreeTermsIds[0]);
            obj.setId(null);
            agreeTerms = obj;
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
            if (inputValidation(agreeTerms) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(AgreeTerms val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveAgreeTerms(agreeTerms);
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
        log.info("exit formToBean()");
    }
    public List<AgreeTerms> getAgreeTermsList()
    {
        return getGenericManager().getAgreeTermsList();
    }

    public void setSelectedAgreeTermsIds(Long[] val)
    {
        selectedAgreeTermsIds = val;
    }

    public Long[] getSelectedAgreeTermsIds()
    {
        return selectedAgreeTermsIds;
    }
}
