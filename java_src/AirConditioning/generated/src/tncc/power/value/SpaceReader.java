package tncc.power.value;

import com.base.value.AppProperty;
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class SpaceReader extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;
    /** nullable persistent field */
    private String name;

    /** nullable persistent field */
    private String seqName;

    /** nullable persistent field */
    private tncc.power.value.Space space;
    private Long spaceId;

    /** nullable persistent field */
    private tncc.power.value.Reader reader;
    private Long readerId;

    /** nullable persistent field */
    private tncc.power.value.PowerController powercontroller;
    private Long powercontrollerId;

    /** nullable persistent field */
    private AppProperty state;
    private Long stateId;

    /** full constructor */
    public SpaceReader(String name, String seqName, tncc.power.value.Space space, tncc.power.value.Reader reader, tncc.power.value.PowerController powercontroller, AppProperty state) {
        this.name = name;
        this.seqName = seqName;
        this.space = space;
        this.reader = reader;
        this.powercontroller = powercontroller;
        this.state = state;
    }

    /** default constructor */
    public SpaceReader() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeqName() {
        return this.seqName;
    }

    public void setSeqName(String seqName) {
        this.seqName = seqName;
    }

    public tncc.power.value.Space getSpace() {
        return this.space;
    }

    public void setSpace(tncc.power.value.Space space) {
        this.space = space;
    }

    public Long getSpaceId() {
        if (this.space != null && this.space.getId() != null)
            return space.getId();
        return this.spaceId;
    }

    public void setSpaceId(Long id) {
        this.spaceId = id;
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

    public AppProperty getState() {
        return this.state;
    }

    public void setState(AppProperty state) {
        this.state = state;
    }

    public Long getStateId() {
        if (this.state != null && this.state.getId() != null)
            return state.getId();
        return this.stateId;
    }

    public void setStateId(Long id) {
        this.stateId = id;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("name", getName())
            .append("seqName", getSeqName())
            .append("space", getSpace())
            .append("reader", getReader())
            .append("powercontroller", getPowercontroller())
            .append("state", getState())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
