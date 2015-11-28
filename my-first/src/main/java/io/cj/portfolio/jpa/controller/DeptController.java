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

import io.cj.portfolio.jpa.model.Dept;
import io.cj.portfolio.jpa.service.DeptRepository;

@RestController
@RequestMapping(value = "/depts", produces = MediaType.APPLICATION_JSON_VALUE)
public class DeptController {

	@Autowired
	private DeptRepository deptRepository;


	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Dept findOne(@PathVariable Long id) {
		return deptRepository.findOne(id);
	}


	@RequestMapping(method = RequestMethod.GET)
	public List<Dept> findAll() {
		return deptRepository.findAll();
	}


	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<Void> save(@RequestBody Dept dept, UriComponentsBuilder uriComponentsBuilder) {
		deptRepository.save(dept);

		HttpHeaders headers = new HttpHeaders();
	    headers.setLocation(uriComponentsBuilder.path("/depts/{id}").buildAndExpand(dept.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}


	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	public void delete(@PathVariable Long id) {
		Dept dept = deptRepository.findOne(id);
		deptRepository.delete(dept);
	}


}
