package com.dk.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.dk.springboot.dto.EmployeeDto;
import com.dk.springboot.service.EmployeeService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/employees-client")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService; 
	
	@GetMapping("/{EmployeeId}")
	public ResponseEntity<Mono<EmployeeDto>> getEmployeeById(@PathVariable(name = "EmployeeId")  long id)
	{
		return new ResponseEntity<Mono<EmployeeDto>>(employeeService.getEmlpoyeeById(id), HttpStatus.FOUND);
	}
	
	@GetMapping("/list")
	public ResponseEntity<Flux<EmployeeDto>> getAllEmployee()
	{
		return new ResponseEntity<Flux<EmployeeDto>>(employeeService.getAllEmployee(), HttpStatus.OK);
		
	}
	
	@PostMapping("/addEmployee")
	public ResponseEntity<Mono<EmployeeDto>> saveEmployee(@RequestBody  EmployeeDto employee)
	{
		System.out.println("Controller:" + employee);
		return new ResponseEntity<Mono<EmployeeDto>>(employeeService.saveEmployeeDetails(employee), HttpStatus.OK);
	}
	
	@PutMapping("/UpdateEmployee/{id}")
	public ResponseEntity<Mono<EmployeeDto>> updateEmployee(@RequestBody EmployeeDto employee, @PathVariable long id)
	{
		return new ResponseEntity<Mono<EmployeeDto>>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Mono<String>> deleteEmployee(@PathVariable long id)
	{
		
		return new ResponseEntity<Mono<String>>(employeeService.deleteEmployee(id), HttpStatus.OK);
	}

}
