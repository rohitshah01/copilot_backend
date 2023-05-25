package com.example.copilot.backend.backend;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmployeeServiceTest {

  @Autowired EmployeeService employeeService;

  @Test
  public void testFindAll() {
    List<Employee> result = employeeService.findAll();
    assertNotNull(result);
    assertEquals(0, result.size());
  }

  @Test
  public void testFindById() {
    Optional<Employee> result = employeeService.findById(0L);
    assertNotNull(result);
    assertFalse(result.isPresent());
  }

  @Test
  public void testFindByLastName() {
    List<Employee> result = employeeService.findByLastName(null);
    assertNotNull(result);
    assertEquals(0, result.size());
  }

  @Test
  public void testFindByTeam() {
    List<Employee> result = employeeService.findByTeam(null);
    assertNotNull(result);
    assertEquals(0, result.size());
  }

}