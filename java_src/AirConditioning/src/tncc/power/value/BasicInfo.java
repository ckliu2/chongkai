package tncc.power.value;

import com.common.value.Member;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class BasicInfo extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /** persistent field */
    private Integer contract;

    /** persistent field */
    private Date createdDate;

    /** persistent field */
    private Member createdUser;
    private Long createdUserId;

    private Integer year;
    private Integer sem;
    private Integer onMinutes;
    private Integer offMinutes;
    private Integer flag;

    private Integer timingEveryMins;
    private Integer weeklyEveryMins;

    Date scheduleStart;
    Date scheduleEnd;
    Integer threshold;

    List shutdownReaders;
    String shutdownTime;

    String initializeTime;

    Integer panelUpdateMins;

    Integer scheduleCheckMins;

    Integer templimit;

    /** full constructor */
    public BasicInfo(Integer contract, Date createdDate, Member createdUser) {
	this.contract = contract;
	this.createdDate = createdDate;
	this.createdUser = createdUser;
    }

    /** Labor constructor */
    public BasicInfo() {
    }

    public Integer getContract() {
	return this.contract;
    }

    public void setContract(Integer contract) {
	this.contract = contract;
    }

    public Date getCreatedDate() {
	return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
	this.createdDate = createdDate;
    }

    public Member getCreatedUser() {
	return this.createdUser;
    }

    public void setCreatedUser(Member createdUser) {
	this.createdUser = createdUser;
    }

    public Long getCreatedUserId() {
	if (this.createdUser != null && this.createdUser.getId() != null)
	    return createdUser.getId();
	return this.createdUserId;
    }

    public void setCreatedUserId(Long id) {
	this.createdUserId = id;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public Integer getYear() {
	return year;
    }

    public void setYear(Integer year) {
	this.year = year;
    }

    public Integer getSem() {
	return sem;
    }

    public void setSem(Integer sem) {
	this.sem = sem;
    }

    public Integer getOnMinutes() {
	return onMinutes;
    }

    public void setOnMinutes(Integer onMinutes) {
	this.onMinutes = onMinutes;
    }

    public Integer getOffMinutes() {
	return offMinutes;
    }

    public void setOffMinutes(Integer offMinutes) {
	this.offMinutes = offMinutes;
    }

    public Integer getFlag() {
	return flag;
    }

    public void setFlag(Integer flag) {
	this.flag = flag;
    }

    public Date getScheduleStart() {
	return scheduleStart;
    }

    public void setScheduleStart(Date scheduleStart) {
	this.scheduleStart = scheduleStart;
    }

    public Date getScheduleEnd() {
	return scheduleEnd;
    }

    public void setScheduleEnd(Date scheduleEnd) {
	this.scheduleEnd = scheduleEnd;
    }

    public Integer getThreshold() {
	return threshold;
    }

    public void setThreshold(Integer threshold) {
	this.threshold = threshold;
    }

    public Integer getTimingEveryMins() {
	return timingEveryMins;
    }

    public void setTimingEveryMins(Integer timingEveryMins) {
	this.timingEveryMins = timingEveryMins;
    }

    public Integer getWeeklyEveryMins() {
	return weeklyEveryMins;
    }

    public void setWeeklyEveryMins(Integer weeklyEveryMins) {
	this.weeklyEveryMins = weeklyEveryMins;
    }

    public List getShutdownReaders() {
	return shutdownReaders;
    }

    public void setShutdownReaders(List shutdownReaders) {
	this.shutdownReaders = shutdownReaders;
    }

    public String getShutdownTime() {
	return shutdownTime;
    }

    public void setShutdownTime(String shutdownTime) {
	this.shutdownTime = shutdownTime;
    }

    public String getInitializeTime() {
	return initializeTime;
    }

    public void setInitializeTime(String initializeTime) {
	this.initializeTime = initializeTime;
    }

    public Integer getPanelUpdateMins() {
	return panelUpdateMins;
    }

    public void setPanelUpdateMins(Integer panelUpdateMins) {
	this.panelUpdateMins = panelUpdateMins;
    }

    public Integer getScheduleCheckMins() {
	return scheduleCheckMins;
    }

    public void setScheduleCheckMins(Integer scheduleCheckMins) {
	this.scheduleCheckMins = scheduleCheckMins;
    }
    
    public Integer getTemplimit() {
        return templimit;
    }

    public void setTemplimit(Integer templimit) {
        this.templimit = templimit;
    }

    public String toString() {
	return new ToStringBuilder(this).append("contract", getContract())
		.append("createdDate", getCreatedDate())
		.append("createdUser", getCreatedUser()).toString();
    }

    public String getCaption_() {
	return toString();
    }

}
