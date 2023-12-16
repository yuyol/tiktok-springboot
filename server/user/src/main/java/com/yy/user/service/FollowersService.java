package com.yy.user.service;

import com.yy.user.dto.FollowersDto;
import org.springframework.stereotype.Service;

@Service
public interface FollowersService {
    int followersCount(int userId);

    void follow(String followerUserUniqueId, String followUserUniqueId);

    int getUserId(String uniqueId);

}
