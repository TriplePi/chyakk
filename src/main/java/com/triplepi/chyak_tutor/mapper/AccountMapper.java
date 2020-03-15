package com.triplepi.chyak_tutor.mapper;

import com.triplepi.chyak_tutor.domain.Account;
import com.triplepi.chyak_tutor.dto.AccountDTO;

import java.time.ZoneId;

public class AccountMapper implements Mapper<Account, AccountDTO> {
    @Override
    public Account toEntity(AccountDTO accountDTO) {
        Account account = new Account();
        account.setBalance(accountDTO.getBalance());
        account.setCurrency(accountDTO.getCurrency());
        account.setId(accountDTO.getId());
        return account;
    }

    @Override
    public AccountDTO toDTO(Account account) {
        return AccountDTO
                .builder()
                .balance(account.getBalance())
                .currency(account.getCurrency())
                .id(account.getId())
                .build();
    }
}
