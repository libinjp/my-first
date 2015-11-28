package io.cj.portfolio.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import io.cj.portfolio.jpa.model.Book;
import io.cj.portfolio.jpa.service.BookRepository;

@RestController
@RequestMapping(value = "/books", produces = MediaType.APPLICATION_JSON_VALUE)

public class BookController {

	@Autowired
	private BookRepository bookRepository;


	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public  Book findOne(@PathVariable Long id) {
		return bookRepository.findOne(id);
	}


	@RequestMapping(method = RequestMethod.GET)
	public  List<Book> findAll() {
		return bookRepository.findAll();
	}


	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.CREATED)
	public  ResponseEntity<Void> save( @RequestBody Book book, UriComponentsBuilder uriComponentsBuilder) {
		bookRepository.save(book);

		HttpHeaders headers = new HttpHeaders();
	    headers.setLocation(uriComponentsBuilder.path("/books/{id}").buildAndExpand(book.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}


	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	public void delete(@PathVariable Long id) {
		Book book = bookRepository.findOne(id);
		bookRepository.delete(book);
	}

}