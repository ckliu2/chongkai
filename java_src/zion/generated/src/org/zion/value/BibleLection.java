package org.zion.value;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class BibleLection extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;
    /** persistent field */
    private Integer volume;

    /** persistent field */
    private Integer chapter;

    /** persistent field */
    private Integer verse;

    /** persistent field */
    private String lection;

    /** full constructor */
    public BibleLection(Integer volume, Integer chapter, Integer verse, String lection) {
        this.volume = volume;
        this.chapter = chapter;
        this.verse = verse;
        this.lection = lection;
    }

    /** default constructor */
    public BibleLection() {
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

    public Integer getVerse() {
        return this.verse;
    }

    public void setVerse(Integer verse) {
        this.verse = verse;
    }

    public String getLection() {
        return this.lection;
    }

    public void setLection(String lection) {
        this.lection = lection;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("volume", getVolume())
            .append("chapter", getChapter())
            .append("verse", getVerse())
            .append("lection", getLection())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
