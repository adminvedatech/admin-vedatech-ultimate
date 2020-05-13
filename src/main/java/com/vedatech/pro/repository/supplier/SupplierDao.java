package com.vedatech.pro.repository.supplier;


import com.vedatech.pro.model.supplier.Supplier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;

public interface SupplierDao extends CrudRepository<Supplier, Long> {

   // Boolean existsSuppliersBySubAccount_AccountNumber( String account);

    @Query("SELECT SUM(e.balance) FROM Supplier e where e.id = ?1")
    BigDecimal getInitialBalance(Long id);

    Supplier findSupplierById(Long id);

    //    @Query("SELECT e FROM Supplier e where e.supplierRfc = ?1")
    Supplier findBySupplierRfc(String rfc);

    Boolean existsSupplierBySupplierRfc(String rfc);

}
