package com.openclassrooms.demo.controller;

//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoginController {
	
	@GetMapping("/admin")
	public String userhome () {
		return "admin";
	}
	@GetMapping("/user")
	public String adminhome () {
		return "user";
	}

}
