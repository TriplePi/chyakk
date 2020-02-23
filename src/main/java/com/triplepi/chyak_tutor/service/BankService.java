package com.triplepi.chyak_tutor.service;

import com.triplepi.chyak_tutor.domain.Account;
import com.triplepi.chyak_tutor.domain.Currency;

public class BankService {

    public boolean deposit(Account account, Double sum, Currency currency) {
        if (account.getCurrency() != currency)
            return false;
        account.setBalance(account.getBalance() + sum);
        System.out.printf("Deposit to account %s for %s %s has been proceed", account.getId(), sum, currency);
        return true;
    }

    public boolean withdraw(Account account, Double sum, Currency currency) {
        if (account.getBalance() < sum || account.getCurrency() != currency)
            return false;
        account.setBalance(account.getBalance() - sum);
        System.out.printf("Withdraw to account %s for %s %s has been proceed", account.getId(), sum, currency);
        return true;
    }

    public boolean transfer(Account sender, Account recipient, Double sum) {
        if (sender.getBalance() < sum || sender.getCurrency() != recipient.getCurrency())
            return false;
        withdraw(sender, sum, recipient.getCurrency());
        deposit(recipient, sum, sender.getCurrency());
        System.out.printf("Transfer to account %s from %s for %s %s has been proceed", recipient.getId(), sender.getId(), sum, recipient.getCurrency());
        return true;
    }

}
