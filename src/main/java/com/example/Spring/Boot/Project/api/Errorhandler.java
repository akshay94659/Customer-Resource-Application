package com.example.Spring.Boot.Project.api;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.example.Spring.Boot.Project.exception.ApplicationError;
import com.example.Spring.Boot.Project.exception.customerNotFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class Errorhandler extends ResponseEntityExceptionHandler {

  @Value("${documentation_hub}")
  private String details;

  @ExceptionHandler(customerNotFoundException.class)
  public ResponseEntity<ApplicationError> handleException(customerNotFoundException exception,
      WebRequest webRequest) {

    ApplicationError error = new ApplicationError();
    error.setCode(101);
    error.setMessage(exception.getMessage());
    error.setDetails(details);

    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
  }

}
