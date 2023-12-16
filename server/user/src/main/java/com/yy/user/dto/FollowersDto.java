package com.yy.user.dto;

import com.yy.user.entity.Users;
import lombok.Data;

import java.util.List;

@Data
public class FollowersDto {
//    private int followerId;
//    private int userId;
//    private int followerUserId;
    private int followerAmount;
    private int followAmount;
    private List<Users> follows;
    private List<Users> followers;

}
