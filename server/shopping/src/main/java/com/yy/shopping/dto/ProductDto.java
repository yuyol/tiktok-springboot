package com.yy.shopping.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProductDto {
    private long id;
    private String name;
    private String description;
    private long productNameId;
    private long userId;
    private long typeId;
    private float price;
    private List<CategoryDto> category;
    // 当前商品的所有type
    private List<ProductDto> productType;
}
