package com.stc.stcsystemdesigntask.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppErrorResponse {

	private HttpStatus status;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;
	private String message;

	public AppErrorResponse() {
	       timestamp = LocalDateTime.now();
	}
	
	public AppErrorResponse(HttpStatus status) {
	       timestamp = LocalDateTime.now();
	       this.status = status;
	}
}
