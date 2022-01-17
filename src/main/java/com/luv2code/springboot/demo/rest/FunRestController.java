package com.luv2code.springboot.demo.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	 // expose "/"
	
	@GetMapping("/")
	public String sayHello() {
		return "Hello World, time on server is " + LocalDateTime.now();
	}
}
