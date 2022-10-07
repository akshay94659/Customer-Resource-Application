package com.example.Spring.Boot.Project.filters;

import java.io.IOException;
import javax.servlet.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class customFilterUsers implements Filter {

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
      FilterChain filterChain) throws IOException, ServletException {
    System.out.println("customerfilterUsers is working");
     filterChain.doFilter(servletRequest,servletResponse);
  }
}
