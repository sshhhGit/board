package com.example.board.service;

import com.example.board.domain.entity.Account;
import com.example.board.domain.repository.AccountRepository;
import com.example.board.dto.AccountForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    @Transactional
    public Long createUser(AccountForm form) {
        Account account = form.toEntity();
        accountRepository.save(account);
        return account.getAccountId();
    }
}
