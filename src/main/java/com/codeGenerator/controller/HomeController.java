package com.codeGenerator.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import com.codeGenerator.file.FileCreator;
import com.codeGenerator.file.FileZipper;
import com.codeGenerator.generator.ControllerGenerator;
import com.codeGenerator.generator.RepositoryGenerator;
import com.codeGenerator.generator.ServiceGenerator;

@RestController
public class HomeController {
	
	private Logger LOG = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private RepositoryGenerator repositoryGenerator;
	
	@Autowired
	private ServiceGenerator serviceGenerator;
	
	@Autowired
	private ControllerGenerator controllerGenerator;
	
	private static final String REPOSITORY = "Repository";
	private static final String SERVICE = "Service";
	private static final String CONTROLLER = "Controller";
	
	
	@GetMapping("download/{className}")
	public ResponseEntity<StreamingResponseBody> download(@PathVariable String className) {
		
		String repositoryClass = repositoryGenerator.generate(className);
		String serviceClass = serviceGenerator.generate(className);
		String controllerClass = controllerGenerator.generate(className);
		
		Path repoFile = FileCreator.create(className + REPOSITORY, repositoryClass);
		Path servFile = FileCreator.create(className + SERVICE, serviceClass);
		Path contFile = FileCreator.create(className + CONTROLLER, controllerClass);
		
		List<String> fileNames = List.of(
				repoFile.toString(),
				servFile.toString(),
				contFile.toString());
		
		File zipFile = FileZipper.zipMultipleFiles(fileNames, className);
		
		try {
			InputStream inputStream = new FileInputStream(zipFile);
			StreamingResponseBody body = outputStream -> FileCopyUtils.copy(inputStream, outputStream);

			LOG.info("File ready");
			
			return ResponseEntity.ok()
	                .header("Content-Disposition", "attachment;filename= " + zipFile)
	                .body(body);
			
		} catch (FileNotFoundException e) {
			e.getMessage();
		}
		
		return null;
	}
}
