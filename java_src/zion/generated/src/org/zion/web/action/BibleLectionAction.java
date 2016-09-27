package org.zion.web.action;

import org.zion.value.BibleLection;
import org.zion.service.BibleLectionManager;
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

public class BibleLectionAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private BibleLection bibleLection;
    private Long[] selectedBibleLectionIds;

    public BibleLectionAction()
    {
        log = LogFactory.getLog(org.zion.web.action.BibleLectionAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("BIBLELECTION");
    }

    public BibleLection getBibleLection()
    {
        return bibleLection;
    }

    public void setBibleLection(BibleLection val)
    {
        bibleLection = val;
    }

    public void setGenericManager(BibleLectionManager m)
    {
        super.setGenericManager(m);
    }

    public BibleLectionManager getGenericManager()
    {
        return (BibleLectionManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeBibleLection(bibleLection.getId());
        return DELETE;
    }

    public String edit()
    {
        if (bibleLection == null) {
            bibleLection = new BibleLection();
        } else if (bibleLection.getId() != null) {
            bibleLection = getGenericManager().getBibleLectionById(bibleLection.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedBibleLectionIds != null && selectedBibleLectionIds.length > 0) {
            BibleLection obj = getGenericManager().getBibleLectionById(selectedBibleLectionIds[0]);
            obj.setId(null);
            bibleLection = obj;
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
            if (inputValidation(bibleLection) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(BibleLection val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveBibleLection(bibleLection);
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
    public List<BibleLection> getBibleLectionList()
    {
        return getGenericManager().getBibleLectionList();
    }

    public void setSelectedBibleLectionIds(Long[] val)
    {
        selectedBibleLectionIds = val;
    }

    public Long[] getSelectedBibleLectionIds()
    {
        return selectedBibleLectionIds;
    }
}
