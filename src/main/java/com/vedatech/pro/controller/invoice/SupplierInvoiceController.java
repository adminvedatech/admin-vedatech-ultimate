package com.vedatech.pro.controller.invoice;


import com.vedatech.pro.model.invoice.Invoice;
import com.vedatech.pro.model.invoice.InvoiceItems;
import com.vedatech.pro.model.supplier.Supplier;
import com.vedatech.pro.repository.invoice.InvoiceDao;
import com.vedatech.pro.repository.supplier.SupplierDao;
import com.vedatech.pro.service.xml.XmlSupplierInvoiceService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/invoice")
public class SupplierInvoiceController {

    HttpHeaders headers = new HttpHeaders();

    public final XmlSupplierInvoiceService xmlSupplierInvoiceService;
    public final InvoiceDao invoiceDao;
    public final SupplierDao supplierDao;

    public SupplierInvoiceController(XmlSupplierInvoiceService xmlSupplierInvoiceService, InvoiceDao invoiceDao, SupplierDao supplierDao) {
        this.xmlSupplierInvoiceService = xmlSupplierInvoiceService;
        this.invoiceDao = invoiceDao;
        this.supplierDao = supplierDao;
    }


    //-------------------Received Xml Supplier File--------------------------------------------------------
    @RequestMapping(value = "/supplier-xml-file-iii",  method = RequestMethod.POST)
    public ResponseEntity<String> supplierXmlInvoiceII(@RequestParam("file") MultipartFile file) throws Exception {

        File file1 = convert(file);
        String nombreArchivo = file.getOriginalFilename();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        Invoice invoice = new Invoice();
        invoice.setNombreArchivo(nombreArchivo);
        String rfc ="";
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(file1);
        System.out.println("DOC " + doc);
        doc.getDocumentElement().normalize();
        String element = "cfdi:Emisor";

   //    invoice =  xmlSupplierInvoiceService.getComprobanteData(doc, invoice);
      //  invoice.setImpuesto(invoice.getTotal().subtract(invoice.getSubTotal()));
      /*  System.out.println("INVOICE FOLIO" + invoice.getFolio());
        System.out.println("INVOICE FECHA" + invoice.getFecha().toString());
        System.out.println("INVOICE FECHA" + invoice.getTotal());
        System.out.println("INVOICE FECHA" + invoice.getTotal());
*/
    //    invoice = xmlSupplierInvoiceService.getImpuestosteData(doc, invoice);


       // System.out.println("INVOICE IMPUESTO" + invoice.getImpuesto());

    //     invoiceDao.save(invoice);
        NodeList nodeList1 = doc.getElementsByTagName("cfdi:Comprobante");
        String folio = getComprobanteFolioAttributesAsString(nodeList1);

        if (invoiceDao.existsInvoiceByFolio(folio)) {
           String message = "La Factura con Folio: " + folio +"ya existe";
            return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
        }

        NodeList nodeList = doc.getElementsByTagName(element);
     //   Node basenode = nodeList.item(0);

        for (int i = 0; i < nodeList.getLength(); i++) {
            System.out.println("NODE LIST IMPUESTOS "+ getAttributesAsString2(nodeList.item(i).getAttributes()));
            rfc = getEmisorRFCAttributesAsString2(nodeList.item(i).getAttributes());
        }
    /*    if (basenode.getNodeType() == Node.ELEMENT_NODE) {
            System.out.println("ATTRIBUTES "  + getAttributesAsString(basenode.getAttributes()));

        }
*/
        //int j =0;
       // getAttributesAsString2(nodeList.item(j).getAttributes());
      //  NodeList children = basenode.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            System.out.println("NODE LIST ITEMS "+ getEmisorRFCAttributesAsString2(nodeList.item(i).getAttributes()));
            rfc = getEmisorRFCAttributesAsString2(nodeList.item(i).getAttributes());
        }

        if(!supplierDao.existsSupplierBySupplierRfc(rfc)){
            System.out.println("Supplier no existe");
            xmlSupplierInvoiceService.saveSupplierByEmisorData(doc);
        }else  {
            System.out.println("SUPPLIER SI EXISTE");
        }


       invoice.setSupplier(supplierDao.findBySupplierRfc(rfc));
        xmlSupplierInvoiceService.setToInvoiceComprobanteAttributes(doc, invoice);
     //   invoiceDao.save(invoice);

        NodeList nodeList2 = doc.getElementsByTagName("cfdi:Impuestos");
        Node basenode2 = nodeList2.item(0);

        NodeList children2 = basenode2.getChildNodes();
        for (int i = 0; i < children2.getLength(); i++) {
            Node item2 = children2.item(i);
            if (item2.getNodeType() == Node.ELEMENT_NODE) {
                System.out.println("ATTRIBUTES: Impuestos " + item2.getNodeName() + getAttributesAsString2(item2.getAttributes()));

            }
        }

        return null;
    }

    private String getAttributesAsString2(NamedNodeMap attributes) {

        Invoice invoice = new Invoice();
        InvoiceItems invoiceItems = new InvoiceItems();
        List<InvoiceItems> invoiceItemsList = new ArrayList<>();
        StringBuilder sb = new StringBuilder("\n");
        for (int j = 0; j < attributes.getLength(); j++) {
            sb.append("\t- ").append(attributes.item(j).getNodeName()).append(": ").append(attributes.item(j).getNodeValue()).append("\n");
        }

        return sb.toString();
    }

    private String getComprobanteFolioAttributesAsString(NodeList nodeList) {


        String folio ="";

        StringBuilder sb = new StringBuilder("\n");

        for (int i = 0; i < nodeList.getLength(); i++) {
            System.out.println("NODE LIST ITEMS " + getEmisorRFCAttributesAsString2(nodeList.item(i).getAttributes()));
            NamedNodeMap attributes = nodeList.item(i).getAttributes();

            for (int j = 0; j < attributes.getLength(); j++) {
                sb.append("\t- ").append(attributes.item(j).getNodeName()).append(": ").append(attributes.item(j).getNodeValue()).append("\n");
                if (attributes.item(j).getNodeName().toLowerCase().equals("folio")) {
                    System.out.println("Si es rfc es " + attributes.item(j).getNodeValue());
                    folio = attributes.item(j).getNodeValue();
                }
            }
        }

        return folio;
    }



    private String getEmisorRFCAttributesAsString2(NamedNodeMap attributes) {

        Invoice invoice = new Invoice();
        String rfc ="";
        InvoiceItems invoiceItems = new InvoiceItems();
        List<InvoiceItems> invoiceItemsList = new ArrayList<>();
        StringBuilder sb = new StringBuilder("\n");
        for (int j = 0; j < attributes.getLength(); j++) {
            sb.append("\t- ").append(attributes.item(j).getNodeName()).append(": ").append(attributes.item(j).getNodeValue()).append("\n");
            if(attributes.item(j).getNodeName().toLowerCase().equals("rfc")) {
                System.out.println("Si es rfc es " + attributes.item(j).getNodeValue());
              //  invoice.setFolio(attributes.item(j).getNodeValue());
                rfc =attributes.item(j).getNodeValue();
            }
        }

        return rfc;
    }



    private String getAttributesAsString(NamedNodeMap attributes) {

        Invoice invoice = new Invoice();
        InvoiceItems invoiceItems = new InvoiceItems();
        List<InvoiceItems> invoiceItemsList = new ArrayList<>();
        StringBuilder sb = new StringBuilder("\n");
        for (int j = 0; j < attributes.getLength(); j++) {
            sb.append("\t- ").append(attributes.item(j).getNodeName()).append(": ").append(attributes.item(j).getNodeValue()).append("\n");
            if(attributes.item(j).getNodeName() == "Cantidad") {
                System.out.println("Si es Cantidad es " + attributes.item(j).getNodeValue());
                invoiceItems.setCantidad(new BigDecimal(attributes.item(j).getNodeValue()));
            }
            if(attributes.item(j).getNodeName() == "ClaveProdServ") {
                System.out.println("Si es ClaveProdServ es " + attributes.item(j).getNodeValue());
                invoiceItems.setClaveProdServ(attributes.item(j).getNodeValue());
            }
            if(attributes.item(j).getNodeName() == "ClaveUnidad") {
                System.out.println("Si es ClaveUnidad es " + attributes.item(j).getNodeValue());
                invoiceItems.setClaveUnidad(attributes.item(j).getNodeValue());
            }
            if(attributes.item(j).getNodeName() == "Descripcion") {
                System.out.println("Si es Descripcion es " + attributes.item(j).getNodeValue());
                invoiceItems.setDescripcion(attributes.item(j).getNodeValue());
            }
            if(attributes.item(j).getNodeName() == "Importe") {
                System.out.println("Si es Importe es " + attributes.item(j).getNodeValue());
                invoiceItems.setImporte(new BigDecimal(attributes.item(j).getNodeValue()));
            }
            if(attributes.item(j).getNodeName() == "Unidad") {
                System.out.println("Si es Unidad es " + attributes.item(j).getNodeValue());
                invoiceItems.setUnidad(attributes.item(j).getNodeValue());
            }
            if(attributes.item(j).getNodeName() == "ValorUnitario") {
                System.out.println("Si es ValorUnitario es " + attributes.item(j).getNodeValue());
                invoiceItems.setValorUnitario(new BigDecimal(attributes.item(j).getNodeValue()));
            }
            if(attributes.item(j).getNodeName() == "fecha") {
                System.out.println("Si es ValorUnitario es " + attributes.item(j).getNodeValue());
                invoiceItems.setValorUnitario(new BigDecimal(attributes.item(j).getNodeValue()));
            }

        }

        invoiceItemsList.add(invoiceItems);
        invoice.setInvoiceItems(invoiceItemsList);
        getInvoice(invoice);
        return sb.toString();

    }


    public File convert(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }

    public void getInvoice(Invoice invoice) {

        for(InvoiceItems i: invoice.getInvoiceItems()){
            System.out.println("INVOICE ITEMS " + i.getDescripcion());
        }
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
}
