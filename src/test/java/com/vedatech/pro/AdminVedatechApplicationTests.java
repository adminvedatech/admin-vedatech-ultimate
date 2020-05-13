package com.vedatech.pro;

import com.vedatech.pro.model.product.Product;
import com.vedatech.pro.repository.invoice.InvoiceDao;
import com.vedatech.pro.repository.invoice.InvoiceItemsDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
class AdminVedatechApplicationTests {

    @Autowired
	InvoiceItemsDao invoiceItemsDao = null;

	@Test
	void contextLoads() {
	}

}
