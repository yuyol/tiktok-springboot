package com.yy.video.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Videos extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    private long videoId;
    private String yv;
    private long userId;
    private String title;
    private String description;
    private String url;
    private long classificationId;
    private Date uploadDate;
    private int duration;
    private String videoCoverUrl;
    private int auditResult;
    private String auditLabel;
    private String auditState;
    private int likesCount;
    private int commentsCount;
    private int viewsCount;
    private int sharesCount;
    private int favoritesCount;
    private int open;
}
