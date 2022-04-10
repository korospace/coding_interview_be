package com.korospace.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.korospace.helpers.ResponseProduct;
import com.korospace.helpers.ResponseFormat;
import com.korospace.models.entities.Product;
import com.korospace.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
    value = "/products"
    // consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
    // produces = {MediaType.APPLICATION_ATOM_XML_VALUE,MediaType.APPLICATION_JSON_VALUE}
)
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Product product, Errors errors) {
        if (errors.hasErrors()) {
            Map<String,String> messages = new HashMap<>();

            for (ObjectError error : errors.getAllErrors()) {
                String fieldName = ((FieldError) error).getField();
                String errorMessage = error.getDefaultMessage();
                messages.put(fieldName, errorMessage);
            }

            ResponseProduct responseData = new ResponseProduct(400,"failed",messages);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        ResponseProduct responseData = new ResponseProduct(201,"success",productService.save(product));
        return ResponseEntity.status(HttpStatus.CREATED).body(responseData);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Product product,@PathVariable String id, Errors errors) {
        product.setId(id);
        
        if (errors.hasErrors()) {
            Map<String,String> messages = new HashMap<>();

            for (ObjectError error : errors.getAllErrors()) {
                String fieldName = ((FieldError) error).getField();
                String errorMessage = error.getDefaultMessage();
                messages.put(fieldName, errorMessage);
            }

            ResponseProduct responseData = new ResponseProduct(400,"failed",messages);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        ResponseProduct responseData = new ResponseProduct(201,"success",productService.save(product));
        return ResponseEntity.status(HttpStatus.CREATED).body(responseData);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") String id) {
        Boolean isDeleted = productService.deleteById(id);

        if (isDeleted == false) {
            ResponseProduct responseData = new ResponseProduct(404,"failed","product with id:"+id+" is not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseData);
        }

        ResponseProduct responseData = new ResponseProduct(202,"success");
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(responseData);
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        Iterable<Product> data = productService.findAll();
        ResponseProduct responseData = new ResponseProduct(200,"success",data);
        
        return ResponseEntity.status(HttpStatus.OK).body(responseData);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") String id) {
        Product data = productService.findById(id);

        if (data == null) {
            ResponseProduct responseData = new ResponseProduct(404,"failed","product with id:"+id+" is not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseData);
        }

        ResponseProduct responseData = new ResponseProduct(200,"success",data);
        return ResponseEntity.status(HttpStatus.OK).body(responseData);
    }

}
