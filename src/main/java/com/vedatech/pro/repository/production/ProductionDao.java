package com.vedatech.pro.repository.production;

import com.vedatech.pro.model.production.Production;
import com.vedatech.pro.model.report.SalesByProduct;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public interface ProductionDao extends CrudRepository<Production, Long> {

    Boolean  existsProductionByBatch(String code);

//    @Query("SELECT AVG(d.cost) FROM Production d WHERE  GROUP BY d.code")
//    BigDecimal  getAveCostByCode(String code);

    @Query("SELECT AVG(d.cost) FROM Production d WHERE Month(d.initialDate)=?1 AND d.code = ?2")
    BigDecimal  getAveCostCodeByMonth(int date, String code);

}
