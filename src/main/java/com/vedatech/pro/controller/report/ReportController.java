package com.vedatech.pro.controller.report;


import com.vedatech.pro.model.report.SalesByProduct;
import com.vedatech.pro.model.report.TotalProduct;
import com.vedatech.pro.repository.invoice.InvoiceItemsDao;
import com.vedatech.pro.service.CfdiService;
import com.vedatech.pro.service.CfdiServiceImp;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@RestController
@RequestMapping("/api/report")
public class ReportController {

    public final InvoiceItemsDao invoiceItemsDao;
    public final CfdiServiceImp cfdiService;

    public ReportController(InvoiceItemsDao invoiceItemsDao, CfdiServiceImp cfdiService) {
        this.invoiceItemsDao = invoiceItemsDao;
        this.cfdiService = cfdiService;
    }

    //-------------------Get Transactions between Dates and Bank Id--------------------------------------------------------

//    @GetMapping(value = "/getSalesByProduct/{after}/{before}")
      @GetMapping(value = "/getSalesByProduct")
//    @RequestMapping(value = "/getSalesByProduct", method = RequestMethod.GET)
     public ResponseEntity<List<TotalProduct>> readBankTransactions(@RequestParam("after") String after, @RequestParam("before") String before) {

        System.out.println("AFTER " + after);
        System.out.println("BEFORE " + before);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        HttpHeaders headers = new HttpHeaders();
          DateFormat df = new SimpleDateFormat("dd MM yyyy");



          try {
              GregorianCalendar cal = new GregorianCalendar();
              GregorianCalendar cal2 = new GregorianCalendar();

            Date date1 = df.parse(after);
            Date date2 = df.parse(before);
            cal.setTime(date1);
            cal2.setTime(date2);

              List<SalesByProduct> salesByProductList = invoiceItemsDao.getDataSales(cal, cal2);
              ArrayList<TotalProduct> totalProducts = new ArrayList<>();
              for (SalesByProduct s : salesByProductList) {
                  System.out.println("Sales by Product " + s.getDescripcion() + "  " + s.getCantidad());
                  TotalProduct totalProduct = new TotalProduct();
                  totalProduct.setCantidad(s.getCantidad());
                  totalProduct.setDescripcion(s.getDescripcion());
                  totalProduct.setClaveUnidad(s.getClaveUnidad());
                  totalProduct.setValorUnitario(s.getValorUnitario());
                  totalProduct.setImporte(s.getImporte());
                  totalProducts.add(totalProduct);
              }

              for (TotalProduct t : totalProducts) {
                  System.out.println("Total Products " + t.getClaveUnidad() + " " + t.getDescripcion() + " " + t.getCantidad() + " " + t.getValorUnitario() +
                          " " + t.getImporte());
              }

              return new ResponseEntity<List<TotalProduct>>(totalProducts, headers, HttpStatus.OK);

        } catch (ParseException e) {
            e.printStackTrace();
        }
           // List<SalesByProduct> bankTransactions = bankTransactionService.findBankTransactionByDateGreaterThanEqualAndDateLessThanEqualAndBank_Id(date1, date2, id);



        return new ResponseEntity<List<TotalProduct>>(headers, HttpStatus.CONFLICT);
    }

}
