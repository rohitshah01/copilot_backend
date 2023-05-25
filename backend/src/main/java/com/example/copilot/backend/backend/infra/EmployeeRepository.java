package com.example.copilot.backend.backend.infra;


import org.springframework.data.jpa.repository.JpaRepository;

// create employee repository interface which extends jparepository.
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
}
