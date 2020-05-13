package com.vedatech.pro.repository.invoice;
import com.vedatech.pro.model.invoice.Invoice;
import com.vedatech.pro.model.invoice.InvoiceItems;
//import com.vedatech.pro.model.invoice.SalesByProduct;
import com.vedatech.pro.model.report.SalesByProduct;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public interface InvoiceItemsDao extends CrudRepository<InvoiceItems, Long> {

    @Query("SELECT d.claveUnidad, d.descripcion, d.valorUnitario, SUM(d.cantidad), sum(d.importe) FROM InvoiceItems d GROUP BY d.claveUnidad")
    List<Object[]> getData();

   // @Query("SELECT d.claveUnidad as claveUnidad, d.descripcion as descripcion, d.valorUnitario as valorUnitario, SUM(d.cantidad) as cantidad, sum(d.importe) as importe FROM InvoiceItems d WHERE d.date >= ?1 AND d.date < ?2 AND d.invoice.customer.id > 0 GROUP BY d.claveUnidad")
    @Query("SELECT d.claveUnidad as claveUnidad, d.descripcion as descripcion, d.valorUnitario as valorUnitario, SUM(d.cantidad) as cantidad, sum(d.importe) as importe FROM InvoiceItems d WHERE d.date >= ?1 AND d.date < ?2 GROUP BY d.claveUnidad")
    List<SalesByProduct> getDataSales(GregorianCalendar date, GregorianCalendar date2);

 //   select * from table where Month(date) = 12 ;
    @Query("SELECT  SUM(d.cantidad) as cantidad FROM InvoiceItems d WHERE Month(d.date)=2")
    BigDecimal getCantidad();




}
