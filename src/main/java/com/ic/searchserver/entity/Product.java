package com.ic.searchserver.entity;

import org.springframework.data.elasticsearch.annotations.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(indexName = "products")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {
    
    private String id;
    private String name;
    private String description;
    private long price;
    private int sellNumber;
    private int soldNumber;
    private String type;
    private String imageUrl;
    private long createdTime;
    private long updatedTime;
    private String parentId;
    private long likes;
}
