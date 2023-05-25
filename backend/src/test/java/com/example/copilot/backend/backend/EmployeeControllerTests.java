package com.example.copilot.backend.backend;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private EmployeeRepository employeeRepository;

	@Test
	public void testGetAllEmployees() throws Exception {
		Employee employee1 = Employee.builder()
				.firstName("John")
				.lastName("Doe")
				.build();
		Employee employee2 = Employee.builder()
				.firstName("Jane")
				.lastName("Doe")
				.build();
		List<Employee> employees = Arrays.asList(employee1, employee2);
		given(employeeRepository.findAll()).willReturn(employees);

		mockMvc.perform(get("/api/employees"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(2)))
				.andExpect(jsonPath("$[0].firstName", is("John")))
				.andExpect(jsonPath("$[0].lastName", is("Doe")))
				.andExpect(jsonPath("$[1].firstName", is("Jane")))
				.andExpect(jsonPath("$[1].lastName", is("Doe")));
	}

	@Test
	public void testGetEmployee() throws Exception {
		Employee employee = Employee.builder()
				.firstName("John")
				.lastName("Doe")
				.build();
		given(employeeRepository.findById(1L)).willReturn(Optional.of(employee));

		mockMvc.perform(get("/api/employees/1"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.firstName", is("John")))
				.andExpect(jsonPath("$.lastName", is("Doe")));
	}

	@Test
	public void testCreateEmployee() throws Exception {
		Employee employee = Employee.builder()
				.firstName("John")
				.lastName("Doe")
				.build();
		given(employeeRepository.save(employee)).willReturn(employee);

		mockMvc.perform(post("/api/employees")
						.contentType(MediaType.APPLICATION_JSON)
						.content("{\"firstName\":\"John\",\"lastName\":\"Doe\"}"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.firstName", is("John")))
				.andExpect(jsonPath("$.lastName", is("Doe")));
	}

	@Test
	public void testUpdateEmployee() throws Exception {
		Employee employee = Employee.builder()
				.firstName("John")
				.lastName("Doe")
				.build();
		given(employeeRepository.save(employee)).willReturn(employee);

		mockMvc.perform(post("/api/employees/1")
						.contentType(MediaType.APPLICATION_JSON)
						.content("{\"firstName\":\"John\",\"lastName\":\"Doe\"}"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.firstName", is("John")))
				.andExpect(jsonPath("$.lastName", is("Doe")));
	}

	@Test
	public void testDeleteEmployee() throws Exception {
		mockMvc.perform(post("/api/employees/1/delete"))
				.andExpect(status().isOk());

		verify(employeeRepository, times(1)).deleteById(1L);
	}

}
