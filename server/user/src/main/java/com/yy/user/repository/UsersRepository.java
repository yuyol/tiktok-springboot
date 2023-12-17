package com.yy.user.repository;

import com.yy.user.entity.Users;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByUserId(long userId);

    Optional<Users> findByMobileNumber(String mobileNumber);

    Optional<Users> findByUniqueId(String uniqueId);

    @Transactional
    void deleteByMobileNumber(String mobileNumber);

    @Query(nativeQuery = true, value = "SELECT u.user_id FROM Users AS u WHERE u.unique_id LIKE :uniqueId")
    int searchUserIdByUniqueId(@Param("uniqueId")String unique_id);

    /**
     * 搜索user id的所有粉丝
     */
    @Query(nativeQuery = true, value = "SELECT u.* FROM Users AS u, Followers AS f WHERE f.user_id = :userId AND u.user_id = f.follower_user_id")
    Optional<List<Users>> searchFollowersByUserId(@Param("userId") int userId);

    @Query(nativeQuery = true, value = "SELECT u.* FROM Users AS u, Followers AS f WHERE f.follower_user_id = :userId AND u.user_id = f.user_id")
    Optional<List<Users>> searchFollowsByUserId(@Param("userId") int userId);
}
