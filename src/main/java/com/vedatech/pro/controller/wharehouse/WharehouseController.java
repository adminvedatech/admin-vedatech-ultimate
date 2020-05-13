package com.vedatech.pro.controller.wharehouse;


import com.vedatech.pro.model.depot.Inventory;
import com.vedatech.pro.model.depot.MovementsWharehouse;
import com.vedatech.pro.repository.wharehouse.MovementsWharehouseDao;
import com.vedatech.pro.service.wharehouse.MovementsWharehouseService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;

@Controller
@RequestMapping("api/wharehouse")
public class WharehouseController {

    HttpHeaders headers = new HttpHeaders();

    public final MovementsWharehouseService wharehouseService;
    public final MovementsWharehouseDao wharehouseDao;

    public WharehouseController(MovementsWharehouseService wharehouseService, MovementsWharehouseDao wharehouseDao) {
        this.wharehouseService = wharehouseService;
        this.wharehouseDao = wharehouseDao;
    }

    @RequestMapping(value = "/get-inventory", method = RequestMethod.GET)
    public ResponseEntity<List<Inventory>> getAllBankTransaction() {

        List<Inventory> inventories =  wharehouseService.getInventory();


//        if (inventories.isEmpty()) {
//            headers.set("error", "no existen movimientos a la cuentas del Cliente");
//            return new ResponseEntity<List<Inventory>>(headers, HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
//        }
        return new ResponseEntity<List<Inventory>>(inventories, HttpStatus.OK);

    }


    @RequestMapping(value = "/add-movement-wharehouse", method = RequestMethod.POST)
    public ResponseEntity<String> createProduction(@RequestBody MovementsWharehouse movementsWharehouse) {
        System.out.println("Creating Bank Account " + movementsWharehouse.toString());
        DateFormat df = new SimpleDateFormat("yyy MM dd");
        df.setCalendar(movementsWharehouse.getFecha());
        GregorianCalendar cal = new GregorianCalendar();

        System.out.println("DATE TIME IS " + String.valueOf(movementsWharehouse.getFecha()));

        String gregorianCalendar = String.valueOf(movementsWharehouse.getFecha());

        MovementsWharehouse saveProduction = wharehouseDao.save(movementsWharehouse);
       // this.almacenMovement(saveProduction);
        String message = "La Producccion se agrego a la base de datos";
        return new ResponseEntity <String> (message,HttpStatus.OK);
    }

}
