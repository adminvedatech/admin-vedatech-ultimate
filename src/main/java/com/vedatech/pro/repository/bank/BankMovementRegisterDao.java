package com.vedatech.pro.repository.bank;

import com.vedatech.pro.model.bank.BankMovementRegister;
import com.vedatech.pro.model.product.Product;
import org.springframework.data.repository.CrudRepository;

public interface BankMovementRegisterDao extends CrudRepository<BankMovementRegister, Long> {

    BankMovementRegister findBankMovementRegisterById(Long id);
}
