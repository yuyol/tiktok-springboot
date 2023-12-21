package com.yy.user.repository;

import com.yy.user.entity.Followers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FollowersRepository extends JpaRepository<Followers, Long> {

    /**
     * 查询相关用户的粉丝数
     * @param userId
     * @return
     */
    @Query(nativeQuery = true,value = "select count(*) from Followers where FOLLOWER_USER_ID = :userId")
    int followersCount(@Param("userId") Long userId);

    @Query(nativeQuery = true,value = "select count(*) from Followers where USER_ID = :userId")
    int followsCount(@Param("userId") Long userId);

    @Query(nativeQuery = true, value = "select count(*) from Followers AS f where f.user_id = :userId and f.follower_user_id = :followerUserId")
    int findIfRepeat(@Param("userId") Long userId, @Param("followerUserId") Long followerUserId);

}
