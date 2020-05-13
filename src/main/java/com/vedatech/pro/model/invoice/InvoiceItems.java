package com.vedatech.pro.model.invoice;
import com.vedatech.pro.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;
import java.util.GregorianCalendar;

@Getter
@Setter
@Entity
@Table(name = "invoice_items")
public class InvoiceItems extends BaseEntity {

    private String claveProdServ;
    private BigDecimal cantidad;
    private GregorianCalendar date;
    private String unidad;
    private String claveUnidad;
    private String descripcion;
    private BigDecimal valorUnitario;
    private BigDecimal importe;
    private BigDecimal descuento;
//    @ManyToOne
//    public Invoice invoice;
}
