package com.vedatech.pro.service.response;


import com.vedatech.pro.model.invoice.Invoice;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ResponseService {

    public ResponseEntity<String> noContentResponse(String message);
}