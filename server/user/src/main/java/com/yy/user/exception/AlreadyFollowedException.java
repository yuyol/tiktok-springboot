package com.yy.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AlreadyFollowedException extends RuntimeException{
    public AlreadyFollowedException(long userId, long followerUserId) {
        super(String.format("%s is already followed by %s",userId,followerUserId));
    }
}
