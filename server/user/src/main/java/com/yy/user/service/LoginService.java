package com.yy.user.service;

import com.yy.user.dto.LoginDto;
import com.yy.user.dto.UsersDto;

public interface LoginService {
    UsersDto login(LoginDto loginDto);
}
