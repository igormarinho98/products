package webvest.api.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import webvest.api.model.Account;

public interface AccountRepository extends JpaRepository<Account, UUID> {


}
