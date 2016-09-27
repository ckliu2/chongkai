package tncc.power.value;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class EvenLog extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;
    /** persistent field */
    private Float perc;

    /** persistent field */
    private Float kw;

    /** nullable persistent field */
    private Boolean alertmsg;

    /** persistent field */
    private Date createdDate;

    /** persistent field */
    private tncc.power.value.Shutdown shutdownprc;
    private Long shutdownprcId;

    /** full constructor */
    public EvenLog(Float perc, Float kw, Boolean alertmsg, Date createdDate, tncc.power.value.Shutdown shutdownprc) {
        this.perc = perc;
        this.kw = kw;
        this.alertmsg = alertmsg;
        this.createdDate = createdDate;
        this.shutdownprc = shutdownprc;
    }

    /** default constructor */
    public EvenLog() {
    }

    /** minimal constructor */
    public EvenLog(Float perc, Float kw, Date createdDate, tncc.power.value.Shutdown shutdownprc) {
        this.perc = perc;
        this.kw = kw;
        this.createdDate = createdDate;
        this.shutdownprc = shutdownprc;
    }

    public Float getPerc() {
        return this.perc;
    }

    public void setPerc(Float perc) {
        this.perc = perc;
    }

    public Float getKw() {
        return this.kw;
    }

    public void setKw(Float kw) {
        this.kw = kw;
    }

    public Boolean getAlertmsg() {
        return this.alertmsg;
    }

    public void setAlertmsg(Boolean alertmsg) {
        this.alertmsg = alertmsg;
    }

    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public tncc.power.value.Shutdown getShutdownprc() {
        return this.shutdownprc;
    }

    public void setShutdownprc(tncc.power.value.Shutdown shutdownprc) {
        this.shutdownprc = shutdownprc;
    }

    public Long getShutdownprcId() {
        if (this.shutdownprc != null && this.shutdownprc.getId() != null)
            return shutdownprc.getId();
        return this.shutdownprcId;
    }

    public void setShutdownprcId(Long id) {
        this.shutdownprcId = id;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("perc", getPerc())
            .append("kw", getKw())
            .append("alertmsg", getAlertmsg())
            .append("createdDate", getCreatedDate())
            .append("shutdownprc", getShutdownprc())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
