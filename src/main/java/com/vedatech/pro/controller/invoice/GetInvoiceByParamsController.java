package com.vedatech.pro.controller.invoice;


import com.vedatech.pro.model.invoice.Invoice;
import com.vedatech.pro.model.invoice.InvoiceItems;
import com.vedatech.pro.model.invoice.jaxb.Comprobante;
import com.vedatech.pro.repository.invoice.InvoiceDao;
import com.vedatech.pro.service.register.RegisterInvoiceService;
import com.vedatech.pro.service.unmarshaller.UnmarshallerService;
import com.vedatech.pro.service.validate.ComprobanteValidateService;
import com.vedatech.pro.service.wharehouse.MovementsWharehouseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/param")
public class GetInvoiceByParamsController {

    public final UnmarshallerService unmarshallerService;
    public final ComprobanteValidateService validateService;
    public final RegisterInvoiceService registerInvoiceService;
    public final InvoiceDao invoiceDao;
    public final MovementsWharehouseService movementsWharehouseService;

    public GetInvoiceByParamsController(UnmarshallerService unmarshallerService, ComprobanteValidateService validateService, RegisterInvoiceService registerInvoiceService, InvoiceDao invoiceDao, MovementsWharehouseService movementsWharehouseService) {
        this.unmarshallerService = unmarshallerService;
        this.validateService = validateService;
        this.registerInvoiceService = registerInvoiceService;
        this.invoiceDao = invoiceDao;
        this.movementsWharehouseService = movementsWharehouseService;
    }

    @RequestMapping(value = "/upload-service", method = RequestMethod.POST)
    public ResponseEntity<String> readBankTransactions(@RequestParam("file") MultipartFile file) throws JAXBException {

            String comprobante = "";
            String nombreArchivo="";
            String message = "";
            nombreArchivo = file.getOriginalFilename();

                try {
                     comprobante = new String(file.getBytes(), "UTF-8");
                } catch (IOException e) {
                    e.printStackTrace();
                }

        try {

            Comprobante unmarshalComprobante = (Comprobante) unmarshallerService.contextFile(Comprobante.class, comprobante);

            if(!validateService.isValidCustomerInvoice(unmarshalComprobante)) {
                message = "El Comprobante no es una Factura Valida";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
            }

            if(validateService.existFolioInBD(unmarshalComprobante)){
                message = "Fail to save the folio " + unmarshalComprobante.getFolio() + "! exist";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
            }



            else {
                Invoice invoice = new Invoice();
               Invoice fillInvoice = registerInvoiceService.fillInvoice(invoice, unmarshalComprobante);
               List<InvoiceItems> invoiceItems = registerInvoiceService.getConceptos(unmarshalComprobante);
               fillInvoice.setInvoiceItems(invoiceItems);
             ResponseEntity<String> mes = registerInvoiceService.existInventory(invoiceItems, invoice);
             if(mes.getStatusCode().value() == 417) {
                 String message2 = "Debe agregar producciones";
                 return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message2);
             }

                if( mes.getStatusCode().value() == 409) {
                    System.out.println("FALLO EN EL INVENTARIO EL INVENTARIO NO ALCANZA");
                    String message3 = "NO HAY INVENTARIO AGREGE PRODUCCION";
                    return ResponseEntity.status(HttpStatus.CONFLICT).body(message3);
                }

               Invoice completeInvoice = registerInvoiceService.registerCustomer(unmarshalComprobante, fillInvoice, nombreArchivo);
              //  invoiceDao.save(fillInvoice);
                movementsWharehouseService.sendCustomerInvoiceAlmacen(invoiceDao.save(completeInvoice));
                // System.out.println("REGISTER INVOICE SERVICE " + customer.getName());
                System.out.println("ENVIAR RESPUESTA AL SERVIDOR");
                message = "La Factura con Folio: " + " " +"se agrego con exito";
                return ResponseEntity.status(HttpStatus.OK).body(message);
            }

        }catch (Error e){

            return new ResponseEntity<String>(HttpStatus.CONFLICT);

        }

    }

}
