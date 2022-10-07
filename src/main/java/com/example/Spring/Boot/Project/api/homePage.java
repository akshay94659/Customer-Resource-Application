package com.example.Spring.Boot.Project.api;

import java.util.Date;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class homePage {

  @GetMapping
  public String homeMessage() {
    return ("Application is running properly "+ " " + new Date());
  }
}
