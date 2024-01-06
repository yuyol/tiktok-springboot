package com.yy.shopping.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.File;

@Data
public class UploadInfoDto {
    private String name;
    private int percentage;
    private long size;
    private String status;
    private long uid;
    private String url;
    private Object raw;
}
