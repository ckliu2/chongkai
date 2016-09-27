package com.web.value;

import com.common.value.Member;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.AppProperty;
import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class SubMenu extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;    

	/** persistent field */
    private String name;

    /** persistent field */
    private Integer seqNo;

    /** nullable persistent field */
    private Boolean status;

    /** nullable persistent field */
    private String content;

    /** persistent field */
    private Date lastModifiedDate;

    /** persistent field */
    private Date createdDate;

    /** nullable persistent field */
    private com.web.value.Menu menu;
    private Long menuId;

    /** persistent field */
    private Member lastModifiedUser;
    private Long lastModifiedUserId;

    /** persistent field */
    private Member createdUser;
    private Long createdUserId;
    
    private String url;    
    
    /** nullable persistent field */
    private AppProperty linkType;
    private Long linkTypeId;

    /** full constructor */
    public SubMenu(String name, Integer seqNo, Boolean status, String content, Date lastModifiedDate, Date createdDate, com.web.value.Menu menu, Member lastModifiedUser, Member createdUser) {
        this.name = name;
        this.seqNo = seqNo;
        this.status = status;
        this.content = content;
        this.lastModifiedDate = lastModifiedDate;
        this.createdDate = createdDate;
        this.menu = menu;
        this.lastModifiedUser = lastModifiedUser;
        this.createdUser = createdUser;
    }

    /** default constructor */
    public SubMenu() {
    }

    /** minimal constructor */
    public SubMenu(String name, Integer seqNo, Date lastModifiedDate, Date createdDate, Member lastModifiedUser, Member createdUser) {
        this.name = name;
        this.seqNo = seqNo;
        this.lastModifiedDate = lastModifiedDate;
        this.createdDate = createdDate;
        this.lastModifiedUser = lastModifiedUser;
        this.createdUser = createdUser;
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

    public com.web.value.Menu getMenu() {
        return this.menu;
    }

    public void setMenu(com.web.value.Menu menu) {
        this.menu = menu;
    }

    public Long getMenuId() {
        if (this.menu != null && this.menu.getId() != null)
            return menu.getId();
        return this.menuId;
    }

    public void setMenuId(Long id) {
        this.menuId = id;
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
            .append("lastModifiedDate", getLastModifiedDate())
            .append("createdDate", getCreatedDate())
            .append("menu", getMenu())
            .append("lastModifiedUser", getLastModifiedUser())
            .append("createdUser", getCreatedUser())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
    public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
