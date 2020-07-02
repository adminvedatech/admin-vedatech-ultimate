package com.vedatech.pro.controller.invoice;


import com.vedatech.pro.model.invoice.jaxb.Comprobante;
import com.vedatech.pro.service.register.RegisterInvoiceService;
import com.vedatech.pro.service.unmarshaller.UnmarshallerService;
import com.vedatech.pro.service.validate.ComprobanteValidateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@RestController
@RequestMapping("/api/invoice")
public class UploadInvoiceSupplierController {

    public final UnmarshallerService unmarshallerService;
    public final ComprobanteValidateService validateService;
    public final RegisterInvoiceService registerInvoiceService;

    public UploadInvoiceSupplierController(UnmarshallerService unmarshallerService, ComprobanteValidateService validateService, RegisterInvoiceService registerInvoiceService) {
        this.unmarshallerService = unmarshallerService;
        this.validateService = validateService;
        this.registerInvoiceService = registerInvoiceService;
    }

    @RequestMapping(value = "/customer-xml-file2", consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> customerXmlInvoice(@RequestBody String comprobante) throws JAXBException {
      //  String comprobante = "";
        String nombreArchivo = "";
        String message = "";
   //     nombreArchivo = file.getOriginalFilename();
        System.out.println("NOMBRE DEL ARCHIVO " + nombreArchivo);

        try {
          //  comprobante = new String(file.getBytes(), "UTF-8");
       //     Comprobante unmarshalComprobante = unmarshallerService.contextFile(Comprobante.class, comprobante);

        //    System.out.println("UNMARSHALLER " + unmarshalComprobante.getFolio());
//            if (!validateService.isValidSupplierInvoice(unmarshalComprobante)) {
//                message = "El Comprobante no es una Factura Valida";
//                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
//
//            }
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);

        } catch (Error e) {
            e.printStackTrace();
            message = "La Factura con Folio: " + " " + "conflicto";
            return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
        }

    }


}