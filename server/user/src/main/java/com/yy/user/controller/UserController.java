package com.yy.user.controller;

import com.yy.user.dto.UsersDto;
import com.yy.user.service.UsersService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UsersService usersService;

    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping("/createUser")
    public String createUser(@RequestBody UsersDto usersDto) {

        usersService.createUser(usersDto);

        return "Hello World";
    }

}
