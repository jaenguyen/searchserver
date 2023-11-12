package com.ic.searchserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ic.searchserver.entity.Product;
import com.ic.searchserver.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Iterable<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Product product, String id) {
        Product product1 = productRepository.findById(id).get();
        // replace
        return productRepository.save(product1);
    }

    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }
}
