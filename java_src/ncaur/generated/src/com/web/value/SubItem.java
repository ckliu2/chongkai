package com.web.value;

import com.base.value.AppProperty;
import com.common.value.Member;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class SubItem extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;
    /** persistent field */
    private String name;

    /** persistent field */
    private Integer seqNo;

    /** nullable persistent field */
    private Boolean status;

    /** nullable persistent field */
    private String content;

    /** nullable persistent field */
    private String url;

    /** persistent field */
    private Date lastModifiedDate;

    /** persistent field */
    private Date createdDate;

    /** persistent field */
    private Member lastModifiedUser;
    private Long lastModifiedUserId;

    /** persistent field */
    private Member createdUser;
    private Long createdUserId;

    /** persistent field */
    private com.web.value.SubMenu subMenu;
    private Long subMenuId;

    /** nullable persistent field */
    private AppProperty linkType;
    private Long linkTypeId;

    /** full constructor */
    public SubItem(String name, Integer seqNo, Boolean status, String content, String url, Date lastModifiedDate, Date createdDate, Member lastModifiedUser, Member createdUser, com.web.value.SubMenu subMenu, AppProperty linkType) {
        this.name = name;
        this.seqNo = seqNo;
        this.status = status;
        this.content = content;
        this.url = url;
        this.lastModifiedDate = lastModifiedDate;
        this.createdDate = createdDate;
        this.lastModifiedUser = lastModifiedUser;
        this.createdUser = createdUser;
        this.subMenu = subMenu;
        this.linkType = linkType;
    }

    /** default constructor */
    public SubItem() {
    }

    /** minimal constructor */
    public SubItem(String name, Integer seqNo, Date lastModifiedDate, Date createdDate, Member lastModifiedUser, Member createdUser, com.web.value.SubMenu subMenu) {
        this.name = name;
        this.seqNo = seqNo;
        this.lastModifiedDate = lastModifiedDate;
        this.createdDate = createdDate;
        this.lastModifiedUser = lastModifiedUser;
        this.createdUser = createdUser;
        this.subMenu = subMenu;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSeqNo() {
        return this.seqNo;
    }

    public void setSeqNo(Integer seqNo) {
        this.seqNo = seqNo;
    }

    public Boolean getStatus() {
        return this.status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public com.web.value.SubMenu getSubMenu() {
        return this.subMenu;
    }

    public void setSubMenu(com.web.value.SubMenu subMenu) {
        this.subMenu = subMenu;
    }

    public Long getSubMenuId() {
        if (this.subMenu != null && this.subMenu.getId() != null)
            return subMenu.getId();
        return this.subMenuId;
    }

    public void setSubMenuId(Long id) {
        this.subMenuId = id;
    }

    public AppProperty getLinkType() {
        return this.linkType;
    }

    public void setLinkType(AppProperty linkType) {
        this.linkType = linkType;
    }

    public Long getLinkTypeId() {
        if (this.linkType != null && this.linkType.getId() != null)
            return linkType.getId();
        return this.linkTypeId;
    }

    public void setLinkTypeId(Long id) {
        this.linkTypeId = id;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("name", getName())
            .append("seqNo", getSeqNo())
            .append("status", getStatus())
            .append("content", getContent())
            .append("url", getUrl())
            .append("lastModifiedDate", getLastModifiedDate())
            .append("createdDate", getCreatedDate())
            .append("lastModifiedUser", getLastModifiedUser())
            .append("createdUser", getCreatedUser())
            .append("subMenu", getSubMenu())
            .append("linkType", getLinkType())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
