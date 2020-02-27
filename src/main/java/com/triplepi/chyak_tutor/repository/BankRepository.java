package com.triplepi.chyak_tutor.repository;

import com.triplepi.chyak_tutor.domain.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank, Long> {
}
