package com.vedatech.pro.service.register;

import com.vedatech.pro.model.invoice.Invoice;
import com.vedatech.pro.model.invoice.InvoiceItems;
import com.vedatech.pro.model.invoice.jaxb.Comprobante;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RegisterInvoiceService {

    public Invoice registerCustomer(Comprobante comprobante, Invoice invoice, String nombreArchivo);
    public void registerSupplier(Comprobante comprobante,String nombreArchivo);
    public List<InvoiceItems> getConceptos(Comprobante comprobante);
    public Invoice fillInvoice(Invoice invoice, Comprobante comprobante);
    public ResponseEntity<String> existInventory(List<InvoiceItems> invoiceItems, Invoice invoice);
}
