package tncc.power.web.action;

import tncc.power.value.*;
import tncc.power.service.PowerManager;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.AppProperty;
import com.base.value.Function;
import com.base.web.displaytag.*;

public class LogAction extends CommonActionSupport {
    private Log log;
    String startDate, endDate, msg;
    Long typeId;
    List<Log> al;
    int code;

    public Log getLog() {
	return log;
    }

    public void setLog(Log val) {
	log = val;
    }

    public void setGenericManager(PowerManager m) {
	super.setGenericManager(m);
    }

    public PowerManager getGenericManager() {
	return (PowerManager) super.getGenericManager();
    }

    public List<AppProperty> getLogMode() {
	return super.getAppPropertyList("log.mode");
    }

    public String list() {
	if (startDate == null || startDate.equals("")) {
	    startDate = Tools.formatSimpleDate2(-2, 0);
	}
	if (endDate == null || endDate.equals("")) {
	    endDate = Tools.formatSimpleDate2(0, 1);
	}
	System.out.println("startDate=" + startDate + "--endDate=" + endDate);
	return SUCCESS;
    }

    public String getStartDate() {
	return startDate;
    }

    public void setStartDate(String startDate) {
	this.startDate = startDate;
    }

    public String getEndDate() {
	return endDate;
    }

    public void setEndDate(String endDate) {
	this.endDate = endDate;
    }

    public Long getTypeId() {
	return typeId;
    }

    public void setTypeId(Long typeId) {
	this.typeId = typeId;
    }

    public String getMsg() {
	return msg;
    }

    public void setMsg(String msg) {
	this.msg = msg;
    }
    
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Log> getLogList() {	
	List<Log> al = new ArrayList<Log>();
	System.out.println("code="+code);
	if(code==0){	
	  int pageIndex = getPageIndex();
	  int pageSize = 50;
	
	  Date s = null, e = null;
	  AppProperty logtype = null;
	  if (typeId != null) {
	    logtype = getGenericManager().getAppPropertyById(typeId);
	  }
	  s = Tools.convertToDateTime(startDate);
	  e = Tools.convertToDateTime(endDate);
	  System.out.println("s="+s);
	  System.out.println("e="+e);
	  System.out.println("pageIndex="+pageIndex);
	  al = getGenericManager().getLogList(s, e, logtype, msg, pageSize,pageIndex);
	  int resultSize = getGenericManager().getLogListRresultSize(s, e,logtype, msg);
	  getSession().setAttribute("RESULT_SIZE", new Integer(resultSize));	
	}else{
	    getSession().setAttribute("RESULT_SIZE", 0);
	}
	return al;
    }

}
