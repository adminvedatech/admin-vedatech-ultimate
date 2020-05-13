package com.vedatech.pro.controller.test;


import com.vedatech.pro.model.production.Production;
import com.vedatech.pro.model.report.ProductCostByMonth;
import com.vedatech.pro.model.report.ProductSostByMonth;
import com.vedatech.pro.model.depot.MovementsWharehouse;
import com.vedatech.pro.repository.invoice.InvoiceItemsDao;
import com.vedatech.pro.repository.production.ProductionDao;
import com.vedatech.pro.repository.wharehouse.MovementsWharehouseDao;
import com.vedatech.pro.service.wharehouse.ExtractWharehouseService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("api/test")
public class TestController {

    public final InvoiceItemsDao invoiceItemsDao;
    public final MovementsWharehouseDao movementsWharehouseDao;
    public final ProductionDao productionDao;

    HttpHeaders headers = new HttpHeaders();

    public TestController(InvoiceItemsDao invoiceItemsDao, MovementsWharehouseDao movementsWharehouseDao, ProductionDao productionDao) {
        this.invoiceItemsDao = invoiceItemsDao;
        this.movementsWharehouseDao = movementsWharehouseDao;
        this.productionDao = productionDao;
    }

    @RequestMapping(value = "/getCantidad", method = RequestMethod.GET)
    public void getCantidad() {

        BigDecimal cantidad = invoiceItemsDao.getCantidad();

        System.out.println("CANTIDAD " + cantidad);


    }

    @RequestMapping(value = "/get-cost-by-mont", method = RequestMethod.GET)
    public void getProductCostByMonth() {

        List<ProductSostByMonth> productCostByMonths = movementsWharehouseDao.getCostByMonth();

        for (ProductSostByMonth p : productCostByMonths) {
            ProductCostByMonth productCostByMonth = new ProductCostByMonth();
            productCostByMonth.setCode(p.getCode());
            productCostByMonth.setProductName(p.getDescription());
            productCostByMonth.setJunary(p.getUnitCost());

            System.out.println("PRODUCT BY MONTH " + productCostByMonth.toString());

        }

        List<ExtractWharehouseService> wharehouseinventory = movementsWharehouseDao.getWharehouseByMonth();

        for (ExtractWharehouseService p : wharehouseinventory) {
            ProductCostByMonth productCostByMonth = new ProductCostByMonth();
            productCostByMonth.setCode(p.getCode());
            productCostByMonth.setProductName(p.getDescription());
            // productCostByMonth.setJunary(p.getUnitCost());
            //   productCostByMonth.setTotal(p.getTotal());
            //    productCostByMonth.setFebraury(p.getIssues());


            System.out.println("PRODUCT INVENTORIES " + productCostByMonth.toString());

        }


    }

    @RequestMapping(value = "/get-movements-wharehouse", method = RequestMethod.GET)
    public ResponseEntity<List<MovementsWharehouse>> getAllBankTransaction() {

        List<MovementsWharehouse> wharehouse = (List<MovementsWharehouse>) movementsWharehouseDao.findAll();
        if (wharehouse.isEmpty()) {
            headers.set("error", "no existen movimientos a la cuentas del Cliente");
            return new ResponseEntity<List<MovementsWharehouse>>(headers, HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<MovementsWharehouse>>(wharehouse, HttpStatus.OK);

    }


    @RequestMapping(value = "/get-production-date", method = RequestMethod.GET)
    public ResponseEntity<String> getCostDate() {

        Optional<Production> production = productionDao.findById(Long.valueOf(1));
        System.out.println("PRODUCTION 1 " + production.toString());
       GregorianCalendar calendar = production.get().getInitialDate();
        System.out.println("CALENDAR " + calendar.get(Calendar.MONTH));
        System.out.println("CALENDAR " + calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("CALENDAR " + calendar.get(Calendar.YEAR));
        int date = calendar.get(Calendar.MONTH) +1;
        System.out.println("INT DATE ES " + date);

        System.out.println("PRODUCTION COST AVE " + productionDao.getAveCostCodeByMonth(date, "7501419310023"));

        return new ResponseEntity<String>("todo ok", HttpStatus.OK);
    }

}

