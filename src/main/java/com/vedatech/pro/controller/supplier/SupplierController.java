package com.vedatech.pro.controller.supplier;

import com.vedatech.pro.model.invoice.Invoice;
import com.vedatech.pro.model.supplier.Supplier;
import com.vedatech.pro.repository.invoice.InvoiceDao;
import com.vedatech.pro.repository.supplier.SupplierDao;
import com.vedatech.pro.service.contabilidad.ContabilidadService;
import com.vedatech.pro.service.wharehouse.MovementsWharehouseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("api/supplier")
public class SupplierController {

    public final SupplierDao supplierDao;
    public final InvoiceDao invoiceDao;
    public final MovementsWharehouseService movementsWharehouseService;
    public final ContabilidadService contabilidadService;

    public SupplierController(SupplierDao supplierDao, InvoiceDao invoiceDao, MovementsWharehouseService movementsWharehouseService, ContabilidadService contabilidadService) {
        this.supplierDao = supplierDao;
        this.invoiceDao = invoiceDao;
        this.movementsWharehouseService = movementsWharehouseService;
        this.contabilidadService = contabilidadService;
    }

    @RequestMapping(value = "/add-supplier", method = RequestMethod.POST)
    public ResponseEntity<String> createBankAccount(@RequestBody Supplier supplier) {
        System.out.println("Creating Bank Account " + supplier.getCompany());

        if(supplierDao.existsSupplierBySupplierRfc(supplier.getSupplierRfc())){
            String message = "El proveedor ya existe";
            return new ResponseEntity<String>(message, HttpStatus.CONFLICT);

        }else {
            Supplier upSupplier = supplierDao.save(supplier);
            String message = "El Proveedor se agrego a la base de datos";
            return new ResponseEntity <String> (message,HttpStatus.OK);

        }

    }

    //  UPDATE SUPPLIER
    @RequestMapping(value = "/update-supplier", method = RequestMethod.PUT)
    public ResponseEntity<String> updateSupplier(@RequestBody Supplier supplier) {
        System.out.println("Creating Bank Account " + supplier.getCompany());

        Supplier upSupplier = supplierDao.save(supplier);
        String message = "El Proveedor se actualizo en la base de datos";
        return new ResponseEntity <String> (message,HttpStatus.OK);

    }



    // PETICION DE TODOS LOS SUPPLIERS
    @RequestMapping(value = "/get-suppliers", method = RequestMethod.GET)
    public ResponseEntity<List<Supplier>> getAllSuppliers() {
        try {
            List<Supplier>suppliers = (List<Supplier>) supplierDao.findAll();

            return new ResponseEntity<List<Supplier>>(suppliers, HttpStatus.OK);
        }catch (Error e){
            List<Supplier> suppliers = null;
            return new ResponseEntity<List<Supplier>>(suppliers, HttpStatus.GATEWAY_TIMEOUT);
        }

    }

    // PETICION DE BUSQUEDA DE SUPPLIER BY ID
    @RequestMapping(value = "/get-supplier/{id}", method = RequestMethod.GET)
    public ResponseEntity<Supplier> getSupplierById(@PathVariable(value = "id") Long id) {
        try {

            Supplier supplier =  supplierDao.findSupplierById(id);

            return new ResponseEntity<Supplier>(supplier, HttpStatus.OK);
        }catch (Error e){
            Supplier supplier = null;
            return new ResponseEntity<Supplier>(supplier, HttpStatus.CONFLICT);
        }

    }

    @RequestMapping(value = "/add-supplier-invoice", method = RequestMethod.POST)
    public ResponseEntity<String> createProduction(@RequestBody Invoice invoice) {
        System.out.println("Creating Bank Account " + invoice.toString());

        if(invoiceDao.existsInvoiceByFolio(invoice.getFolio())){
            String message = "La Factura ya existe verifique sus datos";
            return new ResponseEntity<String>(message, HttpStatus.CONFLICT);

        }
        Invoice saveInvoice = invoiceDao.save(invoice);
        movementsWharehouseService.sendSupplierInvoiceAlmacen(saveInvoice);
    //    contabilidadService.fillInvoiceSupplierPoliza(saveInvoice);
     //   contabilidadService.fillItemsPoliza(saveInvoice);
     //   this.almacenMovement(saveProduction);
        String message = "La Producccion se agrego a la base de datos";
        return new ResponseEntity <String> (message,HttpStatus.OK);

    }


}

