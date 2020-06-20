package com.vedatech.pro.model.contabilidad;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vedatech.pro.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "subcuenta")
public class SubCuenta extends BaseEntity {

    @Column(name = "name_subaccount")
    private String nameSubAccount;

    @Column(name = "subaccount_number")
    private String subAccountNumber;

    @Column
    private BigDecimal subAccountBalance;

    @ManyToOne()
    @JoinColumn(name="cuentas_id")
    @JsonIgnoreProperties("subCuentas")
    private Cuentas cuentas;
}
