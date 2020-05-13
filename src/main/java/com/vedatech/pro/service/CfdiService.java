package com.vedatech.pro.service;

import com.vedatech.pro.model.customer.Customer;
import com.vedatech.pro.model.invoice.Invoice;
import com.vedatech.pro.model.invoice.jaxb.Comprobante;
import com.vedatech.pro.model.supplier.Supplier;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public interface CfdiService {

    public <T> T contextFile(Class<T> tClass, String comprobante) throws JAXBException;
    public Comprobante contextFileSupplier(String file);
    public Customer saveCustomer(Comprobante comprobante);
    public Boolean existBranch(Comprobante comprobante);
    public Boolean existCustomer(Comprobante comprobante);
    public Supplier saveSupplier(Comprobante comprobante);
    public Boolean existSupplier(Comprobante comprobante);
    public void fillInvoice(Invoice invoice, Comprobante comprobante);


    public Integer convertToInteger(String str);

}
