package io.cj.portfolio.jpa.service;

import org.springframework.data.jpa.repository.JpaRepository;

import io.cj.portfolio.jpa.model.Label;

public interface LabelRepository  extends JpaRepository<Label, Long> {

}