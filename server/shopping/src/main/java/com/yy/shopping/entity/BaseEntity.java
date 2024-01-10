package com.yy.shopping.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Date;

@MappedSuperclass
// Auditing
@EntityListeners(AuditingEntityListener.class)
// LomBok create getter setter automatically
@Getter
@Setter
@ToString
public class BaseEntity {
    @CreatedDate
    // Do not update
    @Column(updatable = false)
    private LocalDateTime gmtCreated;
    @LastModifiedDate
    // Do not insert
    @Column(insertable = false)
    private LocalDateTime gmtUpdated;
}
