package com.yy.shopping.repository;

import com.yy.shopping.entity.ProductInfoType;
import com.yy.shopping.entity.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProductInfoTypeRepository extends JpaRepository<ProductInfoType, Long> {

    @Query(nativeQuery = true, value = "select pit.* from Product_Info_Type pit where pit.product_name_id = :nameId and pit.user_id = :userId and pit.type_id = :typeId")
    Optional<ProductInfoType> findByNameIdAndUserIdAndTypeId(@Param("nameId") long nameId, @Param("userId") long userId, @Param("typeId") long typeId);
}
