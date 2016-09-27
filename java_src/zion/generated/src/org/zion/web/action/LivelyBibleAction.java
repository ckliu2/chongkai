package org.zion.web.action;

import org.zion.value.LivelyBible;
import org.zion.service.LivelyBibleManager;
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

public class LivelyBibleAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private LivelyBible livelyBible;
    private Long[] selectedLivelyBibleIds;

    public LivelyBibleAction()
    {
        log = LogFactory.getLog(org.zion.web.action.LivelyBibleAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("LIVELYBIBLE");
    }

    public LivelyBible getLivelyBible()
    {
        return livelyBible;
    }

    public void setLivelyBible(LivelyBible val)
    {
        livelyBible = val;
    }

    public void setGenericManager(LivelyBibleManager m)
    {
        super.setGenericManager(m);
    }

    public LivelyBibleManager getGenericManager()
    {
        return (LivelyBibleManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeLivelyBible(livelyBible.getId());
        return DELETE;
    }

    public String edit()
    {
        if (livelyBible == null) {
            livelyBible = new LivelyBible();
        } else if (livelyBible.getId() != null) {
            livelyBible = getGenericManager().getLivelyBibleById(livelyBible.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedLivelyBibleIds != null && selectedLivelyBibleIds.length > 0) {
            LivelyBible obj = getGenericManager().getLivelyBibleById(selectedLivelyBibleIds[0]);
            obj.setId(null);
            livelyBible = obj;
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
            if (inputValidation(livelyBible) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(LivelyBible val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveLivelyBible(livelyBible);
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
    public List<LivelyBible> getLivelyBibleList()
    {
        return getGenericManager().getLivelyBibleList();
    }

    public void setSelectedLivelyBibleIds(Long[] val)
    {
        selectedLivelyBibleIds = val;
    }

    public Long[] getSelectedLivelyBibleIds()
    {
        return selectedLivelyBibleIds;
    }
}
