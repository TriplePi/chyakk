package com.triplepi.chyak_tutor.dto;

import com.triplepi.chyak_tutor.domain.Account;

import java.util.List;
import java.util.Objects;

public class BankDTO {

    private Long id;
    private String name;
    private List<AccountDTO> accountList;

    public BankDTO(Long id, String name, List<AccountDTO> accountList) {
        this.id = id;
        this.name = name;
        this.accountList = accountList;
    }

    public BankDTO() {
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

    public List<AccountDTO> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<AccountDTO> accountList) {
        this.accountList = accountList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankDTO bankDTO = (BankDTO) o;
        return Objects.equals(id, bankDTO.id) &&
                Objects.equals(name, bankDTO.name) &&
                Objects.equals(accountList, bankDTO.accountList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, accountList);
    }
}
