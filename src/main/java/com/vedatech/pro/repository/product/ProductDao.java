package com.vedatech.pro.repository.product;

import com.vedatech.pro.model.product.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface ProductDao extends CrudRepository<Product, Long> {

        Product findProductByCode(String code);
        Product findProductById(Long id);
        Boolean  existsProductByCode(String code);



}
