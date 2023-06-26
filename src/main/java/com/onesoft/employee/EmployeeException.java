package com.onesoft.employee;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmployeeException {
@ExceptionHandler(value=EmployeeNotFoundException.class) 
public ResponseEntity<Object> getEmployeeException() {
	return new ResponseEntity<>("Employee ID is not Available", HttpStatus.NOT_FOUND);
}
@ExceptionHandler(value=NameNotFoundException.class) 
public ResponseEntity<Object> getEmployeeNameException() {
	return new ResponseEntity<>("Employee Name is not Available", HttpStatus.NOT_FOUND);
}

}
