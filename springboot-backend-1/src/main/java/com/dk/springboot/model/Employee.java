package com.dk.springboot.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@Table(name="Eemployees")
@AllArgsConstructor
@NoArgsConstructor

public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private long id;
	
	@Column(name = "first_name")
	@NotNull(message = "First name should not be null")
	@Size(max = 30, message = "First name size must be less than 30")
	private String firstName;
	
	
	@Column(name = "last_name")
	private String lastName;
	
	
	@Column(name = "email")
	@Email(message = "Email format is not correct")
	private String email;

}
