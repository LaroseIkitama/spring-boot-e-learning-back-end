package com.yekola.yekola_api_course.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EntityNotFoundException extends RuntimeException {
	String message;
}
