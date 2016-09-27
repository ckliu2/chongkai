package tncc.wpc.web.action;

import tncc.wpc.value.*;
import tncc.wpc.service.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;

import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.*;
import com.common.value.*;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Tue Feb 02 14:20:47 CST 2010
*/

public class EvenLevelAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private EvenLevel evenLevel;
    private Long[] selectedEvenLevelIds;

    public EvenLevelAction()
    {
        log = LogFactory.getLog(tncc.wpc.web.action.EvenLevelAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("EVENLEVEL");
    }

    public EvenLevel getEvenLevel()
    {
        return evenLevel;
    }

    public void setEvenLevel(EvenLevel val)
    {
        evenLevel = val;
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
        getGenericManager().removeEvenLevel(evenLevel.getId());
        return DELETE;
    }

    public String edit()
    {
        if (evenLevel == null) {
            evenLevel = new EvenLevel();
        } else if (evenLevel.getId() != null) {
            evenLevel = getGenericManager().getEvenLevelById(evenLevel.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedEvenLevelIds != null && selectedEvenLevelIds.length > 0) {
            EvenLevel obj = getGenericManager().getEvenLevelById(selectedEvenLevelIds[0]);
            obj.setId(null);
            evenLevel = obj;
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
            if (inputValidation(evenLevel) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(EvenLevel val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveEvenLevel(evenLevel);
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
        evenLevel.setMember(s.getMember()); 
        evenLevel.setCreatedDate(Tools.getCurrentTimestamp());      
        evenLevel.setCreatedUser(s.getMember()); 
        evenLevel.setMember(getGenericManager().getMemberById(evenLevel.getMemberId())); 
        evenLevel.setMessenger(getGenericManager().getMessengerById(evenLevel.getMessengerId()));
        log.info("exit formToBean()");
    }

    public List<EvenLevel> getEvenLevelList()
    {
        return getGenericManager().getEvenLevelList();
    }

    public void setSelectedEvenLevelIds(Long[] val)
    {
        selectedEvenLevelIds = val;
    }

    public Long[] getSelectedEvenLevelIds()
    {
        return selectedEvenLevelIds;
    }   
    
   
    public List<Messenger> getMessengerList()
    {
        return getGenericManager().getMessengerList();
    }

}
