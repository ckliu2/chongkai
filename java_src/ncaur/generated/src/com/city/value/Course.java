package com.city.value;

import com.base.value.AppProperty;
import com.base.value.UploadedFile;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class Course extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;
    /** persistent field */
    private String stime;

    /** persistent field */
    private String no;

    /** persistent field */
    private String courseName;

    /** persistent field */
    private String teacher;

    /** nullable persistent field */
    private String description;

    /** persistent field */
    private Date registerBegin;

    /** persistent field */
    private Date registerEnd;

    /** nullable persistent field */
    private String fee;

    /** nullable persistent field */
    private Boolean note1;

    /** nullable persistent field */
    private Boolean note2;

    /** nullable persistent field */
    private Boolean note3;

    /** nullable persistent field */
    private Boolean note4;

    /** nullable persistent field */
    private Date noteDate1;

    /** nullable persistent field */
    private Date noteDate2;

    /** nullable persistent field */
    private Date noteDate3;

    /** nullable persistent field */
    private Date noteDate4;

    /** nullable persistent field */
    private String times;

    /** nullable persistent field */
    private String emailDescript;

    /** nullable persistent field */
    private Date lastModifiedDate;

    /** nullable persistent field */
    private Date createdDate;

    /** nullable persistent field */
    private UploadedFile coursefile;
    private String coursefileFileName;
    private Long coursefileId;

    /** nullable persistent field */
    private UploadedFile emailfile;
    private String emailfileFileName;
    private Long emailfileId;

    /** persistent field */
    private AppProperty type;
    private Long typeId;

    /** nullable persistent field */
    private List filegroups;

    /** nullable persistent field */
    private Set photos;

    /** full constructor */
    public Course(String stime, String no, String courseName, String teacher, String description, Date registerBegin, Date registerEnd, String fee, Boolean note1, Boolean note2, Boolean note3, Boolean note4, Date noteDate1, Date noteDate2, Date noteDate3, Date noteDate4, String times, String emailDescript, Date lastModifiedDate, Date createdDate, UploadedFile coursefile, UploadedFile emailfile, AppProperty type, List filegroups, Set photos) {
        this.stime = stime;
        this.no = no;
        this.courseName = courseName;
        this.teacher = teacher;
        this.description = description;
        this.registerBegin = registerBegin;
        this.registerEnd = registerEnd;
        this.fee = fee;
        this.note1 = note1;
        this.note2 = note2;
        this.note3 = note3;
        this.note4 = note4;
        this.noteDate1 = noteDate1;
        this.noteDate2 = noteDate2;
        this.noteDate3 = noteDate3;
        this.noteDate4 = noteDate4;
        this.times = times;
        this.emailDescript = emailDescript;
        this.lastModifiedDate = lastModifiedDate;
        this.createdDate = createdDate;
        this.coursefile = coursefile;
        this.emailfile = emailfile;
        this.type = type;
        this.filegroups = filegroups;
        this.photos = photos;
    }

    /** default constructor */
    public Course() {
    }

    /** minimal constructor */
    public Course(String stime, String no, String courseName, String teacher, Date registerBegin, Date registerEnd, AppProperty type) {
        this.stime = stime;
        this.no = no;
        this.courseName = courseName;
        this.teacher = teacher;
        this.registerBegin = registerBegin;
        this.registerEnd = registerEnd;
        this.type = type;
    }

    public String getStime() {
        return this.stime;
    }

    public void setStime(String stime) {
        this.stime = stime;
    }

    public String getNo() {
        return this.no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeacher() {
        return this.teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getRegisterBegin() {
        return this.registerBegin;
    }

    public void setRegisterBegin(Date registerBegin) {
        this.registerBegin = registerBegin;
    }

    public Date getRegisterEnd() {
        return this.registerEnd;
    }

    public void setRegisterEnd(Date registerEnd) {
        this.registerEnd = registerEnd;
    }

    public String getFee() {
        return this.fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public Boolean getNote1() {
        return this.note1;
    }

    public void setNote1(Boolean note1) {
        this.note1 = note1;
    }

    public Boolean getNote2() {
        return this.note2;
    }

    public void setNote2(Boolean note2) {
        this.note2 = note2;
    }

    public Boolean getNote3() {
        return this.note3;
    }

    public void setNote3(Boolean note3) {
        this.note3 = note3;
    }

    public Boolean getNote4() {
        return this.note4;
    }

    public void setNote4(Boolean note4) {
        this.note4 = note4;
    }

    public Date getNoteDate1() {
        return this.noteDate1;
    }

    public void setNoteDate1(Date noteDate1) {
        this.noteDate1 = noteDate1;
    }

    public Date getNoteDate2() {
        return this.noteDate2;
    }

    public void setNoteDate2(Date noteDate2) {
        this.noteDate2 = noteDate2;
    }

    public Date getNoteDate3() {
        return this.noteDate3;
    }

    public void setNoteDate3(Date noteDate3) {
        this.noteDate3 = noteDate3;
    }

    public Date getNoteDate4() {
        return this.noteDate4;
    }

    public void setNoteDate4(Date noteDate4) {
        this.noteDate4 = noteDate4;
    }

    public String getTimes() {
        return this.times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public String getEmailDescript() {
        return this.emailDescript;
    }

    public void setEmailDescript(String emailDescript) {
        this.emailDescript = emailDescript;
    }

    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public UploadedFile getCoursefile() {
        return this.coursefile;
    }

    public void setCoursefile(UploadedFile coursefile) {
        this.coursefile = coursefile;
    }

    public String getCoursefileFileName() {
        return this.coursefileFileName;
    }

    public void setCoursefileFileName(String val) {
        this.coursefileFileName = val;
    }

    public Long getCoursefileId() {
        if (this.coursefile != null && this.coursefile.getId() != null)
            return coursefile.getId();
        return this.coursefileId;
    }

    public void setCoursefileId(Long id) {
        this.coursefileId = id;
    }

    public UploadedFile getEmailfile() {
        return this.emailfile;
    }

    public void setEmailfile(UploadedFile emailfile) {
        this.emailfile = emailfile;
    }

    public String getEmailfileFileName() {
        return this.emailfileFileName;
    }

    public void setEmailfileFileName(String val) {
        this.emailfileFileName = val;
    }

    public Long getEmailfileId() {
        if (this.emailfile != null && this.emailfile.getId() != null)
            return emailfile.getId();
        return this.emailfileId;
    }

    public void setEmailfileId(Long id) {
        this.emailfileId = id;
    }

    public AppProperty getType() {
        return this.type;
    }

    public void setType(AppProperty type) {
        this.type = type;
    }

    public Long getTypeId() {
        if (this.type != null && this.type.getId() != null)
            return type.getId();
        return this.typeId;
    }

    public void setTypeId(Long id) {
        this.typeId = id;
    }

    public List getFilegroups() {
        return this.filegroups;
    }

    public void setFilegroups(List filegroups) {
        this.filegroups = filegroups;
    }

    public Set getPhotos() {
        return this.photos;
    }

    public void setPhotos(Set photos) {
        this.photos = photos;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("stime", getStime())
            .append("no", getNo())
            .append("courseName", getCourseName())
            .append("teacher", getTeacher())
            .append("description", getDescription())
            .append("registerBegin", getRegisterBegin())
            .append("registerEnd", getRegisterEnd())
            .append("fee", getFee())
            .append("note1", getNote1())
            .append("note2", getNote2())
            .append("note3", getNote3())
            .append("note4", getNote4())
            .append("noteDate1", getNoteDate1())
            .append("noteDate2", getNoteDate2())
            .append("noteDate3", getNoteDate3())
            .append("noteDate4", getNoteDate4())
            .append("times", getTimes())
            .append("emailDescript", getEmailDescript())
            .append("lastModifiedDate", getLastModifiedDate())
            .append("createdDate", getCreatedDate())
            .append("coursefile", getCoursefile())
            .append("emailfile", getEmailfile())
            .append("type", getType())
            .append("filegroups", getFilegroups())
            .append("photos", getPhotos())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
