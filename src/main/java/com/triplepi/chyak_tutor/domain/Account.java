package com.triplepi.chyak_tutor.domain;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
@Builder
public class Account {

    @Id
    private Long id;
    private Currency currency;
    private Double balance = 0d;

}
