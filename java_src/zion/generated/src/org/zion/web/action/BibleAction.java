package org.zion.web.action;

import org.zion.value.Bible;
import org.zion.service.BibleManager;
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

public class BibleAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private Bible bible;
    private Long[] selectedBibleIds;

    public BibleAction()
    {
        log = LogFactory.getLog(org.zion.web.action.BibleAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("BIBLE");
    }

    public Bible getBible()
    {
        return bible;
    }

    public void setBible(Bible val)
    {
        bible = val;
    }

    public void setGenericManager(BibleManager m)
    {
        super.setGenericManager(m);
    }

    public BibleManager getGenericManager()
    {
        return (BibleManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeBible(bible.getId());
        return DELETE;
    }

    public String edit()
    {
        if (bible == null) {
            bible = new Bible();
        } else if (bible.getId() != null) {
            bible = getGenericManager().getBibleById(bible.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedBibleIds != null && selectedBibleIds.length > 0) {
            Bible obj = getGenericManager().getBibleById(selectedBibleIds[0]);
            obj.setId(null);
            bible = obj;
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
            if (inputValidation(bible) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(Bible val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveBible(bible);
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
    public List<Bible> getBibleList()
    {
        return getGenericManager().getBibleList();
    }

    public void setSelectedBibleIds(Long[] val)
    {
        selectedBibleIds = val;
    }

    public Long[] getSelectedBibleIds()
    {
        return selectedBibleIds;
    }
}
