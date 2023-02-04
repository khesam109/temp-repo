package com.khesam.trivialspring.repository;

import com.khesam.trivialspring.repository.entity.AccountsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountJpaRepository extends JpaRepository<AccountsEntity, String> {
}
