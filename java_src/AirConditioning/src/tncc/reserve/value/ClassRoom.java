package tncc.reserve.value;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
import java.util.*;
import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class ClassRoom extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;
    /** persistent field */

    private String id;

    private String name;

    String classroom;

    private String classroomGroup;

    private Set readers;

    /** full constructor */
    public ClassRoom(String name) {
	this.name = name;
    }

    /** Labor constructor */
    public ClassRoom() {
    }

    public String getName() {
	return this.name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }

    public Set getReaders() {
	return readers;
    }

    public void setReaders(Set readers) {
	this.readers = readers;
    }

    public String getClassroomGroup() {
	return classroomGroup;
    }

    public void setClassroomGroup(String classroomGroup) {
	this.classroomGroup = classroomGroup;
    }
    
    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String toString() {
	return new ToStringBuilder(this).append("name", getName()).toString();
    }

    public String getCaption_() {
	return toString();
    }

}
