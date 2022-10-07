package com.example.Spring.Boot.Project.exception;

public class customerNotFoundException extends RuntimeException {

  public customerNotFoundException(String message) {
    super(message);
  }
}
