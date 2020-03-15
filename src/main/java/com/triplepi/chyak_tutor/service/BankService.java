package com.triplepi.chyak_tutor.service;

import com.triplepi.chyak_tutor.domain.Account;
import com.triplepi.chyak_tutor.domain.Currency;
import com.triplepi.chyak_tutor.dto.AccountDTO;
import com.triplepi.chyak_tutor.dto.BankDTO;
import com.triplepi.chyak_tutor.mapper.AccountMapper;
import com.triplepi.chyak_tutor.mapper.BankMapper;
import com.triplepi.chyak_tutor.repository.AccountRepository;
import com.triplepi.chyak_tutor.repository.BankRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BankService {

    private final BankRepository bankRepository;
    private final AccountService accountService;
    private final AccountMapper accountMapper;
    private final AccountRepository accountRepository;
    private final BankMapper bankMapper;

    private static final Logger logger = LoggerFactory.getLogger(BankService.class);

    public BankService(BankRepository bankRepository, AccountService accountService, AccountMapper accountMapper, AccountRepository accountRepository, BankMapper bankMapper) {
        this.bankRepository = bankRepository;
        this.accountService = accountService;
        this.accountMapper = accountMapper;
        this.accountRepository = accountRepository;
        this.bankMapper = bankMapper;
    }

    public BankDTO getBank(Long id) {
        return bankMapper.toDTO(bankRepository.getOne(id));
    }

    public BankDTO saveBank(BankDTO bank) {
        accountService.saveAccounts(bank.getAccountList());
        return bankMapper.toDTO(bankRepository.save(bankMapper.toEntity(bank)));
    }

    public List<BankDTO> getAllBanks() {
        return bankRepository.findAll().stream().map(bankMapper::toDTO).collect(Collectors.toList());
    }
}
