package com.vedatech.pro.model.report;

import com.vedatech.pro.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;


@Getter
@Setter
@Entity
@Table(name = "product_cost_by_month")
public class ProductCostByMonth extends BaseEntity {

    private String code;
    private String productName;
    private BigDecimal junary;
    private BigDecimal unitCost;
    private BigDecimal febraury;
    private BigDecimal total;

    @Override
    public String toString() {
        return "ProductCostByMonth{" +
                "code='" + code + '\'' +
                ", productName='" + productName + '\'' +
                ", junary=" + junary +
                ", unitCost=" + unitCost +
                ", febraury=" + febraury +
                ", total=" + total +
                '}';
    }
}
