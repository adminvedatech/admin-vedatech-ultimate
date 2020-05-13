package com.vedatech.pro.model.report;
import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

public interface ProductSostByMonth {

    String getCode();
    String getDescription();
    BigDecimal getUnitCost();
    BigDecimal getTotal();
    BigDecimal getEntrance();
    BigDecimal getIssues();

}
