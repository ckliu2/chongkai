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
    Created Date: Sat Jan 30 12:02:09 CST 2010
*/

public class ControllerAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private Controller controller;
    private Long[] selectedControllerIds;

    public ControllerAction()
    {
        log = LogFactory.getLog(tncc.wpc.web.action.ControllerAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("CONTROLLER");
    }

    public Controller getController()
    {
        return controller;
    }

    public void setController(Controller val)
    {
        controller = val;
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
        getGenericManager().removeController(controller.getId());
        return DELETE;
    }

    public String edit()
    {
        if (controller == null) {
            controller = new Controller();
        } else if (controller.getId() != null) {
            controller = getGenericManager().getControllerById(controller.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedControllerIds != null && selectedControllerIds.length > 0) {
            Controller obj = getGenericManager().getControllerById(selectedControllerIds[0]);
            obj.setId(null);
            controller = obj;
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
            if (inputValidation(controller) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(Controller val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveController(controller);
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
        controller.setMember(s.getMember()); 
        controller.setCreatedDate(Tools.getCurrentTimestamp());      
        controller.setCreatedUser(s.getMember());        
        controller.setRoom(getGenericManager().getRoomById(controller.getRoomId())); 
        log.info("exit formToBean()");
    }

    public List<Room> getRoomList()
    {
        return getGenericManager().getRoomList(); // TODO
    }

    public List<Controller> getControllerList()
    {
        return getGenericManager().getControllerList();
    }

    public void setSelectedControllerIds(Long[] val)
    {
        selectedControllerIds = val;
    }

    public Long[] getSelectedControllerIds()
    {
        return selectedControllerIds;
    }
}
