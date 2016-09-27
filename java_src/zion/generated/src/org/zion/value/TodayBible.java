package org.zion.value;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class TodayBible extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;
    /** persistent field */
    private String date;

    /** persistent field */
    private Integer volume;

    /** persistent field */
    private Integer chapter;

    /** persistent field */
    private Integer classify;

    /** full constructor */
    public TodayBible(String date, Integer volume, Integer chapter, Integer classify) {
        this.date = date;
        this.volume = volume;
        this.chapter = chapter;
        this.classify = classify;
    }

    /** default constructor */
    public TodayBible() {
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getVolume() {
        return this.volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Integer getChapter() {
        return this.chapter;
    }

    public void setChapter(Integer chapter) {
        this.chapter = chapter;
    }

    public Integer getClassify() {
        return this.classify;
    }

    public void setClassify(Integer classify) {
        this.classify = classify;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("date", getDate())
            .append("volume", getVolume())
            .append("chapter", getChapter())
            .append("classify", getClassify())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
