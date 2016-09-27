package com.web.web.action;

import com.web.value.*;
import com.web.service.WebManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;

import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Fri May 28 09:33:28 CST 2010
*/

public class BolgClassAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private BolgClass bolgClass;
    private Long[] selectedBolgClassIds;

    public BolgClassAction()
    {
        log = LogFactory.getLog(com.web.web.action.BolgClassAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("BOLGCLASS");
    }

    public BolgClass getBolgClass()
    {
        return bolgClass;
    }

    public void setBolgClass(BolgClass val)
    {
        bolgClass = val;
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
        getGenericManager().removeBolgClass(bolgClass.getId());
        return DELETE;
    }

    public String edit()
    {
        if (bolgClass == null) {
            bolgClass = new BolgClass();
        } else if (bolgClass.getId() != null) {
            bolgClass = getGenericManager().getBolgClassById(bolgClass.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }
    
    
    public List<Menu> getTest(){
    	return getGenericManager().getMenuList();
    }

    public String copy()
    {
        if (selectedBolgClassIds != null && selectedBolgClassIds.length > 0) {
            BolgClass obj = getGenericManager().getBolgClassById(selectedBolgClassIds[0]);
            obj.setId(null);
            bolgClass = obj;
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
            if (inputValidation(bolgClass) == false)
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(BolgClass val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        java.sql.Timestamp ts = Tools.getCurrentTimestamp();
        try{
           if (bolgClass.getId() == null) {
                 bolgClass.setCreatedDate(ts);
                 bolgClass.setCreatedUser(getSessionUser().getMember());
            }
            System.out.println("ID not-null");
            bolgClass.setLastModifiedDate(ts);
            bolgClass.setLastModifiedUser(getSessionUser().getMember());
            bolgClass.setCreatedDate(ts);
            bolgClass.setCreatedUser(getSessionUser().getMember());
            System.out.println("Id="+bolgClass.getId());
            System.out.println("Name="+bolgClass.getName());
            System.out.println("SeqNo="+bolgClass.getSeqNo());
            System.out.println("Status="+bolgClass.getStatus());
            System.out.println("CreatedDate="+bolgClass.getCreatedDate());
            System.out.println("CreatedUser="+bolgClass.getCreatedUser());
            System.out.println("LastModifiedDate="+bolgClass.getLastModifiedDate());
            System.out.println("LastModifiedUser="+bolgClass.getLastModifiedUser());
            getGenericManager().saveBolgClass(bolgClass);
            return SUCCESS;
        }
        catch (Exception e){
        	System.out.println("SAVE Excption="+e.toString());
        	return SUCCESS;
        }
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
        //bolgClass.setBolg(getGenericManager().getBolgById(bolgClass.getBolgId())); 
        log.info("exit formToBean()");
    }
    public List<Bolg> getBolgList()
    {
        return getGenericManager().getBolgList(); // TODO
    }

    public List<BolgClass> getBolgClassList()
    {
    	System.out.println("getBolgClassList()..");
    	
    	return getGenericManager().getBolgClassList();
    }

    public void setSelectedBolgClassIds(Long[] val)
    {
        selectedBolgClassIds = val;
    }

    public Long[] getSelectedBolgClassIds()
    {
        return selectedBolgClassIds;
    }
}
