package org.zion.value;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class LivelyBible extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;

    Long id; 
    
    /** persistent field */
    private String date;

    /** persistent field */
    private Integer volume;

    /** persistent field */
    private Integer chapter;

    /** nullable persistent field */
    private Boolean excep;

    /** nullable persistent field */
    private String content;

    /** persistent field */
    private Integer classify;

    /** full constructor */
    public LivelyBible(String date, Integer volume, Integer chapter, Boolean excep, String content, Integer classify) {
        this.date = date;
        this.volume = volume;
        this.chapter = chapter;
        this.excep = excep;
        this.content = content;
        this.classify = classify;
    }

    /** default constructor */
    public LivelyBible() {
    }

    /** minimal constructor */
    public LivelyBible(String date, Integer volume, Integer chapter, Integer classify) {
        this.date = date;
        this.volume = volume;
        this.chapter = chapter;
        this.classify = classify;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Boolean getExcep() {
        return this.excep;
    }

    public void setExcep(Boolean excep) {
        this.excep = excep;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
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
            .append("excep", getExcep())
            .append("content", getContent())
            .append("classify", getClassify())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
