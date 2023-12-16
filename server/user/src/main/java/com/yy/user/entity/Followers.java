package com.yy.user.entity;

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
public class Followers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    private int followerId;
    private int userId;
    private int followerUserId;
}
