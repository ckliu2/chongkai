package com.web.web.action;

import com.web.value.*;
import com.web.service.WebManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.*;

import com.common.value.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.*;


public class AgreeTermsAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private AgreeTerms agreeTerms;
    Long memberId;
    Member member;
    String result;

    public AgreeTermsAction()
    {
        log = LogFactory.getLog(com.web.web.action.AgreeTermsAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("AGREETERMS");
    }

    public AgreeTerms getAgreeTerms()
    {
        return agreeTerms;
    }

    public void setAgreeTerms(AgreeTerms val)
    {
        agreeTerms = val;
    }

    public void setGenericManager(WebManager m)
    {
        super.setGenericManager(m);
    }

    public WebManager getGenericManager()
    {
        return (WebManager) super.getGenericManager();
    }

    public String check()
    { 	
	System.out.println("check memberId="+memberId);
	
	member=getGenericManager().getMemberById(memberId);	
	agreeTerms=getGenericManager().getAgreeTermsByMember(member);
	
	if(agreeTerms.getId()!=null){
	    result="1";
	}else{
	    result="0";
	}
	
	System.out.println("check result="+result);
	
	return result;
    }
    
    
    public String save()
    {        
	agreeTerms = new AgreeTerms();
	member=getGenericManager().getMemberById(memberId);
	agreeTerms.setCreatedDate(Tools.getCurrentTimestamp());
	agreeTerms.setCreatedUser(member);
        getGenericManager().saveAgreeTerms(agreeTerms);
        return SUCCESS;
    }

    public String list()
    {
        return SUCCESS;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }
    
    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
    
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
    
}
