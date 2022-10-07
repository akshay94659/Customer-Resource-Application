package com.example.Spring.Boot.Project.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

  @RequestMapping(value="/hello")
  public String sayHello(){
    return "Hello World";
  }
  @RequestMapping(value = "/heyAkshay")
  public String hiAkshay(){
    return "Hi Akshay Sharma";
  }
}
