package com.yy.shopping.repository;

import com.yy.shopping.entity.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {

    @Query(nativeQuery = true, value = "select pt.* from Product_Type pt where pt.product_name_id = :nameId and pt.user_id = :userId and pt.type_id = :typeId")
    Optional<ProductType> findByNameIdAndUserIdAndTypeId(@Param("nameId") long nameId, @Param("userId") long userId, @Param("typeId") long typeId);

    @Query(nativeQuery = true, value = "select pt.type_id from Product_Type pt where pt.product_name_id = :productNameId and pt.user_id = :userId")
    List<Long> findAllTypeIdBySellerAndProductName(@Param("userId") long userId, @Param("productNameId") long productNameId);
}
