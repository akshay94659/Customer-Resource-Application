package com.example.Spring.Boot.Project.Dao;

import com.example.Spring.Boot.Project.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface customerDao extends CrudRepository<Customer, Integer> {

  @Override
  List<Customer> findAll();

}
