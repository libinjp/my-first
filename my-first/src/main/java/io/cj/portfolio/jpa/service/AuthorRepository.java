package io.cj.portfolio.jpa.service;

import org.springframework.data.jpa.repository.JpaRepository;

import io.cj.portfolio.jpa.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}