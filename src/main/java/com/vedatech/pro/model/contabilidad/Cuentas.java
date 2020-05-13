package com.vedatech.pro.model.contabilidad;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.opencsv.bean.CsvBindByName;
import com.vedatech.pro.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Entity
//@Builder(builderClassName = "CustomerBuild")
@Table(name = "cuentas")
public class Cuentas extends BaseEntity {

    @CsvBindByName
    @Column
    public String name;

    @CsvBindByName
    @Column
    public String account;

    @CsvBindByName
    @Column
    public BigDecimal balance;

    @OneToMany(cascade= CascadeType.ALL, mappedBy = "cuentas", fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnoreProperties("cuentas")
    private List<SubCuenta> subCuentas;


    @Override
    public String toString() {
        return "Cuentas{" +
                "name='" + name + '\'' +
                ", account='" + account + '\'' +
                ", balance=" + balance +
                '}';
    }
}
