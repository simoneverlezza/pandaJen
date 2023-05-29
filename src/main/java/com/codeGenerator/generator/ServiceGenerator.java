package com.codeGenerator.generator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ServiceGenerator {
	
	private Logger LOG = LoggerFactory.getLogger(ServiceGenerator.class);
	
	public String generate(String className) {
		String result= """
				import java.util.List;
				import java.util.Optional;
				
				import org.springframework.beans.factory.annotation.Autowired;
				
				@Service
				public class %sService {
					
					@Autowired
					private %sRepository repository;
					
					
					public List<%s> findAll() {
						return repository.findAll();
					}
					
					public %s findById(long id) {
						Optional<%s> data = repository.findById(id);
						if(data.isPresent()) {
							return data.get();
						} else {
							return null;
						}
					}
					
					public %s create(%s data) {
						return repository.save(data);
					}
					
					public %s update(%s data) {
					
					}
					
					public void deleteById(long id) {
						repository.deleteById(id);
					}
					
				
				}
				
				"""
				.replace("%s", className);
		
		return result;
	}

}
