package com.triplepi.chyak_tutor.service;

import com.triplepi.chyak_tutor.domain.Account;
import com.triplepi.chyak_tutor.domain.Currency;
import com.triplepi.chyak_tutor.dto.AccountDTO;
import com.triplepi.chyak_tutor.mapper.AccountMapper;
import com.triplepi.chyak_tutor.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {

    private AccountRepository accountRepository;
    private AccountMapper accountMapper;

    private static final Logger logger = LoggerFactory.getLogger(BankService.class);

    public AccountService(AccountRepository accountRepository, AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
        this.accountRepository = accountRepository;
    }

    public List<AccountDTO> saveAccounts(Collection<AccountDTO> accounts) {
        return accountRepository
                .saveAll(accounts.stream().map(accountMapper::toEntity).collect(Collectors.toList()))
                .stream().map(accountMapper::toDTO).collect(Collectors.toList());
    }

    public AccountDTO getAccount(Long id) {
        return accountMapper.toDTO(accountRepository.getOne(id));
    }

    public List<AccountDTO> getAllAccounts() {
        return accountRepository.findAll().stream().map(accountMapper::toDTO).collect(Collectors.toList());
    }

    public AccountDTO deposit(Long accountId, Double sum, Currency currency) {
        Account account = accountRepository.getOne(accountId);
        if (account.getCurrency() != currency)
            throw new IllegalArgumentException("Invalid currency");
        account.setBalance(account.getBalance() + sum);
        logger.info(String.format("Deposit to account %s for %s %s has been proceed", account.getId(), sum, currency));
        return accountMapper.toDTO(accountRepository.save(account));
    }

    public AccountDTO withdraw(Long accountId, Double sum, Currency currency) {
        Account account = accountRepository.getOne(accountId);
        if (account.getBalance() < sum || account.getCurrency() != currency)
            throw new IllegalArgumentException("Invalid currency");
        account.setBalance(account.getBalance() - sum);
        logger.info(String.format("Withdraw to account %s for %s %s has been proceed", account.getId(), sum, currency));
        return accountMapper.toDTO(accountRepository.save(account));
    }

    public AccountDTO transfer(Long senderId, Long recipientId, Double sum) {
        Account sender = accountRepository.getOne(senderId);
        Account recipient = accountRepository.getOne(recipientId);
        if (sender.getBalance() < sum || sender.getCurrency() != recipient.getCurrency())
            throw new IllegalArgumentException("Invalid currency");
        deposit(recipientId, sum, recipient.getCurrency());
        AccountDTO dto = withdraw(senderId, sum, recipient.getCurrency());
        logger.info(String.format("Transfer to account %s from %s for %s %s has been proceed", recipient.getId(), sender.getId(), sum, recipient.getCurrency()));
        return dto;
    }
}
