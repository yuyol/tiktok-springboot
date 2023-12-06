package com.yy.user.service;

import com.yy.user.dto.UsersDto;

public interface UsersService {


    void createUser(UsersDto usersDto);

    UsersDto getUserById(long userId);

    UsersDto getUserByMobileNumber(String mobileNumber);

    UsersDto getUserByUniqueId(String uniqueId);
}
