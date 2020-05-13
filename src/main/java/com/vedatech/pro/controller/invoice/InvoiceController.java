package com.vedatech.pro.controller.invoice;

//import com.vedatech.pro.model.accounting.AccountingType;
import com.vedatech.pro.model.customer.Customer;
import com.vedatech.pro.model.invoice.Invoice;
import com.vedatech.pro.model.invoice.jaxb.Comprobante;
import com.vedatech.pro.repository.customer.CustomerDao;
import com.vedatech.pro.repository.invoice.InvoiceDao;
import com.vedatech.pro.repository.supplier.SupplierDao;
import com.vedatech.pro.service.CfdiService;
//import io.reactivex.Flowable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.apache.commons.io.FileUtils;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/invoice")
public class InvoiceController {

    public final CfdiService cfdiService;
    public final CustomerDao customerDao;
    public final SupplierDao supplierDao;
    public final InvoiceDao invoiceDao;

    public InvoiceController(CfdiService cfdiService, CustomerDao customerDao, SupplierDao supplierDao, InvoiceDao invoiceDao) {
        this.cfdiService = cfdiService;
        this.customerDao = customerDao;
        this.supplierDao = supplierDao;
        this.invoiceDao = invoiceDao;
    }

    HttpHeaders headers = new HttpHeaders();


    //-------------------Received Xml Customer File--------------------------------------------------------
   @RequestMapping(value = "/customer-xml-file", consumes = MediaType.APPLICATION_XML_VALUE)
   public ResponseEntity<String> customerXmlInvoice(@RequestBody String comprobante) throws JAXBException {


        String receptorRfc = "ANT021004RI7";
        Customer customer = new Customer();
        Invoice invoice = new Invoice();
        String message = "";
        System.out.println("COMPROBANTE " + comprobante);
        try {


            Comprobante unmarshalComprobante = (Comprobante) cfdiService.contextFile(Comprobante.class, comprobante);
            if (unmarshalComprobante == null ){
                message = "Fail to save the folio exist";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
            }
            if(unmarshalComprobante.getAddenda() == null ){
                message = "El Comprobante no es una Factura Valida";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
            }


            if (unmarshalComprobante.getAddenda().getFacturaInterfactura() == null){
                message = "Verifique que el documento sea una Factura Valida con Adenda";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
            }


            if ( !unmarshalComprobante.getEmisor().getRfc().equals(receptorRfc)){
                message = "Fail to save the folio " + unmarshalComprobante.getFolio() + "! exist";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
            }
            if (invoiceDao.existsInvoiceByFolio(unmarshalComprobante.getFolio()) ){
                message = "Fail to save the folio " + unmarshalComprobante.getFolio() + "! exist";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
            }


            if (!cfdiService.existCustomer(unmarshalComprobante)) {
                System.out.println("NO EXISTE EL CUSTOMER");
                invoice.setCustomer(cfdiService.saveCustomer(unmarshalComprobante));
                cfdiService.fillInvoice(invoice, unmarshalComprobante);

            } else if (!cfdiService.existBranch(unmarshalComprobante)) {
                System.out.println("Existe Branch?");
                invoice.setCustomer(customerDao.findCustomerByCustomerRfc(unmarshalComprobante.getReceptor().getRfc()));
                cfdiService.fillInvoice(invoice, unmarshalComprobante);
            } else if (customerDao.findCustomerByCustomerRfcAndStoreNum(unmarshalComprobante.getReceptor().getRfc(), unmarshalComprobante.getAddenda().getFacturaInterfactura().getEncabezado().getNumSucursal()) != null) {
                invoice.setCustomer(customerDao.findCustomerByCustomerRfcAndStoreNum(unmarshalComprobante.getReceptor().getRfc(), unmarshalComprobante.getAddenda().getFacturaInterfactura().getEncabezado().getNumSucursal()));
                cfdiService.fillInvoice(invoice, unmarshalComprobante);
            } else {
                System.out.println("AGREGAMOS CUSTOMER A LA FACTURA");
                invoice.setCustomer(cfdiService.saveCustomer(unmarshalComprobante));
                cfdiService.fillInvoice(invoice, unmarshalComprobante);
            }

            System.out.println("ENVIAR RESPUESTA AL SERVIDOR");
            message = "La Factura con Folio: " + unmarshalComprobante.getFolio() +" " +"se agrego con exito";
            return ResponseEntity.status(HttpStatus.OK).body(message);
        }catch (Error e) {
            System.out.println("Error " + e);
            return new ResponseEntity<String>(HttpStatus.CONFLICT);

        }
    }


    //-------------------Received Xml Supplier File--------------------------------------------------------
    @RequestMapping(value = "/supplier-xml-file", consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> supplierXmlInvoice(@RequestBody String comprobante) throws JAXBException {

        String receptorRfc = "ANT021004RI7";
        Customer customer = new Customer();
        Invoice invoice = new Invoice();
        String message = "";

            Comprobante unmarshalComprobante =  cfdiService.contextFileSupplier( comprobante);
            System.out.println("INVOICE CONTROLLER SUPPLIER " + unmarshalComprobante.getEmisor().getNombre());

        message="pues aaaahhh que la chingada";
         return ResponseEntity.status(HttpStatus.OK).body(message);


    }




    @RequestMapping(value = "/setTruePaymentInvoiceById/{id}", method = RequestMethod.GET)
    public ResponseEntity<Invoice> getInvoiceById(@PathVariable( value = "id") Long id) {


        try {

            Invoice findInvoiceById = invoiceDao.findInvoiceById(id);
            findInvoiceById.setPayment(true);
            Invoice paymentInvoice = invoiceDao.save(findInvoiceById);
            return new ResponseEntity<Invoice>(paymentInvoice, HttpStatus.OK);
        } catch (Exception e) {
            // String message = "FAIL to upload !";
            return new ResponseEntity<Invoice>(HttpStatus.EXPECTATION_FAILED);
        }

    }

    @RequestMapping(value = "/setFalsePaymentInvoiceById/{id}", method = RequestMethod.GET)
    public ResponseEntity<Invoice> setFalsePaymentInvoiceById(@PathVariable( value = "id") Long id) {


        try {

            Invoice findInvoiceById = invoiceDao.findInvoiceById(id);
            findInvoiceById.setPayment(false);
            Invoice paymentInvoice = invoiceDao.save(findInvoiceById);
            return new ResponseEntity<Invoice>(paymentInvoice, HttpStatus.OK);
        } catch (Exception e) {
            // String message = "FAIL to upload !";
            return new ResponseEntity<Invoice>(HttpStatus.EXPECTATION_FAILED);
        }

    }



    public File convert(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }

    public void getInvoices(List<String> invoices) throws JAXBException {

        List<String> stringList = new ArrayList<>();
        for (String f: invoices){
            customerXmlInvoice(f);
        }
    }

    @RequestMapping(value = "/get-customer-invoice", method = RequestMethod.GET)
    public ResponseEntity<List<Invoice>> getAllBankTransaction() {

        List<Invoice> invoiceList = (List<Invoice>) invoiceDao.findAllInvoicesByCustomer();
        if (invoiceList.isEmpty()) {
            headers.set("error", "no existen movimientos a la cuentas del Cliente");
            return new ResponseEntity<List<Invoice>>(headers, HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Invoice>>(invoiceList, HttpStatus.OK);

    }

}

