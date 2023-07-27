package com.challengeecomerce.BMW.Automotors;

import com.challengeecomerce.BMW.Automotors.models.Client;
import com.challengeecomerce.BMW.Automotors.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class BmwAutomotorsApplication {
	public static void main(String[] args) {
		SpringApplication.run(BmwAutomotorsApplication.class, args);
	}

	@Autowired
	private PasswordEncoder passwordEncoder;
	@Bean // cada vez q se crea la app
	public CommandLineRunner initData(ClientRepository clientRepository){ // declaro la var
		return (args -> {
			Client Pepe = new Client("Pepe", "Honguito","pepe@gmail.com", passwordEncoder.encode("melba456"),"direccion","23456");
			clientRepository.save(Pepe);
			//Client admin = new Client());

		});
	}}

