package com.yy.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class WrongPasswordException extends RuntimeException{

    public WrongPasswordException() {
        super(String.format("账号或密码错误"));
    }
}
