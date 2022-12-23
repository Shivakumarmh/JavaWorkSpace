package com.dk.springboot.service;



import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;


import com.dk.springboot.dto.EmployeeDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeService {
	
	WebClient webClient = WebClient.builder().baseUrl("http://localhost:8082/employees")
			.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
	
	public Mono<EmployeeDto> getEmlpoyeeById(long empId)
	{
		
		return webClient.get().uri("/"+empId).retrieve().bodyToMono(EmployeeDto.class);
	}
	
	public Flux<EmployeeDto> getAllEmployee()
	{
		return webClient.get().uri("").retrieve().bodyToFlux(EmployeeDto.class);
		
	}
	
	public Mono<EmployeeDto> saveEmployeeDetails(EmployeeDto employee)
	{
		System.out.println(employee);
		return webClient.post().bodyValue(employee).retrieve().bodyToMono(EmployeeDto.class);
	}

	public Mono<EmployeeDto> updateEmployee(EmployeeDto employee, long id) {
		
		return webClient.put().uri("/"+id).bodyValue(employee).retrieve().bodyToMono(EmployeeDto.class);
	}

	public Mono<String> deleteEmployee(long id) {
		// TODO Auto-generated method stub
		return webClient.delete().uri("/"+ id).retrieve().bodyToMono(String.class);
		
	}

}
