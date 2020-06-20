package com.vedatech.pro.controller.contabilidad;


import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.vedatech.pro.model.contabilidad.Cuentas;
import com.vedatech.pro.model.contabilidad.Poliza;
import com.vedatech.pro.model.contabilidad.SubCuenta;
import com.vedatech.pro.model.product.Product;
import com.vedatech.pro.repository.contabilidad.CuentasDao;
import com.vedatech.pro.repository.contabilidad.SubCuentaDao;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

@Controller
@RequestMapping("api/contabilidad")
public class ContabilidadController {

    HttpHeaders headers = new HttpHeaders();
    public  final CuentasDao cuentasDao;
    public final SubCuentaDao subCuentaDao;

    public ContabilidadController(CuentasDao cuentasDao, SubCuentaDao subCuentaDao) {
        this.cuentasDao = cuentasDao;
        this.subCuentaDao = subCuentaDao;
    }

    @RequestMapping(value = "/upload-service", method = RequestMethod.POST)
    public ResponseEntity<String> readProductCSVFile(@RequestParam("file") MultipartFile file) throws JAXBException {

        String message ="";
        // validate file
        if (file.isEmpty()) {
            message = "El Formato del Archivo: " + file.getOriginalFilename() + " esta erroneo o no contiene datos, favor de verificar" + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        } else {
            try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
                System.out.println("Vamos a convertir la file" + reader.toString());
                CsvToBean<Cuentas> csvToBean = new CsvToBeanBuilder(reader)
                        .withType(Cuentas.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();
                List<Cuentas> cuentas = csvToBean.parse();
                for(Cuentas p : cuentas){
                    System.out.println("Valores de la file " + p.toString());
                    Cuentas cuentas1 = new Cuentas();
                    cuentasDao.save(p);
                }

            } catch (Exception ex) {
                message = "Error en el Archivo: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
            }
        }

        message = "You successfully uploaded " + file.getOriginalFilename() + "!";
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }


    @RequestMapping(value = "/getAllCuentas", method = RequestMethod.GET)
    public ResponseEntity<List<Cuentas>> getAllCuentas() {

        List<Cuentas> cuentas = (List<Cuentas>) cuentasDao.findAll();
        if (cuentas.isEmpty()) {
            headers.set("error", "no existen movimientos a la cuentas del Cliente");
            return new ResponseEntity<List<Cuentas>>(headers, HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Cuentas>>(cuentas, HttpStatus.OK);

    }

    //-------------------Create a Bank Account--------------------------------------------------------

    @RequestMapping(value = "/addSubAccount", method = RequestMethod.POST)
    public ResponseEntity<String> createSubAccount(@RequestBody SubCuenta subAccount) {

       try {

           System.out.println("SUBACCOUNT " + subAccount.toString());
           subCuentaDao.save(subAccount);
           HttpHeaders headers = new HttpHeaders();
           headers.set("accepted ok","el dato se almaceno en la base de datos");
           String message ="los datos se almacenaron en la BD";
           return new ResponseEntity<String>(message, HttpStatus.OK);
       }catch (Error e) {

           headers.set("error al acceder a la base de datosverifique", "verifique de nuevo");
           String message ="error al almacenar los datos";
           return new ResponseEntity<String>(message, HttpStatus.CONFLICT);

       }

    }


//    Regresa todas las SubCuentas

    @RequestMapping(value = "/get-all-subaccounts", method = RequestMethod.GET)
    public ResponseEntity<List<SubCuenta>> getAllSubCuentas() {

        List<SubCuenta> subCuentas = (List<SubCuenta>) subCuentaDao.findAll();
        if (subCuentas.isEmpty()) {
            headers.set("error", "no existen movimientos a la cuentas del Cliente");
            return new ResponseEntity<List<SubCuenta>>(headers, HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<SubCuenta>>(subCuentas, HttpStatus.OK);
     }

    // PETICION DE BUSQUEDA DE CUENTAS  BY ID
    @RequestMapping(value = "/get-account-by-id/{id}", method = RequestMethod.GET)
    public ResponseEntity<Cuentas> getCuentasById(@PathVariable(value = "id") Long id) {

        System.out.println("POLIZA NUMBER "+ id);

        try {
            Cuentas cuentas = cuentasDao.findById(id).get();
            return new ResponseEntity<Cuentas>(cuentas, HttpStatus.OK);
        }catch (Error e){
            Cuentas cuentas = null;
            return new ResponseEntity<Cuentas>(cuentas, HttpStatus.CONFLICT);
        }

    }



    // PETICION DE BUSQUEDA DE SUBACCOUNT BY ACCOUNT NUMBER
    @RequestMapping(value = "/get-subaccount-by-number/{id}", method = RequestMethod.GET)
    public ResponseEntity<SubCuenta> getBankMovementRegisterById(@PathVariable(value = "id") String id) {

        System.out.println("POLIZA NUMBER "+ id);

        try {
            SubCuenta subCuenta = subCuentaDao.findSubCuentaBySubAccountNumber(id);
            return new ResponseEntity<SubCuenta>(subCuenta, HttpStatus.OK);
        }catch (Error e){
            SubCuenta subCuenta = null;
            return new ResponseEntity<SubCuenta>(subCuenta, HttpStatus.CONFLICT);
        }

    }


}
