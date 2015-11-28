package io.cj.portfolio.jpa.service;

import org.springframework.data.jpa.repository.JpaRepository;

import io.cj.portfolio.jpa.model.LabelPortfolio;

public interface LabelPortfolioRepository  extends JpaRepository<LabelPortfolio, Long> {

}

