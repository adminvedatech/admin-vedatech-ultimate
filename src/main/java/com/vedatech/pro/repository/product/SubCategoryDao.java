package com.vedatech.pro.repository.product;

import com.vedatech.pro.model.product.SubCategory;
import org.springframework.data.repository.CrudRepository;

public interface SubCategoryDao extends CrudRepository<SubCategory, Long> {

    Boolean existsBySubCatName(String subcategory);

}
