package com.yy.user.dto;

import lombok.Data;

@Data
public class UsersDto {
    private int userId;
    private String username;
    private String email;
    private String mobileNumber;
    private String password;
    private String profilePictureUrl;
    private String text;
    private FollowersDto followersDto;
}
