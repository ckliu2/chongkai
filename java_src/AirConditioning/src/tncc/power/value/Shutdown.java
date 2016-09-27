package tncc.power.value;

import com.common.value.Member;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;
import tncc.wpc.value.*;

/** @author Hibernate CodeGenerator */
public class Shutdown extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;  


	private Long id;
	
    /** persistent field */
    private String name;

    /** persistent field */
    private Integer perc;

    /** persistent field */
    private Date createdDate;

    /** persistent field */
    private Member createdUser;
    private Long createdUserId;

    /** nullable persistent field */
    private List reader;
    
    /** persistent field */
    private Integer gap;
    
    /** persistent field */
    private EvenLevel evenlevel;
    private Long evenlevelId;


	/** Labor constructor */
    public Shutdown() {
    }



    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPerc() {
        return this.perc;
    }

    public void setPerc(Integer perc) {
        this.perc = perc;
    }

    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Member getCreatedUser() {
        return this.createdUser;
    }

    public void setCreatedUser(Member createdUser) {
        this.createdUser = createdUser;
    }

    public Long getCreatedUserId() {
        if (this.createdUser != null && this.createdUser.getId() != null)
            return createdUser.getId();
        return this.createdUserId;
    }

    public void setCreatedUserId(Long id) {
        this.createdUserId = id;
    }

    public List getReader() {
        return this.reader;
    }

    public void setReader(List reader) {
        this.reader = reader;
    }
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
    public Integer getGap() {
		return gap;
	}

	public void setGap(Integer gap) {
		this.gap = gap;
	}
	
    public EvenLevel getEvenlevel() {
        return this.evenlevel;
    }

    public void setEvenlevel(EvenLevel evenlevel) {
        this.evenlevel = evenlevel;
    }

    public Long getEvenlevelId() {
        if (this.evenlevel != null && this.evenlevel.getId() != null)
            return evenlevel.getId();
        return this.evenlevelId;
    }

    public void setEvenlevelId(Long id) {
        this.evenlevelId = id;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("name", getName())
            .append("perc", getPerc())
            .append("createdDate", getCreatedDate())
            .append("createdUser", getCreatedUser())
            .append("reader", getReader())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
