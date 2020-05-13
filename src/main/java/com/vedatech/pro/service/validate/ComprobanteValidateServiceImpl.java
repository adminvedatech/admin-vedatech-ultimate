package com.vedatech.pro.service.validate;

import com.vedatech.pro.model.invoice.jaxb.Comprobante;
import com.vedatech.pro.repository.invoice.InvoiceDao;
import com.vedatech.pro.service.CfdiService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.math.BigDecimal;

@Service
public class ComprobanteValidateServiceImpl implements ComprobanteValidateService {

    public final InvoiceDao invoiceDao;
    public final CfdiService cfdiService;

    public ComprobanteValidateServiceImpl(InvoiceDao invoiceDao, CfdiService cfdiService) {
        this.invoiceDao = invoiceDao;
        this.cfdiService = cfdiService;
    }


    @Override
    public Boolean isValidCustomerInvoice(Comprobante comprobante) {

        try {

            if(comprobante.getAddenda().getFacturaInterfactura() != null){
                return true;
            }
            return false;

        } catch (NullPointerException e) {
            System.out.println("ERROR " + e);
            return false;
        }
    }


    public Boolean existFolioInBD(Comprobante comprobante){

        if (invoiceDao.existsInvoiceByFolio(comprobante.getFolio())){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Boolean isValidSupplierInvoice(Comprobante comprobante) {
      //  System.out.println("RFC RECEPTOR " + comprobante.getReceptor().getRfc());
        String receptor = comprobante.getEmisor().getNombre();
        String pass = "ANT021004RI7";
        System.out.println("EMISOR " + comprobante.getEmisor().getRfc());
        System.out.println("RECEPTOR " + comprobante.getReceptor().getRfc());

      return false;

    }

    @Override
    public Boolean isTaxesInvoice(Comprobante comprobante) {
        try {
            BigDecimal tax = comprobante.getImpuestos().getTotalImpuestosTrasladados();
            BigDecimal zero = new BigDecimal("0.00");
            if (tax.equals(zero)) {
                System.out.println("REGREZO FALSE");
                return false;
            }
            System.out.println("REGREZO TRUE");
            return true;

        } catch (NullPointerException e) {
            System.out.println("ERROR " + e);
            System.out.println("CATCH REGRESO FALSE");
            return false;
        }
    }


    public Boolean existCustomerInBD(Comprobante comprobante){

        if (!cfdiService.existCustomer(comprobante)) {
           return true;
        }else {
            return false;
        }
    }

}










