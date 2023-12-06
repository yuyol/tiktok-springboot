package com.yy.user.mapper;

import com.yy.user.dto.UsersDto;
import com.yy.user.entity.Users;

public class UsersMapper {

    public static Users UsersDtoToUsers(UsersDto usersDto, Users users) {
        users.setUserId(usersDto.getUserId());
        users.setUsername(usersDto.getUsername());
        users.setEmail(usersDto.getEmail());
        users.setMobileNumber(usersDto.getMobileNumber());
        users.setPassword(usersDto.getPassword());
        users.setProfilePictureUrl(usersDto.getProfilePictureUrl());
        users.setText(usersDto.getText());
        return users;
    }

    public static UsersDto UsersToUsersDto(Users users, UsersDto usersDto) {
        usersDto.setUserId(users.getUserId());
        usersDto.setUsername(users.getUsername());
        usersDto.setEmail(users.getEmail());
        usersDto.setMobileNumber(users.getMobileNumber());
        usersDto.setPassword(users.getPassword());
        usersDto.setProfilePictureUrl(users.getProfilePictureUrl());
        usersDto.setText(users.getText());
        return usersDto;
    }
}
