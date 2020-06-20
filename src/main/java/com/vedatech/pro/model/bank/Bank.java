package com.vedatech.pro.model.bank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vedatech.pro.model.BaseEntity;
import com.vedatech.pro.model.contabilidad.SubCuenta;
import com.vedatech.pro.model.contactinfo.ContactInfo;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
//@Builder(builderClassName = "CustomerBuild")
@Table(name = "bank")
public class Bank extends BaseEntity {

    private String bankName;
    private String bankAccount;
    private String subAccount;
    private BigDecimal initialBalance;
    private BigDecimal balance;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="subcuenta_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    SubCuenta subCuenta;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="contact_info_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    ContactInfo contactInfo;

}
