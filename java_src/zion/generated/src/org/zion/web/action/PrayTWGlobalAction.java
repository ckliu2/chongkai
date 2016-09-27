package org.zion.web.action;

import org.zion.value.PrayTWGlobal;
import org.zion.service.PrayTWGlobalManager;
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

public class PrayTWGlobalAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private PrayTWGlobal prayTWGlobal;
    private Long[] selectedPrayTWGlobalIds;

    public PrayTWGlobalAction()
    {
        log = LogFactory.getLog(org.zion.web.action.PrayTWGlobalAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("PRAYTWGLOBAL");
    }

    public PrayTWGlobal getPrayTWGlobal()
    {
        return prayTWGlobal;
    }

    public void setPrayTWGlobal(PrayTWGlobal val)
    {
        prayTWGlobal = val;
    }

    public void setGenericManager(PrayTWGlobalManager m)
    {
        super.setGenericManager(m);
    }

    public PrayTWGlobalManager getGenericManager()
    {
        return (PrayTWGlobalManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removePrayTWGlobal(prayTWGlobal.getId());
        return DELETE;
    }

    public String edit()
    {
        if (prayTWGlobal == null) {
            prayTWGlobal = new PrayTWGlobal();
        } else if (prayTWGlobal.getId() != null) {
            prayTWGlobal = getGenericManager().getPrayTWGlobalById(prayTWGlobal.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedPrayTWGlobalIds != null && selectedPrayTWGlobalIds.length > 0) {
            PrayTWGlobal obj = getGenericManager().getPrayTWGlobalById(selectedPrayTWGlobalIds[0]);
            obj.setId(null);
            prayTWGlobal = obj;
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
            if (inputValidation(prayTWGlobal) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(PrayTWGlobal val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().savePrayTWGlobal(prayTWGlobal);
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
    public List<PrayTWGlobal> getPrayTWGlobalList()
    {
        return getGenericManager().getPrayTWGlobalList();
    }

    public void setSelectedPrayTWGlobalIds(Long[] val)
    {
        selectedPrayTWGlobalIds = val;
    }

    public Long[] getSelectedPrayTWGlobalIds()
    {
        return selectedPrayTWGlobalIds;
    }
}