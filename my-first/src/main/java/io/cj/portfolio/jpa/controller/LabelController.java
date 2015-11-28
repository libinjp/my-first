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

import io.cj.portfolio.jpa.model.Label;
import io.cj.portfolio.jpa.service.LabelRepository;

@RestController
@RequestMapping(value = "/labels", produces = MediaType.APPLICATION_JSON_VALUE)
public class LabelController {

	@Autowired
	private LabelRepository labelRepository;


	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public  Label findOne(@PathVariable Long id) {
		return labelRepository.findOne(id);
	}


	@RequestMapping(method = RequestMethod.GET)
	public  List<Label> findAll() {
		return labelRepository.findAll();
	}


	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.CREATED)
	public  ResponseEntity<Void> save( @RequestBody Label label, UriComponentsBuilder uriComponentsBuilder) {
		labelRepository.save(label);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder.path("/labels/{id}").buildAndExpand(label.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}


	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	public void delete(@PathVariable Long id) {
		Label label = labelRepository.findOne(id);
		labelRepository.delete(label);
	}

}
