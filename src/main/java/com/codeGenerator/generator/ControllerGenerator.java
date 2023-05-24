package com.codeGenerator.generator;

import org.springframework.stereotype.Component;


@Component
public class ControllerGenerator {
	
	public String generate(String className) {
		return """
				import java.util.List;
				import java.util.Optional;
				
				import org.springframework.beans.factory.annotation.Autowired;
				import org.springframework.http.HttpStatus;
				import org.springframework.http.ResponseEntity;
				import org.springframework.web.bind.annotation.DeleteMapping;
				import org.springframework.web.bind.annotation.GetMapping;
				import org.springframework.web.bind.annotation.PathVariable;
				import org.springframework.web.bind.annotation.PostMapping;
				import org.springframework.web.bind.annotation.PutMapping;
				import org.springframework.web.bind.annotation.RequestBody;
				import org.springframework.web.bind.annotation.RequestMapping;
				import org.springframework.web.bind.annotation.RestController;
				
				
				@RestController
				public class %sController {
				
					@Autowired
					%sService service;
				
					
					@GetMapping
					public List<%s> findAll() {
						return service.findAll();
					}
					
					@GetMapping
					public %s getById(@PathVariable long id) {
						return service.findById(id);
					}
					
					@PostMapping
					public ResponseEntity<%s> create%s(@RequestBody %s data) {
						try {
							%s createdData = repository.save(data);
							return new ResponseEntity<>(createdData, HttpStatus.CREATED);
						} catch (Exception e) {
							return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
						}
					}
					
					@PutMapping
					public ResponseEntity<%s> update%s(@PathVariable("id") long id, @RequestBody %s data) {
				
					}
						
					@DeleteMapping
					public ResponseEntity<HttpStatus> deleteById(@PathVariable("id") long id) {
						try {
							service.deleteById(id);
							return new ResponseEntity<>(HttpStatus.NO_CONTENT);
						} catch (Exception e) {
							return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
						}
					}
					
				}

				
				"""
				.replace("%s", className);
	}

}
