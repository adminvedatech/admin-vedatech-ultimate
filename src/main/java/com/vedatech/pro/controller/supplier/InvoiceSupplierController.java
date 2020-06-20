package com.vedatech.pro.controller.supplier;


import com.vedatech.pro.model.invoice.Invoice;
import com.vedatech.pro.repository.invoice.InvoiceDao;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("api/supplier")
public class InvoiceSupplierController {

    HttpHeaders headers = new HttpHeaders();

    public final InvoiceDao invoiceDao;

    public InvoiceSupplierController(InvoiceDao invoiceDao) {
        this.invoiceDao = invoiceDao;
    }

    @RequestMapping(value = "/get-supplier-invoice", method = RequestMethod.GET)
    public ResponseEntity<List<Invoice>> getAllBankTransaction() {

        List<Invoice> invoiceList = (List<Invoice>) invoiceDao.findAllInvoicesBySupplier();
        if (invoiceList.isEmpty()) {
            headers.set("error", "no existen movimientos a la cuentas del Cliente");
            return new ResponseEntity<List<Invoice>>(headers, HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Invoice>>(invoiceList, HttpStatus.OK);

    }


    @RequestMapping(value = "/get-supplier-invoice/{id}", method = RequestMethod.GET)
    public ResponseEntity<Invoice> getInvoiceSupplierById(@PathVariable( value = "id") Long id) {

        System.out.println("VALOR DE ID INVOICE SUPPLIER " + id);

        try {
            Invoice invoiceList = (Invoice) invoiceDao.getInvoiceSupplierById(id);
            return new ResponseEntity<Invoice>(invoiceList, HttpStatus.OK);
        }catch (Error e) {
            headers.set("error", "no existe la Factura indicada del Proveedor");
            return new ResponseEntity<Invoice>(headers, HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }


    }


    @RequestMapping(value = "/get-supplier-invoice-by-id/{id}", method = RequestMethod.GET)
    public ResponseEntity<Invoice> getSupplierInvoiceById(@PathVariable( value = "id") Long id) {

        System.out.println("VALOR DE ID INVOICE SUPPLIER " + id);

        try {
            Invoice invoiceList = (Invoice) invoiceDao.getInvoiceById(id);
            return new ResponseEntity<Invoice>(invoiceList, HttpStatus.OK);
        }catch (Error e) {
            headers.set("error", "no existe la Factura indicada del Proveedor");
            return new ResponseEntity<Invoice>(headers, HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }


    }
}
