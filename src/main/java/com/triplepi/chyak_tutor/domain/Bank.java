package com.triplepi.chyak_tutor.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Bank {

    @Id
    private Long id;
    private String name;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Account> accountList;

    public Bank(Long id, String name, List<Account> accountList) {
        this.id = id;
        this.name = name;
        this.accountList = accountList;
    }

    public Bank() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", accountList=" + accountList +
                '}';
    }
}
