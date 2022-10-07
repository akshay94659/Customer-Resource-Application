package com.example.Spring.Boot.Project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import com.example.Spring.Boot.Project.filters.customFilterUriAdoption;

@Configuration
public class customFilterUriConfig {

  @Bean
  public FilterRegistrationBean<customFilterUriAdoption> registrationBean() {
    FilterRegistrationBean<customFilterUriAdoption> registrationBean = new FilterRegistrationBean<customFilterUriAdoption>();
    registrationBean.setFilter(new customFilterUriAdoption());
    registrationBean.addUrlPatterns("/customers/*");
    return registrationBean;
  }
}
