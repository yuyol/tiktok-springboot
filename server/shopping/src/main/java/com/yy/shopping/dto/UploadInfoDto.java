package com.yy.shopping.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UploadInfoDto {
    private MultipartFile[] files;
    private String title;
    private String description;
    private List<String> categories;
    private float price;
    private int userId;
    private String type;
}
