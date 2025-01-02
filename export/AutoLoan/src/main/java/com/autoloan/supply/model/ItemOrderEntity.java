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
@Table(name = "ITEM_ORDER", schema = "AUTOLOAN")
public class ItemOrderEntity extends MasterEntity {

    @Column(name = "QTD", nullable = false)
    private Integer qtD;

    @Column(name = "DISCOUNT", nullable = false)
    private Double discount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ORDER", referencedColumnName = "ID")
    private OrderEntity orderEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PRODUCT", referencedColumnName = "ID")
    private ProductEntity productEntity;

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