package com.common.value;

import com.base.value.AppProperty;
import java.io.Serializable;
import java.util.List;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class WebSite extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;
    /** persistent field */
    private String code;

    /** persistent field */
    private String name;

    /** persistent field */
    private String homeUri;

    /** nullable persistent field */
    private String domain;

    /** persistent field */
    private AppProperty country;
    private Long countryId;

    /** persistent field */
    private AppProperty seoTitle;
    private Long seoTitleId;

    /** persistent field */
    private AppProperty seoKeyword;
    private Long seoKeywordId;

    /** persistent field */
    private AppProperty seoDesc;
    private Long seoDescId;

    /** nullable persistent field */
    private List functionCategory;

    /** full constructor */
    public WebSite(String code, String name, String homeUri, String domain, AppProperty country, AppProperty seoTitle, AppProperty seoKeyword, AppProperty seoDesc, List functionCategory) {
        this.code = code;
        this.name = name;
        this.homeUri = homeUri;
        this.domain = domain;
        this.country = country;
        this.seoTitle = seoTitle;
        this.seoKeyword = seoKeyword;
        this.seoDesc = seoDesc;
        this.functionCategory = functionCategory;
    }

    /** Labor constructor */
    public WebSite() {
    }

    /** minimal constructor */
    public WebSite(String code, String name, String homeUri, AppProperty country, AppProperty seoTitle, AppProperty seoKeyword, AppProperty seoDesc) {
        this.code = code;
        this.name = name;
        this.homeUri = homeUri;
        this.country = country;
        this.seoTitle = seoTitle;
        this.seoKeyword = seoKeyword;
        this.seoDesc = seoDesc;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHomeUri() {
        return this.homeUri;
    }

    public void setHomeUri(String homeUri) {
        this.homeUri = homeUri;
    }

    public String getDomain() {
        return this.domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public AppProperty getCountry() {
        return this.country;
    }

    public void setCountry(AppProperty country) {
        this.country = country;
    }

    public Long getCountryId() {
        if (this.country != null && this.country.getId() != null)
            return country.getId();
        return this.countryId;
    }

    public void setCountryId(Long id) {
        this.countryId = id;
    }

    public AppProperty getSeoTitle() {
        return this.seoTitle;
    }

    public void setSeoTitle(AppProperty seoTitle) {
        this.seoTitle = seoTitle;
    }

    public Long getSeoTitleId() {
        if (this.seoTitle != null && this.seoTitle.getId() != null)
            return seoTitle.getId();
        return this.seoTitleId;
    }

    public void setSeoTitleId(Long id) {
        this.seoTitleId = id;
    }

    public AppProperty getSeoKeyword() {
        return this.seoKeyword;
    }

    public void setSeoKeyword(AppProperty seoKeyword) {
        this.seoKeyword = seoKeyword;
    }

    public Long getSeoKeywordId() {
        if (this.seoKeyword != null && this.seoKeyword.getId() != null)
            return seoKeyword.getId();
        return this.seoKeywordId;
    }

    public void setSeoKeywordId(Long id) {
        this.seoKeywordId = id;
    }

    public AppProperty getSeoDesc() {
        return this.seoDesc;
    }

    public void setSeoDesc(AppProperty seoDesc) {
        this.seoDesc = seoDesc;
    }

    public Long getSeoDescId() {
        if (this.seoDesc != null && this.seoDesc.getId() != null)
            return seoDesc.getId();
        return this.seoDescId;
    }

    public void setSeoDescId(Long id) {
        this.seoDescId = id;
    }

    public List getFunctionCategory() {
        return this.functionCategory;
    }

    public void setFunctionCategory(List functionCategory) {
        this.functionCategory = functionCategory;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("code", getCode())
            .append("name", getName())
            .append("homeUri", getHomeUri())
            .append("domain", getDomain())
            .append("country", getCountry())
            .append("seoTitle", getSeoTitle())
            .append("seoKeyword", getSeoKeyword())
            .append("seoDesc", getSeoDesc())
            .append("functionCategory", getFunctionCategory())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
