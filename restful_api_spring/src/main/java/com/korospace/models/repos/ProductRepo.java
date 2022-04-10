package com.korospace.models.repos;

import java.util.List;

import com.korospace.models.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepo extends CrudRepository<Product,String> {
    public List<Product> findByNameContains(String name);
}
