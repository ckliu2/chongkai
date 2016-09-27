package tncc.wpc.value;

import com.common.value.Member;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class MyDVR extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;
    
	private Long id;
	
    /** persistent field */
    private String name;

    /** persistent field */
    private String ip;

    /** persistent field */
    private String userId;

    /** persistent field */
    private String password;

    /** persistent field */
    private Integer port;

    /** persistent field */
    private Date createdDate;

    /** persistent field */
    private Member member;
    private Long memberId;

    /** persistent field */
    private Member createdUser;
    private Long createdUserId;

    /** full constructor */
    public MyDVR(String name, String ip, String userId, String password, Integer port, Date createdDate, Member member, Member createdUser) {
        this.name = name;
        this.ip = ip;
        this.userId = userId;
        this.password = password;
        this.port = port;
        this.createdDate = createdDate;
        this.member = member;
        this.createdUser = createdUser;
    }

    /** Labor constructor */
    public MyDVR() {
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

    public String getIp() {
        return this.ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPort() {
        return this.port;
    }

    public void setPort(Integer port) {
        this.port = port;
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

    public String toString() {
        return new ToStringBuilder(this)
            .append("name", getName())
            .append("ip", getIp())
            .append("userId", getUserId())
            .append("password", getPassword())
            .append("port", getPort())
            .append("createdDate", getCreatedDate())
            .append("member", getMember())
            .append("createdUser", getCreatedUser())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
