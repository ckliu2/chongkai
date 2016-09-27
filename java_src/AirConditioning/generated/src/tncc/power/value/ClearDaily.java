package tncc.power.value;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class ClearDaily extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;
    /** nullable persistent field */
    private tncc.power.value.Reader reader;
    private Long readerId;

    /** nullable persistent field */
    private tncc.power.value.PowerController powercontroller;
    private Long powercontrollerId;

    /** full constructor */
    public ClearDaily(tncc.power.value.Reader reader, tncc.power.value.PowerController powercontroller) {
        this.reader = reader;
        this.powercontroller = powercontroller;
    }

    /** default constructor */
    public ClearDaily() {
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

    public tncc.power.value.PowerController getPowercontroller() {
        return this.powercontroller;
    }

    public void setPowercontroller(tncc.power.value.PowerController powercontroller) {
        this.powercontroller = powercontroller;
    }

    public Long getPowercontrollerId() {
        if (this.powercontroller != null && this.powercontroller.getId() != null)
            return powercontroller.getId();
        return this.powercontrollerId;
    }

    public void setPowercontrollerId(Long id) {
        this.powercontrollerId = id;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("reader", getReader())
            .append("powercontroller", getPowercontroller())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
