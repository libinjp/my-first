package io.cj.portfolio.jpa.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import io.cj.portfolio.jpa.model.Portfolio;

public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
	@Query("SELECT p FROM Portfolio p LEFT OUTER JOIN p.labelPortfolios l ON l.loginId = ?1")
	List<Portfolio> findByLoginUser(Long loginUserId);
}
