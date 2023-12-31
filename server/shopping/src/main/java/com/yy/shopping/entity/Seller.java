package com.yy.shopping.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Seller extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    private long id;
    private long productNameId;
    private long productInfoId;
    private long userId;
}
