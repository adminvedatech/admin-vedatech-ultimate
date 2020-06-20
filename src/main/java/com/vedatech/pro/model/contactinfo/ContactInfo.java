package com.vedatech.pro.model.contactinfo;

import com.vedatech.pro.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Table;

@Getter
@Setter
@Entity
//@Builder(builderClassName = "CustomerBuild")
@Table(name = "contact_info")
public class ContactInfo extends BaseEntity {

    private String phone;
    private String email;
    private String cellphone;
    private String website;
    private String address;
    private String city;
    private String notes;

}
