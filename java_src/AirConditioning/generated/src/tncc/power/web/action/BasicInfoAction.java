package tncc.power.web.action;

import tncc.power.value.BasicInfo;
import tncc.power.service.BasicInfoManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Mar 20 16:19:30 CST 2014
*/

public class BasicInfoAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private BasicInfo basicInfo;
    private String scheduleStart;
    private String scheduleEnd;
    private Long[] shutdownReadersIds;
    private Long[] selectedBasicInfoIds;

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

    public void setGenericManager(BasicInfoManager m)
    {
        super.setGenericManager(m);
    }

    public BasicInfoManager getGenericManager()
    {
        return (BasicInfoManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeBasicInfo(basicInfo.getId());
        return DELETE;
    }

    public String edit()
    {
        if (basicInfo == null) {
            basicInfo = new BasicInfo();
        } else if (basicInfo.getId() != null) {
            basicInfo = getGenericManager().getBasicInfoById(basicInfo.getId());
        } else { // TODO
        }
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
        log.info("enter beanToForm()");
        scheduleStart = Tools.dateToString(basicInfo.getScheduleStart());
        scheduleEnd = Tools.dateToString(basicInfo.getScheduleEnd());
        shutdownReadersIds = getGenericManager().getIdsFromReaderList(basicInfo.getShutdownReaders());
        log.info("exit beanToForm()");
    }

    protected void formToBean()
    {
        log.info("enter formToBean()");
        basicInfo.setScheduleStart(Tools.convertToDate(scheduleStart)); 
        basicInfo.setScheduleEnd(Tools.convertToDate(scheduleEnd)); 
        basicInfo.setShutdownReaders(getGenericManager().getReaderListByIds(shutdownReadersIds)); 
        log.info("exit formToBean()");
    }
    public void setScheduleStart(String val)
    {
        scheduleStart = val;
    }

    public String getScheduleStart()
    {
        return scheduleStart;
    }

    public void setScheduleEnd(String val)
    {
        scheduleEnd = val;
    }

    public String getScheduleEnd()
    {
        return scheduleEnd;
    }

    public List<List> getShutdownReadersList()
    {
        return getGenericManager().getShutdownReadersList(); // TODO
    }

    public void setShutdownReadersIds(Long[] val)
    {
        shutdownReadersIds = val;
    }

    public Long[] getShutdownReadersIds()
    {
        return shutdownReadersIds;
    }

    public List<BasicInfo> getBasicInfoList()
    {
        return getGenericManager().getBasicInfoList();
    }

    public void setSelectedBasicInfoIds(Long[] val)
    {
        selectedBasicInfoIds = val;
    }

    public Long[] getSelectedBasicInfoIds()
    {
        return selectedBasicInfoIds;
    }
}
