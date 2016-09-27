package com.web.web.action;

import com.web.value.*;
import com.web.service.WebManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;

import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.*;

public class SubItemAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private SubItem subItem;
    private Long[] selectedSubItemIds; 
	private Long QuerySubItem;	

    public SubItemAction()
    {
        log = LogFactory.getLog(com.web.web.action.SubItemAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("SUBITEM");
    }

    public SubItem getSubItem()
    {
        return subItem;
    }

    public void setSubItem(SubItem val)
    {
        subItem = val;
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
        getGenericManager().removeSubItem(subItem.getId());
        return DELETE;
    }

    public String edit()
    {
        if (subItem == null) {
            subItem = new SubItem();
        } else if (subItem.getId() != null) {
            subItem = getGenericManager().getSubItemById(subItem.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedSubItemIds != null && selectedSubItemIds.length > 0) {
            SubItem obj = getGenericManager().getSubItemById(selectedSubItemIds[0]);
            obj.setId(null);
            subItem = obj;
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
            if (inputValidation(subItem) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(SubItem val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        java.sql.Timestamp ts = Tools.getCurrentTimestamp();
        if (subItem.getId() == null) {
            subItem.setCreatedDate(ts);
            subItem.setCreatedUser(getSessionUser().getMember());
        }
        subItem.setLastModifiedDate(ts);
        subItem.setLastModifiedUser(getSessionUser().getMember());
        subItem.setCreatedDate(ts);
        subItem.setCreatedUser(getSessionUser().getMember());
        getGenericManager().saveSubItem(subItem);
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
        subItem.setSubMenu(getGenericManager().getSubMenuById(subItem.getSubMenuId())); 
        subItem.setLinkType(getAppPropertyById(subItem.getLinkTypeId()));
        log.info("exit formToBean()");
    }
    public List getSubMenuList()
    {
    	ArrayList<SubMenu> al = new ArrayList<SubMenu>();
    	List<Menu> menus=getGenericManager().getMenuList();
    	 for(int i=0;i<menus.size();i++){
    		 Menu m=(Menu)menus.get(i);    
    		 SubMenu nv=new SubMenu();    
    		 nv.setId(0L);
    		 nv.setName("-------- "+m.getName()+" --------");
    		 al.add(nv);
    		 List<SubMenu> submenus=getGenericManager().getSubMenuByMenu(m.getId());
    		 for(int j=0;j<submenus.size();j++){
    			 SubMenu sm=(SubMenu)submenus.get(j);   
        		 al.add(sm);
    		 }
    	 }
    	 return al;
       // return getGenericManager().getSubMenuList(); // TODO
    }
    
    /*
    public List getSubMenuList()
    {
    	ArrayList<NameValue> al = new ArrayList<NameValue>();
    	List<Menu> menus=getGenericManager().getMenuList();
    	 for(int i=0;i<menus.size();i++){
    		 Menu m=(Menu)menus.get(i);    
    		 NameValue nv=new NameValue();    		 
    		 nv.setName("-------- "+m.getName()+" --------");
    		 al.add(nv);
    		 List<SubMenu> submenus=getGenericManager().getSubMenuByMenu(m.getId());
    		 for(int j=0;j<submenus.size();j++){
    			 SubMenu sm=(SubMenu)submenus.get(j);      		   
        		 NameValue nv1=new NameValue();        		 
        		 nv1.setId(Integer.parseInt(String.valueOf(sm.getId())));
        		 nv1.setName(sm.getName());
        		 al.add(nv1);
    		 }
    	 }
    	 return al;
       // return getGenericManager().getSubMenuList(); // TODO
    }
     */

    public List<SubItem> getSubItemList()
    {
    	if(QuerySubItem!=null){
      	  System.out.println("QuerySubItem!=null");
      	    return getGenericManager().getSubItemBySubMenu(QuerySubItem);
      	}else{
              return getGenericManager().getSubItemList();
      	}
    	
        
    }

    public void setSelectedSubItemIds(Long[] val)
    {
        selectedSubItemIds = val;
    }

    public Long[] getSelectedSubItemIds()
    {
        return selectedSubItemIds;
    }
    
    public Long getQuerySubItem() {
		return QuerySubItem;
	}

	public void setQuerySubItem(Long querySubItem) {
		QuerySubItem = querySubItem;
	}

}
