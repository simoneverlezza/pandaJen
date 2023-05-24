package com.codeGenerator.generator;

import org.springframework.stereotype.Component;

@Component
public class RepositoryGenerator {

	public String generate(String className) {
		return """
				import org.springframework.data.jpa.repository.JpaRepository;
				
				public interface %sRepository extends JpaRepository<%s, Long> {
					
				}
				"""
				.replace("%s", className);
	}
}
