package com.dk.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dk.springboot.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
