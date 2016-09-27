package tncc.power.value;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
import tncc.reserve.value.*;
import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class PowerControllerReader extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;

	private String id;
    
    /** nullable persistent field */
    private String name;

    /** nullable persistent field */
    private tncc.power.value.PowerController powerController;
    private Long powerControllerId;

    /** nullable persistent field */
    private tncc.power.value.Reader reader;
    private Long readerId;   

	int deviceNo;

	ClassRoom classRoom;

	Course course;

    /** full constructor */
    public PowerControllerReader(String name, tncc.power.value.PowerController powerController, tncc.power.value.Reader reader) {
        this.name = name;
        this.powerController = powerController;
        this.reader = reader;
    }

    /** Labor constructor */
    public PowerControllerReader() {
    }
    
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
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
    
    public int getDeviceNo() {
		return deviceNo;
	}

	public void setDeviceNo(int deviceNo) {
		this.deviceNo = deviceNo;
	}
	
	public ClassRoom getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(ClassRoom classRoom) {
		this.classRoom = classRoom;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
    public String toString() {
        return new ToStringBuilder(this)
            .append("name", getName())
            .append("powerController", getPowerController())
            .append("reader", getReader())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
