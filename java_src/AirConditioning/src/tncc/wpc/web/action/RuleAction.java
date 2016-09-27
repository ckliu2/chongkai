package tncc.wpc.web.action;
import com.base.value.*;

import tncc.wpc.value.*;
import tncc.wpc.service.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;

import com.common.value.Member;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.*;



/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Tue Feb 02 14:20:47 CST 2010
*/

public class RuleAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private Rule rule;
    private Long[] selectedRuleIds;
	private Long[] conditionsIds;
	private int period;
    private int second;

    
    public RuleAction()
    {
        log = LogFactory.getLog(tncc.wpc.web.action.RuleAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("RULE");
    }

    public Rule getRule()
    {
        return rule;
    }

    public void setRule(Rule val)
    {
        rule = val;
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
        getGenericManager().removeRule(rule.getId());
        return DELETE;
    }

    public String edit()
    {
        if (rule == null) {
            rule = new Rule();
        } else if (rule.getId() != null) {
            rule = getGenericManager().getRuleById(rule.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedRuleIds != null && selectedRuleIds.length > 0) {
            Rule obj = getGenericManager().getRuleById(selectedRuleIds[0]);
            obj.setId(null);
            rule = obj;
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
            if (inputValidation(rule) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(Rule val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");        
        getGenericManager().saveRule(rule);
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
        rule.setMember(s.getMember()); 
        rule.setCreatedDate(Tools.getCurrentTimestamp());      
        rule.setCreatedUser(s.getMember());  
        
        //異常次數時間     
        Times ts=getGenericManager().getTimesById(rule.getTimesId());
          if(ts==null){
        	  ts=new Times();
        	  ts.setCycle(period);
        	  ts.setTime(second);
        	  getGenericManager().saveTimes(ts);    
     	      rule.setTimes(ts);
     	      //System.out.println("ts is null");
          }else{
        	  ts.setCycle(period);
        	  ts.setTime(second);
        	  getGenericManager().saveTimes(ts);    
     	      rule.setTimes(ts);
     	      //System.out.println("ts not null");
          }
          //異常次數時間
        
        rule.setMember(getGenericManager().getMemberById(rule.getMemberId()));  
        rule.setStatus(getAppPropertyById(rule.getStatusId())); 
        rule.setTimes(getGenericManager().getTimesById(rule.getTimesId())); 
        rule.setEvenLevel(getGenericManager().getEvenLevelById(rule.getEvenLevelId())); 
        rule.setDecision(getAppPropertyById(rule.getDecisionId())); 
        rule.setDeviceProperty(getGenericManager().getDevicePropertyById(rule.getDevicePropertyId())); 
        //rule.setConditions(getGenericManager().geta(conditionsIds));
        
        rule.setConditions(getGenericManager().getAppPropertyListByIds(conditionsIds));
        
        log.info("exit formToBean()");
    }

    public List<DeviceProperty> getDevicePropertyList()
    {
        return getGenericManager().getDevicePropertyList(); // TODO
    }

    public List<AppProperty> getStatusList()
    {
        return super.getAppPropertyList("rule.status");
    }

    public List<Times> getTimesList()
    {
        return getGenericManager().getTimesList(); // TODO
    }

    public List<EvenLevel> getEvenLevelList()
    {
        return getGenericManager().getEvenLevelList(); // TODO
    }

    public List<AppProperty> getDecisionList()
    {
        return super.getAppPropertyList("rule.decision");
    }

    public List<Rule> getRuleList()
    {
        return getGenericManager().getRuleList();
    }

    public void setSelectedRuleIds(Long[] val)
    {
        selectedRuleIds = val;
    }

    public Long[] getSelectedRuleIds()
    {
        return selectedRuleIds;
    }
    
    public int getPeriod() {
    	  return rule.getTimes().getCycle();    	
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public int getSecond() {
		return rule.getTimes().getTime();  	
	}

	public void setSecond(int second) {
		this.second = second;
	}
	
    public Long[] getConditionsIds() {
		return conditionsIds;
	}

	public void setConditionsIds(Long[] conditionsIds) {
		this.conditionsIds = conditionsIds;
	}
	
	
    public List<AppProperty> getConditionList()
    {
        List<AppProperty> al = getAppPropertyList("rule.condition");
        al.removeAll( rule.getConditions() );
        return al;
    }
    
    
    public List<AppProperty> getRuleConditionList()
    {
        return rule.getConditions();
    }
	
	
	
}
