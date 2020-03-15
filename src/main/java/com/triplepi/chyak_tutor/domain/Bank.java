package com.triplepi.chyak_tutor.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Bank {

    @Id
    private Long id;
    private String name;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Account> accountList;
}
