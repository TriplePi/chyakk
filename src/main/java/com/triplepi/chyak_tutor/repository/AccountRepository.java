package com.triplepi.chyak_tutor.repository;

import com.triplepi.chyak_tutor.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
