package io.cj.portfolio.jpa.service;

import org.springframework.data.jpa.repository.JpaRepository;

import io.cj.portfolio.jpa.model.Dept;

public interface DeptRepository  extends JpaRepository<Dept, Long> {

}
