package com.vedatech.pro.controller;


import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.vedatech.pro.model.product.Category;
import com.vedatech.pro.model.product.Product;
import com.vedatech.pro.model.product.SubCategory;
import com.vedatech.pro.model.production.Production;
import com.vedatech.pro.repository.product.CategoryDao;
import com.vedatech.pro.repository.product.ProductDao;
import com.vedatech.pro.repository.product.SubCategoryDao;
import com.vedatech.pro.repository.production.ProductionDao;
import com.vedatech.pro.service.wharehouse.MovementsWharehouseService;
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
@RequestMapping("api/production")
public class ProductionController {

    HttpHeaders headers = new HttpHeaders();

    public final ProductDao productDao;
    public final ProductionDao productionDao;
    public final MovementsWharehouseService wharehouseService;
    public final CategoryDao categoryDao;
    public final SubCategoryDao subCategoryDao;

    public ProductionController(ProductDao productDao, ProductionDao productionDao, MovementsWharehouseService wharehouseService, CategoryDao categoryDao, SubCategoryDao subCategoryDao) {
        this.productDao = productDao;
        this.productionDao = productionDao;
        this.wharehouseService = wharehouseService;
        this.categoryDao = categoryDao;
        this.subCategoryDao = subCategoryDao;
    }

    @RequestMapping(value = "/upload-service", method = RequestMethod.POST)
    public ResponseEntity<String> readProductCSVFile(@RequestParam("file") MultipartFile file) throws JAXBException {

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
                CsvToBean<Product> csvToBean = new CsvToBeanBuilder(reader)
                        .withType(Product.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();
                System.out.println("convert CSVBean" + csvToBean.toString());
                // convert `CsvToBean` object to list of users
                List<Product> products = csvToBean.parse();

                for(Product p : products){
                    System.out.println("Valores de la file " + p.toString());
                    Product product = new Product();
                        productDao.save(p);

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


    @RequestMapping(value = "/add-product", method = RequestMethod.POST)
    public ResponseEntity<String> createBankAccount(@RequestBody Product product) {
        System.out.println("Creating Bank Account " + product.getProductName());

        if(productDao.existsProductByCode(product.getCode())){
            String message = "El codigo del Producto ya existe";
            return new ResponseEntity<String>(message, HttpStatus.CONFLICT);

        }else {
            Product upProduct = productDao.save(product);
            String message = "El Producto se agrego a la base de datos";
            return new ResponseEntity <String> (message,HttpStatus.OK);

        }

    }


    @RequestMapping(value = "/add-category", method = RequestMethod.POST)
    public ResponseEntity<String> createCategory(@RequestBody Category category) {
        System.out.println("Creating Category " + category.getCatName());

        if(categoryDao.existsByCatName(category.getCatName())){

            String message = "La Categoria ya existe";
            return new ResponseEntity<String>(message, HttpStatus.CONFLICT);

        }else {
            categoryDao.save(category);
            String message = "La Categoria se agrego a la base de datos";
            return new ResponseEntity <String> (message,HttpStatus.OK);

        }

    }


    @RequestMapping(value = "/add-subcategory", method = RequestMethod.POST)
    public ResponseEntity<String> createSubCategory(@RequestBody SubCategory subCategory) {
        System.out.println("Creating Category " + subCategory.getSubCatName());

        if(subCategoryDao.existsBySubCatName(subCategory.getSubCatName())){

            String message = "La Categoria ya existe";
            return new ResponseEntity<String>(message, HttpStatus.CONFLICT);

        }else {
            subCategoryDao.save(subCategory);
            String message = "La Categoria se agrego a la base de datos";
            return new ResponseEntity <String> (message,HttpStatus.OK);

        }

    }


    //  UPDATE PORDUCT
    @RequestMapping(value = "/update-product", method = RequestMethod.PUT)
    public ResponseEntity<String> updateSupplier(@RequestBody Product product) {
        System.out.println("Creating Bank Account " + product.getProductName());

        Product upProduct = productDao.save(product);
        String message = "El Producto se actualizo en la base de datos";
        return new ResponseEntity <String> (message,HttpStatus.OK);

    }



    @RequestMapping(value = "/getAllProducts", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> getAllBankTransaction() {

        List<Product> products = (List<Product>) productDao.findAll();
        if (products.isEmpty()) {
            headers.set("error", "no existen movimientos a la cuentas del Cliente");
            return new ResponseEntity<List<Product>>(headers, HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);

    }


    @RequestMapping(value = "/get-categories", method = RequestMethod.GET)
    public ResponseEntity<List<Category>> getCategories() {

        List<Category> categories = (List<Category>) categoryDao.findAll();
        if (categories.isEmpty()) {
            headers.set("error", "no existen categorias");
            return new ResponseEntity<List<Category>>(headers, HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);

    }


    @RequestMapping(value = "/get-subcategories", method = RequestMethod.GET)
    public ResponseEntity<List<SubCategory>> getSubCategories() {

        List<SubCategory> subCategories = (List<SubCategory>) subCategoryDao.findAll();
        if (subCategories.isEmpty()) {
            headers.set("error", "no existen subcategorias");
            return new ResponseEntity<List<SubCategory>>(headers, HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<SubCategory>>(subCategories, HttpStatus.OK);

    }


    // PETICION DE BUSQUEDA DE SUPPLIER BY ID
    @RequestMapping(value = "/get-product/{id}", method = RequestMethod.GET)
    public ResponseEntity<Product> getProductById(@PathVariable(value = "id") Long id) {
        try {

            Product product =  productDao.findProductById(id);

            return new ResponseEntity<Product>(product, HttpStatus.OK);
        }catch (Error e){
            Product product = null;
            return new ResponseEntity<Product>(product, HttpStatus.CONFLICT);
        }

    }


    @RequestMapping(value = "/add-production", method = RequestMethod.POST)
    public ResponseEntity<String> createProduction(@RequestBody Production production) {
        System.out.println("Creating Bank Account " + production.toString());

        if(productionDao.existsProductionByBatch(production.getBatch())){
            String message = "El codigo del Producto ya existe verifique si la produccion ya esta dada de alta";
            return new ResponseEntity<String>(message, HttpStatus.CONFLICT);

        }
             Production saveProduction = productionDao.save(production);
            this.almacenMovement(saveProduction);
            String message = "La Producccion se agrego a la base de datos";
            return new ResponseEntity <String> (message,HttpStatus.OK);

    }


    private void almacenMovement(Production production){

        this.wharehouseService.sendProductionAlmacen(production);
   }


    @RequestMapping(value = "/get-all-productions", method = RequestMethod.GET)
    public ResponseEntity<List<Production>> getAllProductions() {

        List<Production> productions = (List<Production>) productionDao.findAll();
        if (productions.isEmpty()) {
            headers.set("error", "no existen movimientos");
            return new ResponseEntity<List<Production>>(headers, HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Production>>(productions, HttpStatus.OK);

    }



}



