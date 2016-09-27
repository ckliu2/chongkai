package tncc.power.value;

import com.base.value.AppProperty;
import com.common.value.Member;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang.builder.ToStringBuilder;
import tncc.wpc.value.Building;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class Space extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;
    /** persistent field */
    private String name;

    /** persistent field */
    private Date createdDate;

    /** nullable persistent field */
    private AppProperty readerType;
    private Long readerTypeId;

    /** persistent field */
    private Member createdUser;
    private Long createdUserId;

    /** persistent field */
    private Building building;
    private Long buildingId;

    /** nullable persistent field */
    private List reader;

    /** full constructor */
    public Space(String name, Date createdDate, AppProperty readerType, Member createdUser, Building building, List reader) {
        this.name = name;
        this.createdDate = createdDate;
        this.readerType = readerType;
        this.createdUser = createdUser;
        this.building = building;
        this.reader = reader;
    }

    /** default constructor */
    public Space() {
    }

    /** minimal constructor */
    public Space(String name, Date createdDate, Member createdUser, Building building) {
        this.name = name;
        this.createdDate = createdDate;
        this.createdUser = createdUser;
        this.building = building;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public AppProperty getReaderType() {
        return this.readerType;
    }

    public void setReaderType(AppProperty readerType) {
        this.readerType = readerType;
    }

    public Long getReaderTypeId() {
        if (this.readerType != null && this.readerType.getId() != null)
            return readerType.getId();
        return this.readerTypeId;
    }

    public void setReaderTypeId(Long id) {
        this.readerTypeId = id;
    }

    public Member getCreatedUser() {
        return this.createdUser;
    }

    public void setCreatedUser(Member createdUser) {
        this.createdUser = createdUser;
    }

    public Long getCreatedUserId() {
        if (this.createdUser != null && this.createdUser.getId() != null)
            return createdUser.getId();
        return this.createdUserId;
    }

    public void setCreatedUserId(Long id) {
        this.createdUserId = id;
    }

    public Building getBuilding() {
        return this.building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Long getBuildingId() {
        if (this.building != null && this.building.getId() != null)
            return building.getId();
        return this.buildingId;
    }

    public void setBuildingId(Long id) {
        this.buildingId = id;
    }

    public List getReader() {
        return this.reader;
    }

    public void setReader(List reader) {
        this.reader = reader;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("name", getName())
            .append("createdDate", getCreatedDate())
            .append("readerType", getReaderType())
            .append("createdUser", getCreatedUser())
            .append("building", getBuilding())
            .append("reader", getReader())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
