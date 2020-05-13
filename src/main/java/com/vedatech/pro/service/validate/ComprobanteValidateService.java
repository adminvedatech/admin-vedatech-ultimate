package com.vedatech.pro.service.validate;

import com.vedatech.pro.model.invoice.jaxb.Comprobante;

import javax.xml.bind.JAXBException;

public interface ComprobanteValidateService {

    public Boolean isValidCustomerInvoice(Comprobante comprobante);
    public Boolean existFolioInBD(Comprobante comprobante);
    public Boolean isValidSupplierInvoice(Comprobante comprobante);
    public Boolean isTaxesInvoice(Comprobante comprobante);



}
