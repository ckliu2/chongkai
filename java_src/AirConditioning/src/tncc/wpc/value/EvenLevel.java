package tncc.wpc.value;

import com.common.value.Member;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class EvenLevel extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;   


	private Long id;
    
    /** nullable persistent field */
    private String name;

    /** nullable persistent field */
    private String shortMessage;

    /** nullable persistent field */
    private String longMessage;

    /** nullable persistent field */
    private String memo;

    /** persistent field */
    private Date createdDate;

    /** persistent field */
    private Member member;
    private Long memberId;

    /** persistent field */
    private Member createdUser;
    private Long createdUserId;
    
    /** persistent field */
    private Messenger messenger;
    private Long messengerId;

    /** full constructor */
    public EvenLevel(String name, String shortMessage, String longMessage, String memo, Date createdDate, Member member, Member createdUser) {
        this.name = name;
        this.shortMessage = shortMessage;
        this.longMessage = longMessage;
        this.memo = memo;
        this.createdDate = createdDate;
        this.member = member;
        this.createdUser = createdUser;
    }

    /** Labor constructor */
    public EvenLevel() {
    }

    /** minimal constructor */
    public EvenLevel(Date createdDate, Member member, Member createdUser) {
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

    public String getShortMessage() {
        return this.shortMessage;
    }

    public void setShortMessage(String shortMessage) {
        this.shortMessage = shortMessage;
    }

    public String getLongMessage() {
        return this.longMessage;
    }

    public void setLongMessage(String longMessage) {
        this.longMessage = longMessage;
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
    
    public Messenger getMessenger() {
        return this.messenger;
    }

    public void setMessenger(Messenger messenger) {
        this.messenger = messenger;
    }

    public Long getMessengerId() {
        if (this.messenger != null && this.messenger.getId() != null)
            return messenger.getId();
        return this.messengerId;
    }

    public void setMessengerId(Long id) {
        this.messengerId = id;
    }




    public String toString() {
        return new ToStringBuilder(this)
            .append("name", getName())
            .append("shortMessage", getShortMessage())
            .append("longMessage", getLongMessage())
            .append("memo", getMemo())
            .append("createdDate", getCreatedDate())
            .append("member", getMember())
            .append("createdUser", getCreatedUser())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
