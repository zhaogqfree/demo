package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZhaoGQ
 */
@SpringBootApplication
@RestController
public class DemoApplication {
    @RequestMapping(value = "/")

	public static void main(String[] args) {

    	SpringApplication.run(DemoApplication.class, args);
	}
}
