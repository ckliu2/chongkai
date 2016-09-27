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
    /** persistent field */
    private Integer year;

    /** persistent field */
    private Integer sem;

    /** persistent field */
    private Integer onMinutes;

    /** persistent field */
    private Integer offMinutes;

    /** persistent field */
    private Date scheduleStart;

    /** persistent field */
    private Date scheduleEnd;

    /** persistent field */
    private Integer threshold;

    /** nullable persistent field */
    private Integer contract;

    /** persistent field */
    private Integer timingEveryMins;

    /** persistent field */
    private Integer weeklyEveryMins;

    /** nullable persistent field */
    private Integer panelUpdateMins;

    /** nullable persistent field */
    private Integer scheduleCheckMins;

    /** persistent field */
    private Date createdDate;

    /** persistent field */
    private Integer flag;

    /** nullable persistent field */
    private String shutdownTime;

    /** nullable persistent field */
    private String initializeTime;

    /** persistent field */
    private Member createdUser;
    private Long createdUserId;

    /** nullable persistent field */
    private List shutdownReaders;

    /** full constructor */
    public BasicInfo(Integer year, Integer sem, Integer onMinutes, Integer offMinutes, Date scheduleStart, Date scheduleEnd, Integer threshold, Integer contract, Integer timingEveryMins, Integer weeklyEveryMins, Integer panelUpdateMins, Integer scheduleCheckMins, Date createdDate, Integer flag, String shutdownTime, String initializeTime, Member createdUser, List shutdownReaders) {
        this.year = year;
        this.sem = sem;
        this.onMinutes = onMinutes;
        this.offMinutes = offMinutes;
        this.scheduleStart = scheduleStart;
        this.scheduleEnd = scheduleEnd;
        this.threshold = threshold;
        this.contract = contract;
        this.timingEveryMins = timingEveryMins;
        this.weeklyEveryMins = weeklyEveryMins;
        this.panelUpdateMins = panelUpdateMins;
        this.scheduleCheckMins = scheduleCheckMins;
        this.createdDate = createdDate;
        this.flag = flag;
        this.shutdownTime = shutdownTime;
        this.initializeTime = initializeTime;
        this.createdUser = createdUser;
        this.shutdownReaders = shutdownReaders;
    }

    /** default constructor */
    public BasicInfo() {
    }

    /** minimal constructor */
    public BasicInfo(Integer year, Integer sem, Integer onMinutes, Integer offMinutes, Date scheduleStart, Date scheduleEnd, Integer threshold, Integer timingEveryMins, Integer weeklyEveryMins, Date createdDate, Integer flag, Member createdUser) {
        this.year = year;
        this.sem = sem;
        this.onMinutes = onMinutes;
        this.offMinutes = offMinutes;
        this.scheduleStart = scheduleStart;
        this.scheduleEnd = scheduleEnd;
        this.threshold = threshold;
        this.timingEveryMins = timingEveryMins;
        this.weeklyEveryMins = weeklyEveryMins;
        this.createdDate = createdDate;
        this.flag = flag;
        this.createdUser = createdUser;
    }

    public Integer getYear() {
        return this.year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getSem() {
        return this.sem;
    }

    public void setSem(Integer sem) {
        this.sem = sem;
    }

    public Integer getOnMinutes() {
        return this.onMinutes;
    }

    public void setOnMinutes(Integer onMinutes) {
        this.onMinutes = onMinutes;
    }

    public Integer getOffMinutes() {
        return this.offMinutes;
    }

    public void setOffMinutes(Integer offMinutes) {
        this.offMinutes = offMinutes;
    }

    public Date getScheduleStart() {
        return this.scheduleStart;
    }

    public void setScheduleStart(Date scheduleStart) {
        this.scheduleStart = scheduleStart;
    }

    public Date getScheduleEnd() {
        return this.scheduleEnd;
    }

    public void setScheduleEnd(Date scheduleEnd) {
        this.scheduleEnd = scheduleEnd;
    }

    public Integer getThreshold() {
        return this.threshold;
    }

    public void setThreshold(Integer threshold) {
        this.threshold = threshold;
    }

    public Integer getContract() {
        return this.contract;
    }

    public void setContract(Integer contract) {
        this.contract = contract;
    }

    public Integer getTimingEveryMins() {
        return this.timingEveryMins;
    }

    public void setTimingEveryMins(Integer timingEveryMins) {
        this.timingEveryMins = timingEveryMins;
    }

    public Integer getWeeklyEveryMins() {
        return this.weeklyEveryMins;
    }

    public void setWeeklyEveryMins(Integer weeklyEveryMins) {
        this.weeklyEveryMins = weeklyEveryMins;
    }

    public Integer getPanelUpdateMins() {
        return this.panelUpdateMins;
    }

    public void setPanelUpdateMins(Integer panelUpdateMins) {
        this.panelUpdateMins = panelUpdateMins;
    }

    public Integer getScheduleCheckMins() {
        return this.scheduleCheckMins;
    }

    public void setScheduleCheckMins(Integer scheduleCheckMins) {
        this.scheduleCheckMins = scheduleCheckMins;
    }

    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getFlag() {
        return this.flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getShutdownTime() {
        return this.shutdownTime;
    }

    public void setShutdownTime(String shutdownTime) {
        this.shutdownTime = shutdownTime;
    }

    public String getInitializeTime() {
        return this.initializeTime;
    }

    public void setInitializeTime(String initializeTime) {
        this.initializeTime = initializeTime;
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

    public List getShutdownReaders() {
        return this.shutdownReaders;
    }

    public void setShutdownReaders(List shutdownReaders) {
        this.shutdownReaders = shutdownReaders;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("year", getYear())
            .append("sem", getSem())
            .append("onMinutes", getOnMinutes())
            .append("offMinutes", getOffMinutes())
            .append("scheduleStart", getScheduleStart())
            .append("scheduleEnd", getScheduleEnd())
            .append("threshold", getThreshold())
            .append("contract", getContract())
            .append("timingEveryMins", getTimingEveryMins())
            .append("weeklyEveryMins", getWeeklyEveryMins())
            .append("panelUpdateMins", getPanelUpdateMins())
            .append("scheduleCheckMins", getScheduleCheckMins())
            .append("createdDate", getCreatedDate())
            .append("flag", getFlag())
            .append("shutdownTime", getShutdownTime())
            .append("initializeTime", getInitializeTime())
            .append("createdUser", getCreatedUser())
            .append("shutdownReaders", getShutdownReaders())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
