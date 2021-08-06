package com.example.board.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
// 다른 패키지에서 생성자 함부로 생성하지 마세요!
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Account {

    @Id @Column(name = "user_id")
    // SQL 에서 자동생성되도록 돕는 어노테이션
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    private String username;
    private String password;
    private String email;

    @Builder
    public Account(Long accountId, String username, String password, String email) {
        this.accountId = accountId;
        this.username = username;
        this.password = password;
        this.email = email;
    }
}