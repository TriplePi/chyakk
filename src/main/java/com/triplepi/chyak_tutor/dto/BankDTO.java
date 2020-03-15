package com.triplepi.chyak_tutor.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankDTO {

    private Long id;
    private String name;
    private List<AccountDTO> accountList;
}
