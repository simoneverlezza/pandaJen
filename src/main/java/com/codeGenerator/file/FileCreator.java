package com.codeGenerator.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class FileCreator {
	
	private static Logger LOG = LoggerFactory.getLogger(FileCreator.class);
	private static final String BASE_DIRECTORY = "created";
	
	
	public static Path create(String name, String content) {

		File baseDir = new File(BASE_DIRECTORY);
		baseDir.mkdir();
		
		Path path = Path.of(baseDir + "/" + name + ".java");
		
		try {
			
			Path result = Files.writeString(path, content);
		
			return result;
			
		} catch (IOException e) {
			LOG.error("Errore nel creare il file: " + name);
			e.getMessage();
		}
		return null;
	}

}
