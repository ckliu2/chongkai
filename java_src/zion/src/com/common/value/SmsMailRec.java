package com.common.value;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class SmsMailRec implements Serializable {

    private static final long serialVersionUID = 1L;    

	private Long id;
    
    /** persistent field */
    private String cellphone;

    /** persistent field */
    private String email;   

	/** persistent field */
    private String cellphone1;

    /** persistent field */
    private String email1;

    /** persistent field */
    private String msg;

    /** nullable persistent field */
    private Date sendDate;

    /** nullable persistent field */
    private com.common.value.Member target;
    private Long targetId;

    /** nullable persistent field */
    private com.common.value.Member member;
    private Long memberId;

    /** full constructor */
    public SmsMailRec(String cellphone, String email, String msg, Date sendDate, com.common.value.Member target, com.common.value.Member member) {
        this.cellphone = cellphone;
        this.email = email;
        this.msg = msg;
        this.sendDate = sendDate;
        this.target = target;
        this.member = member;
    }

    /** default constructor */
    public SmsMailRec() {
    }

    /** minimal constructor */
    public SmsMailRec(String cellphone, String email, String msg) {
        this.cellphone = cellphone;
        this.email = email;
        this.msg = msg;
    }

    public String getCellphone() {
        return this.cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getSendDate() {
        return this.sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public com.common.value.Member getTarget() {
        return this.target;
    }

    public void setTarget(com.common.value.Member target) {
        this.target = target;
    }

    public Long getTargetId() {
        if (this.target != null && this.target.getId() != null)
            return target.getId();
        return this.targetId;
    }

    public void setTargetId(Long id) {
        this.targetId = id;
    }

    public com.common.value.Member getMember() {
        return this.member;
    }

    public void setMember(com.common.value.Member member) {
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
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	 public String getCellphone1() {
			return cellphone1;
		}

		public void setCellphone1(String cellphone1) {
			this.cellphone1 = cellphone1;
		}

		public String getEmail1() {
			return email1;
		}

		public void setEmail1(String email1) {
			this.email1 = email1;
		}


    public String toString() {
        return new ToStringBuilder(this)
            .append("cellphone", getCellphone())
            .append("email", getEmail())
            .append("msg", getMsg())
            .append("sendDate", getSendDate())
            .append("target", getTarget())
            .append("member", getMember())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
