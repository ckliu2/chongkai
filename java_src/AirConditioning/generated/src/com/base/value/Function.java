package com.base.value;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class Function extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;
    /** persistent field */
    private Integer seqNo;

    /** persistent field */
    private String funKey;

    /** persistent field */
    private String funNameCh;

    /** persistent field */
    private String funNameEn;

    /** persistent field */
    private String funUrl;

    /** nullable persistent field */
    private String descCh;

    /** nullable persistent field */
    private String descEn;

    /** nullable persistent field */
    private Date editBegin;

    /** nullable persistent field */
    private Date editEnd;

    /** nullable persistent field */
    private Boolean disabled;

    /** nullable persistent field */
    private com.base.value.FunctionCategory category;
    private Long categoryId;

    /** nullable persistent field */
    private List authority;

    /** full constructor */
    public Function(Integer seqNo, String funKey, String funNameCh, String funNameEn, String funUrl, String descCh, String descEn, Date editBegin, Date editEnd, Boolean disabled, com.base.value.FunctionCategory category, List authority) {
        this.seqNo = seqNo;
        this.funKey = funKey;
        this.funNameCh = funNameCh;
        this.funNameEn = funNameEn;
        this.funUrl = funUrl;
        this.descCh = descCh;
        this.descEn = descEn;
        this.editBegin = editBegin;
        this.editEnd = editEnd;
        this.disabled = disabled;
        this.category = category;
        this.authority = authority;
    }

    /** Labor constructor */
    public Function() {
    }

    /** minimal constructor */
    public Function(Integer seqNo, String funKey, String funNameCh, String funNameEn, String funUrl) {
        this.seqNo = seqNo;
        this.funKey = funKey;
        this.funNameCh = funNameCh;
        this.funNameEn = funNameEn;
        this.funUrl = funUrl;
    }

    public Integer getSeqNo() {
        return this.seqNo;
    }

    public void setSeqNo(Integer seqNo) {
        this.seqNo = seqNo;
    }

    public String getFunKey() {
        return this.funKey;
    }

    public void setFunKey(String funKey) {
        this.funKey = funKey;
    }

    public String getFunNameCh() {
        return this.funNameCh;
    }

    public void setFunNameCh(String funNameCh) {
        this.funNameCh = funNameCh;
    }

    public String getFunNameEn() {
        return this.funNameEn;
    }

    public void setFunNameEn(String funNameEn) {
        this.funNameEn = funNameEn;
    }

    public String getFunUrl() {
        return this.funUrl;
    }

    public void setFunUrl(String funUrl) {
        this.funUrl = funUrl;
    }

    public String getDescCh() {
        return this.descCh;
    }

    public void setDescCh(String descCh) {
        this.descCh = descCh;
    }

    public String getDescEn() {
        return this.descEn;
    }

    public void setDescEn(String descEn) {
        this.descEn = descEn;
    }

    public Date getEditBegin() {
        return this.editBegin;
    }

    public void setEditBegin(Date editBegin) {
        this.editBegin = editBegin;
    }

    public Date getEditEnd() {
        return this.editEnd;
    }

    public void setEditEnd(Date editEnd) {
        this.editEnd = editEnd;
    }

    public Boolean getDisabled() {
        return this.disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public com.base.value.FunctionCategory getCategory() {
        return this.category;
    }

    public void setCategory(com.base.value.FunctionCategory category) {
        this.category = category;
    }

    public Long getCategoryId() {
        if (this.category != null && this.category.getId() != null)
            return category.getId();
        return this.categoryId;
    }

    public void setCategoryId(Long id) {
        this.categoryId = id;
    }

    public List getAuthority() {
        return this.authority;
    }

    public void setAuthority(List authority) {
        this.authority = authority;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("seqNo", getSeqNo())
            .append("funKey", getFunKey())
            .append("funNameCh", getFunNameCh())
            .append("funNameEn", getFunNameEn())
            .append("funUrl", getFunUrl())
            .append("descCh", getDescCh())
            .append("descEn", getDescEn())
            .append("editBegin", getEditBegin())
            .append("editEnd", getEditEnd())
            .append("disabled", getDisabled())
            .append("category", getCategory())
            .append("authority", getAuthority())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
