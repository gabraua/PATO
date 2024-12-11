package com.quack.pato;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.quack.pato.principal.Principal;

@SpringBootApplication
public class PatoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatoApplication.class, args);
		Principal principal = new Principal();
		principal.exibeMenu();

	}

}
