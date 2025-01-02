package com.autoloan.supply.model;

import com.autoloan.helper.db.MasterEntity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;



@Getter
@Setter
@Entity
@Table(name = "TAX", schema = "AUTOLOAN")
public class TaxEntity extends MasterEntity {
    
    @Column(name = "NAME", nullable = false, length = 100)
    private String name;
    
    @Column(name = "PERCENT")
    private Double percent;
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return new EqualsBuilder().appendSuper(super.equals(o)).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).appendSuper(super.hashCode()).toHashCode();
    }
}