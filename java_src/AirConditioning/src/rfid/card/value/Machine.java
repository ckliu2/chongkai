package rfid.card.value;

import com.base.value.AppProperty;
import com.common.value.Member;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class Machine extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;   


	private Long id;	
	
    /** nullable persistent field */
    private Integer money;

    /** persistent field */
    private Date createdDate;

    /** persistent field */
    private Member member;
    private Long memberId;

    /** persistent field */
    private AppProperty kind;
    private Long kindId;

    /** full constructor */
    public Machine(Integer money, Date createdDate, Member member, AppProperty kind) {
        this.money = money;
        this.createdDate = createdDate;
        this.member = member;
        this.kind = kind;
    }

    /** Labor constructor */
    public Machine() {
    }

    /** minimal constructor */
    public Machine(Date createdDate, Member member, AppProperty kind) {
        this.createdDate = createdDate;
        this.member = member;
        this.kind = kind;
    }

    public Integer getMoney() {
        return this.money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Member getMember() {
        return this.member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Long getMemberId() {
        if (this.member != null && this.member.getId() != null)
            return member.getId();
        return this.memberId;
    }

    public void setMemberId(Long id) {
        this.memberId = id;
    }

    public AppProperty getKind() {
        return this.kind;
    }

    public void setKind(AppProperty kind) {
        this.kind = kind;
    }

    public Long getKindId() {
        if (this.kind != null && this.kind.getId() != null)
            return kind.getId();
        return this.kindId;
    }

    public void setKindId(Long id) {
        this.kindId = id;
    }
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    public String toString() {
        return new ToStringBuilder(this)
            .append("money", getMoney())
            .append("createdDate", getCreatedDate())
            .append("member", getMember())
            .append("kind", getKind())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
