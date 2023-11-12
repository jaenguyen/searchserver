package com.ic.searchserver.service;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ic.searchserver.entity.Product;
import com.ic.searchserver.util.SearchUtil;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch.core.SearchResponse;

@Service
public class SearchService {

    @Autowired
    private ElasticsearchClient elasticsearchClient;

    public SearchResponse<Product> matchAllProductWithNameServices(String name) throws Exception{
        Supplier<Query> supplier = SearchUtil.supplierByName(name);
        SearchResponse<Product> searchResponse = elasticsearchClient.search(s->s.index("products").query(supplier.get()), Product.class);
        return searchResponse;
    }
}
