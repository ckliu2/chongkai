package com.web.web.action;

import com.web.value.*;
import com.web.service.WebManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.*;



public class ConsultantAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private Consultant consultant;
    private Long[] selectedConsultantIds;
	AppProperty type;

    public ConsultantAction()
    {
        log = LogFactory.getLog(com.web.web.action.ConsultantAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("CONSULTANT");
    }

    public Consultant getConsultant()
    {
        return consultant;
    }

    public void setConsultant(Consultant val)
    {
        consultant = val;
    }

    public void setGenericManager(WebManager m)
    {
        super.setGenericManager(m);
    }

    public WebManager getGenericManager()
    {
        return (WebManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeConsultant(consultant.getId());
        return DELETE;
    }

    public String edit()
    {
        if (consultant == null) {
            consultant = new Consultant();
        } else if (consultant.getId() != null) {
            consultant = getGenericManager().getConsultantById(consultant.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedConsultantIds != null && selectedConsultantIds.length > 0) {
            Consultant obj = getGenericManager().getConsultantById(selectedConsultantIds[0]);
            obj.setId(null);
            consultant = obj;
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
            if (inputValidation(consultant) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(Consultant val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveConsultant(consultant);
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
        consultant.setType(getAppPropertyById(consultant.getTypeId())); 
        consultant.setMember(getGenericManager().getMemberById(consultant.getMemberId())); 
        log.info("exit formToBean()");
    }
    public List<AppProperty> getTypeList()
    {
        return super.getAppPropertyList("consultant.type");
    }

    public List<Consultant> getConsultantList()
    {
        return getGenericManager().getConsultantList();
    }

    public void setSelectedConsultantIds(Long[] val)
    {
        selectedConsultantIds = val;
    }

    public Long[] getSelectedConsultantIds()
    {
        return selectedConsultantIds;
    }
    
    public AppProperty getType() {
		return type;
	}

	public void setType(AppProperty type) {
		this.type = type;
	}
}
