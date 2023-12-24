package com.yy.video.controller;

import com.yy.video.dto.VideosDto;
import com.yy.video.entity.Videos;
import com.yy.video.exception.FileAlreadyExistedException;
import com.yy.video.service.VideosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@CrossOrigin
public class VideoController {

    // 设置保存视频文件的目录
    private static final String VIDEO_UPLOAD_DIR = "D:/upload";

    private final VideosService videosService;

    public VideoController(VideosService videosService) {
        this.videosService = videosService;
    }
    @PostMapping("/upload")
    public ResponseEntity<VideosDto> uploadVideo(@RequestParam("file") MultipartFile file) {

        /*
        try {
            // 获取上传的文件名
            String fileName = file.getOriginalFilename();
            fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + fileName;
            System.out.println("文件名："+fileName);

            // 创建保存视频文件的目录
            File uploadDir = new File(VIDEO_UPLOAD_DIR);
//            if (!uploadDir.exists()) {
//                uploadDir.mkdirs();
//            }

            // 创建保存视频文件的路径
            String filePath = VIDEO_UPLOAD_DIR + File.separator + fileName;
            File dest = new File(filePath);
            if(dest.exists()) throw new FileAlreadyExistedException(filePath);

            if(!dest.getParentFile().exists()) {
                dest.getParentFile().mkdir();
            }

            // 保存视频文件
            file.transferTo(dest);

            // 返回上传成功信息
//            return "上传成功";
            VideosDto videosDto = new VideosDto();
            videosDto.setSuccess(true);
            videosDto.setUrl("file:///D:/upload/20231220165147_Roblox%20VR%202023.03.18%20-%2009.54.24.01.mp4");
            return ResponseEntity.status(HttpStatus.OK)
                    .body(videosDto);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new VideosDto());
        }*/

        VideosDto videosDto = null;
        try {
            videosDto = videosService.uploadVideo(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(videosDto);
    }
}
