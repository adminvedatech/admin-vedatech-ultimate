package com.vedatech.pro.model.depot;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vedatech.pro.model.BaseEntity;
import com.vedatech.pro.model.customer.Customer;
import com.vedatech.pro.model.production.Production;
import com.vedatech.pro.model.supplier.Supplier;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.GregorianCalendar;

@Getter
@Setter
@Entity
@Table(name = "movements_wharehouse")
public class MovementsWharehouse extends BaseEntity {

    public String code;
    @DateTimeFormat(pattern = "yyy/MM/dd")
    private GregorianCalendar fecha;
    public String description;
    public String batch;
    public BigDecimal unitCost;
    public BigDecimal totalCost;
    public BigDecimal entrance;
    public BigDecimal price;
    public BigDecimal subTotal;
    public BigDecimal issues;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="supplier_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    Supplier supplier;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="customer_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    Customer customer;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="production_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    Production production;



    @Override
    public String toString() {
        return "MovementsWharehouse{" +
                "code='" + code + '\'' +
                ", fecha=" + fecha +
                ", description='" + description + '\'' +
                ", batch='" + batch + '\'' +
                ", unitCost=" + unitCost +
                ", totalCost=" + totalCost +
                ", entrance=" + entrance +
                ", issues=" + issues +
                '}';
    }
}
