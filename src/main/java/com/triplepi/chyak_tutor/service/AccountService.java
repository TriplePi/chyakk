package com.triplepi.chyak_tutor.service;

import com.triplepi.chyak_tutor.domain.Account;
import com.triplepi.chyak_tutor.mapper.AccountMapper;
import com.triplepi.chyak_tutor.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class AccountService {

    private AccountRepository accountRepository;
    private AccountMapper accountMapper;

    public AccountService(AccountRepository accountRepository, AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
        Account account = new Account();
        this.accountRepository = accountRepository;
    }

    public List<Account> saveAccounts(Collection<Account> accounts) {
        return accountRepository.saveAll(accounts);
    }
}
