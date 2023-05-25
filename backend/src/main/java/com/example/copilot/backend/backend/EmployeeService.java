package com.example.copilot.backend.backend;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepository;

  public List<Employee> findAll() {
    return employeeRepository.findAll();
  }

  public Optional<Employee> findById(Long id) {
    return employeeRepository.findById(id);
  }

  public List<Employee> findByLastName(String lastName) {
        return employeeRepository.findByLastName(lastName);
  }

  public List<Employee> findByTeam(String team) {
    return employeeRepository.findByTeam(team);
  }



}
