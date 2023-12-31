package com.yy.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    private Long userId;
    private String uniqueId;
    @NotEmpty(message = "用户名不能为空")
    private String username;
    @Email(message = "请输入正确邮箱地址")
    private String email;
    @Pattern(regexp = "(^$|[0-9]{11})", message = "请输入正确手机号")
    @NotEmpty(message = "手机号不能为空")
    private String mobileNumber;
    @Size(min = 8,message = "请输入至少八位密码")
    @NotEmpty(message = "密码不能为空")
    private String password;
    private String profilePictureUrl;
    private String text;
    private Date joinDate;
    private Date lastLogin;
}
