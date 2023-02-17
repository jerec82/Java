package com.example.restapi.model;

public class ResponseModel {
	private String status;
	private String message;
	private String path;
	
	public ResponseModel () {}
	
	public ResponseModel (String status, String message, String path) {
		this.status = status;
		this.message = message;
		this.path = path;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}





}
