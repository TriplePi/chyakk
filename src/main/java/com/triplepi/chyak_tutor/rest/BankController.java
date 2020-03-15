package com.triplepi.chyak_tutor.rest;

import com.triplepi.chyak_tutor.dto.BankDTO;
import com.triplepi.chyak_tutor.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.ZoneId;
import java.util.List;

@RestController
@RequestMapping("/bank")
public class BankController {

    private final BankService bankService;

    @Autowired
    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @GetMapping("{id}")
    public BankDTO getBank(@PathVariable("id") Long id) {
        return bankService.getBank(id);
    }

    @PostMapping
    public BankDTO saveBank(@RequestBody BankDTO bank) {
        return bankService.saveBank(bank);
    }

    @GetMapping
    public List<BankDTO> getBanks() {
        return bankService.getAllBanks();
    }
}
