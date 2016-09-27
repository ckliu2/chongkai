package tncc.wpc.web.action;

import tncc.wpc.value.*;
import tncc.wpc.service.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;
import com.base.value.SessionUser;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Mar 04 09:35:03 CST 2010
*/

public class MyDVRAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private MyDVR myDVR;
    private Long[] selectedMyDVRIds;

    public MyDVRAction()
    {
        log = LogFactory.getLog(tncc.wpc.web.action.MyDVRAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("MYDVR");
    }

    public MyDVR getMyDVR()
    {
        return myDVR;
    }

    public void setMyDVR(MyDVR val)
    {
        myDVR = val;
    }

    public void setGenericManager(wpcManager m)
    {
        super.setGenericManager(m);
    }

    public wpcManager getGenericManager()
    {
        return (wpcManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeMyDVR(myDVR.getId());
        return DELETE;
    }

    public String edit()
    {
        if (myDVR == null) {
            myDVR = new MyDVR();
        } else if (myDVR.getId() != null) {
            myDVR = getGenericManager().getMyDVRById(myDVR.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedMyDVRIds != null && selectedMyDVRIds.length > 0) {
            MyDVR obj = getGenericManager().getMyDVRById(selectedMyDVRIds[0]);
            obj.setId(null);
            myDVR = obj;
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
            if (inputValidation(myDVR) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(MyDVR val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveMyDVR(myDVR);
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
        SessionUser s=(SessionUser)getSession().getAttribute("user");    
        myDVR.setMember(s.getMember()); 
        myDVR.setCreatedDate(Tools.getCurrentTimestamp());      
        myDVR.setCreatedUser(s.getMember()); 

        log.info("exit formToBean()");
    }

    public List<MyDVR> getMyDVRList()
    {
        return getGenericManager().getMyDVRList();
    }

    public void setSelectedMyDVRIds(Long[] val)
    {
        selectedMyDVRIds = val;
    }

    public Long[] getSelectedMyDVRIds()
    {
        return selectedMyDVRIds;
    }
}
