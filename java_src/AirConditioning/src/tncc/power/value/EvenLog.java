package tncc.power.value;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class EvenLog extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;
    
	private Long id;
	
	
    /** persistent field */
    private float perc;

    /** persistent field */
    private float kw;

    /** persistent field */
    private Date createdDate; 

	//private boolean alertmsg=false;
	private Boolean alertmsg = new Boolean(false);

    /** persistent field */
    private tncc.power.value.Shutdown shutdownprc;
    private Long shutdownprcId;

    /** full constructor */
    public EvenLog(Integer perc, Integer kw, Date createdDate, tncc.power.value.Shutdown shutdownprc) {
        this.perc = perc;
        this.kw = kw;
        this.createdDate = createdDate;
        this.shutdownprc = shutdownprc;
    }

    /** Labor constructor */
    public EvenLog() {
    }
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    public float getPerc() {
        return this.perc;
    }

    public void setPerc(float perc) {
        this.perc = perc;
    }

    public float getKw() {
        return this.kw;
    }

    public void setKw(float kw) {
        this.kw = kw;
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
    
	public Boolean getAlertmsg() {
		return alertmsg;
	}

	public void setAlertmsg(Boolean alertmsg) {
		this.alertmsg = alertmsg;
	}

    /*
	public boolean isAlertmsg() {
		return alertmsg;
	}

	public void setAlertmsg(boolean alertmsg) {
		this.alertmsg = alertmsg;
	}
*/

    public String toString() {
        return new ToStringBuilder(this)
            .append("perc", getPerc())
            .append("kw", getKw())
            .append("createdDate", getCreatedDate())
            .append("shutdownprc", getShutdownprc())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
