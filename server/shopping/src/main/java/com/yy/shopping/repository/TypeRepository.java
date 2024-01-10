package com.yy.shopping.repository;

import com.yy.shopping.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TypeRepository extends JpaRepository<Type, Long> {

    @Query(nativeQuery = true, value = "select t.* from Type t where t.name = :name")
    Optional<Type> findByName(@Param("name") String name);
}
