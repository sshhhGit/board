package com.example.board.dto;

import com.example.board.domain.entity.Account;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Data
@NoArgsConstructor
public class AccountForm {

    private Long accountId;
    private String username;
    private String password;
    private String email;

    @Builder
    public AccountForm(Long accountId, String username, String password, String email) {
        this.accountId = accountId;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Account toEntity(){
        return Account.builder()
                .accountId(accountId)
                .username(username)
                .password(new BCryptPasswordEncoder().encode(password))
                .email(email)
                .build();
    }
}
