package com.triplepi.chyak_tutor.dto;

import com.triplepi.chyak_tutor.domain.Currency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDTO {

    private Long id;
    private Currency currency;
    private Double balance = 0d;
}
