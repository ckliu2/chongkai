package rfid.card.web.action;

import rfid.card.value.Recorder;
import rfid.card.service.RecorderManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;

import jxl.*;
import jxl.write.*; 
import java.io.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.*;
import com.common.value.*;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Nov 18 14:22:25 CST 2009
*/

public class RecorderAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private Recorder recorder;
    private Long[] selectedRecorderIds;
    private String cardId="";
	private String md5="";
    private Member member;
	private Date beginDate;
    private Date endDate; 
	private int dismoney=0;
    private int addmoney=0;
    private int sum;
	private String p;
    
    public RecorderAction()
    {
        log = LogFactory.getLog(rfid.card.web.action.RecorderAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("RECORDER");
    }

    public Recorder getRecorder()
    {
        return recorder;
    }

    public void setRecorder(Recorder val)
    {
        recorder = val;
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
        getGenericManager().removeRecorder(recorder.getId());
        return DELETE;
    }

    public String edit()
    {
        if (recorder == null) {
            recorder = new Recorder();
        } else if (recorder.getId() != null) {
            recorder = getGenericManager().getRecorderById(recorder.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedRecorderIds != null && selectedRecorderIds.length > 0) {
            Recorder obj = getGenericManager().getRecorderById(selectedRecorderIds[0]);
            obj.setId(null);
            recorder = obj;
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
            if (inputValidation(recorder) == false) {
            	System.out.println("inputValidation error!"+"  "+"cardId="+recorder.getMember().getCardId());
            	appendXworkParam("cardId="+recorder.getMember().getCardId());
                return INPUT;
            }
        }
        return SUCCESS;
    }

    public boolean inputValidation(Recorder val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        appendXworkParam("cardId="+recorder.getMember().getCardId());
        
        /**回寫卡片金額*/
          Member m=recorder.getMember();
          
          System.out.println("save recorder.getKindId()="+recorder.getKindId());
		  if(recorder.getKindId()==8L){			 
			   
		  }else{			 
			  
		  }
		getGenericManager().saveMember(m);
        
        
        getGenericManager().saveRecorder(recorder);
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
        java.sql.Timestamp ts = Tools.getCurrentTimestamp();
        recorder.setMember(getGenericManager().getMemberById(recorder.getMemberId())); 
        recorder.setKind(getAppPropertyById(recorder.getKindId()));         
        recorder.setCreatedDate(ts);
        recorder.setCreatedUser(getMemberFromSessionUser());
        log.info("exit formToBean()");
    }
    public List<Member> getMemberList()
    {
        return getGenericManager().getMemberList(); // TODO
    }

    public List<AppProperty> getKindList()
    {
        return super.getAppPropertyList("recorder.kind");
    }
    
    
    public List<AppProperty> getWebCardMoneyList()
    {
        return super.getAppPropertyList("webcard.money");
    }
    
   /* 
    public Member getMember(){
    	member=getGenericManager().getMemberByIdWithMD5(md5);
    	 if(member==null){
    		 member=getGenericManager().getMemberByCardId(cardId); 
    	 }
    	//member=getGenericManager().getMemberByCardId(cardId); 
    	return member;
    }
    */
    public void Count(List<Recorder> rc){
		 for(int i=0;i<rc.size();i++){
			 Recorder r=(Recorder)rc.get(i);
			 int money=r.getMoney();
			 Long kind=r.getKindId();
			 
			  if(kind==1L||kind==8L){
				  //System.out.println("member="+r.getMember().getName()+"  1 money="+money+"   kind="+kind);
				  addmoney+=money;
			  }else if(kind==2L||kind==9L){
				  //System.out.println("member="+r.getMember().getName()+"  2 money="+money+"   kind="+kind);
				  dismoney+=money;
			  }
			  sum=addmoney-dismoney;
			  //System.out.println("addmoney="+addmoney+"  dismoney="+dismoney);
		 }
    }
    
 /*
     public List<Recorder> getRecorderListByMember()
    {
    	Member m=getGenericManager().getMemberByIdWithMD5(md5);
    	 if(m==null){
    		 m=getGenericManager().getMemberByCardId(cardId);
    	 }
        System.out.println("by Member name="+m.getName()); 	
        //ArrayList<Recorder> al = new ArrayList<Recorder>();  
  	     //exportExcel(getGenericManager().getRecorderListByMember(getMember()));	
        return getGenericManager().getRecorderListByMember(m);
       //return al;
    	
    }
*/
    public List<Recorder> getRecorderList()
    {
    	//System.out.println("beginDate="+beginDate+"  endDate="+endDate+"   p="+p);
    	
    	
    	if(p.equals("save")){
    	   if(beginDate!=null && endDate!=null){
    		   List<Recorder> al=getGenericManager().getRecorderListSaveByDate(beginDate,endDate);
    		   Count(al);    	
    		   return al;
    	    }else{    	    	      
    	       Date beginDate=new Date();
    	       Date endDate=new Date();
    	       beginDate.setHours(0);
    	       beginDate.setMinutes(0);    	       
    	       endDate.setHours(23);
    	       endDate.setMinutes(59);    	       
    	       List<Recorder> al=getGenericManager().getRecorderListSaveByDate(beginDate,endDate);
    		   Count(al);
    		   //exportExcel(al);
    		   return al;
    	    }
        }else{
     	   if(beginDate!=null && endDate!=null){
    		   List<Recorder> al=getGenericManager().getRecorderListDisByDate(beginDate,endDate);
    		   Count(al);
    		   //exportExcel(al);
    		   return al;
    	    }else{    	    	      
    	       Date beginDate=new Date();
    	       Date endDate=new Date();
    	       beginDate.setHours(0);
    	       beginDate.setMinutes(0);    	       
    	       endDate.setHours(23);
    	       endDate.setMinutes(59);    	       
    	       List<Recorder> al=getGenericManager().getRecorderListDisByDate(beginDate,endDate);
    		   Count(al);
    		   //exportExcel(al);
    		   return al;
    	    }
        }
      
    }

    public void setSelectedRecorderIds(Long[] val)
    {
        selectedRecorderIds = val;
    }

    public Long[] getSelectedRecorderIds()
    {
        return selectedRecorderIds;
    }
    
    public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	
    public Date getBeginDate() {
    	 if(beginDate==null){
    		 beginDate=Tools.getToday();
    	 }
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
   	 if(endDate==null){
   		endDate=Tools.getToday();
	 }
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	   public int getDismoney() {
			return dismoney;
		}

		public void setDismoney(int dismoney) {
			this.dismoney = dismoney;
		}

		public int getAddmoney() {
			return addmoney;
		}

		public void setAddmoney(int addmoney) {
			this.addmoney = addmoney;
		}

		public int getSum() {
			return sum;
		}

		public void setSum(int sum) {
			this.sum = sum;
		}
		
	
		
	    public String getP() {
			return p;
		}

		public void setP(String p) {
			this.p = p;
		}
		
	    public String getMd5() {
			return md5;
		}

		public void setMd5(String md5) {
			this.md5 = md5;
		}
}
