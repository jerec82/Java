package com.example.restapi;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

public class FileDownloadUtils {

	private Path foundFile;
	
	public Resource getFile(String filePath) throws MalformedURLException {
		foundFile = Paths.get(filePath);
		return new UrlResource(foundFile.toUri());
	}
	
}
