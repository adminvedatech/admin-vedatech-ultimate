package com.vedatech.pro.model.bank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.opencsv.bean.CsvBindByName;
import com.vedatech.pro.model.BaseEntity;
import com.vedatech.pro.model.contabilidad.Poliza;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.GregorianCalendar;

@Getter
@Setter
@Entity
//@Builder(builderClassName = "CustomerBuild")
@Table(name = "bank_movement_register")
public class BankMovementRegister extends BaseEntity {

        @Column
        public String cuenta;

        @Column
        public String fechaOperacion;

        @Column
        public String fecha;

        @Column
        public String referencia;

        @Column
        public String descripcion;


        @Column
        public String codTransac;

        @Column
        public String sucursal;


        @Column
        public BigDecimal depositos;

        @Column
        public BigDecimal retiros;

        @Column
        public BigDecimal saldo;

        @Column
        public String movimiento;

        @Column(name = "ENABLED", nullable = false)
        private boolean enabled = false;



        @Column
        public String descripcionDetallada;

//        @ManyToOne(fetch= FetchType.LAZY)
//        @JoinColumn(name="bank_id")
//        @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//        Bank bank;

        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name="poliza_id")
        @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
        private Poliza poliza;

//        @OneToOne
//        @JoinTable(name = "poliza_bank_movement",
//                joinColumns = {@JoinColumn(name="bank_movement_register_id", referencedColumnName="id")
//                }, inverseJoinColumns = {
//                        @JoinColumn(name = "poliza_id", referencedColumnName = "id", unique = true)
//                })
      //  @OneToOne(mappedBy ="bankMovementRegister")
      //  Poliza poliza;
    @Override
    public String toString() {
        return "BankMovementRegister{" +

                ", fechaOperacion=" + fechaOperacion +
                ", fecha=" + fecha +
                ", referencia='" + referencia + '\'' +
                ", codTransac='" + codTransac + '\'' +
                ", depositos=" + depositos +
                ", retiros=" + retiros +
                ", saldo=" + saldo +
                ", descripcionDetallada='" + descripcionDetallada + '\'' +
                '}';
    }
}
