package com.vedatech.pro.repository.invoice;

import com.vedatech.pro.model.invoice.Invoice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

public interface InvoiceDao extends CrudRepository<Invoice, Long> {

    public List<Invoice> findAllByCustomerId(Long id);
    public List<Invoice> findAllBySupplierId(Long id);

    public Invoice findInvoiceById(Long id);

    @Query("SELECT e FROM Invoice e where e.supplier.id > 0")
    public List<Invoice> findAllInvoicesBySupplier();

//    @Query("SELECT e FROM Invoice e GROUP BY e.supplier")
//    public List<Invoice> findAllInvoicesBySupplier();

    @Query("SELECT e FROM Invoice e where e.customer.id > 0")
    public List<Invoice> findAllInvoicesByCustomer();

    @Query("SELECT  SUM(e.total) FROM Invoice e where e.customer.id =?1")
    public BigDecimal getSumTotalByCustomer(Long id);

    @Query("SELECT  SUM(e.total) FROM Invoice e where e.supplier.id =?1")
    public BigDecimal getSumTotalBySupplier(Long id);

    @Query("SELECT e FROM Invoice e where e.supplier.id =?1")
    public Invoice getInvoiceSupplierById(Long id);


    Boolean existsInvoiceByFolio(String folio);

    @Query("SELECT  e FROM Invoice e where e.customer.id =?1")
    public List<Invoice> findInvoiceWithNoPolizaByCustomer(Long id);

    //public List<Invoice> findAllByPolizas_Empty();

    // public List<Invoice> findAllByPolizas_EmptyAndCustomerId(Long id);

}
