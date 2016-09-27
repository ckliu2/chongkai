package com.common.value;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class WebLog extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;
    /** persistent field */
    private String clientIP;

    /** nullable persistent field */
    private String visitPage;

    /** nullable persistent field */
    private String memo;

    /** nullable persistent field */
    private Date createdDate;

    /** full constructor */
    public WebLog(String clientIP, String visitPage, String memo, Date createdDate) {
        this.clientIP = clientIP;
        this.visitPage = visitPage;
        this.memo = memo;
        this.createdDate = createdDate;
    }

    /** default constructor */
    public WebLog() {
    }

    /** minimal constructor */
    public WebLog(String clientIP) {
        this.clientIP = clientIP;
    }

    public String getClientIP() {
        return this.clientIP;
    }

    public void setClientIP(String clientIP) {
        this.clientIP = clientIP;
    }

    public String getVisitPage() {
        return this.visitPage;
    }

    public void setVisitPage(String visitPage) {
        this.visitPage = visitPage;
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

    public String toString() {
        return new ToStringBuilder(this)
            .append("clientIP", getClientIP())
            .append("visitPage", getVisitPage())
            .append("memo", getMemo())
            .append("createdDate", getCreatedDate())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
