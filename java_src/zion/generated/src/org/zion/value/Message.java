package org.zion.value;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class Message extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;
    /** persistent field */
    private String subject;

    /** persistent field */
    private String youtube;

    /** persistent field */
    private Date messageDate;

    /** full constructor */
    public Message(String subject, String youtube, Date messageDate) {
        this.subject = subject;
        this.youtube = youtube;
        this.messageDate = messageDate;
    }

    /** default constructor */
    public Message() {
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getYoutube() {
        return this.youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }

    public Date getMessageDate() {
        return this.messageDate;
    }

    public void setMessageDate(Date messageDate) {
        this.messageDate = messageDate;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("subject", getSubject())
            .append("youtube", getYoutube())
            .append("messageDate", getMessageDate())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
