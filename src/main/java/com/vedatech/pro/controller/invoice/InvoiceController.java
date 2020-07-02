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
import com.vedatech.pro.service.unmarshaller.UnmarshallerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

@RestController
@RequestMapping("/api/invoice")
public class InvoiceController {

    public final CfdiService cfdiService;
    public final CustomerDao customerDao;
    public final SupplierDao supplierDao;
    public final InvoiceDao invoiceDao;
    public final UnmarshallerService unmarshallerService;

    public InvoiceController(CfdiService cfdiService, CustomerDao customerDao, SupplierDao supplierDao, InvoiceDao invoiceDao, UnmarshallerService unmarshallerService) {
        this.cfdiService = cfdiService;
        this.customerDao = customerDao;
        this.supplierDao = supplierDao;
        this.invoiceDao = invoiceDao;
        this.unmarshallerService = unmarshallerService;
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
    public ResponseEntity<String> supplierXmlInvoice(@RequestBody String comprobante) throws JAXBException, ParserConfigurationException, IOException, SAXException {

        String receptorRfc = "ANT021004RI7";
        Customer customer = new Customer();
        Invoice invoice = new Invoice();
        String message = "";
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//an instance of builder to parse the specified xml file
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(comprobante);
        doc.getDocumentElement().normalize();
        System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
     //   Comprobante unmarshalComprobante =  cfdiService.contextFileSupplier( comprobante);
      //      System.out.println("INVOICE CONTROLLER SUPPLIER " + unmarshalComprobante.getEmisor().getNombre());

        message="pues aaaahhh que la chingada";
         return ResponseEntity.status(HttpStatus.OK).body(message);


    }


    //-------------------Received Xml Supplier File--------------------------------------------------------
    @RequestMapping(value = "/supplier-xml-file-ii",  method = RequestMethod.POST)
    public ResponseEntity<String> supplierXmlInvoiceII(@RequestParam("file") MultipartFile file) throws JAXBException {

      //  String receptorRfc = "ANT021004RI7";
        String comprobante = "";
    //    Customer customer = new Customer();
    //    Invoice invoice = new Invoice();
    //    String message = "";
        try {

            comprobante = new String(file.getBytes(), "UTF-8");
            System.out.println("COMPROBANTE " + comprobante);
           File file1 = convert(file);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//an instance of builder to parse the specified xml file
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file1);
            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
            System.out.println("Root element: " + doc.getDocumentElement().getTagName());
            System.out.println("Root element: " + doc.getDocumentElement().getTagName());
            System.out.println("Root element: " + doc.getElementsByTagName("cfdi:Emisor"));



            NodeList nodeList = doc.getElementsByTagName("cfdi:Conceptos");
            Node basenode = nodeList.item(0);

            NodeList children = basenode.getChildNodes();
            for (int i = 0; i < children.getLength(); i++) {
                Node item = children.item(i);
                if (item.getNodeType() == Node.ELEMENT_NODE) {
                    System.out.println("ATTRIBUTES " + item.getNodeName() + getAttributesAsString(item.getAttributes()));

                }
            }







          //  Attributes attributes = (Attributes) doc.getElementsByTagName("cfdi:Emisor");
          ///  System.out.println("ATTRIBUTES " + attributes.getValue("rfc"));

            System.out.println("LENGTH: " + nodeList.getLength());
// nodeList is not iterable, so we are using for loop
            for (int itr = 0; itr < nodeList.getLength(); itr++)
            {
                Node node = nodeList.item(itr);
                System.out.println("\nNode Name :" + node.hasAttributes());

                if (node.hasAttributes())
                {
                    Element eElement = (Element) node;
                    listAllAttributes(eElement);
                    System.out.println("Student id: "+ eElement.getAttribute("rfc"));
                    System.out.println("Student id: "+ ((Element) node).getAttribute("rfc"));
                    System.out.println("Student id: "+      ((Element) node).getAttributeNode("rfc"));
                }
            }

        } catch (IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
            String message="error primer catch";
            return ResponseEntity.status(HttpStatus.OK).body(message);
        }

        try {
            Comprobante unmarshalComprobante = (Comprobante) unmarshallerService.contextFile(Comprobante.class, comprobante);

          //  System.out.println("UNMARSHALLER " + unmarshalComprobante.getEmisor());
            System.out.println("Tuvimos un null");
            if(unmarshalComprobante != null ){
                System.out.println("EL ARCHIVO PASO");
            }else {
                String message="la Factura de compra en XML no puede ser procesado, hagalo manulamente";
                return ResponseEntity.status(HttpStatus.HTTP_VERSION_NOT_SUPPORTED).body(message);
            }

        }catch (Error error){

            String message="error segundo catch";
            return ResponseEntity.status(HttpStatus.OK).body(message);

        }
        Comprobante unmarshalComprobante =  cfdiService.contextFileSupplier( comprobante);
        System.out.println("INVOICE CONTROLLER SUPPLIER " + unmarshalComprobante.getEmisor().getNombre());




       String message="llego bien el archivo";
        return ResponseEntity.status(HttpStatus.OK).body(message);


    }


    private String getAttributesAsString(NamedNodeMap attributes) {
        StringBuilder sb = new StringBuilder("\n");
        for (int j = 0; j < attributes.getLength(); j++) {
            sb.append("\t- ").append(attributes.item(j).getNodeName()).append(": ").append(attributes.item(j).getNodeValue()).append("\n");
        }
        return sb.toString();

    }


    public static void listAllAttributes(Element element) {

        System.out.println("List attributes for node: " + element.getNodeName());

        // get a map containing the attributes of this node
        NamedNodeMap attributes = element.getAttributes();

        // get the number of nodes in this map

        int numAttrs = attributes.getLength();


        for (int i = 0; i < numAttrs; i++) {
            Attr attr = (Attr) attributes.item(i);
            String attrName = attr.getNodeName();

            String attrValue = attr.getNodeValue();
            System.out.println("Found attribute: " + attrName + " with value: " + attrValue);

        }
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
    public ResponseEntity<List<Invoice>> getAllBankTransaction(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy
    ) {

        List<Invoice> invoiceList = (List<Invoice>) invoiceDao.findAllInvoicesByCustomer();
        if (invoiceList.isEmpty()) {
            headers.set("error", "no existen movimientos a la cuentas del Cliente");
            return new ResponseEntity<List<Invoice>>(headers, HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Invoice>>(invoiceList, HttpStatus.OK);

    }

}

