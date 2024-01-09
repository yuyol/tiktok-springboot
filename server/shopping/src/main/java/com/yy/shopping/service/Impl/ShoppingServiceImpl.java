package com.yy.shopping.service.Impl;

import com.yy.shopping.dto.UploadInfoDto;
import com.yy.shopping.entity.Product;
import com.yy.shopping.entity.ProductName;
import com.yy.shopping.repository.ProductNameRepository;
import com.yy.shopping.repository.ProductRepository;
import com.yy.shopping.service.ShoppingService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ShoppingServiceImpl implements ShoppingService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductNameRepository productNameRepository;
    @Override
    public void uploadProduct(UploadInfoDto uploadInfoDto) {
        // 1. 利用product name和user id在product name中查找product name id
        String name = uploadInfoDto.getTitle();
        Optional<ProductName> byName = productNameRepository.findByName(name);

        if(byName.isPresent()) {
            // 1.1 查到了id 继续查询是否有seller关系
            long id = byName.get().getId();
            System.out.println(id);

        }
    }

    public void saveProduct(UploadInfoDto uploadInfoDto) {

    }
}
