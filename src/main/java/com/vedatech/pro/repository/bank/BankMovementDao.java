package com.vedatech.pro.repository.bank;

import com.vedatech.pro.model.bank.BankMovements;
import org.springframework.data.repository.CrudRepository;

public interface BankMovementDao extends CrudRepository<BankMovements, Long> {

    Boolean existsByReference(String reference);
}
