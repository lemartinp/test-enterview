package com.luis.test.service;

import com.luis.test.domain.Account;
import com.luis.test.repository.AccountRepository;
import com.luis.test.repository.AccountRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Optional<Account> check(Integer id) {
        return this.accountRepository.findById(id);
    }

    @Override
    public Account create(Account account) {
        return this.accountRepository.save(account);
    }

    @Override
    public void delete(Integer id) {
        this.accountRepository.deleteById(id);
    }


}
