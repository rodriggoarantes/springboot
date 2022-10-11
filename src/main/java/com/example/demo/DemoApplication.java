package com.example.demo;

import javax.websocket.server.PathParam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping({"/", ""})
	String sayHello() {
		return "Hello World!";
	}

	@GetMapping("/{text}")
	String sayHelloWithParam(@PathVariable() String text) {
		return String.format("Hello World! Welcome [%s]", text.toUpperCase());
	}
}
