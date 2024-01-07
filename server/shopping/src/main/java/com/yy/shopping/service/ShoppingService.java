package com.yy.shopping.service;

import com.yy.shopping.dto.UploadInfoDto;
import org.springframework.stereotype.Service;


public interface ShoppingService {
    void uploadProduct(UploadInfoDto uploadInfoDto);
}
