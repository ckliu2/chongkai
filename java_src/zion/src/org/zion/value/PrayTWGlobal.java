package org.zion.value;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class PrayTWGlobal extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;
    
    
	Long id;
	
	
    /** persistent field */
    private String content;

    /** full constructor */
    public PrayTWGlobal(String content) {
        this.content = content;
    }

    /** default constructor */
    public PrayTWGlobal() {
    }
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("content", getContent())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
