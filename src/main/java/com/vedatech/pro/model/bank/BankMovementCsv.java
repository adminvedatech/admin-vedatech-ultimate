package com.vedatech.pro.model.bank;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.opencsv.bean.CsvBindByName;
import com.vedatech.pro.model.BaseEntity;
import com.vedatech.pro.model.contabilidad.Poliza;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
//@Builder(builderClassName = "CustomerBuild")
@Table(name = "bank_movement_csv")
public class BankMovementCsv extends BaseEntity {

    @CsvBindByName
    @Column
    public String cuenta;

    @CsvBindByName
    @Column
    public String fechaOperacion;

    @CsvBindByName
    @Column
    public String fecha;

    @CsvBindByName
    @Column
    public String referencia;

    @CsvBindByName
    @Column
    public String descripcion;

    @CsvBindByName
    @Column
    public String codTransac;

    @CsvBindByName
    @Column
    public String sucursal;

    @CsvBindByName
    @Column
    public BigDecimal depositos;

    @CsvBindByName
    @Column
    public BigDecimal retiros;

    @CsvBindByName
    @Column
    public BigDecimal saldo;

    @CsvBindByName
    @Column
    public String movimiento;

    @CsvBindByName
    @Column
    public String descripcionDetallada;

    @Column(name = "ENABLED", nullable = false)
    private boolean enabled = false;



}
