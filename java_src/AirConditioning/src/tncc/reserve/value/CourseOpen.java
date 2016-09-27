package tncc.reserve.value;

import com.common.value.Member;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class CourseOpen extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;
    
	Long id;

    /** nullable persistent field */
	
	private String active;
	
	private Integer node;

	private Integer week;	

	private String reservation;

    /** nullable persistent field */
    private String startTime;

    /** nullable persistent field */
    private String endTime;

    /** nullable persistent field */
    private tncc.reserve.value.Course course;
    private String courseId;

    /** nullable persistent field */
    private Member teacher;
    private Long teacherId;

    /** nullable persistent field */
    private tncc.reserve.value.ClassRoom classroom;
    private String classroomId;

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

    public tncc.reserve.value.Course getCourse() {
        return this.course;
    }

    public void setCourse(tncc.reserve.value.Course course) {
        this.course = course;
    }

    public String getCourseId() {
        if (this.course != null && this.course.getId() != null)
            return course.getId();
        return this.courseId;
    }

    public void setCourseId(String id) {
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

    public String getClassroomId() {
        if (this.classroom != null && this.classroom.getId() != null)
            return classroom.getId();
        return this.classroomId;
    }

    public void setClassroomId(String id) {
        this.classroomId = id;
    }
    
    public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}
	
	public Integer getNode() {
		return node;
	}

	public void setNode(Integer node) {
		this.node = node;
	}
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getReservation() {
		return reservation;
	}

	public void setReservation(String reservation) {
		this.reservation = reservation;
	}


    public String toString() {
        return new ToStringBuilder(this)            
            .append("week", getWeek())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("course", getCourse())
            .append("teacher", getTeacher())
            .append("classroom", getClassroom())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
