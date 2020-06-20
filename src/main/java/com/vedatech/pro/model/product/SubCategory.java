package com.vedatech.pro.model.product;

import com.vedatech.pro.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "sub_category")
public class SubCategory extends BaseEntity {

    public String subCatName;
}
