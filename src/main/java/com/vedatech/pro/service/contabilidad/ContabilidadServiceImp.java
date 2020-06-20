package com.vedatech.pro.service.contabilidad;

import com.vedatech.pro.model.bank.Bank;
import com.vedatech.pro.model.bank.BankMovementCsv;
import com.vedatech.pro.model.bank.BankMovementRegister;
import com.vedatech.pro.model.contabilidad.Poliza;
import com.vedatech.pro.repository.bank.BankDao;
import com.vedatech.pro.repository.bank.BankMovementCsvDao;
import com.vedatech.pro.repository.bank.BankMovementRegisterDao;
import com.vedatech.pro.repository.contabilidad.PolizaDao;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContabilidadServiceImp implements ContabilidadService {

    private final BankMovementRegisterDao movementRegisterDao;
    public final BankMovementCsvDao bankMovementCsvDao;
    public final BankDao bankDao;
    private final PolizaDao polizaDao;

    public ContabilidadServiceImp(BankMovementRegisterDao movementRegisterDao, BankMovementCsvDao bankMovementCsvDao, BankDao bankDao, PolizaDao polizaDao) {
        this.movementRegisterDao = movementRegisterDao;
        this.bankMovementCsvDao = bankMovementCsvDao;
        this.bankDao = bankDao;
        this.polizaDao = polizaDao;
    }


    @Override
    public void savePolizaSupplier(Poliza poliza) {

    }

    @Override
    public void savePolizaBankMovementRegister(BankMovementRegister bankMovementRegister) {

        movementRegisterDao.save(bankMovementRegister);

    //    BankMovementCsv bankMovementCsv = bankMovementCsvDao.findBankMovementCsvById(poliza.getBankMovementRegister().getId());
//        BankMovementRegister bankMovementRegister = setBankMovementRegister(bankMovementCsv);

        //  System.out.println("SUBACCOUNT " + subAccount.toString());
//        bankMovementRegister.setPolizaNumber(poliza.getPolizaNumber());
//        poliza.setBankMovementRegister(movementRegisterDao.save(bankMovementRegister));
//        Poliza loadPoliza = polizaDao.save(poliza);
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("accepted ok", "poliza is in BD ok");
//        Optional<Poliza> getPoliza = polizaDao.findById(loadPoliza.getId());
//        if (getPoliza != null) {
//            bankMovementCsv.setEnabled(true);
//            bankMovementCsvDao.save(bankMovementCsv);
//        }
    }

    @Override
    public BankMovementRegister setBankMovementRegister(BankMovementCsv bankMovementFromCsv) {
        BankMovementRegister bankMovementRegister = new BankMovementRegister();

        Bank bank = bankDao.findBankByBankAccount(bankMovementFromCsv.getCuenta());
       // bankMovementRegister.setBank(bank);
        bankMovementRegister.setFecha(bankMovementFromCsv.getFecha());
        bankMovementRegister.setFechaOperacion(bankMovementFromCsv.getFechaOperacion());
        bankMovementRegister.setCodTransac(bankMovementFromCsv.getCodTransac());
        bankMovementRegister.setDescripcionDetallada(bankMovementFromCsv.getDescripcionDetallada());
        bankMovementRegister.setDepositos(bankMovementFromCsv.getDepositos());
        bankMovementRegister.setRetiros(bankMovementFromCsv.getRetiros());
        bankMovementRegister.setReferencia(bankMovementFromCsv.getReferencia());

        return bankMovementRegister;
    }

}

