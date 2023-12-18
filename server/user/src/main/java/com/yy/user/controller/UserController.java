package com.yy.user.controller;

import com.yy.user.constants.UsersConstants;
import com.yy.user.dto.FollowersDto;
import com.yy.user.dto.ResponseDto;
import com.yy.user.dto.UsersDto;
import com.yy.user.service.FollowersService;
import com.yy.user.service.UsersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
public class UserController {

    private final UsersService usersService;

    private final FollowersService followersService;


    public UserController(UsersService usersService,FollowersService followersService) {
        this.usersService = usersService;
        this.followersService = followersService;
    }



    /**
     * CreateUser
     * @param usersDto
     */
    @Validated
    @PostMapping("/createUser")
    public ResponseEntity<ResponseDto> createUser(@RequestBody @Valid UsersDto usersDto) {

        usersService.createUser(usersDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(UsersConstants.STATUS_201, UsersConstants.MESSAGE_201));
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
     * 使用uniqueId获取用户
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

    /**
     * 使用手机号删除用户
     * @param mobileNumber
     * @return
     */
    @DeleteMapping("/deleteUserByMobileNumber")
    public ResponseEntity<ResponseDto> deleteUserByMobileNumber(@RequestParam String mobileNumber) {
        usersService.deleteUserByMobileNumber(mobileNumber);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(UsersConstants.STATUS_200,UsersConstants.MESSAGE_200));
    }

    /**
     * 获取用户粉丝数
     * @param userId
     * @return
     */
    @GetMapping("/getFollowersAmount")
    public int getFollows(@RequestParam int userId) {
        int count = followersService.followersCount(userId);
        return count;
    }

    /**
     * 获取FollowerDto
     * @param userId
     * @return
     */
    @GetMapping("/getFollowersDto")
    public ResponseEntity<FollowersDto> getFollowers(@RequestParam int userId) {
        FollowersDto followersDto = usersService.getFollowers(userId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(followersDto);
    }
}
