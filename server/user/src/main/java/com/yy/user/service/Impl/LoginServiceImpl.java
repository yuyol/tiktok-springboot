package com.yy.user.service.Impl;

import com.yy.user.dto.LoginDto;
import com.yy.user.dto.UsersDto;
import com.yy.user.exception.WrongPasswordException;
import com.yy.user.service.LoginService;
import com.yy.user.service.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final UsersService usersService;

    @Override
    public UsersDto login(LoginDto loginDto) {
        UsersDto userByMobileNumber = usersService.getUserByMobileNumber(loginDto.getMobileNumber());
        // 验证密码是否正确
        if(!loginDto.getPassword().equals(userByMobileNumber.getPassword())) {
            throw new WrongPasswordException();
        }
        return userByMobileNumber;
    }

}
