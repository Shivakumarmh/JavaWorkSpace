package com.dk.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.dk.springboot.model.Employee;
import com.dk.springboot.service.EmployeeService;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.val;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	};
	
	@PostMapping()
	public ResponseEntity<Employee> saveEmployee(@RequestBody @Valid  Employee employee)
	{
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
	}
	
	@GetMapping()
	public ResponseEntity<List<Employee>> getAllEmployees()
	{
		return new ResponseEntity<List<Employee>>(employeeService.getAllEmployee(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id)
	{
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(id), HttpStatus.FOUND);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody @Valid Employee employee, @PathVariable("id") long id )
	{
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id")  long id)
	{
		employeeService.deleteEmployee(id);
		return new ResponseEntity<String>("Deleted", HttpStatus.OK);
	}
}
