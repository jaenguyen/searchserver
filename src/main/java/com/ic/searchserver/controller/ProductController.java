package com.ic.searchserver.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ic.searchserver.entity.Product;
import com.ic.searchserver.service.ProductService;
import com.ic.searchserver.service.SearchService;

import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;

@RestController
@RequestMapping("/apis")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private SearchService searchService;

    @GetMapping("/products")
    Iterable<Product> findAll() {
        return productService.getProducts();
    }

    @PostMapping("/product")
    Product insertProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @GetMapping("/search")
    List<Product> matchAllWithName(@RequestParam String name) throws Exception {
        SearchResponse<Product> searchResponse = searchService.matchAllProductWithNameServices(name);
        List<Product> products = new ArrayList<>();
        List<Hit<Product>> listOfHits = searchResponse.hits().hits();
        for (Hit<Product> hit : listOfHits) {
            products.add(hit.source());
        }
        return products;
    }
}
