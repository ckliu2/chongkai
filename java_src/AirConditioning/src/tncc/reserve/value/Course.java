package tncc.reserve.value;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class Course extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;
    /** persistent field */
    private String id;   

	private String name;

    /** full constructor */
    public Course(String name) {
        this.name = name;
    }

    /** Labor constructor */
    public Course() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

    public String toString() {
        return new ToStringBuilder(this)
            .append("name", getName())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
