package com.yy.shopping.mapper;

import com.yy.shopping.dto.ProductDto;
import com.yy.shopping.entity.ProductInfo;

public class ProductMapper {

    public static ProductDto productInfoToProductDto(ProductInfo productInfo, ProductDto productDto, String productName) {
        productDto.setId(productInfo.getId());
        productDto.setProductNameId(productInfo.getProductNameId());
        productDto.setName(productName);
        productDto.setDescription(productInfo.getDescription());
        productDto.setUserId(productInfo.getUserId());
        productDto.setTypeId(productInfo.getTypeId());
        productDto.setPrice(productInfo.getPrice());
        return productDto;
    }

}
