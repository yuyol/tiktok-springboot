package com.yy.shopping.dto;

import lombok.Data;

@Data
public class ProductDto {
    private long id;
    private String name;
    private String description;
    private long price;
    private long categoryId;
}
