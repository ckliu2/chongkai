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

public class MenuAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private Menu menu;
    private Long[] selectedMenuIds;

    public MenuAction()
    {
        log = LogFactory.getLog(com.web.web.action.MenuAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("MENU");
    }

    public Menu getMenu()
    {
        return menu;
    }

    public void setMenu(Menu val)
    {
        menu = val;
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
        getGenericManager().removeMenu(menu.getId());
        return DELETE;
    }

    public String edit()
    {
        try{
            System.out.println("Edit()");
    	if (menu == null) {
            menu = new Menu();
        } else if (menu.getId() != null) {
            menu = getGenericManager().getMenuById(menu.getId());
        } else { // TODO
        }
        beanToForm();
   
        return SUCCESS;
        }catch(Exception e){
        	System.out.print("edit()="+e.toString());
        	return SUCCESS;
        }
    }

    public String copy()
    {
        if (selectedMenuIds != null && selectedMenuIds.length > 0) {
            Menu obj = getGenericManager().getMenuById(selectedMenuIds[0]);
            obj.setId(null);
            menu = obj;
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
            if (inputValidation(menu) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(Menu val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        java.sql.Timestamp ts = Tools.getCurrentTimestamp();
        if (menu.getId() == null) {
            menu.setCreatedDate(ts);
            menu.setCreatedUser(getSessionUser().getMember());
        }
        menu.setLastModifiedDate(ts);
        menu.setLastModifiedUser(getSessionUser().getMember());
        menu.setCreatedDate(ts);
        menu.setCreatedUser(getSessionUser().getMember());
        getGenericManager().saveMenu(menu);
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
    public List<Menu> getMenuList()
    {
        return getGenericManager().getMenuList();
    }

    public void setSelectedMenuIds(Long[] val)
    {
        selectedMenuIds = val;
    }

    public Long[] getSelectedMenuIds()
    {
        return selectedMenuIds;
    }
}
