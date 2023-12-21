package com.yy.video.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FileAlreadyExistedException extends RuntimeException{
    public FileAlreadyExistedException(String fileName) {
        super(String.format("%s is already existed",fileName));
    }
}
