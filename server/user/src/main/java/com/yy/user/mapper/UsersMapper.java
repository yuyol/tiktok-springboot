package com.yy.user.mapper;

import com.yy.user.dto.UsersDto;
import com.yy.user.entity.Users;

public class UsersMapper {

    public static Users UsersDtoToUsers(UsersDto usersDto, Users users) {
        users.setUserId(usersDto.getUserId());
        users.setUsername(usersDto.getUsername());
        users.setEmail(usersDto.getEmail());
        users.setPassword(usersDto.getPassword());
        users.setProfilePictureUrl(usersDto.getProfilePictureUrl());
        users.setText(usersDto.getText());
        return users;
    }
}
