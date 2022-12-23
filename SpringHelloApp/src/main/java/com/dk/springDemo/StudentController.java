package com.dk.springDemo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	@GetMapping("/student")
	public Student getStudent()
	{
		return (new Student("ABC", "XYZ"));
	}
	
	@GetMapping("/Students")
	public List<Student> GetStudentList()
	{
		List<Student> students = new ArrayList<>();
		students.add(new Student("AB", "CD"));
		students.add(new Student("AB", "CD"));
		students.add(new Student("EF", "GH"));
		students.add(new Student("IJ", "KL"));
		students.add(new Student("MN", "OP"));
		
		
		return students;
	}
	
	@GetMapping("/student/{firstName}/{lastName}")
	public Student getStudentByName(@PathVariable("firstName") String firstName1, @PathVariable("lastName") String lastName1)
	{
		return (new Student(firstName1, lastName1));
	}
	@GetMapping("/student/query")
	public Student getStudentByQuery(@RequestParam(value = "firstName") String firstName1,
									 @RequestParam(value="lastName") String lastName1)
	{
		return new Student(firstName1, lastName1);
	}

}
