package com.common.value;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.ToStringBuilder;
import com.base.value.*;

/** @author Hibernate CodeGenerator */
public class Member implements Serializable {

    private static final long serialVersionUID = 1L;
    /** nullable persistent field */
    
    private Long id;
    
    
    private String name;

    /** nullable persistent field */
    private String cardId;

    /** nullable persistent field */
    private String cardNo;  

	/** nullable persistent field */
    private String password;


    /** nullable persistent field */
    private Boolean enabled;

    /** nullable persistent field */
    private Set groups;   


	/** nullable persistent field */
    private String email;
    
    /** nullable persistent field */
    private String cellphone;


    /** full constructor */
    public Member(String name, String cardId, String cardNo, String password, Integer PersonnelType, Boolean disabled, AppProperty cardType, Set groups) {
        this.name = name;
        this.cardId = cardId;
        this.cardNo = cardNo;
        this.password = password;
       
        this.enabled = enabled;

        this.groups = groups;
    }

    /** Labor constructor */
    public Member() {
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

    public String getCardId() {
        return this.cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getCardNo() {
        return this.cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }



    public Boolean getEnabled() {
        return this.enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Set getGroups() {
        return this.groups;
    }

    public void setGroups(Set groups) {
        this.groups = groups;
    }
    
    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
    public String toString() {
    	return getName();
        /*return new ToStringBuilder(this)
            .append("name", getName())            
            .toString();*/
    }
    
    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

    public String getCaption_() {
        return toString();
    }

    public String getCardStatus() {
         if(getEnabled()){
        	 return "卡片啟用";
         }else{
        	 return "卡片停用";
         }
    	
    }
}
