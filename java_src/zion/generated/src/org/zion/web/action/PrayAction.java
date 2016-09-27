package org.zion.web.action;

import org.zion.value.Pray;
import org.zion.service.PrayManager;
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

public class PrayAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private Pray pray;
    private Long[] selectedPrayIds;

    public PrayAction()
    {
        log = LogFactory.getLog(org.zion.web.action.PrayAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("PRAY");
    }

    public Pray getPray()
    {
        return pray;
    }

    public void setPray(Pray val)
    {
        pray = val;
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
        getGenericManager().removePray(pray.getId());
        return DELETE;
    }

    public String edit()
    {
        if (pray == null) {
            pray = new Pray();
        } else if (pray.getId() != null) {
            pray = getGenericManager().getPrayById(pray.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedPrayIds != null && selectedPrayIds.length > 0) {
            Pray obj = getGenericManager().getPrayById(selectedPrayIds[0]);
            obj.setId(null);
            pray = obj;
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
            if (inputValidation(pray) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(Pray val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        java.sql.Timestamp ts = Tools.getCurrentTimestamp();
        if (pray.getId() == null) {
            pray.setCreatedDate(ts);
            pray.setCreatedUser(getSessionUser().getLoginId());
        }
        pray.setLastModifiedDate(ts);
        pray.setLastModifiedUser(getSessionUser().getLoginId());
        getGenericManager().savePray(pray);
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
        pray.setClassify(getAppPropertyById(pray.getClassifyId())); 
        log.info("exit formToBean()");
    }
    public List<AppProperty> getClassifyList()
    {
        return super.getAppPropertyList("pray.classify");
    }

    public List<Pray> getPrayList()
    {
        return getGenericManager().getPrayList();
    }

    public void setSelectedPrayIds(Long[] val)
    {
        selectedPrayIds = val;
    }

    public Long[] getSelectedPrayIds()
    {
        return selectedPrayIds;
    }
}
