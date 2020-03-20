package com.luis.test.service;

import com.luis.test.domain.Account;

import java.util.Optional;

public interface AccountService {
    Optional<Account> check(Integer id);
    Account create(Account account);
    void delete(Integer id);
}
