package com.vedatech.pro.model.depot;


import com.vedatech.pro.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Setter
@Getter
@Entity
@Table(name = "inventory")
public class Inventory extends BaseEntity {

    private String code;
    private String product;
    private Long quantity;
    private BigDecimal unitCost;
    private BigDecimal totalCost;

    @Override
    public String toString() {
        return "Inventory{" +
                "code='" + code + '\'' +
                ", product='" + product + '\'' +
                ", quantity=" + quantity +
                ", unitCost=" + unitCost +
                ", totalCost=" + totalCost +
                '}';
    }
}
