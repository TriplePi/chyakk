package com.triplepi.chyak_tutor.service;

import com.triplepi.chyak_tutor.domain.Bank;
import com.triplepi.chyak_tutor.dto.BankDTO;
import com.triplepi.chyak_tutor.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BankService {

    private BankRepository bankRepository;
    private AccountService accountService;


    public BankService(BankRepository bankRepository, AccountService accountService) {
        this.bankRepository = bankRepository;
        this.accountService = accountService;
    }

    public BankDTO getBank(Long id) {
        return bankRepository.getOne(id);
    }

    public BankDTO saveBank(BankDTO bank) {
        accountService.saveAccounts(bank.getAccountList());
        return bankRepository.save(bank);
    }

    public List<BankDTO> getBanks() {
        return bankRepository.findAll();
    }

//    public boolean deposit(Account account, Double sum, Currency currency) {
//        if (account.getCurrency() != currency)
//            return false;
//        account.setBalance(account.getBalance() + sum);
//        System.out.printf("Deposit to account %s for %s %s has been proceed", account.getId(), sum, currency);
//        return true;
//    }
//
//    public boolean withdraw(Account account, Double sum, Currency currency) {
//        if (account.getBalance() < sum || account.getCurrency() != currency)
//            return false;
//        account.setBalance(account.getBalance() - sum);
//        System.out.printf("Withdraw to account %s for %s %s has been proceed", account.getId(), sum, currency);
//        return true;
//    }
//
//    public boolean transfer(Account sender, Account recipient, Double sum) {
//        if (sender.getBalance() < sum || sender.getCurrency() != recipient.getCurrency())
//            return false;
//        withdraw(sender, sum, recipient.getCurrency());
//        deposit(recipient, sum, sender.getCurrency());
//        System.out.printf("Transfer to account %s from %s for %s %s has been proceed", recipient.getId(), sender.getId(), sum, recipient.getCurrency());
//        return true;
//    }


}
