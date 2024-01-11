package com.yy.shopping.repository;

import com.yy.shopping.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductInfoRepository extends JpaRepository<ProductInfo, Long> {
    @Query(nativeQuery = true, value = "select pi.* from Product_Info as pi where pi.user_id = :userId AND pi.product_name_id = :productNameId AND pi.type_id = :typeId")
    Optional<ProductInfo> findByUserIdAndProductNameIdAndTypeId(@Param("userId") long userId, @Param("productNameId") long productNameId, @Param("typeId") long typeId);
}
