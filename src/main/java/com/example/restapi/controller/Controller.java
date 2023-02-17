package com.example.restapi.controller;

import java.io.*;
import java.util.Map;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.restapi.FileDownloadUtils;
import com.example.restapi.model.Model;
import com.example.restapi.model.ResponseModel;

@CrossOrigin(origins="http://10.10.1.133:4200", exposedHeaders = {"Content-Disposition"}, allowedHeaders = "*", allowCredentials = "true")
@RestController
public class Controller {

	@GetMapping("/hello")
	public String hello(@RequestParam(value="name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}
	
	
	
	@PostMapping("/api/foos")
	@ResponseBody
	public String updateFoos(@RequestParam Map<String,String> allParams) {
		return "Parameters are" + allParams.entrySet();
	}
	
	@PostMapping("/api/create")
	@ResponseBody
	public Model createModel(@RequestBody Model model) {
		return model;
	}
	

	@PostMapping("/api/iismtr")
	@ResponseBody
	public ResponseEntity<?> postSchet (@RequestBody Model model) throws IOException {
		
		System.out.println(model.getMode()+"||"+model.getDirection()+"||"+model.getDatabegin()+"||"+model.getDataend()+"||"+model.getTf());
		//String line = "Status OK";
		
		FileDownloadUtils fileDownloadUtils = new FileDownloadUtils();
		Resource resource = null;
		
		
		resource = fileDownloadUtils.getFile("///home///ovsyannikov///docs///excel.xlsx");
		System.out.println(resource);
		
		String contentType = "application/octet-stream";
		String headerValue = "attachment; filename = \"" + resource.getFilename() + "\"";
		
		
		return (ResponseEntity<?>) ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType)).header(HttpHeaders.CONTENT_DISPOSITION, headerValue).body(resource);
	}

	
	@CrossOrigin(origins="http://10.10.1.133:3000")
	@PostMapping("/api/upload")
	@ResponseBody
	public ResponseEntity<?> handleFileUpload (@RequestParam("direction") String direction,  @RequestParam("file") MultipartFile file) throws IOException {
		
		System.out.println(direction);
		String name = "file";
		
		FileDownloadUtils fileDownloadUtils = new FileDownloadUtils();
		Resource resource = null;
				
		resource = fileDownloadUtils.getFile("///home///ovsyannikov///docs///excel.xlsx");
		System.out.println(resource);
				
		String contentType = "application/octet-stream";
		String headerValue = "attachment; filename = \"" + resource.getFilename() + "\"";
				
		ResponseModel resmodel = new ResponseModel("ERROR", "Файл добавлен","path");
		byte[] bytes = file.getBytes();
		BufferedOutputStream stream = new BufferedOutputStream (new FileOutputStream(new File(name + "-uploaded")));
		
		stream.write(bytes);
		stream.close();
		System.out.println("Файл получен");
		
		if (resmodel.getStatus().equals("OK")) {
			System.out.println("Ошибок нет");
			//return (ResponseEntity<?>) ResponseEntity.status(HttpStatusCode.valueOf(201)).body(resmodel);
			return (ResponseEntity<?>) ResponseEntity.status(HttpStatusCode.valueOf(201)).body(resmodel);
		} else {
			return (ResponseEntity<?>) ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType)).header(HttpHeaders.CONTENT_DISPOSITION, headerValue).body(resource);
		}
	}
}
