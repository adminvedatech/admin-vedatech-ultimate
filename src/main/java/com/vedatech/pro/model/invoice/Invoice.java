package com.vedatech.pro.model.invoice;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vedatech.pro.model.BaseEntity;
import com.vedatech.pro.model.contabilidad.Poliza;
import com.vedatech.pro.model.customer.Customer;
import com.vedatech.pro.model.product.Product;
import com.vedatech.pro.model.supplier.Supplier;
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
@Table(name = "invoices")
public class Invoice extends BaseEntity {


    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private GregorianCalendar fecha;
    private GregorianCalendar fechaPago;
    private String condicionesDePago;
    private String concept;
    private String nombreArchivo;
    private BigDecimal subTotal;
    private BigDecimal impuesto;
    private BigDecimal total;
    private BigDecimal pago;
    private String folio;
    private Boolean payment;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="poliza_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Poliza poliza;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="customer_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    Customer customer;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="supplier_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    Supplier supplier;


    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "invoice_id")
    private List<InvoiceItems> invoiceItems;

//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "products_id")
//    private List<Product> products;

//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "invoices_id")
//    private List<Poliza> polizas;

}
