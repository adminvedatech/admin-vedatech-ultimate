package com.vedatech.pro.controller.contabilidad;

import com.vedatech.pro.model.bank.Bank;
import com.vedatech.pro.model.bank.BankMovementCsv;
import com.vedatech.pro.model.bank.BankMovementRegister;
import com.vedatech.pro.model.contabilidad.Poliza;
import com.vedatech.pro.repository.bank.BankDao;
import com.vedatech.pro.repository.bank.BankMovementCsvDao;
import com.vedatech.pro.repository.bank.BankMovementRegisterDao;
import com.vedatech.pro.repository.contabilidad.PolizaDao;
import com.vedatech.pro.service.contabilidad.ContabilidadService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
@RequestMapping("api/poliza")
public class PolizaController {

    private final PolizaDao polizaDao;
    private final ContabilidadService contabilidadService;
    private final BankDao bankDao;
    private final BankMovementRegisterDao movementRegisterDao;
    private final BankMovementCsvDao bankMovementCsvDao;

    public PolizaController(PolizaDao polizaDao, ContabilidadService contabilidadService, BankDao bankDao, BankMovementRegisterDao movementRegisterDao, BankMovementCsvDao bankMovementCsvDao) {
        this.polizaDao = polizaDao;
        this.contabilidadService = contabilidadService;
        this.bankDao = bankDao;
        this.movementRegisterDao = movementRegisterDao;
        this.bankMovementCsvDao = bankMovementCsvDao;
    }
//-------------------Create a Bank Account--------------------------------------------------------

    @RequestMapping(value = "/add-poliza", method = RequestMethod.POST)
    public ResponseEntity<String> createSubAccount(@RequestBody BankMovementRegister bankMovementRegister) {

        try {

            String str = bankMovementRegister.getPoliza().getType();
//        Poliza poliza = bankMovementRegister.getPoliza();
            Bank bank = bankDao.findBankByBankAccount(bankMovementRegister.getCuenta());
            Poliza poliza = polizaDao.save(bankMovementRegister.getPoliza());
            bankMovementRegister.setPoliza(poliza);
            bankMovementRegister.setBank(bank);
            switch (str) {
                case "Dr":
                    //    polizaDao.save(poliza);
                    System.out.println("POLIZA GET TYPE DR");
                    break;
                case "Eg":
                    System.out.println("two");
                    this.contabilidadService.savePolizaBankMovementRegister(bankMovementRegister);
                    //    movementRegisterDao.save(bankMovementRegister);
                    break;

                case "Ig":
                    System.out.println("three");
                    break;
                default:
                    System.out.println("no match");
            }


//        BankMovementCsv bankMovementCsv = bankMovementCsvDao.findBankMovementCsvById(poliza.getBankMovementRegister().getId());
//        BankMovementRegister bankMovementRegister = setBankMovementRegister(bankMovementCsv);
//
//        bankMovementRegister.setPolizaNumber(poliza.getPolizaNumber());
//       poliza.setBankMovementRegister(movementRegisterDao.save(bankMovementRegister));
//        Poliza loadPoliza = polizaDao.save(poliza);
            HttpHeaders headers = new HttpHeaders();
            headers.set("accepted ok", "poliza is in BD ok");
//        Optional<Poliza> getPoliza = polizaDao.findById(loadPoliza.getId());
//        if(getPoliza != null){
//            bankMovementCsv.setEnabled(true);
//            bankMovementCsvDao.save(bankMovementCsv);
            //      }
            BankMovementCsv movementCsv = bankMovementCsvDao.findBankMovementCsvById(bankMovementRegister.getId());
            movementCsv.setEnabled(true);
            bankMovementCsvDao.save(movementCsv);
            String message = "La Poliza se guardo correctamente";
            return new ResponseEntity<String>(message, headers, HttpStatus.CREATED);
        }
        catch (Exception e){
            String message = "Error al guardar los datos";
            return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
        }
        }



    //-------------------Create a Bank Account--------------------------------------------------------

    @RequestMapping(value = "/update-poliza", method = RequestMethod.PUT)
    public ResponseEntity<Poliza> updatePoliza(@RequestBody Poliza poliza) {

        Poliza loadPoliza = polizaDao.save(poliza);
        HttpHeaders headers = new HttpHeaders();
        headers.set("accepted ok","poliza is in BD ok");
        Optional<Poliza> getPoliza = polizaDao.findById(loadPoliza.getId());

        return new ResponseEntity<Poliza>(getPoliza.get(),headers, HttpStatus.CREATED);
    }





    public BankMovementRegister setBankMovementRegister(BankMovementCsv bankMovementFromCsv) {

//        BankMovementRegister bankMovementRegister = new BankMovementRegister();
//
//        Bank bank = bankDao.findBankByBankAccount(bankMovementFromCsv.getCuenta());
//        bankMovementRegister.setBank(bank);
//        bankMovementRegister.setFecha(bankMovementFromCsv.getFecha());
//        bankMovementRegister.setFechaOperacion(bankMovementFromCsv.getFechaOperacion());
//        bankMovementRegister.setCodTransac(bankMovementFromCsv.getCodTransac());
//        bankMovementRegister.setDescripcionDetallada(bankMovementFromCsv.getDescripcionDetallada());
//        bankMovementRegister.setDepositos(bankMovementFromCsv.getDepositos());
//        bankMovementRegister.setRetiros(bankMovementFromCsv.getRetiros());
//        bankMovementRegister.setReferencia(bankMovementFromCsv.getReferencia());
//
//        return bankMovementRegister;
        return null;
    }


    // PETICION DE BUSQUEDA DE POLIZA POR NUMERO DE POLIZA
    @RequestMapping(value = "/get-poliza-by-number/{id}", method = RequestMethod.GET)
    public ResponseEntity<Poliza> getBankMovementRegisterById(@PathVariable(value = "id") Long id) {

        System.out.println("POLIZA NUMBER "+ id);

        try {
            Poliza poliza = polizaDao.findById(id).get();
            return new ResponseEntity<Poliza>(poliza, HttpStatus.OK);
        }catch (Error e){
            Poliza polizaerror = null;
            return new ResponseEntity<Poliza>(polizaerror, HttpStatus.CONFLICT);
        }

    }

}
