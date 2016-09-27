package rfid.card.value;

import com.base.value.AppProperty;
import com.common.value.Member;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class Recorder extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;
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
    
    /** persistent field */
    private Member createdUser;
    private Long createdUserId;
    
    
	private Long id;
	
	
    /** nullable persistent field */
    private String memo;

    /** full constructor */
    public Recorder(Integer money, Date createdDate, Member member, AppProperty kind) {
        this.money = money;
        this.createdDate = createdDate;
        this.member = member;
        this.kind = kind;
    }

    /** Labor constructor */
    public Recorder() {
    }

    /** minimal constructor */
    public Recorder(Date createdDate, Member member, AppProperty kind) {
        this.createdDate = createdDate;
        this.member = member;
        this.kind = kind;
    }
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
    
    public String getMemo() {
        return this.memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
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
