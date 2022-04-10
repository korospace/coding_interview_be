package com.korospace.services;

import java.util.Optional;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import com.korospace.models.entities.Product;
import com.korospace.models.repos.ProductRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductService {
    
    @Autowired
    private ProductRepo productRepo;

    public Product save(Product product) {
        Date date = new Date();
        product.setCreated_at(date);
        product.setUdated_at(date);
        return productRepo.save(product);
    }

    public Boolean deleteById(String id) {
        Object product = this.findById(id);

        if (product == null) {
            return false;
        }

        productRepo.deleteById(id);
        return true;
    }

    public Product findById(String id) {
        Optional<Product> product = productRepo.findById(id);
        
        if (!product.isPresent()) {
            return null;
        }

        return productRepo.findById(id).get();
    }

    public List<Product> findByName(String name) {
        return productRepo.findByNameContains(name);
    }

    public Iterable<Product> findAll() {
        return productRepo.findAll();
    }
}
