package com.vedatech.pro.repository.invoice;

import com.vedatech.pro.model.invoice.Invoice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface InvoicePageableDao extends PagingAndSortingRepository<Invoice, Long> {

    Page<Invoice> findAll(Pageable pageable);
}
