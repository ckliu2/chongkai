package rfid.card.web.action;

import rfid.card.value.*;
import rfid.card.service.RecorderManager;
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
    Created Date: Tue Dec 08 09:56:19 CST 2009
*/

public class MachineAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private Machine machine;
    private Long[] selectedMachineIds;
	private String cardId="";
	private Member member;

    public MachineAction()
    {
        log = LogFactory.getLog(rfid.card.web.action.MachineAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("MACHINE");
    }

    public Machine getMachine()
    {
        return machine;
    }

    public void setMachine(Machine val)
    {
        machine = val;
    }

    public void setGenericManager(RecorderManager m)
    {
        super.setGenericManager(m);
    }

    public RecorderManager getGenericManager()
    {
        return (RecorderManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeMachine(machine.getId());
        return DELETE;
    }

    public String edit()
    {
        if (machine == null) {
            machine = new Machine();
        } else if (machine.getId() != null) {
            machine = getGenericManager().getMachineById(machine.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedMachineIds != null && selectedMachineIds.length > 0) {
            Machine obj = getGenericManager().getMachineById(selectedMachineIds[0]);
            obj.setId(null);
            machine = obj;
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
            if (inputValidation(machine) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(Machine val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveMachine(machine);
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
        machine.setMember(getGenericManager().getMemberById(machine.getMemberId())); 
        machine.setKind(getAppPropertyById(machine.getKindId())); 
        log.info("exit formToBean()");
    }


    public List<AppProperty> getKindList()
    {
        return super.getAppPropertyList("machine.kind");
    }

    public List<Machine> getMachineList()
    {
        return getGenericManager().getMachineList();
    }
 /*   
    public List<Machine> getMachineListByMember()
    {
    	Member member=getGenericManager().getMemberByCardId(cardId); 
        return getGenericManager().getMachineListByMember(member);
    }
*/
    public void setSelectedMachineIds(Long[] val)
    {
        selectedMachineIds = val;
    }

    public Long[] getSelectedMachineIds()
    {
        return selectedMachineIds;
    }
    
    public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	/*
    public Member getMember(){
    	member=getGenericManager().getMemberByCardId(cardId);   
    	return member;
    }
    */
}
