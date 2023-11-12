package com.ic.searchserver.repository;

import org.springframework.stereotype.Repository;

import com.ic.searchserver.entity.Product;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

@Repository
public interface ProductRepository extends ElasticsearchRepository<Product, String> {

}