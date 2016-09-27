package com.web.value;

import com.common.value.Department;
import com.common.value.Member;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class Equipment extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;
    /** persistent field */
    private String name;

    /** persistent field */
    private Integer quantity;

    /** nullable persistent field */
    private String meno;

    /** persistent field */
    private Date lastModifiedDate;

    /** persistent field */
    private Date createdDate;

    /** persistent field */
    private Department department;
    private Long departmentId;

    /** persistent field */
    private Member lastModifiedUser;
    private Long lastModifiedUserId;

    /** nullable persistent field */
    private Member createdUser;
    private Long createdUserId;

    /** full constructor */
    public Equipment(String name, Integer quantity, String meno, Date lastModifiedDate, Date createdDate, Department department, Member lastModifiedUser, Member createdUser) {
        this.name = name;
        this.quantity = quantity;
        this.meno = meno;
        this.lastModifiedDate = lastModifiedDate;
        this.createdDate = createdDate;
        this.department = department;
        this.lastModifiedUser = lastModifiedUser;
        this.createdUser = createdUser;
    }

    /** default constructor */
    public Equipment() {
    }

    /** minimal constructor */
    public Equipment(String name, Integer quantity, Date lastModifiedDate, Date createdDate, Department department, Member lastModifiedUser) {
        this.name = name;
        this.quantity = quantity;
        this.lastModifiedDate = lastModifiedDate;
        this.createdDate = createdDate;
        this.department = department;
        this.lastModifiedUser = lastModifiedUser;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getMeno() {
        return this.meno;
    }

    public void setMeno(String meno) {
        this.meno = meno;
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

    public Department getDepartment() {
        return this.department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Long getDepartmentId() {
        if (this.department != null && this.department.getId() != null)
            return department.getId();
        return this.departmentId;
    }

    public void setDepartmentId(Long id) {
        this.departmentId = id;
    }

    public Member getLastModifiedUser() {
        return this.lastModifiedUser;
    }

    public void setLastModifiedUser(Member lastModifiedUser) {
        this.lastModifiedUser = lastModifiedUser;
    }

    public Long getLastModifiedUserId() {
        if (this.lastModifiedUser != null && this.lastModifiedUser.getId() != null)
            return lastModifiedUser.getId();
        return this.lastModifiedUserId;
    }

    public void setLastModifiedUserId(Long id) {
        this.lastModifiedUserId = id;
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

    public String toString() {
        return new ToStringBuilder(this)
            .append("name", getName())
            .append("quantity", getQuantity())
            .append("meno", getMeno())
            .append("lastModifiedDate", getLastModifiedDate())
            .append("createdDate", getCreatedDate())
            .append("department", getDepartment())
            .append("lastModifiedUser", getLastModifiedUser())
            .append("createdUser", getCreatedUser())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
