package com.yy.shopping.dto;

import lombok.Data;

import java.util.List;

@Data
public class MerchandizeListDto {
    private int id;
    private List<ProductDto> childrens;
}
