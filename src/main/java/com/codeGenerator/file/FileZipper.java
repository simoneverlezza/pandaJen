package com.codeGenerator.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileZipper {
	
	private static Logger LOG = LoggerFactory.getLogger(FileZipper.class);
	
	
	public static File zipMultipleFiles(List<String> files, String fileName) {
		try {
			
			String zipFile = fileName + ".zip";
			
			final FileOutputStream fos = new FileOutputStream(zipFile);
	        
			ZipOutputStream zipOut = new ZipOutputStream(fos);

	        for (String file : files) {
	            File fileToZip = new File(file);
	            FileInputStream fis = new FileInputStream(fileToZip);
	            ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
	            zipOut.putNextEntry(zipEntry);

	            byte[] bytes = new byte[1024];
	            int length;
	            while((length = fis.read(bytes)) >= 0) {
	                zipOut.write(bytes, 0, length);
	            }
	            fis.close();
	        }
	        zipOut.close();
	        fos.close();
	        
	        return new File(zipFile);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}

}
