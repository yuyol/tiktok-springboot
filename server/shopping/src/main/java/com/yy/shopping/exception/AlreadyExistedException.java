package com.yy.shopping.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AlreadyExistedException extends RuntimeException{
    public AlreadyExistedException(String resource) {
        super(String.format("当前已经存在%s",resource));
    }
}
