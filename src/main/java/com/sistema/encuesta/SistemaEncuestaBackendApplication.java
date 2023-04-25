package com.sistema.encuesta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SistemaEncuestaBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaEncuestaBackendApplication.class, args);
	}


	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

}
