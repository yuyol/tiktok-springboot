package com.yy.video.dto;

import com.yy.video.entity.Videos;
import lombok.Data;


@Data
public class VideosDto extends Videos {
    // 浏览量
    private Long PV;

    // 点赞量
    private Long stars;

    // 分享量
    private Long shares;

    // 回调函数成功
    private Boolean success;
}
