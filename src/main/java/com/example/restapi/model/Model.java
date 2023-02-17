package com.example.restapi.model;

public class Model {

	private String mode;
	private String path;
	private String direction;
	private String databegin;
	private String dataend;
	private String tf;
	
	public String getMode() {
		return this.mode;
	}
	
	public String getPath() {
		return this.path;
	}
	
	public String getDirection() {
		return this.direction;
	}
	
	public String getDatabegin() {
		return this.databegin;
	}
	
	public String getDataend() {
		return this.dataend;
	}

	public String getTf() {
		return this.tf;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
	public void setDirection(String direction) {
		this.direction = direction;
	}
	
	public void setDatabegin (String databegin) {
		this.databegin = databegin;
	}
	
	public void setDataend (String dataend) {
		this.dataend = dataend;
	}
	
	public void setTf(String tf) {
		this.tf = tf;
	}
}
