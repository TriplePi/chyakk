package com.triplepi.chyak_tutor.rest;

import com.triplepi.chyak_tutor.dto.AccountDTO;
import com.triplepi.chyak_tutor.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.time.ZoneId;
import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("{id}")
    public AccountDTO getAccount(@PathVariable("id") Long id) {
        return accountService.getAccount(id);
    }

    @GetMapping
    public List<AccountDTO> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping(value = "/transfer")
    public AccountDTO transfer(@RequestParam Long senderId,@RequestParam Long recipientId,@RequestParam Double sum) {
        return accountService.transfer(senderId, recipientId, sum);
    }
}
