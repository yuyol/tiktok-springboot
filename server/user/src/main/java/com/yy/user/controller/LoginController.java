package com.yy.user.controller;

import com.yy.user.constants.UsersConstants;
import com.yy.user.dto.LoginDto;
import com.yy.user.dto.ResponseDto;
import com.yy.user.dto.UsersDto;
import com.yy.user.service.FollowersService;
import com.yy.user.service.LoginService;
import com.yy.user.service.UsersService;
import jakarta.validation.Constraint;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.scanner.Constant;

@RestController
@CrossOrigin
public class LoginController {

    private final UsersService usersService;
    private final LoginService loginService;

    public LoginController(UsersService usersService, LoginService loginService) {
        this.usersService = usersService;
        this.loginService = loginService;
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseDto> register(@RequestBody @Valid UsersDto usersDto) {

        usersService.createUser(usersDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto(UsersConstants.STATUS_201,UsersConstants.MESSAGE_201));
    }

    @PostMapping("/login")
    public ResponseEntity<UsersDto> login(@RequestBody LoginDto loginDto) {

        UsersDto usersDto = loginService.login(loginDto);
//        System.out.println("test");

        return ResponseEntity.status(HttpStatus.OK)
                .body(usersDto);
    }
}
