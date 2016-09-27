package com.common.value;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
import com.base.value.*;


/** @author Hibernate CodeGenerator */
public class WebSite extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;
    

	private Long id;
    
    
    /** persistent field */
    private String name;

    /** persistent field */
    private String title;

    /** nullable persistent field */
    private String header;

    /** nullable persistent field */
    private String meta;

    /** nullable persistent field */
    private String footer;

    /** nullable persistent field */
    private String domain;
    
    /** nullable persistent field */
    private MiscCode language;
    private Long languageId;


	/** full constructor */
    public WebSite(String name, String title, String header, String meta, String footer, String domain) {
        this.name = name;
        this.title = title;
        this.header = header;
        this.meta = meta;
        this.footer = footer;
        this.domain = domain;
    }

    /** default constructor */
    public WebSite() {
    }

    /** minimal constructor */
    public WebSite(String name, String title) {
        this.name = name;
        this.title = title;
    }
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHeader() {
        return this.header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getMeta() {
        return this.meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    public String getFooter() {
        return this.footer;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

    public String getDomain() {
        return this.domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
    
    public MiscCode getLanguage() {
        return this.language;
    }

    public void setLanguage(MiscCode language) {
        this.language = language;
    }

    public Long getLanguageId() {
        if (this.language != null && this.language.getId() != null)
            return language.getId();
        return this.languageId;
    }

    public void setLanguageId(Long id) {
        this.languageId = id;
    }

    


    public String toString() {
        return new ToStringBuilder(this)
            .append("name", getName())
            .append("title", getTitle())
            .append("header", getHeader())
            .append("meta", getMeta())
            .append("footer", getFooter())
            .append("domain", getDomain())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
