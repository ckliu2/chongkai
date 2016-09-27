package tncc.wpc.web.action;

import tncc.power.value.Reader;
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
    Created Date: Wed Feb 10 14:04:08 CST 2010
*/

public class MessengerAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private Messenger messenger;
    private Long[] securityIds;
    private Long[] selectedMessengerIds;

    public MessengerAction()
    {
        log = LogFactory.getLog(tncc.wpc.web.action.MessengerAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("MESSENGER");
    }

    public Messenger getMessenger()
    {
        return messenger;
    }

    public void setMessenger(Messenger val)
    {
        messenger = val;
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
        getGenericManager().removeMessenger(messenger.getId());
        return DELETE;
    }

    public String edit()
    {
        if (messenger == null) {
            messenger = new Messenger();
        } else if (messenger.getId() != null) {
            messenger = getGenericManager().getMessengerById(messenger.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedMessengerIds != null && selectedMessengerIds.length > 0) {
            Messenger obj = getGenericManager().getMessengerById(selectedMessengerIds[0]);
            obj.setId(null);
            messenger = obj;
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
            if (inputValidation(messenger) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(Messenger val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveMessenger(messenger);
        return SUCCESS;
    }

    public String list()
    {
        return SUCCESS;
    }

    protected void beanToForm()
    {
        log.info("enter beanToForm()");  
        securityIds = getGenericManager().getIdsFromSecurityList(messenger.getSecuritys());
        log.info("exit beanToForm()");
    }

    protected void formToBean()
    {
        log.info("enter formToBean()");
        SessionUser s=(SessionUser)getSession().getAttribute("user");    
        messenger.setMember(s.getMember()); 
        messenger.setCreatedDate(Tools.getCurrentTimestamp());      
        messenger.setCreatedUser(s.getMember());
        messenger.setMember(getGenericManager().getMemberById(messenger.getMemberId())); 
        messenger.setSecuritys(getGenericManager().getSecurityListByIds(securityIds)); 
        log.info("exit formToBean()");
    }
    
    
    public List<Security> getMessenger_securityList()
    {    	
    	ArrayList<Security>  rs=new ArrayList();
        if(messenger.getSecuritys()!=null){
        	return messenger.getSecuritys();
        }else{
        	return rs;
        }
    	
    }


    public List<Security> getSecurityList()
    {
    	List<Security> s=getGenericManager().getSecurityList();    
    	
    	ArrayList<Security>  rs=new ArrayList();
        if(messenger.getSecuritys()!=null){
        	s.removeAll(messenger.getSecuritys());
        	return s;
        }else{
        	return s;
        }
    	
    }

    public void setSecurityIds(Long[] val)
    {
        securityIds = val;
    }

    public Long[] getSecurityIds()
    {
        return securityIds;
    }

    public List<Messenger> getMessengerList()
    {
        return getGenericManager().getMessengerList();
    }

    public void setSelectedMessengerIds(Long[] val)
    {
        selectedMessengerIds = val;
    }

    public Long[] getSelectedMessengerIds()
    {
        return selectedMessengerIds;
    }
}
