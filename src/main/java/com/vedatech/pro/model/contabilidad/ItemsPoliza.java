package com.vedatech.pro.model.contabilidad;

import com.vedatech.pro.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.GregorianCalendar;

@Getter
@Setter
@Entity
//@Builder(builderClassName = "CustomerBuild")
@Table(name = "items_poliza")
public class ItemsPoliza extends BaseEntity {

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column
    private GregorianCalendar date;

    @Column
    private String accountName;

    @Column
    private String concept;

    @Column
    private String accountNumber;

    @Column
    private String subAccountName;

    @Column
    private String subAccountNumber;

    @Column
    private BigDecimal debit;

    @Column
    private BigDecimal credit;


}
