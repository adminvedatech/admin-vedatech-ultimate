package com.vedatech.pro.model.bank;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vedatech.pro.model.BaseEntity;
import com.vedatech.pro.model.contabilidad.Poliza;
import com.vedatech.pro.model.production.RawMaterial;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Getter
@Setter
@Entity
//@Builder(builderClassName = "CustomerBuild")
@Table(name = "bank_movement")
public class BankMovements extends BaseEntity {

    @Column(name = "date_operation")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private GregorianCalendar dateOperation;

    @Column(name = "date")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date date;

    @Column(name = "reference")
    private String reference;

    @Column(name = "paymentTo")
    private String paymentTo;

    @Column
    private Double deposit;

    @Column
    private Double withdraw;

    @Column
    private Double balance;

    @Column
    private String details;



//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "poliza_id")
//    private List<Poliza> poliza;

//    @ManyToOne(fetch= FetchType.EAGER)
//    @JoinColumn(name="bank_id")
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//    Bank bank;
}
