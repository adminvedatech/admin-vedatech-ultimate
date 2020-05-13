package com.vedatech.pro.model.production;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vedatech.pro.model.BaseEntity;
import com.vedatech.pro.model.customer.Customer;
import com.vedatech.pro.model.invoice.InvoiceItems;
import com.vedatech.pro.model.product.Product;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.GregorianCalendar;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "production")
public class Production extends BaseEntity {

    private String code;
    private String product;
    private GregorianCalendar initialDate;
    private GregorianCalendar finalDate;
    private String batch;
    private String observation;
    private BigDecimal cost;
    private BigDecimal totalCost;
    private BigDecimal quantity;


    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "production_id")
    private List<RawMaterial> rawMaterials;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="product_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    Product productName;

    @Override
    public String toString() {
        return "Production{" +
                "code='" + code + '\'' +
                ", initialDate=" + initialDate +
                ", finalDate=" + finalDate +
                ", batch='" + batch + '\'' +
                ", observation='" + observation + '\'' +
                ", cost=" + cost +
                ", totalCost=" + totalCost +
                ", quantity=" + quantity +
                ", rawMaterials=" + rawMaterials +
                ", productName=" + productName +
                '}';
    }
}
