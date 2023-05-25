package com.example.copilot.backend.backend;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class Employee {

  @Id
  private Long id;
  private String firstName;
  private String lastName;
  private String team;

  public Employee(String john, String doe) {
  }
}
