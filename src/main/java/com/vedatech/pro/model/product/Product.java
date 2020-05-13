package com.vedatech.pro.model.product;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.opencsv.bean.CsvBindByName;
import com.vedatech.pro.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product extends BaseEntity {

    @CsvBindByName
    public String code;

    @CsvBindByName
    public String productName;

    @CsvBindByName
    public BigDecimal unitPrice;

    @CsvBindByName
    public BigDecimal unitCost;

    @CsvBindByName
    public String type;

    @CsvBindByName
    public String subType;

    public BigDecimal jauCost;
    public BigDecimal febCost;
    public BigDecimal marCost;
    public BigDecimal aprCost;
    public BigDecimal mayCost;
    public BigDecimal juneCost;
    public BigDecimal julCost;
    public BigDecimal augCost;
    public BigDecimal sepCost;
    public BigDecimal octCost;
    public BigDecimal novCost;
    public BigDecimal decCost;

    @Override
    public String toString() {
        return "Product{" +
                "code='" + code + '\'' +
                ", productName='" + productName + '\'' +
                ", unitPrice=" + unitPrice +
                ", unitCost=" + unitCost +
                ", type='" + type + '\'' +
                ", subType='" + subType + '\'' +
                '}';
    }
}

