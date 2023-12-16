package com.yy.user.service.Impl;

import com.yy.user.entity.Followers;
import com.yy.user.exception.AlreadyFollowedException;
import com.yy.user.repository.FollowersRepository;
import com.yy.user.repository.UsersRepository;
import com.yy.user.service.FollowersService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FollowersServiceImpl implements FollowersService {

    @Autowired
    FollowersRepository followersRepository;

    @Autowired
    UsersRepository usersRepository;

    /**
     * 计算有多少粉丝数
     * @param userId
     * @return
     */
    @Override
    public int followersCount(int userId) {
        int count = followersRepository.followersCount(userId);
        return count;
    }

    /**
     * 通过uniqueId 获取user id
     * @param uniqueId
     * @return
     */
    @Override
    public int getUserId(String uniqueId) {
        return usersRepository.searchUserIdByUniqueId(uniqueId);
    }

    /**
     * 执行关注操作
     * @param followerUserUniqueId
     * @param followUserUniqueId
     */
    @Override
    public void follow(String followerUserUniqueId, String followUserUniqueId) {
        int followerUserId = usersRepository.searchUserIdByUniqueId(followerUserUniqueId);
        int userId = usersRepository.searchUserIdByUniqueId(followUserUniqueId);
        if(followersRepository.findIfRepeat(userId,followerUserId) != 0) {
            throw new AlreadyFollowedException(userId,followerUserId);
        }
        Followers follower = new Followers();
        follower.setUserId(userId);
        follower.setFollowerUserId(followerUserId);
        followersRepository.save(follower);
    }


}
