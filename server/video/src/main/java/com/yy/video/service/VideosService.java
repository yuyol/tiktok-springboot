package com.yy.video.service;

import com.yy.video.dto.VideosDto;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface VideosService {
    VideosDto uploadVideo(MultipartFile file) throws IOException;
}
