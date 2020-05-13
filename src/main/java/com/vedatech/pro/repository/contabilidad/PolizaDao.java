package com.vedatech.pro.repository.contabilidad;

import com.vedatech.pro.model.contabilidad.Poliza;
import org.springframework.data.repository.CrudRepository;

public interface PolizaDao extends CrudRepository<Poliza, Long> {

//    Poliza findPolizaByPolizaNumber(String number);
}
