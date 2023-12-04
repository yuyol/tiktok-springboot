package com.yy.user.entity;

import jakarta.persistence.Entity;
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
    private int followerId;
    private int userId;
    private int followerUserId;
}
