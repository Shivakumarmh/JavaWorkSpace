package com.dk.springboot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import com.dk.springboot.exception.ResourceNotFoundException;
import com.dk.springboot.model.Employee;
import com.dk.springboot.repository.EmployeeRepository;
import com.dk.springboot.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}
	
	@Override
	public void deleteEmployee(long id) {
		employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "ID", id));
		employeeRepository.deleteById(id);
		
	}

	
	
	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
		// TODO Auto-generated method stub
		 return employeeRepository.findById(id).
				 orElseThrow(() -> new ResourceNotFoundException("Employee", "ID", id));
		 
	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		
		Employee existingEmployee = employeeRepository.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("Employee", "ID", id));
		
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		
		
		return employeeRepository.save(existingEmployee);
	}

	

	
	
	
	//new ResourceNotFoundException("Employee", "ID", id)
}
