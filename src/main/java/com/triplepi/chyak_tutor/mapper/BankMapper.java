package com.triplepi.chyak_tutor.mapper;

import com.triplepi.chyak_tutor.domain.Account;
import com.triplepi.chyak_tutor.domain.Bank;
import com.triplepi.chyak_tutor.dto.BankDTO;

import java.time.ZoneId;
import java.util.stream.Collectors;

public class BankMapper implements Mapper<Bank, BankDTO> {

    private final AccountMapper accountMapper;

    public BankMapper(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    @Override
    public Bank toEntity(BankDTO bankDTO) {
        return Bank.builder()
                .accountList(bankDTO.getAccountList().stream().map(accountMapper::toEntity).collect(Collectors.toList()))
                .id(bankDTO.getId())
                .name(bankDTO.getName())
                .build();
    }

    @Override
    public BankDTO toDTO(Bank bank) {
        return BankDTO.builder()
                .accountList(bank
                        .getAccountList().stream()
                        .map(accountMapper::toDTO)
                        .collect(Collectors.toList()))
                .id(bank.getId())
                .name(bank.getName())
                .build();
    }
}
