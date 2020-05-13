package com.vedatech.pro.service.register;

import com.vedatech.pro.model.customer.Customer;
import com.vedatech.pro.model.invoice.Invoice;
import com.vedatech.pro.model.invoice.InvoiceItems;
import com.vedatech.pro.model.invoice.jaxb.Comprobante;
import com.vedatech.pro.model.supplier.Supplier;
import com.vedatech.pro.repository.customer.CustomerDao;
import com.vedatech.pro.repository.invoice.InvoiceDao;
import com.vedatech.pro.repository.supplier.SupplierDao;
import com.vedatech.pro.service.validate.ComprobanteValidateService;
import com.vedatech.pro.service.wharehouse.MovementsWharehouseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

@Service
public class RegisterInvoiceServiceImpl implements RegisterInvoiceService {

    Boolean tax = true;
    public final CustomerDao customerDao;
    public final SupplierDao supplierDao;
    public final ComprobanteValidateService comprobanteValidateService;
    public  final InvoiceDao invoiceDao;
    public final MovementsWharehouseService movementsWharehouseService;

    public RegisterInvoiceServiceImpl(CustomerDao customerDao, SupplierDao supplierDao, ComprobanteValidateService comprobanteValidateService, InvoiceDao invoiceDao, MovementsWharehouseService movementsWharehouseService) {
        this.customerDao = customerDao;
        this.supplierDao = supplierDao;
        this.comprobanteValidateService = comprobanteValidateService;
        this.invoiceDao = invoiceDao;
        this.movementsWharehouseService = movementsWharehouseService;
    }

    public Invoice registerCustomer(Comprobante comprobante, Invoice invoice, String nombreArchivo) {
      //  Invoice invoice = new Invoice();
        invoice.setNombreArchivo(nombreArchivo);
        Customer customer = new Customer();

        /*---------| Si el Customer no existe se agrega RFC, Nombre y se agrega sucursal si tiene, se graba en BD |----------*/

        if (!customerDao.existsCustomerByCustomerRfc(comprobante.getReceptor().getRfc())) {
            customer.setCompany(comprobante.getReceptor().getNombre());
            customer.setCustomerRfc(comprobante.getReceptor().getRfc());

            if (comprobante.getAddenda().getFacturaInterfactura().getEncabezado().getNumSucursal() != null) {
                customer.setStoreNum(comprobante.getAddenda().getFacturaInterfactura().getEncabezado().getNumSucursal());
                // customerDao.save(customer);
            }
                        invoice.setCustomer(customerDao.save(customer));
                        return invoice;
        }
            /*------El Customer si existe buscamos por RFC y por numero de Sucursal------*/
            if (customerDao.findCustomerByCustomerRfcAndStoreNum(comprobante.getReceptor().getRfc(), comprobante.getAddenda().getFacturaInterfactura().getEncabezado().getNumSucursal()) != null) {
                invoice.setCustomer(customerDao.findCustomerByCustomerRfcAndStoreNum(comprobante.getReceptor().getRfc(), comprobante.getAddenda().getFacturaInterfactura().getEncabezado().getNumSucursal()));
            }
               invoice.setCustomer(customerDao.findCustomerByCustomerRfc(comprobante.getReceptor().getRfc()));
                return invoice;
                 //       fillInvoice(invoice, comprobante);

    }

    @Override
    public void registerSupplier(Comprobante comprobante, String nombreArchivo) {

        Invoice invoice = new Invoice();
        invoice.setNombreArchivo(nombreArchivo);
        Supplier supplier = new Supplier();

        if (!supplierDao.existsSupplierBySupplierRfc(comprobante.getEmisor().getRfc())) {
            supplier.setCompany(comprobante.getEmisor().getNombre());
            supplier.setSupplierRfc(comprobante.getEmisor().getRfc());

            invoice.setSupplier( supplierDao.save(supplier));
            fillInvoice(invoice, comprobante);
        }

    }

    public Invoice fillInvoice(Invoice invoice, Comprobante comprobante) {

        invoice.setFolio(comprobante.getFolio());
        invoice.setFecha(comprobante.getFecha().toGregorianCalendar());
        if (comprobante.getCondicionesDePago() != null) {
            Integer paymentDay = convertToInteger(comprobante.getCondicionesDePago());
            GregorianCalendar gregorianCalendar = comprobante.getFecha().toGregorianCalendar();
            gregorianCalendar.add(Calendar.DATE, paymentDay);
            System.out.println("Gregorian Calendar Payment " + gregorianCalendar.toString());
            invoice.setFechaPago(gregorianCalendar);
        }

        invoice.setTotal(comprobante.getTotal());
        invoice.setInvoiceItems(getConceptos(comprobante));
        return invoice;
//        Invoice invoiceSaved = invoiceDao.save(invoice);
//        movementsWharehouseService.sendCustomerInvoiceAlmacen(invoiceSaved);


    }

    public List<InvoiceItems> getConceptos(Comprobante comprobante) {

        String clave = "";
        List<Comprobante.Conceptos.Concepto> conceptos = comprobante.getConceptos().getConcepto();
        List<InvoiceItems> itemsList = new ArrayList<>();
        for (Comprobante.Conceptos.Concepto c : conceptos) {
            InvoiceItems invoiceItems = new InvoiceItems();
        //    StoreRawMaterial storeRawMaterial = new StoreRawMaterial();
            System.out.println("Descripcion " + c.getDescripcion() + " Num Identificacion " + c.getNoIdentificacion());
            invoiceItems.setCantidad(c.getCantidad());
          //  storeRawMaterial.setOutput(c.getCantidad());
            invoiceItems.setClaveProdServ(c.getClaveProdServ());
            invoiceItems.setDate(comprobante.getFecha().toGregorianCalendar());
          //  storeRawMaterial.setFecha(comprobante.getFecha().toGregorianCalendar());
            if(comprobante.getEmisor().getRfc().equals("ANT021004RI7")) {


            clave = c.getNoIdentificacion();
          //  invoiceItems.setClaveUnidad(c.getNoIdentificacion());

                switch (clave){
                    case "244995":
                        invoiceItems.setClaveUnidad("7503006908026");
                        invoiceItems.setDescripcion("TOSTADA DE MAIZ HORNEADA");
                     //   storeRawMaterial.setDescription(invoiceItems.getDescripcion());
                     // storeRawMaterial.setCode(invoiceItems.getClaveUnidad());
                    break;
                    case "156468":
                        invoiceItems.setClaveUnidad("7503006908019");
                        invoiceItems.setDescripcion("TOSTADA ROJA DE TRIGO");
                     //   storeRawMaterial.setDescription(invoiceItems.getDescripcion());
                     //   storeRawMaterial.setCode(invoiceItems.getClaveUnidad());
                    break;
                    case "26359":
                        invoiceItems.setClaveUnidad("7501419310023");
                        invoiceItems.setDescripcion("TORTILLA DE TRIGO GERMINADO");
                     //   storeRawMaterial.setDescription(invoiceItems.getDescripcion());
                     //   storeRawMaterial.setCode(invoiceItems.getClaveUnidad());
                        break;
                    case "303545":
                        invoiceItems.setClaveUnidad("7503006908033");
                        invoiceItems.setDescripcion("SNACK MIX DE MAIZ");
                    //    storeRawMaterial.setDescription(invoiceItems.getDescripcion());
                    //    storeRawMaterial.setCode(invoiceItems.getClaveUnidad());
                        break;
                    case "36544":
                        invoiceItems.setClaveUnidad("7503006908002");
                        invoiceItems.setDescripcion("TOSTADA DE TRIGO GERMINADO");
                    //    storeRawMaterial.setDescription(invoiceItems.getDescripcion());
                    //    storeRawMaterial.setCode(invoiceItems.getClaveUnidad());
                    break;
                    case "606048":
                        invoiceItems.setClaveUnidad("7501419310047");
                        invoiceItems.setDescripcion("TORTILLA DE MAIZ NOPAL Y LINAZA");
                    //    storeRawMaterial.setDescription(invoiceItems.getDescripcion());
                    //    storeRawMaterial.setCode(invoiceItems.getClaveUnidad());
                    break;
                    case "606049":
                        invoiceItems.setClaveUnidad("7503006908040");
                        invoiceItems.setDescripcion("TOSTADA DE MAIZ NOPAL Y LINAZA");
                    //    storeRawMaterial.setDescription(invoiceItems.getDescripcion());
                    //    storeRawMaterial.setCode(invoiceItems.getClaveUnidad());
                    break;
                    case "7401419310023":
                        invoiceItems.setClaveUnidad("7501419310023");
                        invoiceItems.setDescripcion("TORTILLA DE TRIGO GERMINADO");
                    //    storeRawMaterial.setDescription(invoiceItems.getDescripcion());
                    //    storeRawMaterial.setCode(invoiceItems.getClaveUnidad());
                        break;
                    default:
                    invoiceItems.setClaveUnidad(c.getNoIdentificacion());
                    invoiceItems.setDescripcion(c.getDescripcion().toUpperCase());
                    // storeRawMaterial.setDescription(invoiceItems.getDescripcion());
                    //  storeRawMaterial.setCode(invoiceItems.getClaveUnidad());
                }
               invoiceItems.setValorUnitario(c.getValorUnitario());
                invoiceItems.setImporte(c.getImporte());
            }
            invoiceItems.setUnidad(c.getUnidad());
            itemsList.add(invoiceItems);
        //    storeRawMaterialDao.save(storeRawMaterial);
        }

        return itemsList;
    }

    @Override
    public  ResponseEntity<String> existInventory (List<InvoiceItems> invoiceItems, Invoice invoice) {

        GregorianCalendar calendar = invoice.getFecha();
        int date = calendar.get(Calendar.MONTH) +1;
      //  BigDecimal newCost =  productionDao.getAveCostCodeByMonth(date, production.getCode());

        for (InvoiceItems i: invoiceItems) {

        ResponseEntity<String> message =  movementsWharehouseService.existInventory(date, i.getClaveUnidad(), i.getCantidad());
            System.out.println("RESPONSE ENTITY MESSAGE: "+ message.getStatusCode().value());

            if( message.getStatusCode().value() == 417) {
                System.out.println("FALLO EN EL INVENTARIO ES NULL");
                String message2 = "Debe agregar producciones";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message2);
            }

            if( message.getStatusCode().value() == 409) {
                System.out.println("FALLO EN EL INVENTARIO EL INVENTARIO NO ALCANZA");
                String message3 = "NO HAY INVENTARIO AGREGE PRODUCCION";
                return ResponseEntity.status(HttpStatus.CONFLICT).body(message3);
            }


        }
        String message = "YA NO HABRA PRODUCTO PARA LA SIGUIENTE VENTA";
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }

    public void fillSupplierInvoice(Invoice invoice, Comprobante comprobante) {

        invoice.setFolio(comprobante.getFolio());
        invoice.setFecha(comprobante.getFecha().toGregorianCalendar());
        invoice.setTotal(comprobante.getSubTotal());
        invoice.setImpuesto(comprobante.getImpuestos().getTotalImpuestosTrasladados());
    }





    public Integer convertToInteger(String str) {

        System.out.println("LENGTH STR " + str.length() + " VALUE " + str);
        String replace = str.replaceAll("\\s", "");
        String replaceTwo = replace.replaceAll("[^a-zA-Z]", "");
        String replaceTree = replace.replaceAll("[^0-9]", "");

        System.out.println("REPLACE TWO " + replaceTwo);
        System.out.println("REPLACE TWO " + replaceTree);

        try {
            int valueIntger = Integer.valueOf(replaceTree);
            return valueIntger;

        } catch (NumberFormatException e) {

            System.out.println("ERROR " + e);
            return 0;
        }
    }


}
