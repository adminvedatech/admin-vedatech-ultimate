package com.vedatech.pro.controller.bank;


import com.vedatech.pro.model.bank.Bank;
import com.vedatech.pro.model.bank.BankMovementRegister;
import com.vedatech.pro.model.product.Product;
import com.vedatech.pro.repository.bank.BankDao;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("api/bank")
public class BankController {

    HttpHeaders headers = new HttpHeaders();
    public final BankDao bankDao;

    public BankController(BankDao bankDao) {
        this.bankDao = bankDao;
    }

    @RequestMapping(value = "/add-bank", method = RequestMethod.POST)
    public ResponseEntity<String> createBankAccount(@RequestBody Bank bank) {
        System.out.println("Creating Bank Account " + bank.getBankName());

        if(bankDao.existsByBankAccount(bank.getBankAccount())){
            String message = "La Cuenta de Banco ya existe";
            return new ResponseEntity<String>(message, HttpStatus.CONFLICT);

        }else {
            bankDao.save(bank);
            String message = "El Producto se agrego a la base de datos";
            return new ResponseEntity <String> (message,HttpStatus.OK);

        }

    }

    //  UPDATE PORDUCT
    @RequestMapping(value = "/update-bank", method = RequestMethod.PUT)
    public ResponseEntity<String> updateBankingAccount(@RequestBody Bank bank) {
       // System.out.println("Creating Bank Account " + product.getProductName());

        Bank updateBank = bankDao.save(bank);
        String message = "El Producto se actualizo en la base de datos";
        return new ResponseEntity <String> (message,HttpStatus.OK);

    }




    @RequestMapping(value = "/get-all-bank-account", method = RequestMethod.GET)
    public ResponseEntity<List<Bank>> getAllBankAccount() {

        List<Bank> bank = (List<Bank>) bankDao.findAll();
        if (bank.isEmpty()) {
            headers.set("error", "no existen movimientos a la cuentas del Cliente");
            return new ResponseEntity<List<Bank>>(headers, HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Bank>>(bank, HttpStatus.OK);

    }



    // PETICION DE BUSQUEDA DE CUENTA DE BANCO BY ID
    @RequestMapping(value = "/get-banking-account-byId/{id}", method = RequestMethod.GET)
    public ResponseEntity<Bank> getBankMovementRegisterById(@PathVariable(value = "id") Long id) {
        try {

            Bank bank =  bankDao.findBankById(id);
            return new ResponseEntity<Bank>(bank, HttpStatus.OK);
        }catch (Error e){
           Bank bank  = null;
            return new ResponseEntity<Bank>(bank, HttpStatus.CONFLICT);
        }

    }


    // PETICION DE BUSQUEDA DE CUENTA DE BANCO BY ID
    @RequestMapping(value = "/get-banking-account-byAccount/{id}", method = RequestMethod.GET)
    public ResponseEntity<Bank> getBankByAccount(@PathVariable(value = "id") String bankAccount) {

        System.out.println("VALOR RECIVIDO " + bankAccount);
        try {

            Bank bank =  bankDao.findBankByBankAccount(bankAccount);
            return new ResponseEntity<Bank>(bank, HttpStatus.OK);
        }catch (Error e){
            Bank bank  = null;
            return new ResponseEntity<Bank>(bank, HttpStatus.CONFLICT);
        }

    }


}
