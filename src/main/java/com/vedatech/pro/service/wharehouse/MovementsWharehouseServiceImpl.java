package com.vedatech.pro.service.wharehouse;

import com.vedatech.pro.model.invoice.Invoice;
import com.vedatech.pro.model.invoice.InvoiceItems;
import com.vedatech.pro.model.product.Product;
import com.vedatech.pro.model.production.Production;
import com.vedatech.pro.model.production.RawMaterial;
import com.vedatech.pro.model.depot.Inventory;
import com.vedatech.pro.model.depot.MovementsWharehouse;
import com.vedatech.pro.repository.product.ProductDao;
import com.vedatech.pro.repository.production.ProductionDao;
import com.vedatech.pro.repository.wharehouse.MovementsWharehouseDao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class MovementsWharehouseServiceImpl implements MovementsWharehouseService {

    public final MovementsWharehouseDao movementsWharehouseDao;
    public final ProductDao productDao;
    public final ProductionDao productionDao;

    public MovementsWharehouseServiceImpl(MovementsWharehouseDao movementsWharehouseDao, ProductDao productDao, ProductionDao productionDao) {
        this.movementsWharehouseDao = movementsWharehouseDao;
        this.productDao = productDao;
        this.productionDao = productionDao;
    }



    @Override
    public void sendProductionAlmacen(Production production) {

        MovementsWharehouse movementsWharehouse = new MovementsWharehouse();
    //    Optional<Production> getProduction = productionDao.findById(production.getId());

        movementsWharehouse.setBatch(production.getBatch());
        movementsWharehouse.setCode(production.getCode());
        movementsWharehouse.setDescription(production.getProduct());
        movementsWharehouse.setFecha(production.getInitialDate());
        movementsWharehouse.setEntrance(production.getQuantity());
        movementsWharehouse.setIssues(new BigDecimal(0.00));
        movementsWharehouse.setUnitCost(production.getCost());
        movementsWharehouse.setTotalCost(production.getTotalCost());
        movementsWharehouse.setProduction(production);

        movementsWharehouseDao.save(movementsWharehouse);
        this.updateProductCost(production);

        List<RawMaterial> rawMaterialList = production.getRawMaterials();

        for(RawMaterial rawMaterial : rawMaterialList) {
            MovementsWharehouse material = new MovementsWharehouse();
            material.setCode(rawMaterial.getCodeProduct());
            material.setDescription(rawMaterial.getRawmaterial());
            material.setUnitCost(rawMaterial.getUnitCost());
            material.setTotalCost(rawMaterial.getTotal());
            material.setEntrance(new BigDecimal(0.00));
            material.setIssues(rawMaterial.getQuantity());
            material.setFecha(production.getInitialDate());
            movementsWharehouseDao.save(material);


        }

    }



    @Override
    public void sendSupplierInvoiceAlmacen(Invoice invoice) {

        List<InvoiceItems> invoiceItemsList = invoice.getInvoiceItems();

        for(InvoiceItems item: invoiceItemsList){
            MovementsWharehouse material = new MovementsWharehouse();
            material.setFecha(item.getDate());
            material.setEntrance(item.getCantidad());
            material.setIssues(new BigDecimal(0.00));
            material.setUnitCost(item.getValorUnitario());
            material.setDescription(item.getDescripcion());
            material.setCode(item.getClaveUnidad());
            material.setTotalCost(item.getImporte());
            material.setSupplier(invoice.getSupplier());
            material.setPrice(item.getValorUnitario());
            material.setSubTotal(item.getImporte());
            movementsWharehouseDao.save(material);
        }

    }



    @Override
    public void sendCustomerInvoiceAlmacen(Invoice invoice) {

        List<InvoiceItems> invoiceItemsList = invoice.getInvoiceItems();

        for(InvoiceItems item: invoiceItemsList){
            MovementsWharehouse material = new MovementsWharehouse();
            Product product = productDao.findProductByCode(item.getClaveUnidad());
            material.setFecha(item.getDate());
            material.setIssues(item.getCantidad());
            material.setEntrance(new BigDecimal(0.00));

            GregorianCalendar calendar = invoice.getFecha();
            int date = calendar.get(Calendar.MONTH) +1;
            BigDecimal newCost =  productionDao.getAveCostCodeByMonth(date, item.getClaveUnidad());
            material.setUnitCost(newCost);
            material.setDescription(item.getDescripcion());
            material.setCode(item.getClaveUnidad());
            material.setTotalCost(product.getUnitCost().multiply(item.getCantidad()));
            material.setCustomer(invoice.getCustomer());
            material.setPrice(item.getValorUnitario());
            material.setSubTotal(item.getImporte());
            movementsWharehouseDao.save(material);
        }

    }

    @Override
    public List<Inventory> getInventory() {

        List<ExtractWharehouseService> wharehouseinventory = movementsWharehouseDao.getWharehouseByMonth();
        List<Inventory> inventories = new ArrayList<>();
        for(ExtractWharehouseService p : wharehouseinventory) {
            Inventory inventory = new Inventory();
            inventory.setCode(p.getCode());
            inventory.setQuantity(p.getTotal());
            inventory.setUnitCost(p.getUnitCost());
            inventory.setProduct(p.getDescription());
            inventory.setTotalCost(new BigDecimal(p.getTotal()).multiply(p.getUnitCost()));
            //    productCostByMonth.setFebraury(p.getIssues());
            System.out.println("INVENTORY " + inventory.toString());
            inventories.add(inventory);
        }


        return inventories;
    }

    @Override
    public ResponseEntity<String> existInventory(int date, String code, BigDecimal quantity) {

        try {

            BigDecimal value = new BigDecimal("0");
            if(movementsWharehouseDao.existInventary(date, code) !=null) {
                BigDecimal inventory = movementsWharehouseDao.existInventary(date, code);
                int res;
                res =inventory.compareTo(quantity);
                if(res == 0){
                    System.out.println("INVENTORY " + inventory + "CODE " + code + " CANTIDAD " + quantity);
                    String message = "YA NO HABRA PRODUCTO PARA LA SIGUIENTE VENTA";
                    return ResponseEntity.status(HttpStatus.OK).body(message);
                }else if (res==1){
                    System.out.println("INVENTORY " + inventory + "CODE " + code + " CANTIDAD " + quantity);
                    String message = "SI HAY INVENTARIO";
                    return ResponseEntity.status(HttpStatus.OK).body(message);
                }else if (res == -1){
                    System.out.println("INVENTORY " + inventory + "CODE " + code + " CANTIDAD " + quantity);
                    String message = "NO HAY INVENTARIO AGREGE PRODUCCION";
                    return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
                }
            }else {
                System.out.println("INVENTORY NULL" +  "CODE " + code + " CANTIDAD " + quantity);
                String message = "Debe agregar producciones";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
            }



           String  message = "El Comprobante no es una Factura Valida";
            return ResponseEntity.status(HttpStatus.OK).body(message);

        }catch (NullPointerException e){
           String message = "El Comprobante no es una Factura Valida";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }




    }

    public void updateProductCost(Production production) {

        GregorianCalendar calendar = production.getInitialDate();
        int date = calendar.get(Calendar.MONTH) +1;
      BigDecimal newCost =  productionDao.getAveCostCodeByMonth(date, production.getCode());
        Product product = productDao.findProductByCode(production.getCode());
        product.setUnitCost(newCost);
        productDao.save(product);
       // BigDecimal avgCost = productionDao.getAveCostCodeByMonth(month, production.getCode());
      //  System.out.println("COSTO PROME " + production.getProductName() + ": " + avgCost);

        switch (date){
            case 1:
                product.setJauCost(newCost);
                break;
            case 2:
                product.setFebCost(newCost);
                break;
            case 3:
               product.setMarCost(newCost);
                break;
            case 4:
                product.setAprCost(newCost);
                break;
            case 5:
                product.setMayCost(newCost);
                break;
            case 6:
                product.setJuneCost(newCost);
                break;
            case 7:
                product.setJulCost(newCost);
                break;
            case 8:
                product.setAugCost(newCost);
                break;
            case 9:
                product.setSepCost(newCost);
                break;
            case 10:
                product.setOctCost(newCost);
                break;
            case 11:
                product.setNovCost(newCost);
                break;
            case 12:
                product.setDecCost(newCost);
                break;

        }

    }


}
