package com.yy.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Users {
    @Id
    private int userId;
    private String username;
    private String email;
    private String mobileNumber;
    private String password;
    private String profilePictureUrl;
    private String text;
    private Date joinDate;
    private Date lastLogin;
}
