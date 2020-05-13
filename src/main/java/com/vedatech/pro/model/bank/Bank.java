package com.vedatech.pro.model.bank;

import com.vedatech.pro.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
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

}
