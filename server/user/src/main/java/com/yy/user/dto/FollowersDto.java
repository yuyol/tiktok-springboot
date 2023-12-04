package com.yy.user.dto;

import lombok.Data;

@Data
public class FollowersDto {
    private int followerId;
    private int userId;
    private int followerUserId;
}
