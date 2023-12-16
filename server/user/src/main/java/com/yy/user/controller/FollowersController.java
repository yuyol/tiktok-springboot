package com.yy.user.controller;

import com.yy.user.constants.FollowersConstants;
import com.yy.user.dto.ResponseDto;
import com.yy.user.service.FollowersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class FollowersController {

    FollowersService followersService;

    public FollowersController(FollowersService followersService) {
        this.followersService = followersService;
    }

    /**
     * Follow operation
     * @param followerUserUniqueId
     * @param followUserUniqueId
     * @return
     */
    @PostMapping("/follow")
    public ResponseEntity<ResponseDto> follow(@RequestParam String followerUserUniqueId,
                                              @RequestParam String followUserUniqueId) {
        followersService.follow(followerUserUniqueId, followUserUniqueId);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(FollowersConstants.STATUS_201,FollowersConstants.MESSAGE_201));
    }

    @GetMapping("/getUserId")
    public int getUserId(@RequestParam String uniqueId) {
        return followersService.getUserId(uniqueId);
    }
}
