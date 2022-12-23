package com.dk.springboot.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.dk.springboot.model.Employee;
import com.dk.springboot.repository.EmployeeRepository;
import com.dk.springboot.service.EmployeeService;
//@RunWith(SpringRunner.class)
@SpringBootTest
class EmployeeServiceImplTest {
	
	@Autowired
	EmployeeServiceImpl employeeServiceImpl;
	@MockBean
	EmployeeRepository employeeRepo;
	


	@Test
	void testGetAllEmployee() {
		//fail("Not yet implemented");
		when(employeeRepo.findAll()).thenReturn(List.of(new Employee(1,"abc","xyz","ab@gmail.com"),
				new Employee(1,"abc","xyz","ab@gmail.com")));
		assertEquals(2, employeeServiceImpl.getAllEmployee().size());
	}

}
