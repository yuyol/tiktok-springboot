package com.yy.shopping.repository;

import com.yy.shopping.entity.ProductName;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductNameRepository extends JpaRepository<ProductName, Long> {

    @Query(nativeQuery = true, value = "SELECT pn.* from Product_Name pn where pn.name = :name")
    Optional<ProductName> findByName(@Param("name") String name);

    @Query(nativeQuery = true, value = "SELECT pn.* from Product_Name pn where pn.id = :id")
    Optional<ProductName> findById(@Param("id") long id);
}
