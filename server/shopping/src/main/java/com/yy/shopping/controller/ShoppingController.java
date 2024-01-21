package com.yy.shopping.controller;

import com.yy.shopping.constants.ShoppingConstants;
import com.yy.shopping.dto.MerchandizeListDto;
import com.yy.shopping.dto.ProductDto;
import com.yy.shopping.dto.ResponseDto;
import com.yy.shopping.dto.UploadInfoDto;
import com.yy.shopping.entity.ProductName;
import com.yy.shopping.entity.Type;
import com.yy.shopping.repository.ProductNameRepository;
import com.yy.shopping.repository.TypeRepository;
import com.yy.shopping.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class ShoppingController {

    ShoppingService shoppingService;

    public ShoppingController(ShoppingService shoppingService) {
        this.shoppingService = shoppingService;
    }

//    @PostMapping("/uploadProduct")
//    public ResponseEntity<ResponseDto> uploadProduct(
//            @RequestBody UploadDto files
//            ) throws IOException {
//        for (UploadInfoDto uploadInfo : files.getUploadInfos()) {
//            URL url = new URL(uploadInfo.getUrl());
//            BufferedImage img = ImageIO.read(url);
//            File f = new File(uploadInfo.getName());
//            System.out.println(f);
//        }
//
//
//        return ResponseEntity.status(HttpStatus.CREATED)
//                .body(new ResponseDto(ShoppingConstants.STATUS_201,ShoppingConstants.MESSAGE_201));
//    }

    @Autowired
    ProductNameRepository productNameRepository;
    @Autowired
    TypeRepository typeRepository;
    @PostMapping("/uploadProduct")
    public ResponseEntity<ResponseDto> uploadProduct(
            @RequestParam("files") MultipartFile[] files,
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("category") List<String> categories,
            @RequestParam("user_id") int userId,
            @RequestParam("price") float price,
            @RequestParam("type") String type
            ) throws IOException {

        UploadInfoDto uploadInfoDto = new UploadInfoDto(files,title,description,categories,price,userId,type);

        shoppingService.uploadProduct(uploadInfoDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto(ShoppingConstants.STATUS_201,ShoppingConstants.MESSAGE_201));
    }

    @GetMapping("/getProductListBySeller")
    public ResponseEntity<List<MerchandizeListDto>> getProductListBySeller(
            @RequestParam long userId
    ) {
        List<MerchandizeListDto> merchandizeListDto = shoppingService.getProductListBySeller(userId);

        return ResponseEntity.status(HttpStatus.OK)
                .body(merchandizeListDto);
    }

    @GetMapping("/getProductDetails")
    public ResponseEntity<ProductDto> getProductDetails(@RequestParam("userId") long userId,
                                                        @RequestParam("productInfoId") long productInfoId,
                                                        @RequestParam("productName") String productName) {

        ProductDto productDto = shoppingService.getProductDetails(userId,productInfoId,productName);

        return ResponseEntity.status(HttpStatus.OK)
                .body(productDto);
    }
}
