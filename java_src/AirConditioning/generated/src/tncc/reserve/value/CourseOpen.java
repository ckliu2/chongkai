package tncc.reserve.value;

import com.common.value.Member;
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class CourseOpen extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;
    /** nullable persistent field */
    private Integer week;

    /** nullable persistent field */
    private String startTime;

    /** nullable persistent field */
    private String endTime;

    /** nullable persistent field */
    private String active;

    /** nullable persistent field */
    private Integer node;

    /** nullable persistent field */
    private String reservation;

    /** nullable persistent field */
    private tncc.reserve.value.Course course;
    private Long courseId;

    /** nullable persistent field */
    private Member teacher;
    private Long teacherId;

    /** nullable persistent field */
    private tncc.reserve.value.ClassRoom classroom;
    private Long classroomId;

    /** full constructor */
    public CourseOpen(Integer week, String startTime, String endTime, String active, Integer node, String reservation, tncc.reserve.value.Course course, Member teacher, tncc.reserve.value.ClassRoom classroom) {
        this.week = week;
        this.startTime = startTime;
        this.endTime = endTime;
        this.active = active;
        this.node = node;
        this.reservation = reservation;
        this.course = course;
        this.teacher = teacher;
        this.classroom = classroom;
    }

    /** default constructor */
    public CourseOpen() {
    }

    public Integer getWeek() {
        return this.week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getActive() {
        return this.active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public Integer getNode() {
        return this.node;
    }

    public void setNode(Integer node) {
        this.node = node;
    }

    public String getReservation() {
        return this.reservation;
    }

    public void setReservation(String reservation) {
        this.reservation = reservation;
    }

    public tncc.reserve.value.Course getCourse() {
        return this.course;
    }

    public void setCourse(tncc.reserve.value.Course course) {
        this.course = course;
    }

    public Long getCourseId() {
        if (this.course != null && this.course.getId() != null)
            return course.getId();
        return this.courseId;
    }

    public void setCourseId(Long id) {
        this.courseId = id;
    }

    public Member getTeacher() {
        return this.teacher;
    }

    public void setTeacher(Member teacher) {
        this.teacher = teacher;
    }

    public Long getTeacherId() {
        if (this.teacher != null && this.teacher.getId() != null)
            return teacher.getId();
        return this.teacherId;
    }

    public void setTeacherId(Long id) {
        this.teacherId = id;
    }

    public tncc.reserve.value.ClassRoom getClassroom() {
        return this.classroom;
    }

    public void setClassroom(tncc.reserve.value.ClassRoom classroom) {
        this.classroom = classroom;
    }

    public Long getClassroomId() {
        if (this.classroom != null && this.classroom.getId() != null)
            return classroom.getId();
        return this.classroomId;
    }

    public void setClassroomId(Long id) {
        this.classroomId = id;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("week", getWeek())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("active", getActive())
            .append("node", getNode())
            .append("reservation", getReservation())
            .append("course", getCourse())
            .append("teacher", getTeacher())
            .append("classroom", getClassroom())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
