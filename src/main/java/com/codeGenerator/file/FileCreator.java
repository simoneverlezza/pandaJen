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

		Path path;

		if(name.contains("Repository")) {
			try {
				Path baseDir = Files.createDirectories(Paths.get("created/repository"));
				path = Path.of(baseDir.toString() + "/" + name + ".java");

			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		} else if (name.contains("Service")) {
			try {
				Path baseDir = Files.createDirectories(Paths.get("created/service"));
				path = Path.of(baseDir.toString() + "/" + name + ".java");

			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		} else {
			try {
				Path baseDir = Files.createDirectories(Paths.get("created/controller"));
				path = Path.of(baseDir.toString() + "/" + name + ".java");

			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
			
		/*File baseDir = new File("created");
		baseDir.mkdir();
		
		Path path = Path.of(baseDir + "/" + name + ".java");*/
		
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
