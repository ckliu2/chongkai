package com.base.value;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class UploadedFile extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;
    /** nullable persistent field */
    private String fileName;

    /** nullable persistent field */
    private Long size;

    /** full constructor */
    public UploadedFile(String fileName, Long size) {
        this.fileName = fileName;
        this.size = size;
    }

    /** Labor constructor */
    public UploadedFile() {
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Long getSize() {
        return this.size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("fileName", getFileName())
            .append("size", getSize())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
