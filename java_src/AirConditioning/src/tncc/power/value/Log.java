package tncc.power.value;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;
import com.base.value.*;
import com.common.value.*;

/** @author Hibernate CodeGenerator */
public class Log extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    AppProperty type;

    /** nullable persistent field */
    private String msg;

    String ip;

    /** nullable persistent field */
    private Date createdDate;

    /** nullable persistent field */
    private tncc.power.value.ScheduleDaily scheduleDaily;
    private Long scheduleDailyId;

    /** nullable persistent field */
    private tncc.power.value.Reader reader;
    private Long readerId;

    Member createdUser;


    /** Labor constructor */
    public Log() {
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public AppProperty getType() {
	return type;
    }

    public void setType(AppProperty type) {
	this.type = type;
    }

    public String getMsg() {
	return this.msg;
    }

    public void setMsg(String msg) {
	this.msg = msg;
    }

    public Date getCreatedDate() {
	return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
	this.createdDate = createdDate;
    }

    public tncc.power.value.ScheduleDaily getScheduleDaily() {
	return this.scheduleDaily;
    }

    public void setScheduleDaily(tncc.power.value.ScheduleDaily scheduleDaily) {
	this.scheduleDaily = scheduleDaily;
    }

    public Long getScheduleDailyId() {
	if (this.scheduleDaily != null && this.scheduleDaily.getId() != null)
	    return scheduleDaily.getId();
	return this.scheduleDailyId;
    }

    public void setScheduleDailyId(Long id) {
	this.scheduleDailyId = id;
    }

    public tncc.power.value.Reader getReader() {
	return this.reader;
    }

    public void setReader(tncc.power.value.Reader reader) {
	this.reader = reader;
    }

    public Long getReaderId() {
	if (this.reader != null && this.reader.getId() != null)
	    return reader.getId();
	return this.readerId;
    }

    public void setReaderId(Long id) {
	this.readerId = id;
    }

    public Member getCreatedUser() {
	return createdUser;
    }

    public void setCreatedUser(Member createdUser) {
	this.createdUser = createdUser;
    }
    
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String toString() {
	return new ToStringBuilder(this).append("msg", getMsg())
		.append("createdDate", getCreatedDate())
		.append("scheduleDaily", getScheduleDaily())
		.append("reader", getReader()).toString();
    }
    
    public static long getLogTypeId(Long schduledailyId){
	
	switch(Integer.parseInt(String.valueOf(schduledailyId)))
	     {
	     
	       //課表排程
	       case 81:	
		    return 70L;		  
		   //手動排程
	       case 82:
		   return 69L;  		 
	     
		   //每日強制關閉時段
	       case 89:
		   return 89L; 	   
	       
	       //每日強制初始化時段
	       default:
		   return 90L;   		  
	     }
      
    }

    public String getCaption_() {
	return toString();
    }

}
