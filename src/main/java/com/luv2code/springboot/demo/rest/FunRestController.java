package com.luv2code.springboot.demo.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	// Inject properties for: coach.name an team.name in application.properties
	@Value("${coach.name}")
	private String coachName;

	@Value("${team.name}")
	private String teamName;

	// expose new endpoint for "teaminfo"
	@GetMapping("/teaminfo")
	public String getTeamInfo() {
		return "Coach: " + this.coachName + ", Team name: " + this.teamName;
	}

	// expose "/"
	@GetMapping("/")
	public String sayHello() {
		return "Hello World, time on server is " + LocalDateTime.now();
	}

	// Expose a new endpoint for "workout"
	@GetMapping("/workout")
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	// Expose a new endpoint for "fortune"
	@GetMapping("/fortune")
	public String getDailyFortune() {
		return "Today is your lucky day.";
	}
}
