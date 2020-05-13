package com.vedatech.pro.repository.bank;

import com.vedatech.pro.model.bank.BankMovementCsv;
import com.vedatech.pro.model.bank.BankMovementRegister;
import org.springframework.data.repository.CrudRepository;

public interface BankMovementCsvDao extends CrudRepository<BankMovementCsv, Long> {


    BankMovementCsv findBankMovementCsvById(Long id);
   // Boolean existBankMovementCsvById(Long id);

}
