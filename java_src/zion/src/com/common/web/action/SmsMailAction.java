package com.common.web.action;

import com.common.value.*;
import com.base.util.Tools;
import com.base.value.*;
import com.common.service.CommonManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.mail.MailHelper;
import com.common.web.action.CommonActionSupport;
import com.base.value.*;

public class SmsMailAction extends CommonActionSupport
{

	private Group group;
	private Grade grade;
	private Team team;
	private Unit unit;
	private Industry industry;
	private Member member ;
	private String msg;  
	private String[] phoneIds;
	private Long[] memberIds;
	private Long[] groupIds;
	private Long[] gradeIds;
	private Long[] teamIds;
	private Long[] serviceteamIds;
	private Long[] unitIds;
	private Long[] industryIds;	
	private String[] otherIds;
	private String subject;

    

	
    public void setGenericManager(CommonManager m)
    {
        super.setGenericManager(m);
    }

    public CommonManager getGenericManager()
    {
        return (CommonManager) super.getGenericManager();
    }
    
    public String execute(){
    	
    	return SUCCESS;
    }
    
    public List getUnitList()
    {
        return getGenericManager().getUnitList();
    } 
    
    public List getIndustryList()
    {
        return getGenericManager().getIndustryList();
    } 
    
    public List getGroupList()
    {
        return getGenericManager().getGroupList();
    } 
    
    public List getMemberList()
    {
        return getGenericManager().getMemberList();
    }   
    
	public List<Grade> getGradeList(){
		return getGenericManager().getGradeList();
	}
	
	public List<Team> getTeamList(){
		return getGenericManager().getTeamList();
	}
	
    
    public String send(){
    	System.out.println("1 smsmailAction send()...");
    	try{
    	  setOtherSM(otherIds, msg+getSender()); //�ǰe�ӧO    	
    	  sendGroupSM(groupIds, msg+getSender()); //�ǰe�s��    	
    	  //sendTeamSM(teamIds, msg+getSender()); //�ǰe�u�@�ζ�    	  
    	  sendUnitSM(unitIds, msg+getSender()); //�ǰe��� 	  
    	  //sendIndustrySM(industryIds, msg+getSender()); //�ǰe���~���O
    	  System.out.println("�o�e���\...");	
    	  appendXworkParam("msg=1");
    	  return SUCCESS;
    	}catch(Exception e){
    		System.out.println(e.toString());    		
    		System.out.println("²�T�o�e����...");	
    		appendXworkParam("msg=2");
    	  return INPUT;
    	}    	
    }
    
	public Long[] getServiceteamIds() {
		return serviceteamIds;
	}

	public void setServiceteamIds(Long[] serviceteamIds) {
		this.serviceteamIds = serviceteamIds;
	}
    
	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public String[] getPhoneIds() {
		return phoneIds;
	}

	public void setPhoneIds(String[] phoneIds) {
		this.phoneIds = phoneIds;
	}
	
	public Long[] getMemberIds() {
		return memberIds;
	}

	public void setMemberIds(Long[] memberIds) {
		this.memberIds = memberIds;
	}
	
	public Long[] getGroupIds() {
		return groupIds;
	}	

	public void setGroupIds(Long[] groupIds) {
		this.groupIds = groupIds;
	}
	
	public Long[] getUnitIds() {
		return unitIds;
	}

	public void setUnitIds(Long[] unitIds) {
		this.unitIds = unitIds;
	}

	public Long[] getIndustryIds() {
		return industryIds;
	}

	public void setIndustryIds(Long[] industryIds) {
		this.industryIds = industryIds;
	}
	
	public Long[] getGradeIds() {
		return gradeIds;
	}

	public void setGradeIds(Long[] gradeIds) {
		this.gradeIds = gradeIds;
	}
	
	public Long[] getTeamIds() {
		return teamIds;
	}

	public void setTeamIds(Long[] teamIds) {
		this.teamIds = teamIds;
	}

	public String[] getOtherIds() {
		return otherIds;
	}

	public void setOtherIds(String[] otherIds) {
		this.otherIds = otherIds;
	}
	

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
    //�ǰe�s��²�T
    public void  sendGroupSM(Long[] ids,String msg) throws Exception{    	 
    	if(ids==null){
    		return;   
    	}
    	   for(int i=0;i<ids.length;i++){
    		   group=getGenericManager().getGroupById(ids[i]);
    		   Set members=group.getMembers();
    		    if(members!=null){
     	           Iterator mi = members.iterator(); 
	    		    while (mi.hasNext()) {
	    			  Member m= (Member) mi.next();

	                       MailHelper.sendHtmlMail(m.getEmail(), getSessionUser().getMember().getName(), subject, msg); //�ǰemail1
	                     

	                       
		    		       //�g�J�q�p�O��
	                       SmsMailRec smsMailRec=new SmsMailRec();
	                       SessionUser s=(SessionUser)getSession().getAttribute("user");
	   	    		       smsMailRec.setTarget(m);
	   	    		       smsMailRec.setMember(getGenericManager().getMemberById(s.getId()));
	   	    		       smsMailRec.setMsg(msg);
	   	    		       smsMailRec.setEmail(m.getEmail());
	   	    		       smsMailRec.setCellphone(m.getCellphone());
	   	    		       smsMailRec.setSendDate(Tools.getCurrentTimestamp());
	   	    		       getGenericManager().saveSmsMailRec(smsMailRec);
    		          }

	    		    
	    		    
    		      }	
    	       } 	      
             }
 
    //�ǰe���
    public void  sendUnitSM(Long[] ids,String msg) throws Exception{    	 
    	if(ids==null){
    		return;   
    	}
    	   for(int i=0;i<ids.length;i++){
    		   unit=getGenericManager().getUnitById(ids[i]);
    		   Set members=unit.getMembers();
    		    if(members!=null){
     	           Iterator mi = members.iterator(); 
	    		    while (mi.hasNext()) {
	    			  Member m= (Member) mi.next();

	                       MailHelper.sendHtmlMail(m.getEmail(), getSessionUser().getMember().getName(), subject, msg); //�ǰemail1
	                         
		    		       //�g�J�q�p�O��
	                       SmsMailRec smsMailRec=new SmsMailRec();
	                       SessionUser s=(SessionUser)getSession().getAttribute("user");
	   	    		       smsMailRec.setTarget(m);
	   	    		       smsMailRec.setMember(getGenericManager().getMemberById(s.getId()));
	   	    		       smsMailRec.setMsg(msg);
	   	    		       smsMailRec.setEmail(m.getEmail());	   	    		        
	   	    		       smsMailRec.setSendDate(Tools.getCurrentTimestamp());
	   	    		       getGenericManager().saveSmsMailRec(smsMailRec);
    		          }
    		      }	
    	       } 	      
             }
         

    //�п�Jemail
    public void setOtherSM(String[] ids,String msg) throws Exception {
    	if(ids==null)
    		return;
    	for(int i=0;i<ids.length;i++){
    		String email=ids[i];               
    		   MailHelper.sendHtmlMail(email, getSessionUser().getMember().getName() , subject, msg);//�ǰemail		       
    		   

    		   //�g�J�q�p�O��
               SmsMailRec smsMailRec=new SmsMailRec();
               SessionUser s=(SessionUser)getSession().getAttribute("user");		       
		       smsMailRec.setMember(getGenericManager().getMemberById(s.getId()));
		       smsMailRec.setMsg(msg);
		       smsMailRec.setEmail(email);
		       smsMailRec.setCellphone(email);
		       smsMailRec.setSendDate(Tools.getCurrentTimestamp());
		       getGenericManager().saveSmsMailRec(smsMailRec);
    	}
    }
    
	public String getSender(){
		SessionUser s=(SessionUser)getSession().getAttribute("user");
		return "["+s.getName()+"]";
	   /* if(s.getName()!=null){
	    	String n="\n===============================\n�t�������{�E�|\nSan Jose Christian Assembly\n"+s.getName()+"\n===============================";
	    	return n;
	    }else{
	    	return "";
	    }	*/	 
     }
	

	
    public SessionUser getSessionUser(){
        return (SessionUser)getSession().getAttribute("user");
      }

    
    public String sendMail(){
    	System.out.println("1 smsmailAction sendMail()...");
    	try{
    		System.out.println("subject="+subject+"   msg="+msg);
    		
    		setOtherMail(otherIds, msg+getSender()); //�ǰe�ӧO    	   
    	    System.out.println("EMAIL�o�e���\...");	
    	    appendXworkParam("msg=1");
    	    return SUCCESS;
    	}catch(Exception e){
    		System.out.println(e.toString());    		
    		System.out.println("²�T�o�e����...");	
    		appendXworkParam("msg=2");
    	  return INPUT;
    	}    	
    }
    
    
    //�п�Jemail
    public void setOtherMail(String[] ids,String msg) throws Exception {
    	if(ids==null)
    		return;
    	for(int i=0;i<ids.length;i++){
    		String email=ids[i];               
    		   MailHelper.sendHtmlMail(email, getSessionUser().getMember().getName() , subject, msg);//�ǰemail	
    		  
    		   //�g�J�q�p�O��
               SmsMailRec smsMailRec=new SmsMailRec();
               SessionUser s=(SessionUser)getSession().getAttribute("user");		       
		       smsMailRec.setMember(getGenericManager().getMemberById(s.getId()));
		       smsMailRec.setMsg(msg);
		       smsMailRec.setEmail(email);		      
		       smsMailRec.setSendDate(Tools.getCurrentTimestamp());
		       getGenericManager().saveSmsMailRec(smsMailRec);
    	}
    }
    
}
