package com.vedatech.pro.service.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class ResponseServiceImp implements ResponseService{

    @Override
    public ResponseEntity<String> noContentResponse(String message) {

//        message = "La Factura ya existe verifique sus datos";
//        return new ResponseEntity<String>(message, HttpStatus.CONFLICT);

        String message2 = "La Factura con Folio: se agrego con exito";
        return ResponseEntity.status(HttpStatus.CONFLICT).body(message2);
    }
}
