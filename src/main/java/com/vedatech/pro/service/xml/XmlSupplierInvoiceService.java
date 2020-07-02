package com.vedatech.pro.service.xml;


import com.vedatech.pro.model.invoice.Invoice;
import com.vedatech.pro.model.invoice.InvoiceItems;
import org.w3c.dom.Document;

import java.text.ParseException;
import java.util.List;

public interface XmlSupplierInvoiceService {

    public void setToInvoiceComprobanteAttributes(Document doc, Invoice invoice) throws ParseException;
    public Invoice getComprobanteData(Document doc, Invoice invoice) throws Exception;
    public void saveSupplierByEmisorData(Document doc) throws Exception;
    //public List<InvoiceItems> getConceptosData(Document doc);
    //public Invoice getImpuestosteData(Document doc, Invoice invoice) throws Exception;
}
