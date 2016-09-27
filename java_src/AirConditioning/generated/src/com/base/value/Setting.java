package com.base.value;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class Setting extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;
    /** persistent field */
    private Integer year;

    /** persistent field */
    private Integer sem;

    /** full constructor */
    public Setting(Integer year, Integer sem) {
        this.year = year;
        this.sem = sem;
    }

    /** Labor constructor */
    public Setting() {
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

    public String toString() {
        return new ToStringBuilder(this)
            .append("year", getYear())
            .append("sem", getSem())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
