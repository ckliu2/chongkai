package org.zion.web.action;

import org.zion.value.PrayTWClaim;
import org.zion.service.PrayTWClaimManager;
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

public class PrayTWClaimAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private PrayTWClaim prayTWClaim;
    private Long[] selectedPrayTWClaimIds;

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

    public void setGenericManager(PrayTWClaimManager m)
    {
        super.setGenericManager(m);
    }

    public PrayTWClaimManager getGenericManager()
    {
        return (PrayTWClaimManager) super.getGenericManager();
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
    public List<PrayTW> getPraytwList()
    {
        return getGenericManager().getPraytwList(); // TODO
    }

    public List<Member> getMemberList()
    {
        return getGenericManager().getMemberList(); // TODO
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
}
