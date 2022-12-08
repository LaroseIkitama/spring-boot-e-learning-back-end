package com.yekola.yekola_api_course.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RequestException extends RuntimeException {
	String message;
	HttpStatus httpStatus;
}
