package com.vedatech.pro.service.contabilidad;

import com.vedatech.pro.model.bank.BankMovementCsv;
import com.vedatech.pro.model.bank.BankMovementRegister;
import com.vedatech.pro.model.contabilidad.Poliza;
import com.vedatech.pro.model.invoice.Invoice;

public interface ContabilidadService {

    void savePolizaSupplier(Poliza poliza);
    void savePolizaBankMovementRegister(BankMovementRegister bankMovementRegister);
    BankMovementRegister setBankMovementRegister(BankMovementCsv bankMovementFromCsv);

    
}
