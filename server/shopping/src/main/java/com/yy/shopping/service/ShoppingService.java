package com.yy.shopping.service;

import com.yy.shopping.dto.MerchandizeListDto;
import com.yy.shopping.dto.ProductDto;
import com.yy.shopping.dto.UploadInfoDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ShoppingService {
    void uploadProduct(UploadInfoDto uploadInfoDto);

    List<MerchandizeListDto> getProductListBySeller(long userId);

    ProductDto getProductDetails(long userId, long productInfoId, String productName);
}
