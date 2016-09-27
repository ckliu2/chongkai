package tncc.power.value;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
import tncc.reserve.value.ClassRoom;
import tncc.reserve.value.Course;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class PowerControllerReader extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;
    /** nullable persistent field */
    private String name;

    /** nullable persistent field */
    private Integer deviceNo;

    /** nullable persistent field */
    private tncc.power.value.PowerController powerController;
    private Long powerControllerId;

    /** nullable persistent field */
    private tncc.power.value.Reader reader;
    private Long readerId;

    /** nullable persistent field */
    private ClassRoom classRoom;
    private Long classRoomId;

    /** nullable persistent field */
    private Course course;
    private Long courseId;

    /** full constructor */
    public PowerControllerReader(String name, Integer deviceNo, tncc.power.value.PowerController powerController, tncc.power.value.Reader reader, ClassRoom classRoom, Course course) {
        this.name = name;
        this.deviceNo = deviceNo;
        this.powerController = powerController;
        this.reader = reader;
        this.classRoom = classRoom;
        this.course = course;
    }

    /** default constructor */
    public PowerControllerReader() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDeviceNo() {
        return this.deviceNo;
    }

    public void setDeviceNo(Integer deviceNo) {
        this.deviceNo = deviceNo;
    }

    public tncc.power.value.PowerController getPowerController() {
        return this.powerController;
    }

    public void setPowerController(tncc.power.value.PowerController powerController) {
        this.powerController = powerController;
    }

    public Long getPowerControllerId() {
        if (this.powerController != null && this.powerController.getId() != null)
            return powerController.getId();
        return this.powerControllerId;
    }

    public void setPowerControllerId(Long id) {
        this.powerControllerId = id;
    }

    public tncc.power.value.Reader getReader() {
        return this.reader;
    }

    public void setReader(tncc.power.value.Reader reader) {
        this.reader = reader;
    }

    public Long getReaderId() {
        if (this.reader != null && this.reader.getId() != null)
            return reader.getId();
        return this.readerId;
    }

    public void setReaderId(Long id) {
        this.readerId = id;
    }

    public ClassRoom getClassRoom() {
        return this.classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }

    public Long getClassRoomId() {
        if (this.classRoom != null && this.classRoom.getId() != null)
            return classRoom.getId();
        return this.classRoomId;
    }

    public void setClassRoomId(Long id) {
        this.classRoomId = id;
    }

    public Course getCourse() {
        return this.course;
    }

    public void setCourse(Course course) {
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

    public String toString() {
        return new ToStringBuilder(this)
            .append("name", getName())
            .append("deviceNo", getDeviceNo())
            .append("powerController", getPowerController())
            .append("reader", getReader())
            .append("classRoom", getClassRoom())
            .append("course", getCourse())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
