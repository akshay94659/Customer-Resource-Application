package com.example.Spring.Boot.Project.api;

import java.util.List;
import java.net.URISyntaxException;
import com.example.Spring.Boot.Project.model.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Spring.Boot.Project.service.CustomerService;

@RestController
@RequestMapping(value = "/customers")
public class customerResource {

  @Autowired
  private CustomerService customerService;

  // When a Post call with required payload is made
  @PostMapping
  public Customer addCustomer(@RequestBody Customer customer) {
    return customerService.addCustomer(customer);
  }

  // Get Call to get all the customer
  @GetMapping
  public List<Customer> getCustomers() {
    return customerService.getCustomerList();
  }

  //Get Call to get the Specific CustomerID
  @GetMapping(value = "/{customerId}")
  public Customer getCustomer(@PathVariable("customerId") int customerId) {
    return customerService.getCustomerList(customerId);
  }

  // Put Call to update the customer
  @PutMapping(value = "/{customerId}")
  public Customer updateCustomer(@PathVariable("customerId") int customerId,
      @RequestBody Customer customer) {
    return customerService.updateCustomer(customerId, customer);
  }

  // Delete Call to delete the customer
  @DeleteMapping(value = "/{customerId}")
  public void deleteCustomer(@PathVariable("customerId") int customerId) {
    customerService.deleteCustomer(customerId);
  }

  // Get Endpoint which will trigger the post call
  @GetMapping(value="/jokes")
  public String sendHttpRequest () throws URISyntaxException {
   return customerService.postHttpRequest();
  }
}

