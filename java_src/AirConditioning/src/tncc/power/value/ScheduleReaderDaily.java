package tncc.power.value;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.AppProperty;
import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class ScheduleReaderDaily extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;

	String id;    
    
    /** persistent field */
    private Date scheduledDate;

    /** nullable persistent field */
    private Boolean active;

    /** persistent field */
    private tncc.power.value.Reader reader;
    private Long readerId;

    /** persistent field */
    private ScheduleDaily scheduleDaily;
    
	PowerController powerController;
	
	AppProperty type;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
    public ScheduleDaily getScheduleDaily() {
		return scheduleDaily;
	}

	public void setScheduleDaily(ScheduleDaily scheduleDaily) {
		this.scheduleDaily = scheduleDaily;
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
    
    public PowerController getPowerController() {
		return powerController;
	}

	public void setPowerController(PowerController powerController) {
		this.powerController = powerController;
	}

	public AppProperty getType() {
		return type;
	}

	public void setType(AppProperty type) {
		this.type = type;
	}
	
    public String toString() {
        return new ToStringBuilder(this)
            .append("scheduledDate", getScheduledDate())
            .append("active", getActive())
            .append("reader", getReader())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
