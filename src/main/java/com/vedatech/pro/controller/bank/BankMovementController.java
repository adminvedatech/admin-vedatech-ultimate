package com.vedatech.pro.controller.bank;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.vedatech.pro.model.bank.BankMovementCsv;
import com.vedatech.pro.model.bank.BankMovementRegister;
import com.vedatech.pro.model.bank.BankMovements;
import com.vedatech.pro.repository.bank.BankDao;
import com.vedatech.pro.repository.bank.BankMovementDao;
import com.vedatech.pro.repository.bank.BankMovementCsvDao;
import com.vedatech.pro.repository.bank.BankMovementRegisterDao;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

@Controller
@RequestMapping("api/bank-movement")
public class BankMovementController {

    HttpHeaders headers = new HttpHeaders();

    public final BankDao bankDao;
    public final BankMovementDao bankMovementDao;
    public final BankMovementCsvDao bankMovementCsvDao;
    public final BankMovementRegisterDao bankMovementRegisterDao;

    public BankMovementController(BankDao bankDao, BankMovementDao bankMovementDao, BankMovementCsvDao bankMovementCsvDao, BankMovementRegisterDao bankMovementRegisterDao) {
        this.bankDao = bankDao;
        this.bankMovementDao = bankMovementDao;
        this.bankMovementCsvDao = bankMovementCsvDao;
        this.bankMovementRegisterDao = bankMovementRegisterDao;
    }



    @RequestMapping(value = "/upload-service", method = RequestMethod.POST)
    public ResponseEntity<String> readProductCSVFile(@RequestParam("file") MultipartFile file) throws JAXBException {

        String message ="";
        // validate file
        if (file.isEmpty()) {
            message = "El Formato del Archivo: " + file.getOriginalFilename() + " esta erroneo o no contiene datos, favor de verificar" + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        } else {
            try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
                System.out.println("Vamos a convertir la file" + reader.toString());
                CsvToBean<BankMovementCsv> csvToBean = new CsvToBeanBuilder(reader)
                        .withType(BankMovementCsv.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();
                List<BankMovementCsv> bankregister = csvToBean.parse();

                if(!existBankAccount(bankregister)){
                    message = "Error en el Archivo: No existe la cuenta Bancaria en" + file.getOriginalFilename() + "!";
                    return new ResponseEntity<String>(message, HttpStatus.CONFLICT);
                }else {

                    for(BankMovementCsv p : bankregister){
                        System.out.println("Valores de la file " + p.toString());
                        BankMovementRegister movements = new BankMovementRegister();
                        if(bankDao.existsByBankAccount(p.getCuenta())) {
                            bankMovementCsvDao.save(p);
                        }
                    }
                }



            } catch (Exception ex) {
                message = "Error en el Archivo: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
            }
        }

        message = "You successfully uploaded " + file.getOriginalFilename() + "!";
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }




    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<String> createBankAccount(@RequestBody BankMovements bank) {
        System.out.println("Creating Bank Account " + bank.getReference());



        if(bankMovementDao.existsByReference(bank.getReference())){
            String message = "La Cuenta de Banco ya existe";
            return new ResponseEntity<String>(message, HttpStatus.CONFLICT);

        }else {
            bankMovementDao.save(bank);
            String message = "El Movimiento se agrego a la base de datos";
            return new ResponseEntity <String> (message,HttpStatus.OK);

        }

    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteBankMovementCsv(@PathVariable(value = "id") Long id) {
        System.out.println("Creating Bank Account " + id);

            BankMovementCsv bankMovementCsv = bankMovementCsvDao.findBankMovementCsvById(id);

            bankMovementCsvDao.delete(bankMovementCsv);
            String message = "El Movimiento se elimino a la base de datos";
            return new ResponseEntity <String> (message,HttpStatus.OK);
        }


    @RequestMapping(value = "/get-bank-movement-csv", method = RequestMethod.GET)
    public ResponseEntity<List<BankMovementCsv>> getAllBankMovementTransaction() {

        List<BankMovementCsv> bankMovementRegisters = (List<BankMovementCsv>) bankMovementCsvDao.findAll();
        if (bankMovementRegisters.isEmpty()) {
            headers.set("error", "no existen movimientos a la cuentas del Cliente");
            return new ResponseEntity<List<BankMovementCsv>>(headers, HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<BankMovementCsv>>(bankMovementRegisters, HttpStatus.OK);

    }





    @RequestMapping(value = "/get-bank-movement-register", method = RequestMethod.GET)
    public ResponseEntity<List<BankMovementRegister>> getAllBankMovementRegister() {

        List<BankMovementRegister> bankMovementRegisters = (List<BankMovementRegister>) bankMovementRegisterDao.findAll();
        if (bankMovementRegisters.isEmpty()) {
            headers.set("error", "no existen movimientos a la cuentas del Cliente");
            return new ResponseEntity<List<BankMovementRegister>>(headers, HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<BankMovementRegister>>(bankMovementRegisters, HttpStatus.OK);

    }



    // PETICION DE BUSQUEDA DE MOVIMIENTOS EN ARCHIVO CSV BY ID
    @RequestMapping(value = "/get-bank-movement-csv/{id}", method = RequestMethod.GET)
    public ResponseEntity<BankMovementCsv> getBankMovementCsvById(@PathVariable(value = "id") Long id) {
        try {

          BankMovementCsv movementRegister =  bankMovementCsvDao.findBankMovementCsvById(id);
            return new ResponseEntity<BankMovementCsv>(movementRegister, HttpStatus.OK);
        }catch (Error e){
            BankMovementCsv movementRegister = null;
            return new ResponseEntity<BankMovementCsv>(movementRegister, HttpStatus.CONFLICT);
        }

    }


    // PETICION DE BUSQUEDA DE MOVIMIENTOS REGISTRADOS BY ID
    @RequestMapping(value = "/get-bank-movement-register/{id}", method = RequestMethod.GET)
    public ResponseEntity<BankMovementRegister> getBankMovementRegisterById(@PathVariable(value = "id") Long id) {
        try {

            BankMovementRegister movementRegister =  bankMovementRegisterDao.findBankMovementRegisterById(id);
            return new ResponseEntity<BankMovementRegister>(movementRegister, HttpStatus.OK);
        }catch (Error e){
            BankMovementRegister movementRegister = null;
            return new ResponseEntity<BankMovementRegister>(movementRegister, HttpStatus.CONFLICT);
        }

    }


    public Boolean existBankAccount(List<BankMovementCsv> bankMovementRegisters) {

        for(BankMovementCsv p : bankMovementRegisters){
            System.out.println("Valores de la file " + p.toString());
            BankMovementRegister movements = new BankMovementRegister();
            if(!bankDao.existsByBankAccount(p.getCuenta())) {
               return false;
            }
        }

        return true;
    }
}
