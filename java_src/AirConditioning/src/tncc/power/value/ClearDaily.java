package tncc.power.value;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class ClearDaily extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;
    /** nullable persistent field */
    
    Long id;

	private tncc.power.value.Reader reader;
    private Long readerId;

	PowerController powercontroller;

    /** full constructor */
    public ClearDaily(tncc.power.value.Reader reader) {
        this.reader = reader;
    }

    /** Labor constructor */
    public ClearDaily() {
    }
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
    
    public PowerController getPowercontroller() {
		return powercontroller;
	}

	public void setPowercontroller(PowerController powercontroller) {
		this.powercontroller = powercontroller;
	}

    public String toString() {
        return new ToStringBuilder(this)
            .append("reader", getReader())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
