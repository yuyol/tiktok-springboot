package com.yy.shopping.repository;

import com.yy.shopping.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {



    @Query(nativeQuery = true, value = "select * from Seller AS s where s.product_name_id = :nameId and s.user_id = :userId")
    Optional<Seller> findInfoIdNyNameAndUserId(@Param("nameId") long nameId, @Param("userId") long userId);
}
