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

import io.cj.portfolio.jpa.model.Author;
import io.cj.portfolio.jpa.service.AuthorRepository;

@RestController
@RequestMapping(value = "/authors", produces = MediaType.APPLICATION_JSON_VALUE)

public class AuthorController {

	@Autowired
	private AuthorRepository authorRepository;


	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public  Author findOne(@PathVariable Long id) {
		return authorRepository.findOne(id);
	}


	@RequestMapping(method = RequestMethod.GET)
	public  List<Author> findAll() {
		return authorRepository.findAll();
	}


	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.CREATED)
	public  ResponseEntity<Void> save( @RequestBody Author author, UriComponentsBuilder uriComponentsBuilder) {
		authorRepository.save(author);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder.path("/authors/{id}").buildAndExpand(author.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}


	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	public void delete(@PathVariable Long id) {
		Author author = authorRepository.findOne(id);
		authorRepository.delete(author);
	}

}