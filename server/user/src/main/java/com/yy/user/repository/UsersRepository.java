package com.yy.user.repository;

import com.yy.user.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByUserId(long userId);

    Optional<Users> findByMobileNumber(String mobileNumber);

    Optional<Users> findByUniqueId(String uniqueId);
}
