package com.yy.user.controller;

import com.yy.user.dto.UsersDto;
import com.yy.user.service.UsersService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {

    private final UsersService usersService;

    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }

    /**
     * CreateUser
     * @param usersDto
     */
    @Validated
    @PostMapping("/createUser")
    public void createUser(@RequestBody @Valid UsersDto usersDto) {

        usersService.createUser(usersDto);
    }

    /**
     * Get user detail by user id
     * @param userId
     * @return
     */
    @GetMapping("/getUserById")
    public ResponseEntity<UsersDto> getUserById(@RequestParam long userId) {

        UsersDto usersDto = usersService.getUserById(userId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(usersDto);
    }

    /**
     * Get user detail by mobile number
     * @param mobileNumber
     * @return
     */
    @GetMapping("/getUserByMobileNumber")
    public ResponseEntity<UsersDto> getUserByMobileNumber(@RequestParam String mobileNumber) {

        UsersDto usersDto = usersService.getUserByMobileNumber(mobileNumber);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(usersDto);
    }

    /**
     * Get user detail by unique id
     * @param uniqueId
     * @return
     */
    @GetMapping("/getUserByUniqueId")
    public ResponseEntity<UsersDto> getUserByUniqueId(@RequestParam String uniqueId) {

        UsersDto usersDto = usersService.getUserByUniqueId(uniqueId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(usersDto);
    }
}
