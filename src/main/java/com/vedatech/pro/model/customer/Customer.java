package com.vedatech.pro.model.customer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vedatech.pro.model.BaseEntity;
//import com.vedatech.pro.model.accounting.SubAccount;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
//@Builder(builderClassName = "CustomerBuild")
@Table(name = "customers")
public class Customer extends BaseEntity {

    private String company;
    private String storeNum;
    private BigDecimal balance = BigDecimal.valueOf(0.00);
    private BigDecimal budget;
    @Column(name = "customer_rfc")
    private String customerRfc;
    private Boolean status = false;
    private String subAccount = "000-00-00";


//    @OneToOne(fetch= FetchType.LAZY)
//    @JoinColumn(name="sub_account_id")
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//    SubAccount subAccount;

   /* @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "invoice_id")
    private List<Invoice> invoices;
*/

    @Override
    public String toString() {
        return "Customer{" +

                "company='" + company + '\'' +
                ", storeNum='" + storeNum + '\'' +
                ", balance=" + balance +
                ", budget=" + budget +
                ", customerRfc='" + customerRfc + '\'' +
                ", status=" + status +
                ", subAccount='" + subAccount + '\'' +
                '}';
    }
}

