package com.vedatech.pro.service.wharehouse;

import com.vedatech.pro.model.invoice.Invoice;
import com.vedatech.pro.model.production.Production;
import com.vedatech.pro.model.depot.Inventory;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.List;

public interface MovementsWharehouseService {

     public void sendProductionAlmacen(Production production);
     public void sendSupplierInvoiceAlmacen(Invoice invoice);
     public void sendCustomerInvoiceAlmacen(Invoice invoice);
     public List<Inventory> getInventory();
     public ResponseEntity<String> existInventory(int date, String code, BigDecimal quantity);
}
