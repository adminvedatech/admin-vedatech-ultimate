package com.vedatech.pro.service.wharehouse;

import java.math.BigDecimal;

public interface ExtractWharehouseService {

    String getCode();
    String getDescription();
    BigDecimal getUnitCost();
    Long getTotal();
    BigDecimal getEntrance();
    BigDecimal getIssues();

}
