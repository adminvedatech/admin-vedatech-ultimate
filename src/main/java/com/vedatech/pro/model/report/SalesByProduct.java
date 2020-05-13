package com.vedatech.pro.model.report;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.GregorianCalendar;


public interface SalesByProduct {

    String getClaveUnidad();
    String getDescripcion();
    Long getCantidad();
    BigDecimal getValorUnitario();
    BigDecimal getImporte();
}


