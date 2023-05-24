package com.codeGenerator.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileCreator {
	
	private static Logger LOG = LoggerFactory.getLogger(FileCreator.class);
	
	public static Path create(String name, String content) {
		Path path = Path.of(name + ".java");
		try {
			Path result = Files.writeString(path, content);
			return result;
		} catch (IOException e) {
			LOG.error("Errore nel creare il file: " + name);
			e.printStackTrace();
		}
		return null;
	}

}
