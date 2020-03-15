package com.triplepi.chyak_tutor.config;

import com.triplepi.chyak_tutor.mapper.AccountMapper;
import com.triplepi.chyak_tutor.mapper.BankMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public AccountMapper accountMapper(){
        return new AccountMapper();
    }

    @Bean
    public BankMapper bankMapper(){
        return new BankMapper(accountMapper());
    }

}
