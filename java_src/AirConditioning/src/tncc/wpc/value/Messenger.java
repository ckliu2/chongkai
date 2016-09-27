package tncc.wpc.value;

import com.common.value.Member;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class Messenger extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;
    
	private Long id;
    
    /** persistent field */
    private String name;

    /** persistent field */
    private String memo;

    /** persistent field */
    private Date createdDate;

    /** persistent field */
    private Member member;
    private Long memberId;

    /** persistent field */
    private Member createdUser;
    private Long createdUserId;

    /** nullable persistent field */
    private List securitys;

    /** full constructor */
    public Messenger(String name, String memo, Date createdDate, Member member, Member createdUser, List securitys) {
        this.name = name;
        this.memo = memo;
        this.createdDate = createdDate;
        this.member = member;
        this.createdUser = createdUser;
        this.securitys = securitys;
    }

    /** Labor constructor */
    public Messenger() {
    }

    /** minimal constructor */
    public Messenger(String name, String memo, Date createdDate, Member member, Member createdUser) {
        this.name = name;
        this.memo = memo;
        this.createdDate = createdDate;
        this.member = member;
        this.createdUser = createdUser;
    }
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMemo() {
        return this.memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
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

    public List getSecuritys() {
        return this.securitys;
    }

    public void setSecuritys(List securitys) {
        this.securitys = securitys;
    }

    public String toString() {
       /* return new ToStringBuilder(this)
            .append("name", getName())
            .append("memo", getMemo())
            .append("createdDate", getCreatedDate())
            .append("member", getMember())
            .append("createdUser", getCreatedUser())
            .append("security", getSecuritys())
            .toString();*/
            return getName();
    }

    public String getCaption_() {
        return toString();
    }

}
