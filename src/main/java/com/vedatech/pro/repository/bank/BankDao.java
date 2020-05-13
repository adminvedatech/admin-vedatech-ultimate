package com.vedatech.pro.repository.bank;

import com.vedatech.pro.model.bank.Bank;
import com.vedatech.pro.model.bank.BankMovementRegister;
import org.springframework.data.repository.CrudRepository;

public interface BankDao extends CrudRepository<Bank, Long> {

    Boolean existsByBankAccount(String bankAccount);
    Bank findBankByBankAccount(String bankAccount);
    Bank findBankById(Long id);
}
