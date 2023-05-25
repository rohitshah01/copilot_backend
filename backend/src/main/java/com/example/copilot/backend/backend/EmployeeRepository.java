package com.example.copilot.backend.backend;



 import java.util.List;
 import org.springframework.data.jpa.repository.JpaRepository;
 import org.springframework.stereotype.Repository;

 @Repository
 public interface EmployeeRepository extends JpaRepository<Employee, Long> {

  List<Employee> findByLastName(String lastName);
  List<Employee> findByTeam(String team);

 }
