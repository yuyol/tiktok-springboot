package com.yy.shopping.repository;

import com.yy.shopping.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {



    @Query(nativeQuery = true, value = "select * from Seller AS s where s.product_name_id = :nameId and s.user_id = :userId limit 1")
    Optional<Seller> findInfoIdNyNameAndUserId(@Param("nameId") long nameId, @Param("userId") long userId);

    @Query(nativeQuery = true, value = "select distinct s.product_name_id from Seller AS s where s.user_id = :userId")
    List<Long> findProductNameListBySeller(@Param("userId") long userId);

    @Query(nativeQuery = true, value = "select s.product_info_id from Seller AS s where s.product_name_id = :productNameId limit 0,1")
    Optional<Long> findInfoIdByProductNameId(@Param("productNameId") long productNameId);
}
