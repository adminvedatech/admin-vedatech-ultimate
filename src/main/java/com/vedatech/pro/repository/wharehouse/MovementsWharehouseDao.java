package com.vedatech.pro.repository.wharehouse;

import com.vedatech.pro.model.report.ProductSostByMonth;
import com.vedatech.pro.model.depot.MovementsWharehouse;
import com.vedatech.pro.service.wharehouse.ExtractWharehouseService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

public interface MovementsWharehouseDao extends CrudRepository<MovementsWharehouse, Long> {
//
    @Query("SELECT d.code as code, d.description as description, AVG(d.unitCost) as unitCost FROM MovementsWharehouse d WHERE Month(d.fecha)=1 GROUP BY d.code")
    List<ProductSostByMonth> getCostByMonth();

    @Query("SELECT d.code as code, d.description as description, AVG(d.unitCost) as unitCost, SUM(d.entrance - d.issues) as total FROM MovementsWharehouse d WHERE Month(d.fecha)=1 GROUP BY d.code")
    List<ExtractWharehouseService> getWharehouseByMonth();

    @Query("SELECT SUM(d.entrance - d.issues) as total FROM MovementsWharehouse d WHERE Month(d.fecha)=?1 AND d.code = ?2")
    BigDecimal existInventary(int date, String code);
}
