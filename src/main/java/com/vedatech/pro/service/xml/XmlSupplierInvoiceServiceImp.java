package com.vedatech.pro.service.xml;


import com.vedatech.pro.model.invoice.Invoice;
import com.vedatech.pro.model.invoice.InvoiceItems;
import com.vedatech.pro.model.supplier.Supplier;
import com.vedatech.pro.repository.invoice.InvoiceDao;
import com.vedatech.pro.repository.supplier.SupplierDao;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class XmlSupplierInvoiceServiceImp implements XmlSupplierInvoiceService{

    public final SupplierDao supplierDao;
    public final InvoiceDao invoiceDao;

    public XmlSupplierInvoiceServiceImp(SupplierDao supplierDao, InvoiceDao invoiceDao) {
        this.supplierDao = supplierDao;
        this.invoiceDao = invoiceDao;
    }

    @Override
    public Invoice getComprobanteData(Document doc, Invoice invoice) throws Exception {


        NodeList nodeList = doc.getElementsByTagName("cfdi:Comprobante");
//        for (int i = 0; i < nodeList.getLength(); i++) {
//            System.out.println("NODE LIST ITEMS "+ getEmisorAttributesAndSaveSupplier(nodeList.item(i).getAttributes()));
//
//        }



        return invoice;
    }

    @Override
    public void saveSupplierByEmisorData(Document doc) throws Exception {
        NodeList nodeList = doc.getElementsByTagName("cfdi:Emisor");
        for (int i = 0; i < nodeList.getLength(); i++) {
            System.out.println("NODE LIST ITEMS "+ getEmisorAttributesAndSaveSupplier(nodeList.item(i).getAttributes()));

        }

    }





    private Invoice getComprobanteAttributesAsString(NamedNodeMap attributes, Invoice invoice) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        GregorianCalendar result = null;
        StringBuilder sb = new StringBuilder("\n");
        for (int j = 0; j < attributes.getLength(); j++) {
            sb.append("\t- ").append(attributes.item(j).getNodeName()).append(": ").append(attributes.item(j).getNodeValue()).append("\n");

            if(attributes.item(j).getNodeName().toLowerCase().equals("folio")) {
                System.out.println("Si es Folio es " + attributes.item(j).getNodeValue().toLowerCase());
                invoice.setFolio(attributes.item(j).getNodeValue());
            }

            if(attributes.item(j).getNodeName().toLowerCase().equals("fecha")) {
                String timestampToParse = attributes.item(j).getNodeValue();
              Date fecha = sdf.parse(timestampToParse);
                Calendar cal = new GregorianCalendar();
                cal.setTime(fecha);
                  invoice.setFecha((GregorianCalendar) cal);

            }

            if(attributes.item(j).getNodeName().toLowerCase().equals("subtotal")) {
                System.out.println("Si es subTotal es " + attributes.item(j).getNodeValue());
                invoice.setSubTotal( new BigDecimal(attributes.item(j).getNodeValue()));
            }
            if(attributes.item(j).getNodeName().toLowerCase().equals("descuento")) {
                System.out.println("Si es Descuento es " + attributes.item(j).getNodeValue());
                invoice.setDescuento( new BigDecimal(attributes.item(j).getNodeValue()));
            }

            if(attributes.item(j).getNodeName().toLowerCase().equals("total")) {
                System.out.println("Si es total es " + attributes.item(j).getNodeValue());
                invoice.setTotal( new BigDecimal(attributes.item(j).getNodeValue()));
            }

            if(attributes.item(j).getNodeName().toLowerCase().equals("totalimpuestostrasladados")) {
                System.out.println("Si es total es " + attributes.item(j).getNodeValue());
                invoice.setImpuesto( new BigDecimal(attributes.item(j).getNodeValue()));
            }





        }

      //  invoiceItemsList.add(invoiceItems);
     //   invoice.setInvoiceItems(invoiceItemsList);

        return invoice;

    }


    private String setConceptosAttributesAsString(Document doc, Invoice invoice) {



        List<InvoiceItems> invoiceItemsList = new ArrayList<>();
        NodeList nodeList = doc.getElementsByTagName("cfdi:Concepto");

        StringBuilder sb = new StringBuilder("\n");
        for (int i = 0; i < nodeList.getLength(); i++) {

            NamedNodeMap attributes = nodeList.item(i).getAttributes();
            InvoiceItems invoiceItems = new InvoiceItems();

            for (int j = 0; j < attributes.getLength(); j++) {

                sb.append("\t- ").append(attributes.item(j).getNodeName()).append(": ").append(attributes.item(j).getNodeValue()).append("\n");
                if (attributes.item(j).getNodeName().toLowerCase().equals("cantidad")) {
                    System.out.println("Si es Cantidad es " + attributes.item(j).getNodeValue());
                    invoiceItems.setCantidad(new BigDecimal(attributes.item(j).getNodeValue()));
                }
                if (attributes.item(j).getNodeName().toLowerCase().equals("claveprodserv")) {
                    System.out.println("Si es ClaveProdServ es " + attributes.item(j).getNodeValue());
                    invoiceItems.setClaveProdServ(attributes.item(j).getNodeValue());
                }
                if (attributes.item(j).getNodeName().toLowerCase().equals("claveunidad")) {
                    System.out.println("Si es ClaveUnidad es " + attributes.item(j).getNodeValue());
                    invoiceItems.setClaveUnidad(attributes.item(j).getNodeValue());
                }
                if (attributes.item(j).getNodeName().toLowerCase().equals("descripcion")) {
                    System.out.println("Si es Descripcion es " + attributes.item(j).getNodeValue());
                    invoiceItems.setDescripcion(attributes.item(j).getNodeValue());
                }
                if (attributes.item(j).getNodeName().toLowerCase().equals("importe")) {
                    System.out.println("Si es Importe es " + attributes.item(j).getNodeValue());
                    invoiceItems.setImporte(new BigDecimal(attributes.item(j).getNodeValue()));
                }
                if (attributes.item(j).getNodeName().toLowerCase().equals("tasaocuota")) {
                    System.out.println("Si es TasaOCuota es " + attributes.item(j).getNodeValue());
                    invoiceItems.setImporte(new BigDecimal(attributes.item(j).getNodeValue()));
                }
                if (attributes.item(j).getNodeName().toLowerCase().equals("unidad")) {
                    System.out.println("Si es Unidad es " + attributes.item(j).getNodeValue());
                    invoiceItems.setUnidad(attributes.item(j).getNodeValue());
                }
                if (attributes.item(j).getNodeName().toLowerCase().equals("valorunitario")) {
                    System.out.println("Si es ValorUnitario es " + attributes.item(j).getNodeValue());
                    invoiceItems.setValorUnitario(new BigDecimal(attributes.item(j).getNodeValue()));
                }
                invoiceItemsList.add(invoiceItems);
                invoice.setInvoiceItems(invoiceItemsList);
            }

        }


        invoiceDao.save(invoice);
        return sb.toString();

    }


    public void setToInvoiceComprobanteAttributes(Document doc, Invoice invoice) throws ParseException {

        NodeList nodeList = doc.getElementsByTagName("cfdi:Comprobante");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("SUPPLIER " + invoice.getSupplier().getCompany());

        for (int i = 0; i < nodeList.getLength(); i++) {
           //System.out.println("NODE LIST ITEMS " + getEmisorAttributesAndSaveSupplier(nodeList.item(i).getAttributes()));
            NamedNodeMap attributes = nodeList.item(i).getAttributes();

            StringBuilder sb = new StringBuilder("\n");
            for (int j = 0; j < attributes.getLength(); j++) {
                sb.append("\t- ").append(attributes.item(j).getNodeName()).append(": ").append(attributes.item(j).getNodeValue()).append("\n");
                if (attributes.item(j).getNodeName().toLowerCase().equals("folio")) {
                    System.out.println("Si el folio es " + attributes.item(j).getNodeValue());

                    invoice.setFolio(attributes.item(j).getNodeValue());

                }
                if (attributes.item(j).getNodeName().toLowerCase().equals("serie")) {
                    System.out.println("Si el folio es " + attributes.item(j).getNodeValue());

                    invoice.setSerie(attributes.item(j).getNodeValue());

                }

                if (attributes.item(j).getNodeName().toLowerCase().equals("subtotal")) {
                    System.out.println("Si el subtotal es " + attributes.item(j).getNodeValue());

                    invoice.setSubTotal(new BigDecimal(attributes.item(j).getNodeValue()));

                }

                if (attributes.item(j).getNodeName().toLowerCase().equals("total")) {
                    System.out.println("Si el total es " + attributes.item(j).getNodeValue());

                    invoice.setTotal(new BigDecimal(attributes.item(j).getNodeValue()));

                }

                if (attributes.item(j).getNodeName().toLowerCase().equals("descuento")) {
                    System.out.println("Si el total es " + attributes.item(j).getNodeValue());

                    invoice.setDescuento(new BigDecimal(attributes.item(j).getNodeValue()));

                }

                if (attributes.item(j).getNodeName().toLowerCase().equals("fecha")) {
                    System.out.println("Si el total es " + attributes.item(j).getNodeValue());

                    String timestampToParse = attributes.item(j).getNodeValue();
                    Date fecha = sdf.parse(timestampToParse);
                    Calendar cal = new GregorianCalendar();
                    cal.setTime(fecha);
                    invoice.setFecha((GregorianCalendar) cal);

                }

            }
        }
                setToInvoiceTotalImpuestosAttributes(doc, invoice);

    }


    public void setToInvoiceTotalImpuestosAttributes(Document doc, Invoice invoice) throws ParseException {

        NodeList nodeList = doc.getElementsByTagName("cfdi:Impuestos");

        for (int i = 0; i < nodeList.getLength(); i++) {

            NamedNodeMap attributes = nodeList.item(i).getAttributes();

            StringBuilder sb = new StringBuilder("\n");
            for (int j = 0; j < attributes.getLength(); j++) {
                sb.append("\t- ").append(attributes.item(j).getNodeName()).append(": ").append(attributes.item(j).getNodeValue()).append("\n");
                if (attributes.item(j).getNodeName().toLowerCase().equals("totalimpuestostrasladados")) {
                    System.out.println("Si el TotalImpuestosTrasladados es " + attributes.item(j).getNodeValue());

                    invoice.setImpuesto(new BigDecimal(attributes.item(j).getNodeValue()));

                }

            }

        }

        setConceptosAttributesAsString(doc, invoice);

    }


    private String getEmisorAttributesAndSaveSupplier(NamedNodeMap attributes) {

         Supplier supplier = new Supplier();
         String name = "";
         String rfc = "";

        StringBuilder sb = new StringBuilder("\n");
        for (int j = 0; j < attributes.getLength(); j++) {
            sb.append("\t- ").append(attributes.item(j).getNodeName()).append(": ").append(attributes.item(j).getNodeValue()).append("\n");
            if(attributes.item(j).getNodeName().toLowerCase().equals("rfc")) {
                System.out.println("Si el rfc es " + attributes.item(j).getNodeValue());
                rfc = attributes.item(j).getNodeValue();
               supplier.setSupplierRfc(attributes.item(j).getNodeValue());

            }

            if(attributes.item(j).getNodeName().toLowerCase().equals("nombre")) {
                System.out.println("Si el nombre es " + attributes.item(j).getNodeValue());
                 name = attributes.item(j).getNodeValue();
               supplier.setCompany(attributes.item(j).getNodeValue());
            }
        }

        System.out.println("NAME AND RFC " + name + ": " + rfc);
        supplierDao.save(supplier);

        return sb.toString();

    }









    private Invoice getImpuestosAttributesAsString(NamedNodeMap attributes, Invoice invoice) throws Exception {

        // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // GregorianCalendar result = null;
        StringBuilder sb = new StringBuilder("\n");
        for (int j = 0; j < attributes.getLength(); j++) {
            sb.append("\t- ").append(attributes.item(j).getNodeName()).append(": ").append(attributes.item(j).getNodeValue()).append("\n");

           /* if (attributes.item(j).getNodeName().toLowerCase().equals("folio")) {
                System.out.println("Si es Folio es " + attributes.item(j).getNodeValue().toLowerCase());
                invoice.setFolio(attributes.item(j).getNodeValue());
            }*/
        }
            return null;
    }

    public static Calendar parseTimestamp(String timestamp)
            throws Exception {
        /*
         ** we specify Locale.US since months are in english
         */
        SimpleDateFormat sdf = new SimpleDateFormat
                ("dd-MMM-yyyy HH:mm:ss", Locale.US);
        Date d = sdf.parse(timestamp);
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        return cal;
    }

}
