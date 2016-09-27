package org.zion.value;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class Bible extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;
    /** persistent field */
    private Integer sn;

    /** persistent field */
    private Integer chapterNumber;

    /** persistent field */
    private String shortName;

    /** persistent field */
    private String fullName;

    /** full constructor */
    public Bible(Integer sn, Integer chapterNumber, String shortName, String fullName) {
        this.sn = sn;
        this.chapterNumber = chapterNumber;
        this.shortName = shortName;
        this.fullName = fullName;
    }

    /** default constructor */
    public Bible() {
    }

    public Integer getSn() {
        return this.sn;
    }

    public void setSn(Integer sn) {
        this.sn = sn;
    }

    public Integer getChapterNumber() {
        return this.chapterNumber;
    }

    public void setChapterNumber(Integer chapterNumber) {
        this.chapterNumber = chapterNumber;
    }

    public String getShortName() {
        return this.shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("sn", getSn())
            .append("chapterNumber", getChapterNumber())
            .append("shortName", getShortName())
            .append("fullName", getFullName())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
