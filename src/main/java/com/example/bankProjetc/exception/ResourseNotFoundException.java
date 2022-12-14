package com.example.bankProjetc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourseNotFoundException extends RuntimeException
{
	private static final long serialVersionUID = 1L;
	private String fname;
	private Object fvalue;
	public ResourseNotFoundException( String fname, Object fvalue) {
		super(String.format("%s not found with %s : '%s'",fname,fvalue));
		
		this.fname = fname;
		this.fvalue = fvalue;
	}
	public String getFname() {
		return fname;
	}
	public Object getFvalue() {
		return fvalue;
	}
}
