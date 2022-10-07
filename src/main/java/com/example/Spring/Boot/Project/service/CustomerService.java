package com.example.Spring.Boot.Project.service;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.net.URISyntaxException;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import com.example.Spring.Boot.Project.model.Customer;
import com.example.Spring.Boot.Project.Dao.customerDao;
import com.example.Spring.Boot.Project.Utilis.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import com.example.Spring.Boot.Project.exception.customerNotFoundException;

@Component
public class CustomerService {

  @Autowired
  customerDao dao;

  // Method for adding the new customer
  public Customer addCustomer(Customer customer) {
    return dao.save(customer);
  }

  // Method to get all the Customers
  public List<Customer> getCustomerList() {
    return dao.findAll();
  }

  // Method to get Customer w.r.t customerID
  public Customer getCustomerList(int customerId) {
    Optional<Customer> customerOptional1 = dao.findById(customerId);
    if (!customerOptional1.isPresent()) {
      throw new customerNotFoundException("Customer Record is not available");
    }
    return customerOptional1.get();
  }

  // Update a Customer
  public Customer updateCustomer(int customerId, Customer customer) {
    customer.setCustomerId(customerId);
    return dao.save(customer);
  }

  // Delete a Customer
  public void deleteCustomer(int customerId) {
    dao.deleteById(customerId);
  }

  public String postHttpRequest() throws URISyntaxException {
    WebClient client = WebClient.create();
    MultiValueMap<String, String> bodyValues = new LinkedMultiValueMap<>();
    bodyValues.add("Id", "78912");
    String responseBody = client.post()
        .uri(new URI(Constants.POST_CALL_URI))
        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
        .accept(MediaType.APPLICATION_JSON)
        .body(BodyInserters.fromFormData(bodyValues))
        .retrieve()
        .bodyToMono(String.class)
        .block();
    return responseBody;
  }
}