package com.example.firstProject.utils;

import org.springframework.stereotype.Component;

@Component
public class ResponseStructure <T> {
	private String message;
	private int statuscode;
	private T data;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatuscode() {
		return statuscode;
	}
	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
}
