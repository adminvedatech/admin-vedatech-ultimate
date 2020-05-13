package com.vedatech.pro.model.production;


import com.fasterxml.jackson.databind.ser.Serializers;
import com.vedatech.pro.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "raw_material")
public class RawMaterial extends BaseEntity {

    private String codeProduct;
    private BigDecimal quantity;
    private String rawmaterial;
    private BigDecimal unitCost;
    private BigDecimal total;

    @Override
    public String toString() {
        return "RawMaterial{" +
                "codeProduct='" + codeProduct + '\'' +
                ", quantity=" + quantity +
                ", rawmaterial='" + rawmaterial + '\'' +
                ", unitCost=" + unitCost +
                ", total=" + total +
                '}';
    }
}
