package com.autoloan.supply.model;

import com.autoloan.helper.db.MasterEntity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "ORDER", schema = "AUTOLOAN")
public class OrderEntity extends MasterEntity {
    
    @Column(name = "DATE_ORDER", nullable = false)
    private Object dateOrder;
    
    @OneToMany(mappedBy = "orderEntity", fetch = FetchType.LAZY)
    private List<ItemOrderEntity> listItemOrderEntity;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CUSTOMER", referencedColumnName = "ID")
    private CustomerEntity customerEntity;
    
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