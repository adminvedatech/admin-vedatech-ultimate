package com.vedatech.pro.model.contabilidad;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vedatech.pro.model.BaseEntity;
import com.vedatech.pro.model.bank.BankMovementCsv;
import com.vedatech.pro.model.bank.BankMovementRegister;
import com.vedatech.pro.model.invoice.Invoice;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.GregorianCalendar;
import java.util.List;

@Getter
@Setter
@Entity
//@Builder(builderClassName = "CustomerBuild")
@Table(name = "poliza")
public class Poliza extends BaseEntity {

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column
    private GregorianCalendar date;

    @Column
    private String type;

    @Column
    private String concept;

//   @OneToOne(fetch = FetchType.EAGER)
//   @JoinColumn(name="bank_movement_register_id")
//   @OneToOne
//        @JoinTable(name = "poliza_bank_movement",
//                joinColumns = {@JoinColumn(name="poliza_id", referencedColumnName="id")
//                }, inverseJoinColumns = {@JoinColumn(name = "bank_movement_register_id", referencedColumnName = "id", unique = true)})
//     @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//     private BankMovementRegister bankMovementRegister;

//    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name="invoices_id")
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//    Invoice invoice;

 //   @OneToOne(mappedBy = "poliza")
  // @JoinColumn(name="bank_movement_id")
 //   @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//    private BankMovementRegister bankMovementRegister;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "poliza_id")
    private List<ItemsPoliza> itemsPolizas;

}
