package com.yy.shopping.service.Impl;

import com.yy.shopping.dto.UploadInfoDto;
import com.yy.shopping.entity.Product;
import com.yy.shopping.repository.ProductRepository;
import com.yy.shopping.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingServiceImpl implements ShoppingService {

    @Autowired
    ProductRepository productRepository;
    @Override
    public void uploadProduct(UploadInfoDto uploadInfoDto) {
        // 保存物品信息至 Product
        saveProduct(uploadInfoDto);
        // 绑定物品与分类关系至 Product Category
        // 保存卖家至 Seller
    }

    public void saveProduct(UploadInfoDto uploadInfoDto) {
        Product product = new Product();
        product.setName(uploadInfoDto.getTitle());
        product.setDescription(uploadInfoDto.getDescription());
        product.setPrice(uploadInfoDto.getPrice());
        productRepository.save(product);
    }
}
