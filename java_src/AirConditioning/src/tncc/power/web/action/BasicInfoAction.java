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

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Tue Feb 15 04:59:43 CST 2011
*/

public class BasicInfoAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private BasicInfo basicInfo;
	private Long[] selectedBasicInfoIds,selectedReaderIds;
	private String scheduleStart;
    private String scheduleEnd;
	Long spaceId;

    public BasicInfoAction()
    {
        log = LogFactory.getLog(tncc.power.web.action.BasicInfoAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("BASICINFO");
    }

    public BasicInfo getBasicInfo()
    {
        return basicInfo;
    }

    public void setBasicInfo(BasicInfo val)
    {
        basicInfo = val;
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
        getGenericManager().removeBasicInfo(basicInfo.getId());
        return DELETE;
    }

    public String edit()
    {        
        basicInfo = getGenericManager().getBasicInfo();
        beanToForm();
        return SUCCESS;
    }

    public String copy()
    {
        if (selectedBasicInfoIds != null && selectedBasicInfoIds.length > 0) {
            BasicInfo obj = getGenericManager().getBasicInfoById(selectedBasicInfoIds[0]);
            obj.setId(null);
            basicInfo = obj;
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
            if (inputValidation(basicInfo) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(BasicInfo val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveBasicInfo(basicInfo);
        return SUCCESS;
    }

    public String list()
    {
        return SUCCESS;
    }

    protected void beanToForm()
    {
    	scheduleStart = Tools.dateToString(basicInfo.getScheduleStart());
        scheduleEnd = Tools.dateToString(basicInfo.getScheduleEnd());
    }

    protected void formToBean()
    {
        log.info("enter formToBean()");
        SessionUser s=(SessionUser)getSession().getAttribute("user");   
        basicInfo.setCreatedDate(Tools.getCurrentTimestamp());      
        basicInfo.setCreatedUser(s.getMember()); 
        basicInfo.setScheduleStart(Tools.convertToDate(scheduleStart)); 
        basicInfo.setScheduleEnd(Tools.convertToDate(scheduleEnd));
        basicInfo.setShutdownReaders(getGenericManager().getReaderListByIds(selectedReaderIds)); 
        log.info("exit formToBean()");
    }
    
    public List getPanelUpdateMinsList()
    {
    	return getMins(60);
    }
    
    public List getScheduleCheckMinsList()
    {
    	return getMins(60);
    }
    
    public List<Space> getSpaceListAir()
    {    	    	
    	//AppProperty air=getGenericManager().getAppPropertyById(45L);
        //return getGenericManager().getSpaceListByAir(air);      
        return getGenericManager().getSpaceList();
    }
    
    public List<SpaceReader> getReaderListBySpace()
    {    	
    	Space space=getGenericManager().getSpaceById(spaceId);
        return getGenericManager().getReaderListBySpace(space);
    }
    
    public List<BasicInfo> getBasicInfoList()
    {
        return getGenericManager().getBasicInfoList();
    }
    
    public List getSelectedReaderList()
    {    	
    	return basicInfo.getShutdownReaders(); 	
    }

    public void setSelectedBasicInfoIds(Long[] val)
    {
        selectedBasicInfoIds = val;
    }
    
    public Long[] getSelectedReaderIds() {
		return selectedReaderIds;
	}

	public void setSelectedReaderIds(Long[] selectedReaderIds) {
		this.selectedReaderIds = selectedReaderIds;
	}

    public Long[] getSelectedBasicInfoIds()
    {
        return selectedBasicInfoIds;
    }
    
    public String getScheduleStart() {
		return scheduleStart;
	}

	public void setScheduleStart(String scheduleStart) {
		this.scheduleStart = scheduleStart;
	}

	public String getScheduleEnd() {
		return scheduleEnd;
	}

	public void setScheduleEnd(String scheduleEnd) {
		this.scheduleEnd = scheduleEnd;
	}
	
    public Long getSpaceId() {
		return spaceId;
	}

	public void setSpaceId(Long spaceId) {
		this.spaceId = spaceId;
	}
}
