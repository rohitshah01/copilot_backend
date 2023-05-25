package com.example.copilot.backend.backend;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

  private final EmployeeRepository employeeRepository;

  @GetMapping
  public List<Employee> getAllEmployees() {
    return employeeRepository.findAll();
  }

  @GetMapping("/{id}")
  public Employee getEmployee(@PathVariable Long id) {
    return employeeRepository.findById(id).orElseThrow();
  }

  @PostMapping
  public Employee createEmployee(@RequestBody Employee employee) {
    return employeeRepository.save(employee);
  }

  @PostMapping("/{id}")
  public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
    return employeeRepository.save(employee);
  }

  @PostMapping("/{id}/delete")
  public void deleteEmployee(@PathVariable Long id) {
    employeeRepository.deleteById(id);
  }
}
