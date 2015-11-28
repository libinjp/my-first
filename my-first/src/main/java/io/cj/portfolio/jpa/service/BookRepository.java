package io.cj.portfolio.jpa.service;

import org.springframework.data.jpa.repository.JpaRepository;

import io.cj.portfolio.jpa.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}