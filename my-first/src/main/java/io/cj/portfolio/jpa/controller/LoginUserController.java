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

import io.cj.portfolio.jpa.model.LoginUser;
import io.cj.portfolio.jpa.service.LoginUserRepository;

@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class LoginUserController {

	@Autowired
	private LoginUserRepository loginUserRepository;


	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public  LoginUser findOne(@PathVariable Long id) {
		return loginUserRepository.findOne(id);
	}


	@RequestMapping(method = RequestMethod.GET)
	public List<LoginUser> findAll() {
		return loginUserRepository.findAll();
	}


	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.CREATED)
	public  ResponseEntity<Void> save(@RequestBody LoginUser loginUser, UriComponentsBuilder uriComponentsBuilder) {
		loginUserRepository.save(loginUser);

		HttpHeaders headers = new HttpHeaders();
	    headers.setLocation(uriComponentsBuilder.path("/users/{id}").buildAndExpand(loginUser.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}


	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	public void delete(@PathVariable Long id) {
		LoginUser loginUser = loginUserRepository.findOne(id);
		loginUserRepository.delete(loginUser);
	}

}
