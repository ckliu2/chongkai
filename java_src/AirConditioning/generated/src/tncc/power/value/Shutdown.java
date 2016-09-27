package tncc.power.value;

import com.common.value.Member;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang.builder.ToStringBuilder;
import tncc.wpc.value.EvenLevel;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class Shutdown extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;
    /** persistent field */
    private String name;

    /** persistent field */
    private Integer perc;

    /** persistent field */
    private Integer gap;

    /** persistent field */
    private Date createdDate;

    /** persistent field */
    private Member createdUser;
    private Long createdUserId;

    /** persistent field */
    private EvenLevel evenlevel;
    private Long evenlevelId;

    /** nullable persistent field */
    private List reader;

    /** full constructor */
    public Shutdown(String name, Integer perc, Integer gap, Date createdDate, Member createdUser, EvenLevel evenlevel, List reader) {
        this.name = name;
        this.perc = perc;
        this.gap = gap;
        this.createdDate = createdDate;
        this.createdUser = createdUser;
        this.evenlevel = evenlevel;
        this.reader = reader;
    }

    /** default constructor */
    public Shutdown() {
    }

    /** minimal constructor */
    public Shutdown(String name, Integer perc, Integer gap, Date createdDate, Member createdUser, EvenLevel evenlevel) {
        this.name = name;
        this.perc = perc;
        this.gap = gap;
        this.createdDate = createdDate;
        this.createdUser = createdUser;
        this.evenlevel = evenlevel;
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

    public Integer getGap() {
        return this.gap;
    }

    public void setGap(Integer gap) {
        this.gap = gap;
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

    public List getReader() {
        return this.reader;
    }

    public void setReader(List reader) {
        this.reader = reader;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("name", getName())
            .append("perc", getPerc())
            .append("gap", getGap())
            .append("createdDate", getCreatedDate())
            .append("createdUser", getCreatedUser())
            .append("evenlevel", getEvenlevel())
            .append("reader", getReader())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
