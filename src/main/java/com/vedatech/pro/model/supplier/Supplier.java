package com.vedatech.pro.model.supplier;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.vedatech.pro.model.accounting.SubAccount;
//import com.vedatech.pro.model.info.ContactInfo;
import com.vedatech.pro.model.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "suppliers")
public class Supplier extends BaseEntity
{

    private String company;
    @Column(name = "supplier_rfc")
    private String supplierRfc;
    private String creditDays;
    private String address;
    private String subAccount;
    private BigDecimal initialBalance;
    private BigDecimal balance;
    private String type;
    private Boolean isTax;
    private Boolean isActive;

//    @OneToOne(fetch= FetchType.LAZY)
//    @JoinColumn(name="sub_account_id")
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//    SubAccount subAccount;
}

