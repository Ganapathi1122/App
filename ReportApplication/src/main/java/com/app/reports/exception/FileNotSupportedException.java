package com.app.reports.exception;


public class FileNotSupportedException extends RuntimeException {

	private static final long serialVersionUID = -9034905337171386170L;

	public FileNotSupportedException(String message) {
		super(message);
	}
}
