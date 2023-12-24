package com.yy.video.service.Impl;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.BasicSessionCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.http.HttpProtocol;
import com.qcloud.cos.model.Bucket;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import com.yy.video.dto.VideosDto;
import com.yy.video.service.VideosService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class VideosServiceImpl implements VideosService {
    @Override
    public VideosDto uploadVideo(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + fileName;
        System.out.println("文件名："+fileName);
        // 转换MultipartFile到File
        File convFile = convert(file);

        // 初始化COS客户端
        COSClient cosClient = getCOSClient();

        // 上传对象到指定存储桶
        String bucketName = "yybucket1-1317394054";
        String key = "videos/" + fileName;
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, convFile);
        PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);

        // 初始化VideosDto
        VideosDto videosDto = new VideosDto();
        // 获取对象URL
        String url = String.valueOf(cosClient.getObjectUrl(bucketName,key));
        videosDto.setUrl(url);
        videosDto.setSuccess(true);

        // 存储信息到数据库
        return videosDto;
    }

    /**
     * 初始化COS客户端
     * @return
     */
    public COSClient getCOSClient() {
        // 1 初始化用户身份信息（secretId, secretKey）。
        // SECRETID 和 SECRETKEY 请登录访问管理控制台 https://console.cloud.tencent.com/cam/capi 进行查看和管理
        String secretId = System.getenv("SecretId");//用户的 SecretId，建议使用子账号密钥，授权遵循最小权限指引，降低使用风险。子账号密钥获取可参见 https://cloud.tencent.com/document/product/598/37140
        String secretKey = System.getenv("SecretKey");//用户的 SecretKey，建议使用子账号密钥，授权遵循最小权限指引，降低使用风险。子账号密钥获取可参见 https://cloud.tencent.com/document/product/598/37140
        String CLASSPATH = System.getenv("CLASSPATH");
        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
        // 2 设置 bucket 的地域, COS 地域的简称请参见 https://cloud.tencent.com/document/product/436/6224
        // clientConfig 中包含了设置 region, https(默认 http), 超时, 代理等 set 方法, 使用可参见源码或者常见问题 Java SDK 部分。
        Region region = new Region("na-siliconvalley");
        ClientConfig clientConfig = new ClientConfig(region);
        // 这里建议设置使用 https 协议
        // 从 5.6.54 版本开始，默认使用了 https
        clientConfig.setHttpProtocol(HttpProtocol.https);
        // 3 生成 cos 客户端。
        COSClient cosClient = new COSClient(cred, clientConfig);
        return cosClient;
    }

    /**
     * 将MultipartFile转换为File
     * @param file
     * @return
     * @throws IOException
     */
    public File convert(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }

}
