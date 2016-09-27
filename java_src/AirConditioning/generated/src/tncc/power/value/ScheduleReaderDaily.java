package tncc.power.value;

import com.base.value.AppProperty;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class ScheduleReaderDaily extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;
    /** persistent field */
    private Date scheduledDate;

    /** nullable persistent field */
    private Boolean active;

    /** persistent field */
    private tncc.power.value.Reader reader;
    private Long readerId;

    /** persistent field */
    private tncc.power.value.ScheduleDaily scheduleDaily;
    private Long scheduleDailyId;

    /** nullable persistent field */
    private AppProperty type;
    private Long typeId;

    /** persistent field */
    private tncc.power.value.PowerController powerController;
    private Long powerControllerId;

    /** full constructor */
    public ScheduleReaderDaily(Date scheduledDate, Boolean active, tncc.power.value.Reader reader, tncc.power.value.ScheduleDaily scheduleDaily, AppProperty type, tncc.power.value.PowerController powerController) {
        this.scheduledDate = scheduledDate;
        this.active = active;
        this.reader = reader;
        this.scheduleDaily = scheduleDaily;
        this.type = type;
        this.powerController = powerController;
    }

    /** default constructor */
    public ScheduleReaderDaily() {
    }

    /** minimal constructor */
    public ScheduleReaderDaily(Date scheduledDate, tncc.power.value.Reader reader, tncc.power.value.ScheduleDaily scheduleDaily, tncc.power.value.PowerController powerController) {
        this.scheduledDate = scheduledDate;
        this.reader = reader;
        this.scheduleDaily = scheduleDaily;
        this.powerController = powerController;
    }

    public Date getScheduledDate() {
        return this.scheduledDate;
    }

    public void setScheduledDate(Date scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
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

    public tncc.power.value.PowerController getPowerController() {
        return this.powerController;
    }

    public void setPowerController(tncc.power.value.PowerController powerController) {
        this.powerController = powerController;
    }

    public Long getPowerControllerId() {
        if (this.powerController != null && this.powerController.getId() != null)
            return powerController.getId();
        return this.powerControllerId;
    }

    public void setPowerControllerId(Long id) {
        this.powerControllerId = id;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("scheduledDate", getScheduledDate())
            .append("active", getActive())
            .append("reader", getReader())
            .append("scheduleDaily", getScheduleDaily())
            .append("type", getType())
            .append("powerController", getPowerController())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
