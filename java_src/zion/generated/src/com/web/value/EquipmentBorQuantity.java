package com.web.value;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class EquipmentBorQuantity extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;
    /** persistent field */
    private Integer quantity;

    /** persistent field */
    private com.web.value.Equipment equipment;
    private Long equipmentId;

    /** full constructor */
    public EquipmentBorQuantity(Integer quantity, com.web.value.Equipment equipment) {
        this.quantity = quantity;
        this.equipment = equipment;
    }

    /** default constructor */
    public EquipmentBorQuantity() {
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public com.web.value.Equipment getEquipment() {
        return this.equipment;
    }

    public void setEquipment(com.web.value.Equipment equipment) {
        this.equipment = equipment;
    }

    public Long getEquipmentId() {
        if (this.equipment != null && this.equipment.getId() != null)
            return equipment.getId();
        return this.equipmentId;
    }

    public void setEquipmentId(Long id) {
        this.equipmentId = id;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("quantity", getQuantity())
            .append("equipment", getEquipment())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
