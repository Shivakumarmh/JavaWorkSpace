package com.dk.springDemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//@ResponseBody
@RestController
//@RestController = @Controller + @ResonseBody
public class HelloWorldController {
	//
	@GetMapping("/hello-world")
	public String GetHello()
	{
		return "Hello world";
	}
	
	@GetMapping("/hello-world-app")
	public String GetHelloApp()
	{
		return "Hello world";
	}

}
