package io.cj.portfolio.jpa.service;

import org.springframework.data.jpa.repository.JpaRepository;

import io.cj.portfolio.jpa.model.Portfolio;

public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {

}
