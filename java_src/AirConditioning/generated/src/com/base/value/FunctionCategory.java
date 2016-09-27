package com.base.value;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class FunctionCategory extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;
    /** persistent field */
    private Integer seqNo;

    /** persistent field */
    private String nameCh;

    /** persistent field */
    private String nameEn;

    /** nullable persistent field */
    private Boolean isFront;

    /** full constructor */
    public FunctionCategory(Integer seqNo, String nameCh, String nameEn, Boolean isFront) {
        this.seqNo = seqNo;
        this.nameCh = nameCh;
        this.nameEn = nameEn;
        this.isFront = isFront;
    }

    /** Labor constructor */
    public FunctionCategory() {
    }

    /** minimal constructor */
    public FunctionCategory(Integer seqNo, String nameCh, String nameEn) {
        this.seqNo = seqNo;
        this.nameCh = nameCh;
        this.nameEn = nameEn;
    }

    public Integer getSeqNo() {
        return this.seqNo;
    }

    public void setSeqNo(Integer seqNo) {
        this.seqNo = seqNo;
    }

    public String getNameCh() {
        return this.nameCh;
    }

    public void setNameCh(String nameCh) {
        this.nameCh = nameCh;
    }

    public String getNameEn() {
        return this.nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public Boolean getIsFront() {
        return this.isFront;
    }

    public void setIsFront(Boolean isFront) {
        this.isFront = isFront;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("seqNo", getSeqNo())
            .append("nameCh", getNameCh())
            .append("nameEn", getNameEn())
            .append("isFront", getIsFront())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
