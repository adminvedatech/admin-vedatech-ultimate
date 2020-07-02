package com.vedatech.pro.repository.product;

import com.vedatech.pro.model.product.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryDao extends CrudRepository<Category, Long> {

   // @Query("select c from Category c where c.catName = :category")
    Boolean existsByCatName(String category);


}
