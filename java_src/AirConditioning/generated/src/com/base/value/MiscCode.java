package com.base.value;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class MiscCode extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;
    /** persistent field */
    private String codeName;

    /** persistent field */
    private String keyName;

    /** persistent field */
    private String valueCh;

    /** persistent field */
    private String valueEn;

    /** full constructor */
    public MiscCode(String codeName, String keyName, String valueCh, String valueEn) {
        this.codeName = codeName;
        this.keyName = keyName;
        this.valueCh = valueCh;
        this.valueEn = valueEn;
    }

    /** Labor constructor */
    public MiscCode() {
    }

    public String getCodeName() {
        return this.codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getKeyName() {
        return this.keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public String getValueCh() {
        return this.valueCh;
    }

    public void setValueCh(String valueCh) {
        this.valueCh = valueCh;
    }

    public String getValueEn() {
        return this.valueEn;
    }

    public void setValueEn(String valueEn) {
        this.valueEn = valueEn;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("codeName", getCodeName())
            .append("keyName", getKeyName())
            .append("valueCh", getValueCh())
            .append("valueEn", getValueEn())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
