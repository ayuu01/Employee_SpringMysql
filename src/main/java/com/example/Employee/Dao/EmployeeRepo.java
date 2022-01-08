package com.example.Employee.Dao;

import com.example.Employee.Entity.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepo extends CrudRepository<EmployeeEntity, Integer> {
  public EmployeeEntity findById(int id);

}