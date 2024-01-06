package com.yy.shopping.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Data
public class UploadDto {
    private List<UploadInfoDto> uploadInfos;
    private MultipartFile[] files;
}
