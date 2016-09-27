package tncc.power.web.action;

import tncc.power.value.*;
import tncc.power.service.PowerManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;

import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.AppProperty;
import com.base.value.Function;
import com.base.value.SessionUser;

import tncc.wpc.value.*;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Tue Mar 30 11:34:38 CST 2010
*/

public class PowerControllerAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private PowerController powerController;
    private Long[] readerIds;
    private Long[] selectedPowerControllerIds;

    public PowerControllerAction()
    {
        log = LogFactory.getLog(tncc.power.web.action.PowerControllerAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("POWERCONTROLLER");
    }

    public PowerController getPowerController()
    {
        return powerController;
    }

    public void setPowerController(PowerController val)
    {
        powerController = val;
    }

    public void setGenericManager(PowerManager m)
    {
        super.setGenericManager(m);
    }

    public PowerManager getGenericManager()
    {
        return (PowerManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removePowerController(powerController.getId());
        return DELETE;
    }

    public String edit()
    {
        if (powerController == null) {
            powerController = new PowerController();
        } else if (powerController.getId() != null) {
            powerController = getGenericManager().getPowerControllerById(powerController.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedPowerControllerIds != null && selectedPowerControllerIds.length > 0) {
            PowerController obj = getGenericManager().getPowerControllerById(selectedPowerControllerIds[0]);
            obj.setId(null);
            powerController = obj;
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
            if (inputValidation(powerController) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(PowerController val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().savePowerController(powerController);
        return SUCCESS;
    }

    public String list()
    {
        return SUCCESS;
    }

    protected void beanToForm()
    {
        log.info("enter beanToForm()");
        readerIds = getGenericManager().getIdsFromReaderList(powerController.getReader());
        log.info("exit beanToForm()");
    }

    protected void formToBean()
    {
        log.info("enter formToBean()");
        
        SessionUser s=(SessionUser)getSession().getAttribute("user");   
        powerController.setCreatedDate(Tools.getCurrentTimestamp());      
        powerController.setCreatedUser(s.getMember());       
        powerController.setBuilding(getGenericManager().getBuildingById(powerController.getBuildingId())); 
        powerController.setReader(getGenericManager().getReaderListByIds(readerIds)); 
        powerController.setDeviceType(getAppPropertyById(powerController.getDeviceTypeId())); 
        
        log.info("exit formToBean()");
    }
    public List<Building> getBuildingList()
    {
        return getGenericManager().getBuildingList(); // TODO
    }

    public List<Reader> getReaderList()
    {
        return getGenericManager().getReaderList(); // TODO
    }
    
    public List<Reader> getReaderAllList()
    {
    	List<Reader> al = getGenericManager().getReaderList();
        if (al != null) {
            if (powerController.getReader() != null)
                al.removeAll(powerController.getReader());
            return al;
        }
        return new ArrayList<Reader>();       
    }
    
    public List<Reader> getObject_readerList()
    {
    	ArrayList<Reader>  rs=new ArrayList(); 
    	if(powerController.getReader() == null){
    		 return rs;
    	}else{    		
    		List ls=powerController.getReader();
    		for(int i=0;i<ls.size();i++){
    			Reader r=(Reader)ls.get(i);
    			System.out.println(r.getName());
    			rs.add(r);
    		}
    		return rs;
    	}
    }
    

    public void setReaderIds(Long[] val)
    {
        readerIds = val;
    }

    public Long[] getReaderIds()
    {
        return readerIds;
    }

    public List<PowerController> getPowerControllerList()
    {
        return getGenericManager().getPowerControllerList();
    }

    public void setSelectedPowerControllerIds(Long[] val)
    {
        selectedPowerControllerIds = val;
    }

    public Long[] getSelectedPowerControllerIds()
    {
        return selectedPowerControllerIds;
    }
    
    public List<AppProperty> getDeviceList()
    {
        return super.getAppPropertyList("reader.device");
    }
}
