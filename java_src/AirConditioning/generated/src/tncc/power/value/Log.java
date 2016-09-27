package tncc.power.value;

import com.base.value.AppProperty;
import com.common.value.Member;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class Log extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;
    /** nullable persistent field */
    private String msg;

    /** nullable persistent field */
    private Date createdDate;

    /** persistent field */
    private AppProperty type;
    private Long typeId;

    /** nullable persistent field */
    private tncc.power.value.ScheduleDaily scheduleDaily;
    private Long scheduleDailyId;

    /** nullable persistent field */
    private tncc.power.value.Reader reader;
    private Long readerId;

    /** nullable persistent field */
    private Member createdUser;
    private Long createdUserId;

    /** full constructor */
    public Log(String msg, Date createdDate, AppProperty type, tncc.power.value.ScheduleDaily scheduleDaily, tncc.power.value.Reader reader, Member createdUser) {
        this.msg = msg;
        this.createdDate = createdDate;
        this.type = type;
        this.scheduleDaily = scheduleDaily;
        this.reader = reader;
        this.createdUser = createdUser;
    }

    /** default constructor */
    public Log() {
    }

    /** minimal constructor */
    public Log(AppProperty type) {
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

    public AppProperty getType() {
        return this.type;
    }

    public void setType(AppProperty type) {
        this.type = type;
    }

    public Long getTypeId() {
        if (this.type != null && this.type.getId() != null)
            return type.getId();
        return this.typeId;
    }

    public void setTypeId(Long id) {
        this.typeId = id;
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

    public String toString() {
        return new ToStringBuilder(this)
            .append("msg", getMsg())
            .append("createdDate", getCreatedDate())
            .append("type", getType())
            .append("scheduleDaily", getScheduleDaily())
            .append("reader", getReader())
            .append("createdUser", getCreatedUser())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
