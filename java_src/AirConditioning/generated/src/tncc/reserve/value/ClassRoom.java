package tncc.reserve.value;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class ClassRoom extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;
    /** persistent field */
    private String name;

    /** nullable persistent field */
    private String classroomGroup;

    /** nullable persistent field */
    private Set readers;

    /** full constructor */
    public ClassRoom(String name, String classroomGroup, Set readers) {
        this.name = name;
        this.classroomGroup = classroomGroup;
        this.readers = readers;
    }

    /** default constructor */
    public ClassRoom() {
    }

    /** minimal constructor */
    public ClassRoom(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassroomGroup() {
        return this.classroomGroup;
    }

    public void setClassroomGroup(String classroomGroup) {
        this.classroomGroup = classroomGroup;
    }

    public Set getReaders() {
        return this.readers;
    }

    public void setReaders(Set readers) {
        this.readers = readers;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("name", getName())
            .append("classroomGroup", getClassroomGroup())
            .append("readers", getReaders())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
