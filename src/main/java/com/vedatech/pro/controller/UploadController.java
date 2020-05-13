package com.vedatech.pro.controller;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.vedatech.pro.model.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;

@Controller
public class UploadController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/upload-csv-file", method = RequestMethod.POST)
    public ResponseEntity<String> uploadCSVFile(@RequestParam("file") MultipartFile file, String charset) throws IOException {

        String message ="";
        // validate file
        if (file.isEmpty()) {
            message = "El Formato del Archivo: " + file.getOriginalFilename() + " esta erroneo o no contiene datos, favor de verificar" + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        } else {



            // parse CSV file to create a list of `User` objects
            try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

                // create csv bean reader
                System.out.println("Vamos a convertir la file" + reader.toString());
                CsvToBean<Customer> csvToBean = new CsvToBeanBuilder(reader)
                        .withType(Customer.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();
                System.out.println("convert CSVBean" + csvToBean.toString());
                // convert `CsvToBean` object to list of users
                List<Customer> customers = csvToBean.parse();

                for(Customer c : customers){
                    System.out.println("Valores de la file " + c.getName() + " | "+ c.getEmail());
                }
               // System.out.println(users);

                // TODO: save users in DB?

                // save users list on model
//                model.addAttribute("users", users);
//                model.addAttribute("status", true);

            } catch (Exception ex) {
//                model.addAttribute("message", "An error occurred while processing the CSV file.");
//                model.addAttribute("status", false);
            }
        }

        message = "You successfully uploaded " + file.getOriginalFilename() + "!";
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }

    public File convert(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }
}