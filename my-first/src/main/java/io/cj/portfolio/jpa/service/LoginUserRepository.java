package io.cj.portfolio.jpa.service;

import org.springframework.data.jpa.repository.JpaRepository;

import io.cj.portfolio.jpa.model.LoginUser;

public interface LoginUserRepository extends JpaRepository<LoginUser, Long> {

}
