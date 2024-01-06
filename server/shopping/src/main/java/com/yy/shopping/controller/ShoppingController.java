package com.yy.shopping.controller;

import com.yy.shopping.constants.ShoppingConstants;
import com.yy.shopping.dto.ResponseDto;
import com.yy.shopping.dto.UploadDto;
import com.yy.shopping.dto.UploadInfoDto;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@RestController
@CrossOrigin
public class ShoppingController {

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
            @RequestParam("title") String title
            ) throws IOException {

        System.out.println(files.length);
        for (MultipartFile file :
                files) {
            System.out.println(file.getOriginalFilename());
        }
        System.out.println(title);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto(ShoppingConstants.STATUS_201,ShoppingConstants.MESSAGE_201));
    }
}
