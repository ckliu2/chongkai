package tncc.wpc.value;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class Sensorstatus extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;
    
	private Long id;
    
    /** nullable persistent field */
    private Integer status;

    /** persistent field */
    private Date createdDate;

    /** persistent field */
    private tncc.wpc.value.Sensor sensor;
    private Long sensorId;

    /** full constructor */
    public Sensorstatus(Integer status, Date createdDate, tncc.wpc.value.Sensor sensor) {
        this.status = status;
        this.createdDate = createdDate;
        this.sensor = sensor;
    }

    /** Labor constructor */
    public Sensorstatus() {
    }

    /** minimal constructor */
    public Sensorstatus(Date createdDate, tncc.wpc.value.Sensor sensor) {
        this.createdDate = createdDate;
        this.sensor = sensor;
    }
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public tncc.wpc.value.Sensor getSensor() {
        return this.sensor;
    }

    public void setSensor(tncc.wpc.value.Sensor sensor) {
        this.sensor = sensor;
    }

    public Long getSensorId() {
        if (this.sensor != null && this.sensor.getId() != null)
            return sensor.getId();
        return this.sensorId;
    }

    public void setSensorId(Long id) {
        this.sensorId = id;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("status", getStatus())
            .append("createdDate", getCreatedDate())
            .append("sensor", getSensor())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
