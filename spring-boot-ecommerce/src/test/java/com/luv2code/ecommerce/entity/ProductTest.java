package com.luv2code.ecommerce.entity;

import com.luv2code.ecommerce.dao.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    void  createProduct(){
        Product product = new Product("radio");

        productRepository.save(product);
    }

}