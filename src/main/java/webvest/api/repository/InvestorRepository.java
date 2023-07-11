package webvest.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import webvest.api.model.Investor;

public interface InvestorRepository extends JpaRepository <Investor, Long>{

}
