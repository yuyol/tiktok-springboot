package com.yy.shopping.controller;

import com.yy.shopping.constants.ShoppingConstants;
import com.yy.shopping.dto.ResponseDto;
import com.yy.shopping.dto.UploadInfoDto;
import com.yy.shopping.service.ShoppingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

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

    @PostMapping("/uploadProduct")
    public ResponseEntity<ResponseDto> uploadProduct(
            @RequestParam("files") MultipartFile[] files,
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("category") List<String> categories,
            @RequestParam("user_id") int userId,
            @RequestParam("price") float price
            ) throws IOException {

        UploadInfoDto uploadInfoDto = new UploadInfoDto(files,title,description,categories,price,userId);

        shoppingService.uploadProduct(uploadInfoDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto(ShoppingConstants.STATUS_201,ShoppingConstants.MESSAGE_201));
    }
}
