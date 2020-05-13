package com.vedatech.pro.repository.customer;
import com.vedatech.pro.model.customer.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerDao extends CrudRepository<Customer, Long> {

    Customer findCustomerByCustomerRfc(String rfc);
    Boolean  existsCustomerByCustomerRfc(String rfc);
    Customer findCustomerByCustomerRfcAndStoreNum(String rfc, String storeNum);

}
