package tncc.wpc.value;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class Times extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;
    
	private Long id;
	
    /** nullable persistent field */
    private Integer time;

    /** nullable persistent field */
    private Integer cycle;

    /** full constructor */
    public Times(Integer time, Integer cycle) {
        this.time = time;
        this.cycle = cycle;
    }

    /** Labor constructor */
    public Times() {
    }
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    public Integer getTime() {
        return this.time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getCycle() {
        return this.cycle;
    }

    public void setCycle(Integer cycle) {
        this.cycle = cycle;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("time", getTime())
            .append("cycle", getCycle())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
